package csheets.ext.contact.ui;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

import csheets.ext.Extension;
import csheets.ext.comments.ui.CommentPanel;
import csheets.ext.contact.ExtensionContact;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 * This class implements the UI interface extension for the simple extension.
 * A UI interface extension must extend the UIExtension abstract class.
 * @see UIExtension
 * @author Egidio Santos
 */
public class UIExtensionContact extends UIExtension {

	/** The icon to display with the extension's name */
	private Icon icon;

	/** The menu of the extension */
	private ContactMenuItem menu;
        
        /** A side bar that provides editing of comments */
	private JComponent sideBar;

	public UIExtensionContact(Extension extension, UIController uiController) {
		super(extension, uiController);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns an icon to display with the extension's name.
	 * @return an icon with style
	 */
        @Override
	public Icon getIcon() {
		if (icon == null)
			icon = new ImageIcon(ExtensionContact.class.getResource("res/img/range.gif"));
		return icon;
	}

	/**
         * 
	 * Returns an instance of a class that implements JMenu.
	 * In this simple case this class only supplies one menu option.
	 * @see ExampleMenu
	 * @return a JMenu component
	 */
        @Override
	public JMenuItem getMenuItem() {
		if (menu == null)
			menu = new ContactMenuItem(uiController);
		return menu;
	}
	
	/**
	 * Returns a cell decorator that visualizes the data added by the extension.
	 * @return a cell decorator, or null if the extension does not provide one
	 */
	public CellDecorator getCellDecorator() {
		return null;
	}

	/**
	 * Returns a table decorator that visualizes the data added by the extension.
	 * @return a table decorator, or null if the extension does not provide one
	 */
	public TableDecorator getTableDecorator() {
		return null;
	}	
	
	/**
	 * Returns a toolbar that gives access to extension-specific
	 * functionality.
	 * @return a JToolBar component, or null if the extension does not provide one
	 */
	public JToolBar getToolBar() {
		return null;
	}

	/**
	 * Returns a side bar that provides editing of comments.
	 * @return a side bar
	 */
        @Override
	public JComponent getSideBar() {
		if (sideBar == null)
			sideBar = new ContactPanel(uiController);
		return sideBar;
	}
}
