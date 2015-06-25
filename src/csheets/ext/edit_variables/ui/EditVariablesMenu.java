/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_variables.ui;

import csheets.ext.findworkbooks.ui.FindWorkbooksAction;
import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Antonio Pinheiro
 */
public class EditVariablesMenu extends JMenu{
    public EditVariablesMenu(UIController uiController) {
		super("Edit Variables");
                
		add(new EditVariablesAction(uiController));
	}
}
