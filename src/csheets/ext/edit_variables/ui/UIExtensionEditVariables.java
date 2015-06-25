/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_variables.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import javax.swing.JMenu;

/**
 *
 * @author Antonio Pinheiro
 */
public class UIExtensionEditVariables extends UIExtension{

   /**
     * A menu that provides start sharing
     */
    private EditVariablesMenu menu;

    private JComponent sideBar;

    /**
     * Creates a new user interface extension for start sharing.
     *
     * @param extension the extension for which components are provided
     * @param uiController the user interface controller
     */
    public UIExtensionEditVariables(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a menu that provides editing of style.
     *
     * @return a JMenu component
     */
    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new EditVariablesMenu(uiController);
        }
        return menu;
    }

    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new EditVariablesPanel(uiController);
        }
        return sideBar;
    }

}
