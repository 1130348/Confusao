/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
class SearchOnAnotherInstanceMenu extends JMenu {

	public SearchOnAnotherInstanceMenu(UIController uiController) {
		super("Distributed Search of Worbooks");
		//setMnemonic(KeyEvent.);

		// Adds send action
		add(new SearchOnAnotherInstanceAction(uiController));
		//add(new NetworkSearchAction(uiController));
	}
}
