package csheets.ext.contact.ui;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;

import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Representes the UI extension menu of the simple extension.
 *
 * @author Egidio Santos
 */
public class ContactMenuItem extends JMenuItem {

    /**
     * Creates a new simple menu. This constructor creates and adds the menu
     * options. In this simple example only one menu option is created. A menu
     * option is an action (in this case
     * {@link csheets.ext.simple.ui.ExampleAction})
     *
     * @param uiController the user interface controller
     */
    public ContactMenuItem(UIController uiController) {
        super("Contacts");
        setMnemonic(KeyEvent.VK_C);

    }
}
