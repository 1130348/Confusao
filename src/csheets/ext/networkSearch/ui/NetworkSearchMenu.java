/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkSearch.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Luis
 */
class NetworkSearchMenu extends JMenu {

	public NetworkSearchMenu(UIController uiController) {
		super("Local Network");
		//setMnemonic(KeyEvent.);

		// Adds send action
		add(new NetworkSearchAction(uiController));
	}
}
