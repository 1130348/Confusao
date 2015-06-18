/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing.ui;

import csheets.ext.startsharing.StartSharingController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Egidio Santos
 */
public class StartAutomaticSharingAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * The network controller
     */
    private StartSharingController startSharingController;

    /**
     * The action of the button to send cells
     */
    private SendCellsAction sendCellsAction;

    /**
     * Creates a new start sharing action.
     *
     * @param uiController the user interface controller
     */
    public StartAutomaticSharingAction(UIController uiController,
            SendCellsAction scaction) {
        this.sendCellsAction = scaction;
        this.uiController = uiController;
        this.startSharingController = new StartSharingController();
    }

    @Override
    protected String getName() {
        return "Start Automatic Sharing...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChooseCleanSheetsInstanceToConnect dialog = ChooseCleanSheetsInstanceToConnect.
                getInstance(null, enabled, startSharingController, sendCellsAction);
        dialog.setVisible(true);
    }

}
