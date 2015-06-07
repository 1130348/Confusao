/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Pereira
 */
public class Network {

	private static final int TIMEOUT = 3;
	private static Thread serverThread;
	private static ArrayList<Socket> clientConnections;
	private static int portTCP;
	private static int portUDP = 9050;
	public static Map<InetAddress, Integer> activeInstances = new HashMap<InetAddress, Integer>();

	/*
	 * To make sure that this class is a service class
	 */
	private Network() {
	}

	public static int getPort() {
		return portTCP;
	}

	public static void setPort(int newPort) {
		portTCP = newPort;
	}

	public static boolean sendSelectedCellRange(Object object) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(
			clientConnections.get(0).getOutputStream());
		out.writeObject(object);
		return true;
	}

	/**
	 * Method that sets the visibility in the local network of the running
	 * instance of cleansheets
	 *
	 * @param cond boolean condition that defines if the application stays
	 * visible or if it stays hidden from the local network
	 */
	public static void isVisibleToOthers(boolean cond) {
		if (cond) {
			serverThread = new Thread(new respond_to_request(portUDP, portTCP));
			serverThread.start();
		} else {
			try {
				String localHost = localHostAddress().getHostName();

				InetAddress destinationIP = InetAddress.getByName(localHost);

				DatagramSocket socket = new DatagramSocket();
				byte[] data = new byte[300];
				String message = "Exit";
				data = message.getBytes();
				DatagramPacket exitMessage = new DatagramPacket(data, message.
																length(), destinationIP, portUDP);

				socket.send(exitMessage);
				serverThread.join();
			} catch (UnknownHostException ex) {
				Logger.getLogger(Network.class.getName()).
					log(Level.SEVERE, null, ex);
			} catch (SocketException ex) {
				Logger.getLogger(Network.class.getName()).
					log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(Network.class.getName()).
					log(Level.SEVERE, null, ex);
			} catch (InterruptedException ex) {
				Logger.getLogger(Network.class.getName()).
					log(Level.SEVERE, null, ex);
			}
		}
	}

	public static Map<InetAddress, Integer> searchInstances() {

		try {

			DatagramSocket socket = new DatagramSocket();
			socket.setBroadcast(true);
			socket.setSoTimeout(1000 * TIMEOUT);
			InetAddress destinationIP = InetAddress.getByName("192.168.1.255");

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
					time = 0;
					reply = new DatagramPacket(data, data.length);
					socket.receive(reply);
					System.out.println("ADDRESS: " + reply.getPort());
					message = new String(reply.getData(), 0, reply.getLength());
					System.out.println(message);

					addClientToMap(Integer.parseInt(message), reply.getAddress());

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
			Logger.getLogger(Network.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (SocketException ex) {
			Logger.getLogger(Network.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Network.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		return activeInstances;
	}

	private static InetAddress localHostAddress() throws UnknownHostException {
		return InetAddress.getLocalHost();
	}

	public static void addClientToMap(Integer port, InetAddress clientAddress) {
		if (!activeInstances.containsValue(port)) {
			activeInstances.put(clientAddress, port);
		}
	}

	public static void connectToInstances(String[] clientsToConnect) {
		InetAddress[] destinationIPs = new InetAddress[clientsToConnect.length];
		DataOutputStream sOut[] = new DataOutputStream[clientsToConnect.length];
		DataInputStream sIn[] = new DataInputStream[clientsToConnect.length];
		for (int i = 0; i < clientsToConnect.length; i++) {

			try {
				destinationIPs[i] = InetAddress.
					getByName(clientsToConnect[i]);
			} catch (UnknownHostException ex) {
				System.out.
					println("The provided server address (" + clientsToConnect + ") is not available");
			}

			try {
				clientConnections.add(new Socket(destinationIPs[i], portTCP));

			} catch (IOException ex) {
				System.out.println("TCP connection failure!");
			}

			try {
				sOut[i] = new DataOutputStream(clientConnections.get(i).
					getOutputStream());
				sIn[i] = new DataInputStream(clientConnections.get(i).
					getInputStream());
			} catch (IOException ex) {
				Logger.getLogger(Network.class.getName()).
					log(Level.SEVERE, null, ex);
			}
		}
	}

	public static Object receiveData() {
		return null;
	}

	public static boolean establishConnection(String address) {
		try {

			InetAddress addr = InetAddress.getByName(address);
			Socket cliente = new Socket(addr, activeInstances.get(addr));
			System.out.println("O cliente se conectou ao servidor!");
			Scanner teclado = new Scanner(System.in);
			PrintStream saida = new PrintStream(cliente.getOutputStream());
			while (teclado.nextLine().equalsIgnoreCase("Sair")) {

				saida.println(teclado.nextLine());

			}
			saida.close();
			teclado.close();
			cliente.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return true;
	}

	public static void waitForConnection() {
		serverThread = new Thread(new wait_for_message(portTCP));
		serverThread.start();
	}

	public static void interruptConnection() {
		serverThread.interrupt();
	}
}

class respond_to_request implements Runnable {

	DatagramSocket sock;
	int portUDP;
	int portTCP;

	public respond_to_request(int portUDP, int portTCP) {
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
			System.out.println("O porto esta ocupado");
			System.exit(1);
		} catch (SocketException ex) {
			Logger.getLogger(respond_to_request.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		String localName = "";
		try {
			localName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException ex) {
			Logger.getLogger(respond_to_request.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		while (true) {
			try {

				DatagramPacket request = new DatagramPacket(data, data.length);
				sock.receive(request);
				message = new String(request.getData(), 0, request.getLength());
				System.out.println("Mensagem" + message);

				Network.addClientToMap(Integer.parseInt(message), request.
									   getAddress());

				if (message.equals("Exit")) {
					sock.close();
					break;
				}

				clientIP = request.getAddress();
				clientPort = request.getPort();

				System.out.println("Client: " + clientPort);
				String port = String.format("%d", portTCP);
				data = port.getBytes();
				if (!(clientIP.getHostName()).equals(localName)) {
					DatagramPacket resposta = new DatagramPacket(data, port.
																 length(), clientIP, clientPort);
					sock.send(resposta);
				}

			} catch (IOException ex) {
				Logger.getLogger(respond_to_request.class.getName()).
					log(Level.SEVERE, null, ex);
			}
		}
	}
}

class wait_for_message implements Runnable {

	int port;

	public wait_for_message(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			ServerSocket servidor = new ServerSocket(port);
			System.out.println("Porta" + port + " aberta!");
			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente "
				+ cliente.getInetAddress().getHostAddress()
			);
//			Network.activeInstances.put(cliente.getInetAddress(), cliente.
//										getPort());
			Network.establishConnection(cliente.getInetAddress().getHostName());
			Scanner s = new Scanner(cliente.getInputStream());
			while (s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
			s.close();
			servidor.close();
			cliente.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
