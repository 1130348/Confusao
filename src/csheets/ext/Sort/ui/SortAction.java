/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Sort.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.FocusOwnerAction;
import java.awt.event.ActionEvent;

/**
 *
 * @author DMMCA
 */
public class SortAction extends FocusOwnerAction{

	/** The user interface controller */
	protected SortController uiController;
        private int typeofsort;
        private int columnToSort;

	/**
	 * Creates a new action.
	 * @param uiController the user interface controller
	 */
	SortAction(SortController uiController, int i) {
		this.uiController = uiController;
                this.typeofsort = i;
                this.columnToSort = -1;
	}

        @Override
	protected String getName() {
		return NAME;
                
	}

	/**
	 * A simple action that presents a confirmation dialog.
	 * If the user confirms then the contents of the cell A1 of the current sheet are set to the string "Changed".
	 * @param event the event that was fired
	 */
        @Override
	public void actionPerformed(ActionEvent event) {

                
                int numberOfColumns = super.focusOwner.getSelectedColumnCount();
                
                if (numberOfColumns == 1) {
                    uiController.sortCells(typeofsort, -1);
                }else{
                    ChooseColumnUI cui = new ChooseColumnUI(null, enabled, uiController, typeofsort, super.focusOwner);
                    cui.setVisible(true);
                }
                
		//uiController.sortCells(typeofsort);
                int a = 0;
	}
}
