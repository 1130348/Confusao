/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame;

import javax.swing.ImageIcon;

/**
 *
 * @author Sergio
 */
public class Player {

	private String name;

	private ImageIcon playerIcon;

	public Player() {

	}

	public String getName() {
		return name;
	}

	public ImageIcon getPlayerIcon() {
		return playerIcon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlayerIcon(ImageIcon playerIcon) {
		this.playerIcon = playerIcon;
	}
}
