/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import csheets.ext.startsharing.ui.SendCellsAction;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 */
public class Server implements Runnable {

	SendCellsAction sendCells;
	boolean isRunning;
	int port;
	Map<Socket, DataOutputStream> clientConnections;
	ServerSocket svSocket;
	Semaphore sem;

	public Server(SendCellsAction sendCellsAction, int port) {
		this.sendCells = sendCellsAction;
		this.port = port;
		this.clientConnections = new HashMap<Socket, DataOutputStream>();
		this.sem = new Semaphore(1);
		this.isRunning = true;
	}

	@Override
	public void run() {
		int option;
		try {
			svSocket = new ServerSocket(port);
			System.out.println("Porta" + port + " aberta!");
			Socket client;
			while (isRunning) {
				sem.acquire();
				client = svSocket.accept();
				option = JOptionPane.showConfirmDialog(null, client.
													   getInetAddress().
													   getCanonicalHostName() + " wants to establish a remote connection to your computer, do you accept it?", "Remote connection request", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (option == 1) {
					clientConnections.
						put(client, new DataOutputStream(client.
								getOutputStream()));

					new Thread(new ReceiveData(client, sendCells)).start();
				} else {
					client.close();
				}
				sem.release();
			}

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (InterruptedException ex) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
