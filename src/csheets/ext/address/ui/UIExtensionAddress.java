package csheets.ext.address.ui;

import javax.swing.JComponent;
import javax.swing.JToolBar;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.JMenuItem;

/**
 * This class implements the UI interface extension for the simple extension. A
 * UI interface extension must extend the UIExtension abstract class.
 *
 * @see UIExtension
 * @author Cristina Lopes
 */
public class UIExtensionAddress extends UIExtension {

	/**
	 * The menu of the extension
	 */
	private AddressMenuItem menu;

	/**
	 * A side bar that provides editing of comments
	 */
	private JComponent sideBar;

	public UIExtensionAddress(Extension extension, UIController uiController) {
		super(extension, uiController);
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 * Returns an instance of a class that implements JMenu. In this simple case
	 * this class only supplies one menu option.
	 *
	 * @see ExampleMenu
	 * @return a JMenu component
	 */
	@Override
	public JMenuItem getMenuItem() {
		if (menu == null) {
			menu = new AddressMenuItem(uiController);
		}
		return menu;
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
	 * Returns a toolbar that gives access to extension-specific functionality.
	 *
	 * @return a JToolBar component, or null if the extension does not provide
	 * one
	 */
	public JToolBar getToolBar() {
		return null;
	}

	/**
	 * Returns a side bar that provides editing of comments.
	 *
	 * @return a side bar
	 */
	@Override
	public JComponent getSideBar() {
		if (sideBar == null) {
			sideBar = new AddressPanel(uiController);
		}
		return sideBar;
	}
}
