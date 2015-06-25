/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Email.UI;

import csheets.ext.Email.ExtensionEmail;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class UIEmail extends UIExtension {

	/**
	 * A side bar that provides editing of comments
	 */
	private JComponent sideBar;

	private ImageIcon icon;

	public UIEmail(Extension extension,
				   UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns an icon to display with the extension's name.
	 *
	 * @return an icon, or null if the extension does not provide one
	 */
	public Icon getIcon() {
		if (icon == null) {
			icon = new ImageIcon(ExtensionEmail.class.
				getResource("res/img/email.png"));
		}
		return icon;
	}

	/**
	 * Returns a cell decorator that visualizes the data added by the extension.
	 *
	 * @return a cell decorator, or null if the extension does not provide one
	 */
	public CellDecorator getCellDecorator() {
		return null;
	}

	/**
	 * Returns a table decorator that visualizes the data added by the
	 * extension.
	 *
	 * @return a table decorator, or null if the extension does not provide one
	 */
	public TableDecorator getTableDecorator() {
		return null;
	}

	/**
	 * Returns a menu component that gives access to extension-specific
	 * functionality.
	 *
	 * @return a JMenu component, or null if the extension does not provide one
	 */
	public JMenu getMenu() {
		return null;
	}

	/**
	 * Returns a toolbar that gives access to extension-specific functionality.
	 *
	 * @return a JToolBar component, or null if the extension does not provide
	 * one
	 */
	public JToolBar getToolBar() {
		return null;
	}

	/**
	 * Returns a menuItem component that gives access to extension-specific
	 * functionality.
	 *
	 * @return a JMenuItem component, or null if the extension does not provide
	 * one
	 */
	public JMenuItem getMenuItem() {
		return null;
	}

	/**
	 * Returns a side bar that gives access to extension-specific functionality.
	 *
	 * @return a component, or null if the extension does not provide one
	 */
	public JComponent getSideBar() {
		if (sideBar == null) {
			sideBar = new EmailMenu(uiController);
		}
		return sideBar;
	}
}
