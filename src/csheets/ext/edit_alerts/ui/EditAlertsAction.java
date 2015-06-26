/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_alerts.ui;

import csheets.ext.findworkbooks.FindWorkbooksController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class EditAlertsAction extends FocusOwnerAction {

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
    public EditAlertsAction(UIController uiController) {
        this.uiController = uiController;
        this.findWorkBooksController = new FindWorkbooksController();
    }

    @Override
    protected String getName() {
        return "Alerts...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EditAlertsDialog dialog = EditAlertsDialog.getInstance(null, true);
        dialog.setVisible(true);
    }
}
