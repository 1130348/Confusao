/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkSearch.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author Luis
 */
public class UIExtensionNetworkSearchInstance extends UIExtension {

	private NetworkSearchMenu menu;

	/**
	 * A side bar that provides editing of comments
	 */
	private JComponent sideBar;

	/**
	 * Creates a new user interface extension
	 *
	 * @param extension the extension for which components are provided
	 * @param uiController the user interface controller
	 */
	public UIExtensionNetworkSearchInstance(Extension extension,
											UIController uiController) {
		super(extension, uiController);
	}
}
