/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing.ui;

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
     * Creates a new start sharing action.
     *
     * @param uiController the user interface controller
     */
    public StartSharingAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Start Sharing...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChooseCleanSheetsInstanceToConnect dialog = ChooseCleanSheetsInstanceToConnect.getInstance(null, enabled);
        dialog.setVisible(true);
    }
 
}
