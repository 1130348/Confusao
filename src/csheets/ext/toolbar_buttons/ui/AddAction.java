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
import csheets.ext.toolbar_buttons.ButtonsExtension;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;

/**
 * Add a new action button operation.
 *
 * @author Cristina Lopes
 */
@SuppressWarnings("serial")
public class AddAction extends ButtonsAction {

	private ButtonsController ctrl;

	/**
	 * Creates a new button action.
	 *
	 * @param uiController the user interface controller
	 */
	public AddAction(UIController uiController) {
		super(uiController);
		ctrl = new ButtonsController(this.uiController);
	}

	/**
	 * Returns the name
	 */
	protected String getName() {
		return "";
	}

	/**
	 * Defines the mnemonic and the icon of the button
	 */
	protected void defineProperties() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
		putValue(SMALL_ICON, new ImageIcon(ButtonsExtension.class.
				 getResource("res/img/Add.gif")));
	}

	/**
	 * The action that the button do
	 *
	 * @param event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		AddWindow b = new AddWindow(ctrl, uiController);
		b.setVisible(enabled);

	}

	protected void applyStyle(StylableCell cell) {
	}
}
