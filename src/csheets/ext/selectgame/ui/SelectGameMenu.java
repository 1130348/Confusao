/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Sergio
 */
public class SelectGameMenu extends JMenu {

	public SelectGameMenu(UIController uiController) {
		super("Games");
		//setMnemonic(KeyEvent.);

		// Adds send action
		add(new SelectGameAction(uiController));
	}
}
