/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Paulo Pereira
 */
public class StartSharingMenu extends JMenu {

	public StartSharingMenu(UIController uiController) {
		super("Network");
		//setMnemonic(KeyEvent.);

		// Adds send action
		SendCellsAction scaction = new SendCellsAction(uiController);
		add(scaction);
		add(new StartSharingAction(uiController, scaction));
                add(new StartAutomaticSharingAction(uiController, scaction));

	}

}
