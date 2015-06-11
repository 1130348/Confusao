/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame;

import csheets.ext.selectgame.ui.ActiveGamesPanel;
import csheets.ext.startsharing.NetworkService;
import csheets.ext.startsharing.ui.SendCellsAction;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sergio
 */
public class SelectGameController {

	public void changePort(int port) {
		NetworkService.setPort(port);
	}

	public void startServer(SendCellsAction cellsAction) {
		NetworkService.startServer(cellsAction);
	}

	public boolean establishConnection(List<String> addresses,
									   SendCellsAction action) {
		return NetworkService.establishConnection(addresses, action);
	}

	public void setActiveGame(String game) {
		ActiveGamesPanel.setActiveGame(game);
	}

	public void removeActiveGame(String game) {
		ActiveGamesPanel.removeActiveGame(game);
	}

	public void setVisibility(boolean b) {
		NetworkService.isVisibleToOthers(b);
	}

	public Map<InetAddress, Integer> searchInstances() {
		return NetworkService.searchInstances();
	}

	public void setSendPort(int port) {
		NetworkService.setPort(port);
	}

	public void interruptConnection() {
		NetworkService.interruptConnection();
	}

}
