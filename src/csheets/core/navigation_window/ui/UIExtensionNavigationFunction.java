/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.navigation_window.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JMenu;

/**
 *
 * @author Luis
 */
public class UIExtensionNavigationFunction extends UIExtension {

	/**
	 * A menu that provides call function
	 */
	private NavigationFunctionMenu menu;

	/**
	 * Creates a new user interface extension for call function.
	 *
	 * @param extension the extension for which components are provided
	 * @param uiController the user interface controller
	 */
	public UIExtensionNavigationFunction(Extension extension,
										 UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns a menu that provides editing of style.
	 *
	 * @return a JMenu component
	 */
	public JMenu getMenu() {
		if (menu == null) {
			menu = new NavigationFunctionMenu(uiController);
		}
		return menu;
	}
}
