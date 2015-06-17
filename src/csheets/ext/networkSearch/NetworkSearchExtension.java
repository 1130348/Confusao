/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkSearch;

import csheets.ext.Extension;
import csheets.ext.networkSearch.ui.UIExtensionNetworkSearchInstance;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Luis
 */
public class NetworkSearchExtension extends Extension {

	/**
	 * The name of the extension
	 */
	public static final String NAME = "Local Network Results";

	/**
	 * Creates a new Search on another instance extension.
	 */
	public NetworkSearchExtension() {
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
		return new UIExtensionNetworkSearchInstance(this, uiController);
	}
}
