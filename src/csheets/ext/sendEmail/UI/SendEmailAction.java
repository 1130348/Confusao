/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sendEmail.UI;

import csheets.core.Cell;
import csheets.ext.sendEmail.SendEmailController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class SendEmailAction extends FocusOwnerAction {

	private UIController uiController;

	public SendEmailAction(UIController uiController) {
		super();
		this.uiController = uiController;
	}

	@Override
	protected String getName() {
		return "Send Email...";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			SendEmailController.getInstance().initiateSession();
			Cell[][] cells = focusOwner.getSelectedCells();
			SendEmailDialog dialog = new SendEmailDialog(null, true, cells);
			dialog.setVisible(true);
		} catch (IOException ex) {
			JOptionPane.
				showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
