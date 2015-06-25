/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_alerts;

import csheets.ext.Extension;
import csheets.ext.edit_alerts.ui.UIExtensionEditAlerts;
import csheets.ext.findworkbooks.ui.UIExtensionFindWorkbooks;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */

    public class EditAlertsExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Edit Alerts";

    /**
     * Creates a new Start Sharing extension.
     */
    public EditAlertsExtension() {
        super(NAME);
    }

    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionEditAlerts(this, uiController);
    }
}
