/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import java.io.IOException;
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
public class NetworkReceiveService {

	private static Thread receiveUDP;
	private static final int TIMEOUT = 3;

	public NetworkReceiveService() {
	}

	public static void startReceivingUDPDatagrams(int portUDP, int portTCP) {
		receiveUDP = new Thread(new RespondToUDPRequest(portUDP, portTCP));
		receiveUDP.start();
	}

	public static void stopReceivingUDPDatagrams(int portUDP) {
		try {
			String localHost = InetAddress.getLocalHost().getHostName();

			InetAddress destinationIP = InetAddress.getByName(localHost);

			DatagramSocket socket = new DatagramSocket();
			byte[] data = new byte[300];
			String message = "Exit";
			data = message.getBytes();
			DatagramPacket exitMessage = new DatagramPacket(data, message.
															length(), destinationIP, portUDP);

			socket.send(exitMessage);
			receiveUDP.join();
		} catch (UnknownHostException ex) {
			Logger.getLogger(NetworkService.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (SocketException ex) {
			Logger.getLogger(NetworkService.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(NetworkService.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (InterruptedException ex) {
			Logger.getLogger(NetworkService.class.getName()).
				log(Level.SEVERE, null, ex);
		}

	}
}
