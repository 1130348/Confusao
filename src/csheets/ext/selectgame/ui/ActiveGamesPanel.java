/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Sergio
 */
public class ActiveGamesPanel extends JPanel {

	public static JList activeGames = new JList();
	public static List gameList;

	public ActiveGamesPanel(UIController uicontroller) {
		super(new BorderLayout());
		JScrollPane scroll = new JScrollPane();
		gameList = new ArrayList<String>();

		scroll.setViewportView(activeGames);
		add(scroll);
	}

	public static void setActiveGame(String game) {
		gameList.add(game);
		activeGames.setListData(gameList.toArray());
	}

	public static void removeActiveGame(String game) {
		gameList.remove(game);
		activeGames.setListData(gameList.toArray());
	}
}
