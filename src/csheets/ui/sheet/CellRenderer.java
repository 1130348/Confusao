/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package csheets.ui.sheet;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.ext.Insert_Image.InsertImageCell;
import csheets.ext.Insert_Image.InsertImageExtension;
import csheets.ext.comments.CommentableCell;
import csheets.ext.comments.CommentsExtension;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.UIExtension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.text.Format;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * The renderer used for cells in a spreadsheet.
 *
 * @author Einar Pehrson
 */
@SuppressWarnings("serial")
public class CellRenderer extends DefaultTableCellRenderer {

	/**
	 * The cell decorators invoked by the renderer
	 */
	private LinkedList<CellDecorator> decorators = new LinkedList<CellDecorator>();

	/**
	 * The cell currently being rendered
	 */
	private Cell cell;

	/**
	 * Whether the cell currently being rendered is selected
	 */
	private boolean selected = false;

	/**
	 * Whether the cell currently being rendered has the focus
	 */
	private boolean hasFocus = false;

	/**
	 * Creates a new cell renderer.
	 *
	 * @param uiController the user interface controller
	 */
	public CellRenderer(UIController uiController) {
		// Fetches decorators
		for (UIExtension extension : uiController.getExtensions()) {
			CellDecorator decorator = extension.getCellDecorator();
			if (decorator != null) {
				decorators.add(decorator);
			}
		}
	}

	public Component getTableCellRendererComponent(JTable table, Object o,
												   boolean selected,
												   boolean hasFocus, int row,
												   int column) {
		super.
			getTableCellRendererComponent(table, o, selected, hasFocus, row, column);

		// Stores members
		this.cell = (Cell) o;
		this.selected = selected;
		this.hasFocus = hasFocus;

		if (cell != null) {
			// Fetches style
			StylableCell stylableCell = (StylableCell) cell.
				getExtension(StyleExtension.NAME);

			// Applies format and updates text
			Value value = cell.getValue();
			Format format = stylableCell.getFormat();
			setText(format == null ? value.toString() : value.toString(format));

			// Applies alignment, font and border
			setHorizontalAlignment(stylableCell.getHorizontalAlignment());
			setVerticalAlignment(stylableCell.getVerticalAlignment());
			setFont(stylableCell.getFont());
			setBorder(stylableCell.getBorder());

			// Applies color
			if (!selected) {
				setBackground(stylableCell.getBackgroundColor());
				if (value.getType() == Value.Type.ERROR) {
					setForeground(Color.red);
				} else {
					setForeground(stylableCell.getForegroundColor());
				}
			}

//                        table = new JTable() {
//                @Override
//                public JToolTip createToolTip() {
//
//                    return new MultiLineToolTip();
//                }
//            };
			// Applies tool tip
			if (value.getType() == Value.Type.ERROR) {
				try {
					setToolTipText(value.toError().getMessage());
				} catch (IllegalValueTypeException e) {
				}
			}

			CommentableCell commentableCell = (CommentableCell) cell.
				getExtension(CommentsExtension.NAME);

			if (commentableCell.hasComment()) {

				setToolTipText("<html>" + commentableCell.
					getAllComments() + "<br>" + "Edited by: " + commentableCell.
					getUser() + "</html>");
			} else {
				setToolTipText(null);
			}

			InsertImageCell imageCell = (InsertImageCell) cell.
				getExtension(InsertImageExtension.NAME);

			String OS = System.getProperty("os.name").toLowerCase();

			if (!commentableCell.hasComment()) {

				if (imageCell.hasImage()) {
//                    if (OS.indexOf("win") > 0) { // verifies if it is windows
					setToolTipText("<html><img src=\"file:\\" + imageCell.
						getImage() + "\"width=\"64\" height=\"64\"></html>");
//                    }else { // it is mac
//                        setToolTipText("<html><img src=\"file://" + imageCell.getImage() + "\"width=\"64\" height=\"64\"></html>");
//                    }
				} else {
					setToolTipText(null);
				}
			} else {
				if (imageCell.hasImage()) {
//                    if (OS.indexOf("win") > 0) { // verifies if it is windows
					setToolTipText("<html><img src=\"file:\\" + imageCell.
						getImage() + "\"width=\"64\" height=\"64\"></html>");
//                    }else { // it is mac
//                        setToolTipText("<html><img src=\"file://" + imageCell.getImage() + "\"width=\"64\" height=\"64\"></html>");
//                    }
				}
			}
		}
		return this;
	}

	/**
	 * Overridden to delegate painting to decorators.
	 *
	 * @param g the Graphics object to protect
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (cell != null) // Invokes decorators
		{
			for (CellDecorator decorator : decorators) {
				if (decorator.isEnabled()) {
					decorator.decorate(this, g, cell, selected, hasFocus);
				}
			}
		}
	}
}
