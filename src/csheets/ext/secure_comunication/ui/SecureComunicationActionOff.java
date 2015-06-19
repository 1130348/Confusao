/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication.ui;

import csheets.ext.secure_comunication.SecureComunicationController;
import csheets.ext.startsharing.NetworkService;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author rddm
 */
public class SecureComunicationActionOff extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * The controller
     */
    private final SecureComunicationController secureComunicationController;

    /**
     *
     *
     * @param uiController the user interface controller
     * @param ctrl
     */
    public SecureComunicationActionOff(UIController uiController,SecureComunicationController ctrl) {
        this.uiController = uiController;
        this.secureComunicationController=ctrl;

    }

    @Override
    protected String getName() {
        return "Disable SSL";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(
                null,
                "SSL server is now off!",
                "Server OFF",
                JOptionPane.INFORMATION_MESSAGE);
        secureComunicationController.stopSSL();

    }

}
