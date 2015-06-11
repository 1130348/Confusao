/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csheets.core.call_function.ui;

import csheets.core.call_function.CallFunctionController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Andre
 */
class CallFunctionAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    private UIController uiController;
    
    /**
     * The call function controller
     */
    private CallFunctionController controller;

    /**
     * Creates a new call function action.
     *
     * @param uiController the user interface controller
     */
    public CallFunctionAction(UIController uiController) {
        this.uiController = uiController;
        this.controller = new CallFunctionController();
    }

    @Override
    protected String getName() {
        return "Execute Function";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CallFunctionUI ui = CallFunctionUI.getInstance(null, enabled, controller);
        ui.setVisible(true);
        
    }
 
}

