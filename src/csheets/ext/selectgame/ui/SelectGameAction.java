/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame.ui;

import csheets.ext.selectgame.SelectGameController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Sergio
 */
public class SelectGameAction extends FocusOwnerAction {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * The network controller
	 */
	private SelectGameController selectGameController;

	/**
	 * Creates a new start sharing action.
	 *
	 * @param uiController the user interface controller
	 */
	public SelectGameAction(UIController uiController) {
		this.uiController = uiController;
		this.selectGameController = new SelectGameController();
	}

	/**
	 * Returns the name of the extension
	 *
	 * @return extension name
	 */
	@Override
	protected String getName() {
		return "Select Game...";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ChoosePartner dialog = ChoosePartner.
			getInstance(null, enabled, selectGameController);
		dialog.setVisible(true);
	}
}
