/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 *
 * @author Marcos
 */
public class InsertImageMenu extends JMenu {

    static InsertImageController  controller;

    /**
     * Creates a new simple menu. This constructor creates and adds the menu
     * options. In this simple example only one menu option is created. A menu
     * option is an action (in this case {@link ImageInsertAction})
     *
     * @param uiController the user interface controller
     */
    public InsertImageMenu(UIController uiController) {
        super("Image");
        setMnemonic(KeyEvent.VK_N);
        //controller = new InsertImageController(uiController, this);
        

        // Adds a ImageInsertAction
        add(new InsertImageAction());
        add(new RemoveImageAction());
    }

}
