/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.call_function.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import javax.swing.JMenu;

/**
 *
 * @author Andre
 */
public class UIExtensionCallFunction extends UIExtension {

    /**
     * A menu that provides call function
     */
    private CallFunctionMenu menu;

    private JComponent sideBar;

    /**
     * Creates a new user interface extension for call function.
     *
     * @param extension the extension for which components are provided
     * @param uiController the user interface controller
     */
    public UIExtensionCallFunction(Extension extension,
                                   UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a menu that provides editing of style.
     *
     * @return a JMenu component
     */
    public JMenu getMenu() {
        if (menu == null) {
            menu = new CallFunctionMenu(uiController);
        }
        return menu;
    }

    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new FormulasPanel(uiController);
        }
        return sideBar;
    }

}
