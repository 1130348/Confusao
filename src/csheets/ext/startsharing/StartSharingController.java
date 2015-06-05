/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class StartSharingController {

    public StartSharingController() {

    }

    public void changePort(int port) {
        Network.setPort(port);
    }

    public boolean establishConnection(String address) {
        return Network.establishConnection(address);
    }

    public boolean sendObject(Object obj) {
        return Network.sendData(obj);
    }

    public void setVisibleToOthers(boolean b) {
        Network.isVisibleToOthers(b);
    }

    public List<InetAddress> searchInstances() {
        return Network.searchInstances();
    }

    public void waitConnection() {
        Network.waitForConnection();
    }
}
