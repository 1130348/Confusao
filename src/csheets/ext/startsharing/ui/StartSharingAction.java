/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing.ui;

import csheets.core.Cell;
import csheets.ext.startsharing.StartSharingController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Paulo Pereira
 */
public class StartSharingAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    private UIController uiController;
    
    /**
     * The network controller
     */
    private StartSharingController startSharingController;

    /**
     * Creates a new start sharing action.
     *
     * @param uiController the user interface controller
     */
    public StartSharingAction(UIController uiController) {
        this.uiController = uiController;
        this.startSharingController = new StartSharingController();
    }

    @Override
    protected String getName() {
        return "Start Sharing...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChooseCleanSheetsInstanceToConnect dialog = new ChooseCleanSheetsInstanceToConnect(null, true, startSharingController);
        dialog.setVisible(true);
        
        Cell[][] selectCells = focusOwner.getSelectedCells();
        for (Cell[] row : selectCells){
            for (Cell cell : row) {
                startSharingController.sendObject(cell);
            }
        }
    }
 
}
