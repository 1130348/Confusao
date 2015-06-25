/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sendEmail.UI;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class SendEmailMenu extends JMenu {

	public SendEmailMenu(UIController uiController) {
		super("Email");

		// Adds send action
		add(new SendEmailAction(uiController));
	}
}
