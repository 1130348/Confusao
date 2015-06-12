/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame;

import csheets.ext.Extension;
import csheets.ext.selectgame.ui.UIExtensionSelectGame;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Sergio
 */
public class SelectGameExtension extends Extension {

	/**
	 * The name of the extension
	 */
	public static final String NAME = "Active Games";

	/**
	 * Creates a new Start Sharing extension.
	 */
	public SelectGameExtension() {
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
		return new UIExtensionSelectGame(this, uiController);
	}
}
