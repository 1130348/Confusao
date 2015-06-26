/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_alerts.ui;

import csheets.ext.Extension;
import csheets.ext.findworkbooks.ui.FindWorkbooksMenu;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JMenu;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class UIExtensionEditAlerts extends UIExtension {

    /**
     * A menu that provides start sharing
     */
    private EditAlertsMenu menu;

    /**
     * Creates a new user interface extension for start sharing.
     *
     * @param extension the extension for which components are provided
     * @param uiController the user interface controller
     */
    public UIExtensionEditAlerts(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a menu that provides editing of style.
     *
     * @return a JMenu component
     */
    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new EditAlertsMenu(uiController);
        }
        return menu;
    }

}
