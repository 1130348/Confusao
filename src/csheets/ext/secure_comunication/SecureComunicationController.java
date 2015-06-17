/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication;

import csheets.ext.findworkbooks.ui.FindWorkbooksPanel;
import csheets.ext.startsharing.NetworkService;
import java.util.List;

/**
 *
 * @author rddm
 */
public class SecureComunicationController {

    public SecureComunicationController() {
    }

    public void searchInstances() {
        NetworkService.isVisibleToOthers(true);
    }
}
