/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance.ui;

import csheets.ext.Extension;
import csheets.ext.networkSearch.ui.NetworkSearchPanel;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import javax.swing.JMenu;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class UIExtensionSearchOnAnotherInstance extends UIExtension {

	/**
	 * A menu that provides search woorkbooks on another instances
	 */
	private SearchOnAnotherInstanceMenu menu;

	/**
	 * A side bar that provides editing of comments
	 */
	private JComponent sideBar;

	/**
	 * Creates a new user interface extension for search woorkbooks on another
	 * instances.
	 *
	 * @param extension the extension for which components are provided
	 * @param uiController the user interface controller
	 */
	public UIExtensionSearchOnAnotherInstance(Extension extension,
											  UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns a menu that provides search woorkbooks on another instances.
	 *
	 * @return a JMenu component
	 */
	public JMenu getMenu() {
		if (menu == null) {
			menu = new SearchOnAnotherInstanceMenu(uiController);
		}
		return menu;
	}

	/**
	 * Returns a side bar that provides editing of comments.
	 *
	 * @return a side bar
	 */
	public JComponent getSideBar() {
		if (sideBar == null) {
			sideBar = new NetworkSearchPanel(uiController);
		}
		return sideBar;
	}

}
