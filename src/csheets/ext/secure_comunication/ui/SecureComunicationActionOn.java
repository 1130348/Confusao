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
public class SecureComunicationActionOn extends FocusOwnerAction {

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
     */
    public SecureComunicationActionOn(UIController uiController,SecureComunicationController ctrl) {
        this.uiController = uiController;
        this.secureComunicationController = ctrl;
    }

    @Override
    protected String getName() {
        return "Enable SSL";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(
                null,
                "Client search has started!\n"
                + "You can track the progress of your search "
                + "on the sidebar under \"Secure Comunication\"",
                "Search Started",
                JOptionPane.INFORMATION_MESSAGE
        );
        secureComunicationController.starSSL();

    }

}
