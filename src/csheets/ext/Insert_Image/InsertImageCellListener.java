/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image;

import java.util.EventListener;

/**
 *
 * @author Marcos
 */
public interface InsertImageCellListener  extends EventListener {

	/**
	 * Invoked when a image is added to or removed from a cell.
	 * @param cell the cell that was modified
	 */
	public void imageChanged(InsertImageCell cell);
}