/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;
import csheets.ext.Extension;
import csheets.ext.startsharing.ui.UIExtensionStartSharing;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * An extension to support the sending of a range of cell. An extension must
 * extend the Extension abstract class. The class that implements the Extension
 * is the "bootstrap" of the extension.
 *
 * @see Extension
 * @author Paulo Pereira
 */
public class StartSharingExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "StartSharing";

    /**
     * Creates a new Start Sharing extension.
     */
    public StartSharingExtension() {
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
        return new UIExtensionStartSharing(this, uiController);
    }

}
