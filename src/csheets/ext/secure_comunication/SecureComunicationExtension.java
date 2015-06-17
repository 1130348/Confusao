/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication;

import csheets.ext.Extension;
import csheets.ext.secure_comunication.ui.UIExtensionSecureComunication;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author rddm
 */
public class SecureComunicationExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Secure Comunication";

    /**
     * Creates a new Start Sharing extension.
     */
    public SecureComunicationExtension() {
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
        return new UIExtensionSecureComunication(this, uiController);
    }
}
