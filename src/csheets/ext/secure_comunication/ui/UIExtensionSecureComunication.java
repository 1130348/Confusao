/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication.ui;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import javax.swing.JMenu;

/**
 * This class implements the UI interface extension for the start sharing
 * extension. A UI interface extension must extend the UIExtension abstract
 * class.
 *
 * @see UIExtension
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class UIExtensionSecureComunication extends UIExtension {

    /**
     * A menu that provides start sharing
     */
    private SecureComunicationMenu menu;

    private JComponent sideBar;

    /**
     * Creates a new user interface extension for start sharing.
     *
     * @param extension the extension for which components are provided
     * @param uiController the user interface controller
     */
    public UIExtensionSecureComunication(Extension extension, UIController uiController) {
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
            menu = new SecureComunicationMenu(uiController);
        }
        return menu;
    }

    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new SecureComunicationPanel(uiController);
        }
        return sideBar;
    }

}
