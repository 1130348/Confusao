/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks.ui;

import csheets.ext.findworkbooks.FindWorkbooksController;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class FindWorkbooksAction extends FocusOwnerAction {

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
    public FindWorkbooksAction(UIController uiController) {
        this.uiController = uiController;
        this.findWorkBooksController = new FindWorkbooksController();
    }

    @Override
    protected String getName() {
        return "Find Workbooks...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        FindWorkbookUI dialog = new FindWorkbookUI(null, enabled, findWorkBooksController);
        dialog.setVisible(true);
        /*JOptionPane.showMessageDialog(
                null,
                "Workbook search has started!\n"
                + "You can track the progress of your search "
                + "on the sidebar under \"Find Workbooks\"",
                "Search Started",
                JOptionPane.INFORMATION_MESSAGE
        );
        try {
            findWorkBooksController.startWorkbooksSearch();
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }*/
    }
}
