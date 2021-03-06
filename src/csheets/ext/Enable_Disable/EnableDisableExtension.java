/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Enable_Disable;

import csheets.ext.Enable_Disable.ui.UIExtensionsEnableDisable;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Marcos
 */
public class EnableDisableExtension extends Extension {

	/**
	 * The Default Name
	 */
	public static final String NAME = "Enable/Disable";

	public EnableDisableExtension() {
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
		return new UIExtensionsEnableDisable(this, uiController);
	}
}
