/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Sort.ui;

import csheets.ui.ctrl.BaseAction;
import java.awt.event.ActionEvent;

/**
 *
 * @author DMMCA
 */
public class SortAction extends BaseAction{

	/** The user interface controller */
	protected SortController uiController;
        private int typeofsort;

	/**
	 * Creates a new action.
	 * @param uiController the user interface controller
	 */
	SortAction(SortController uiController, int i) {
		this.uiController = uiController;
                this.typeofsort = i;
                
	}

	protected String getName() {
		return NAME;
                
	}

	protected void defineProperties() {
	}

	/**
	 * A simple action that presents a confirmation dialog.
	 * If the user confirms then the contents of the cell A1 of the current sheet are set to the string "Changed".
	 * @param event the event that was fired
	 */
	public void actionPerformed(ActionEvent event) {

		uiController.sortCells(typeofsort);
	}
}
