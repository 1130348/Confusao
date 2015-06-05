/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Enable_Disable.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author DMMCA
 */
public class UIExtensionsEnableDisable extends UIExtension {

	/**
	 * A side bar that provides editing of comments
	 */
	private JComponent sideBar;

	public UIExtensionsEnableDisable(Extension extension,
									 UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns a side bar that provides editing of comments.
	 *
	 * @return a side bar
	 */
	public JComponent getSideBar() {

		if (sideBar == null) {
			sideBar = new EnableDisablePanel(uiController);
		}
		return sideBar;

	}
}
