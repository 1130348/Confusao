/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks;

import csheets.ext.Extension;
import csheets.ext.findworkbooks.ui.UIExtensionFindWorkbooks;
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
public class FindWorkbooksExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Find Workbooks";

    /**
     * Creates a new Start Sharing extension.
     */
    public FindWorkbooksExtension() {
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
        return new UIExtensionFindWorkbooks(this, uiController);
    }

}
