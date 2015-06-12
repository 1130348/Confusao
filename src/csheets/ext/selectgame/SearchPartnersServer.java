/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame;

import csheets.ext.searchOnAnotherInstance.SearchOnAnotherInstanceServer;
import csheets.ext.selectgame.ui.GameScene;
import csheets.ext.startsharing.NetworkSendService;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class SearchPartnersServer extends Observable implements Runnable {

	private int port = 9001;

	private GameScene gameInfoDialog;

	private Player player;

	public SearchPartnersServer(GameScene dialog, Player playerToSend) {
		gameInfoDialog = dialog;
		player = playerToSend;
	}

	@Override
	public void run() {
		try {
			ServerSocket servidor = new ServerSocket(port);
			System.out.println("Porta " + port + " aberta!");
			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente "
				+ cliente.getInetAddress().getHostAddress());

			if (NetworkSendService.connectionState == false) {
				NetworkSendService.
					establishConnectionToUser(cliente.getInetAddress());
			}

			ObjectInputStream entrada = new ObjectInputStream(cliente.
				getInputStream());
			Object object = entrada.readObject();

			NetworkSendService.sendUserInfo(player);

			Player playerReceived = ((Player) object);
			gameInfoDialog.setPartnerData(playerReceived);

		} catch (IOException ex) {
			Logger.getLogger(SearchOnAnotherInstanceServer.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SearchOnAnotherInstanceServer.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

}
