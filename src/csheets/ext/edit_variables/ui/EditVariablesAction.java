/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_variables.ui;

import csheets.ext.Extension;
import csheets.ext.edit_variables.EditVariablesController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Pinheiro
 */
public class EditVariablesAction extends FocusOwnerAction {
    
    /**
     * The user interface controller
     */
    private final UIController uiController;

   

    /**
     * Creates a new start sharing action.
     *
     * @param uiController the user interface controller
     */
    public EditVariablesAction(UIController uiController) {
        this.uiController = uiController;
        
    }

    @Override
    protected String getName() {
        return "Edit Variables...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UIExtension[] l = uiController.getExtensions();
        for (UIExtension l1 : l) {
            if(l1.getExtension().getName().equals("Edit Variables"))
            {
                EditVariablesPanel evp = (EditVariablesPanel) l1.getSideBar();
                evp.modifications();
            }
        }
    }
}
