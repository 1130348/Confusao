/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.export.ui;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Luis Lopes <1130752@isep.ipp.pt>
 */
public class ExportAsAction extends FocusOwnerAction{
    
    private UIController uiController;
    private CleanSheets app;

    public ExportAsAction(CleanSheets app, UIController uiController) {
        this.uiController = uiController;
        this.app = app;
    }

    @Override
    protected String getName() {
        return "Export as...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Cell[][] selectedCells = focusOwner.getSelectedCells();
       
       ExportAsDialog dialog = new ExportAsDialog(null, true, uiController, app,selectedCells);
       dialog.setVisible(true);
    }
    
    
    
}
