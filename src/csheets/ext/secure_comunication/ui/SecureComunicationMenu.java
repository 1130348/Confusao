/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication.ui;

import csheets.ext.secure_comunication.SecureComunicationController;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author rddm
 */
public class SecureComunicationMenu extends JMenu {

    private UIController uiController;

    public SecureComunicationMenu(UIController uIController) {
        super("Secure Comunication");
        //add(new SecureComunicationActionOff(uiController));
        SecureComunicationController secureComunicationController = new SecureComunicationController();
        BaseAction sa = new SecureComunicationActionOn(uIController,secureComunicationController);
        add(sa);
        sa = new SecureComunicationActionOff(uIController,secureComunicationController);
        add(sa);
    }

}
