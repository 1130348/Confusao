/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_alerts.ui;

import csheets.ext.findworkbooks.ui.FindWorkbooksAction;
import csheets.ui.ctrl.UIController;
import java.awt.Event;
import javax.swing.JMenu;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class EditAlertsMenu extends JMenu {

    public EditAlertsMenu(UIController uiController) {
        super("Alerts");
		//setMnemonic(KeyEvent.);

        // Adds send action
        add(new EditAlertsAction(uiController));
    }
}
