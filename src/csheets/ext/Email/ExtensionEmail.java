/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Email;

import csheets.ext.Email.UI.UIEmail;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

public class ExtensionEmail extends Extension {

	/**
	 * The Default Name
	 */
	public static final String NAME = "Email";

	public ExtensionEmail() {
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
		return new UIEmail(this, uiController);
	}
}
