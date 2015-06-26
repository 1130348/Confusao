/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Form_Editor;

import csheets.ext.Extension;
import csheets.ext.Form_Editor.UI.UIExtensionFormEditor;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author DMMCA
 */
public class FormEditorExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Form Editor";

    /**
     * Creates a new Example extension.
     */
    public FormEditorExtension() {
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
        return new UIExtensionFormEditor(this, uiController);
    }
}
