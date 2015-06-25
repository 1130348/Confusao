/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.navigation_window;

import csheets.core.navigation_window.ui.UIExtensionNavigationFunction;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Luis
 */
public class NavigationFunctionExtension extends Extension {

	/**
	 * The name of the extension
	 */
	public static final String NAME = "Navigation Workbook";

	/**
	 * Creates a new Call Function extension.
	 */
	public NavigationFunctionExtension() {
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
		return new UIExtensionNavigationFunction(this, uiController);
	}

}
