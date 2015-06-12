/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Sort;

import csheets.ext.Extension;
import csheets.ext.Sort.ui.UIExtensionSort;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author DMMCA
 */
public class SortExtension extends Extension{
	/** The name of the extension */
	public static final String NAME = "Sort";

	/**
	 * Creates a new Example extension.
	 */
	public SortExtension() {
		super(NAME);
	}
	

	/**
	 * Returns the user interface extension of this extension 
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionSort(this, uiController);
	}
    
}
