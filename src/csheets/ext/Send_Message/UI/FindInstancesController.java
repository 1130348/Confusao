/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message.UI;

import csheets.ext.Send_Message.Connection;
import java.io.IOException;

/**
 *
 * @author Jose
 */
public class FindInstancesController {

	private static FindInstancesUI FSUI;
	private static Connection server = null;

	public void setFindInstanesUI(FindInstancesUI s) throws IOException {
		FSUI = s;
	}

	public void create() {

		createServer();
	}

	private void createServer() {
		Thread Server = new Thread() {
			@Override
			public void run() {
				try {
					if (server == null) {
						server = new Connection(3439);
						System.out.println(server.getConServerSocket());
					}
					Connection.setListenner();
					Connection.searchActiveInstances();
					server.setInstancesUI(FSUI);

					server.createThreads();
					FSUI.SetConnection(server.getConSocket().getInetAddress().
						toString().substring(1, server.getConSocket().
											 getInetAddress().toString().
											 length()));
				} catch (IOException ex) {

				}
			}
		};
		Server.start();
	}
}
