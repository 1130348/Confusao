/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.call_function.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Andre
 */
public class CallFunctionMenu extends JMenu {

    public CallFunctionMenu(UIController uiController) {
        super("Functions Wizard");

        // Adds send action
        add(new CallFunctionAction(uiController));
    }
}
