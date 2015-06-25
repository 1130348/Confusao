/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csheets.ext.call_function;

import csheets.ext.call_function.ui.UIExtensionCallFunction;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Andre
 */
public class CallFunctionExtension extends Extension {

    /**
	 * The name of the extension
	 */
	public static final String NAME = "Formulas Register";

    /**
     * Creates a new Call Function extension.
     */
    public CallFunctionExtension() {
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
        return new UIExtensionCallFunction(this, uiController);
    }

}
