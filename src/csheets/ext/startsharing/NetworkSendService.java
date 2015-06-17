/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import csheets.ext.selectgame.Player;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 */
public class NetworkSendService {

	public static Socket cliente;

	public static boolean connectionState = false;

	public static final int TIMEOUT = 3;

	public NetworkSendService() {
	}

	public static Map<InetAddress, Integer> searchActiveInstances(int portUDP,
																  int portTCP) {

		Map<InetAddress, Integer> activeInstances = new HashMap<InetAddress, Integer>();

		try {

			DatagramSocket socket = new DatagramSocket();
			socket.setBroadcast(true);
			socket.setSoTimeout(1000 * TIMEOUT);
			InetAddress destinationIP = InetAddress.getByName("10.8.255.255");

			byte[] data = new byte[300];
			String message = String.format("%d", portTCP);
			data = message.getBytes("ISO-8859-1");
			DatagramPacket request = new DatagramPacket(data, message.
														length(), destinationIP, portUDP);

			socket.send(request);
			DatagramPacket reply;

			long startTime = 0;
			long endTime = 0;
			long time = 0;

			while (time < 15000) {
				try {
					startTime = System.currentTimeMillis();

					reply = new DatagramPacket(data, data.length);
					socket.receive(reply);
					System.out.println("ADDRESS: " + reply.getPort());
					message = new String(reply.getData(), 0, reply.getLength());
					System.out.println(message);

					NetworkService.
						addClientToMap(Integer.parseInt(message), reply.
									   getAddress());

					activeInstances.put(reply.getAddress(), Integer.
										parseInt(message));

					endTime += System.currentTimeMillis();
					time += endTime - startTime;
					System.out.println(time);
				} catch (SocketTimeoutException ex) {
					endTime += System.currentTimeMillis();
					time += endTime - startTime;
					System.out.println(time);
					System.out.println("Instance did not respond!");
				}
			}

			socket.close();

		} catch (UnknownHostException ex) {
			Logger.getLogger(NetworkService.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (SocketException ex) {
			Logger.getLogger(NetworkService.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(NetworkService.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		return activeInstances;
	}

	public static void sendObject(Object object,
								  ObjectOutputStream sOut) {
		try {
			sOut.writeObject(object);
		} catch (IOException ex) {
			Logger.getLogger(NetworkSendService.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	public static void sendString(String message,
								  DataOutputStream sOut) {
		try {
			byte[] data = new byte[300];
			data = message.getBytes();
			sOut.write((byte) message.length());
			sOut.write(data, 0, message.length());
		} catch (IOException ex) {
			Logger.getLogger(NetworkSendService.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	public static void establishConnectionToUser(InetAddress address) {
		try {
			cliente = new Socket(address, 9001);
			connectionState = true;
			System.out.println("O cliente conectou-se ao servidor!");
		} catch (IOException ex) {
			Logger.getLogger(NetworkSendService.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	public static void sendUserInfo(Player playerToSend) {
		ObjectOutputStream saida;
		try {
			saida = new ObjectOutputStream(cliente.
				getOutputStream());
			saida.writeObject(playerToSend);
		} catch (IOException ex) {
			Logger.getLogger(NetworkSendService.class.getName()).
				log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * Connection using SSL
	 *
	 * @param address
	 * @return
	 */
	public static boolean establishSecureConnectionToUser(InetAddress address) {
		try {
			SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.
				getDefault();
			cliente = sslsocketfactory.createSocket(address, 1337);
			connectionState = true;
			System.out.println("O cliente conectou-se ao servidor SSL!");
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
