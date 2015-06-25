/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.ext.Extension;
import csheets.ext.searchOnAnotherInstance.ui.UIExtentionSearchByContent;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Luis Lopes <1130752@isep.ipp.pt>
 */
public class SearchByContentExtension extends Extension {

	/**
	 * The name of the extension
	 */
	public static final String NAME = "Workbook Search By Content";

	/**
	 * Creates a new Search on another instance extension.
	 */
	public SearchByContentExtension() {
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
		return new UIExtentionSearchByContent(this, uiController);
	}
}