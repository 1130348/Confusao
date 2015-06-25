/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.call_function.ui;

import csheets.core.Cell;
import csheets.ext.call_function.CallFunctionController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Andre
 */
public class CallFunctionAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * The call function controller
     */
    private CallFunctionController controller;

    private int uiNumber; //will difference if the result is to store at the side bar, or at the active cell

    /**
     * Creates a new call function action.
     *
     * @param uiController the user interface controller
     * @param n the number that will say if the value is supposed to be stored
     * in the side bar or in the active cell
     */
    public CallFunctionAction(UIController uiController, int n) {
        this.uiController = uiController;
        this.controller = new CallFunctionController();
        this.uiNumber = n;

    }

    @Override
    protected String getName() {
        return "Execute Function";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CallFunctionUI ui = CallFunctionUI.getInstance(null, enabled, controller, uiNumber, uiController);
        ui.setVisible(true);

    }

}
