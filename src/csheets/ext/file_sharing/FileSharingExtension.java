/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing;

import csheets.ext.Extension;
import csheets.ext.file_sharing.ui.UIExtensionFileSharing;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Marcos
 */
public class FileSharingExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "File Sharing";

    /**
     * Creates a new InsertImage extension.
     */
    public FileSharingExtension() {
        super(NAME);
    }

    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionFileSharing(this, uiController);
    }
}