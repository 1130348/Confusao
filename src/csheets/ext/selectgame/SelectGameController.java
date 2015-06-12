/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame;

import csheets.ext.selectgame.ui.ActiveGamesPanel;
import csheets.ext.selectgame.ui.ChoosePartner;
import csheets.ext.selectgame.ui.GameScene;
import csheets.ext.startsharing.NetworkSendService;
import csheets.ext.startsharing.NetworkService;
import java.net.InetAddress;
import java.util.Map;

/**
 *
 * @author Sergio
 */
public class SelectGameController {

	public void establishConnection(String playerName) {
		NetworkService.establishConnectionToUser(playerName);
	}

	public void sendUserInfo(Player player) {
		NetworkSendService.sendUserInfo(player);
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

	public void startGameServer(GameScene dialog, Player player, ChoosePartner partnersDialog) {
		NetworkService.startGameServer(dialog, player, partnersDialog);
	}

	public void interruptConnection() {
		NetworkService.interruptConnection();
	}

}
