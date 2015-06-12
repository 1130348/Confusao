/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.ext.Extension;
import csheets.ext.comments.ui.CommentedCellDecorator;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 *
 * @author Marcos
 */
public class UIExtensionInsertImage extends UIExtension {

    /**
     * The icon to display with the extension's name
     */
//	private Icon icon;
    /**
     * A cell decorator that visualizes comments on cells
     */
	private CellDecorator cellDecorator;
    /**
     * A side bar that provides editing of comments
     */
    private JComponent sideBar;

    /**
     * The menu of the extension
     */
    private InsertImageMenu menu;

    public UIExtensionInsertImage(Extension extension, UIController uiController) {
        super(extension, uiController);
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns an icon to display with the extension's name.
     *
     * @return an icon with style
     */
    public Icon getIcon() {
        return null;
    }

    /**
     * Returns an instance of a class that implements JMenu. In this simple case
     * this class only supplies one menu option.
     *
     * @see ExampleMenu
     * @return a JMenu component
     */
    public JMenu getMenu() {
        if (menu == null) {
            menu = new InsertImageMenu(uiController);
        }
        return menu;
    }

    /**
     * Returns a cell decorator that visualizes comments on cells.
     *
     * @return decorator for cells with comments
     */
    public CellDecorator getCellDecorator() {
        if (cellDecorator == null) {
            cellDecorator = new InsertImageCellDecorator();
        }
        return cellDecorator;
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
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new InsertImagePanel(uiController);
        }
        return sideBar;

    }
}
