/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image;

import csheets.core.Cell;
import csheets.ext.Extension;
import csheets.ext.Insert_Image.ui.UIExtensionInsertImage;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Marcos
 */
public class InsertImageExtension extends Extension {

	/** The name of the extension */
	public static final String NAME = "Image";

	/**
	 * Creates a new Example extension.
	 */
	public InsertImageExtension() {
		super(NAME);
	}
	
	/**
	 * Makes the given cell with image.
	 * @param cell the cell to insert image
	 * @return a image cell
	 */
	public InsertImageCell extend(Cell cell) {
		return new InsertImageCell(cell);
	}
	
	/**
	 * Returns the user interface extension of this extension 
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionInsertImage(this, uiController);
	}
}