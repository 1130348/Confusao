/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 */
public class RespondToUDPRequest implements Runnable {

	private DatagramSocket sock;
	private final int portUDP;
	private final int portTCP;

	public RespondToUDPRequest(int portUDP, int portTCP) {
		this.portUDP = portUDP;
		this.portTCP = portTCP;
	}

	@Override
	public void run() {
		byte[] data = new byte[300];
		String message;
		InetAddress clientIP;
		int clientPort;

		try {
			sock = new DatagramSocket(portUDP);
		} catch (BindException ex) {
			System.out.println("The choosen port is not available!");
		} catch (SocketException ex) {
			Logger.getLogger(RespondToUDPRequest.class.getName()).
				log(Level.SEVERE, null, ex);
		}

		String localName = "";
		try {
			localName = InetAddress.getLocalHost().getCanonicalHostName();
		} catch (UnknownHostException ex) {
			Logger.getLogger(RespondToUDPRequest.class.getName()).
				log(Level.SEVERE, null, ex);
		}

		while (true) {
			try {

				DatagramPacket request = new DatagramPacket(data, data.length);
				sock.receive(request);
				message = new String(request.getData(), 0, request.getLength());
				System.out.println("Mensagem" + message);

				if (message.equals("Exit")) {
					sock.close();
					break;
				}

				clientIP = request.getAddress();
				clientPort = request.getPort();

				System.out.println("Client: " + clientPort);
				String port = String.format("%d", portTCP);
				data = port.getBytes();
				if (!(clientIP.getCanonicalHostName()).equals(localName)) {
					DatagramPacket resposta = new DatagramPacket(data, port.
																 length(), clientIP, clientPort);

					NetworkService.
						addClientToMap(Integer.parseInt(message), request.
									   getAddress());
					sock.send(resposta);
				}

			} catch (IOException ex) {
				Logger.getLogger(RespondToUDPRequest.class.getName()).
					log(Level.SEVERE, null, ex);
			}
		}
	}

}
