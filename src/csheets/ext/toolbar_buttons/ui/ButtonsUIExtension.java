/*
 * Copyright (c) 2005 Einar Pehrson
 *
 * This file is part of
 * CleanSheets Extension for Style
 *
 * CleanSheets Extension for Style is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * CleanSheets Extension for Style is distributed in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets Extension for Style; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 */
package csheets.ext.toolbar_buttons.ui;

import csheets.ext.style.StyleExtension;
import csheets.ext.toolbar_buttons.ButtonsExtension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 * The user interface extension for buttons.
 *
 * @author Cristina Lopes
 */
public class ButtonsUIExtension extends UIExtension {

	/**
	 * The icon to display with the extension's name
	 */
	private Icon icon;

	/**
	 * A menu that provides editing of buttons
	 */
	private ButtonsMenu menu;

	/**
	 * A toolbar that provides editing of buttons
	 */
	private ButtonsToolBar toolBar;

	/**
	 * Creates a new user interface extension for buttons.
	 *
	 * @param extension the extension for which components are provided
	 * @param uiController the user interface controller
	 */
	public ButtonsUIExtension(ButtonsExtension extension,
							  UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns an icon to display with the extension's name.
	 *
	 * @return an icon with style
	 */
	public Icon getIcon() {
		if (icon == null) {
			icon = new ImageIcon(
				StyleExtension.class.getResource("res/img/logo.gif"));
		}
		return icon;
	}

	/**
	 * Returns a menu that provides adding an action button.
	 *
	 * @return a JMenu component
	 */
	public JMenu getMenu() {
		if (menu == null) {
			menu = new ButtonsMenu(uiController);
		}
		return menu;
	}

	/**
	 * Returns a toolbar that provides adding an action button.
	 *
	 * @return a JToolBar component
	 */
	public JToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new ButtonsToolBar(uiController);
		}
		return toolBar;
	}

	/**
	 * Returns the toolbar that is already created
	 *
	 * @return toolBar
	 */
	public ButtonsToolBar getActualToolBar() {
		return this.toolBar;
	}

	/**
	 * Returns the sidebar
	 *
	 * @return null
	 */
	@Override
	public JComponent getSideBar() {
		return null;
	}
}
