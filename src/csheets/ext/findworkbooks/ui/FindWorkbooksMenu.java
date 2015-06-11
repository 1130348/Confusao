/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class FindWorkbooksMenu extends JMenu {
    
     public FindWorkbooksMenu(UIController uiController) {
		super("Search");
		//setMnemonic(KeyEvent.);

		// Adds send action
		add(new FindWorkbooksAction(uiController));
	}
}
