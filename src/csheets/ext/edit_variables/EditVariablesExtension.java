/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_variables;

import csheets.ext.Extension;
import csheets.ext.edit_variables.ui.UIExtensionEditVariables;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Antonio Pinheiro
 */
public class EditVariablesExtension extends Extension{
    /**
     * The name of the extension
     */
    public static final String NAME = "Edit Variables";

    /**
     * Creates a new Start Sharing extension.
     */
    public EditVariablesExtension() {
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
        return new UIExtensionEditVariables(this, uiController);
    }
}
