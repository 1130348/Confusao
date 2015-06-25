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
package csheets.ext.toolbar_buttons.ui;

import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.Component;
import java.awt.Insets;
import java.util.Date;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * A tool bar that displays style-related actions.
 *
 * @author Cristina Lopes
 */
@SuppressWarnings("serial")
public final class ButtonsToolBar extends JToolBar implements SelectionListener {

	/**
	 * The common button insets
	 */
	private static final Insets INSETS = new Insets(2, 2, 2, 2);

	/**
	 * The button for adding a button to the toolbar
	 */
	private final JToggleButton addButton;

	/**
	 * The uiController
	 */
	private final UIController uiController;

	/**
	 * Creates a new style tool bar.
	 *
	 * @param uiController the user interface controller
	 */
	public ButtonsToolBar(UIController uiController) {
		super(new Date().toString());
		this.uiController = uiController;
		this.uiController.addSelectionListener(this);
		// Adds font actions
		addButton = addToggleButton(new AddAction(uiController), "addButton", "");
		addSeparator();
	}

	/**
	 * Return a vector of the components of the toolbar
	 *
	 * @return components
	 */
	public Component[] getButtons() {
		return super.getComponents();
	}

	/**
	 * Adds a button with the given action to the tool bar, and reduces the
	 * default insets.
	 *
	 * @param action the action to add
	 * @return the button that was added
	 */
	@Override
	public JButton add(Action action) {
		JButton button = super.add(action);
		button.setMargin(INSETS);
		return button;
	}

	/**
	 * Adds a button with the given action to the tool bar, and reduces the
	 * default insets.
	 *
	 * @param action the action to add
	 * @param name
	 * @param toolTip
	 * @param groups the button groups to which the button belongs
	 * @return the button that was added
	 */
	public JToggleButton addToggleButton(Action action, String name,
										 String toolTip,
										 ButtonGroup... groups) {
		Component[] l = super.getComponents();
		for (Component l1 : l) {
			if (l1.getClass() == JToggleButton.class) {
				System.out.println(l1.getName());
			}
		}
		JToggleButton button = new JToggleButton(action);
		button.setSelected(false);
		button.setName(name);
		button.setToolTipText(toolTip);
		button.setMargin(INSETS);
		add(button);
		for (ButtonGroup group : groups) {
			group.add(button);
		}
		setVisible(false);
		setVisible(true);
		return button;
	}

	/**
	 * Selects buttons depending on the style of the active cell.
	 *
	 * @param event the selection event that was fired
	 */
	@Override
	public void selectionChanged(SelectionEvent event) {
		if (event.getCell() != null && event.isCellChanged()) {
			StylableCell cell = (StylableCell) event.getCell().getExtension(
				StyleExtension.NAME);
			addButton.setSelected(cell.getFont().isBold());
		}
	}

	/**
	 * This method will create the new button and add to the toolbar
	 */
	public void addButton(String name, String toolTip, String icon,
						  String selectedItem) {
		DefaultAction d = new DefaultAction(this.uiController, toolTip, icon, selectedItem);
		String tmp = name + "- " + toolTip;
		addToggleButton(d, name, tmp);
	}
}
