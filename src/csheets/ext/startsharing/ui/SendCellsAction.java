/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing.ui;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.ext.startsharing.SendCellsController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Paulo Pereira
 */
public class SendCellsAction extends FocusOwnerAction {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * The network controller
	 */
	private SendCellsController sendCellsController;

	/**
	 * Creates a new start sharing action.
	 *
	 * @param uiController the user interface controller
	 */
	public SendCellsAction(UIController uiController) {
		super.setEnabled(false);
		this.uiController = uiController;
		this.sendCellsController = new SendCellsController();
	}

	@Override
	protected String getName() {
		return "Send Cells...";
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Cell[][] selectedCells = focusOwner.getSelectedCells();

		sendCellsController.sendCells(selectedCells);

	}

	public void replaceCells(List<Cell> newCells) {
		Address add;
		for (Cell newCell : newCells) {
			add = newCell.getAddress();
			focusOwner.getModel().
				setValueAt(newCell.getValue(), add.getRow(), add.
						   getColumn());
		}

	}

}
