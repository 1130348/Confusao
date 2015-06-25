/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.MacrosWindow.ui;

import csheets.ext.findworkbooks.FindWorkbooksController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class MacrosWindowAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * The network controller
     */
    private final FindWorkbooksController findWorkBooksController;

    /**
     * Creates a new start sharing action.
     *
     * @param uiController the user interface controller
     */
    public MacrosWindowAction(UIController uiController) {
        this.uiController = uiController;
        this.findWorkBooksController = new FindWorkbooksController();
    }
    
    @Override
    protected String getName() {
        return "New Macro...";
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ChooseMacroTypeDialog dialog = new ChooseMacroTypeDialog(null, true, uiController);
        dialog.setVisible(true);
        
    }
}
