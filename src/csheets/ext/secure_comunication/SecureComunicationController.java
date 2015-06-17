/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication;

import csheets.ext.startsharing.NetworkService;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rddm
 */
public class SecureComunicationController {

    Set<InetAddress> activeIPs;

    public SecureComunicationController() {
    }

    public List<String> refreshInstances() {
        List<String> listInstances = new ArrayList<>();
        activeIPs = NetworkService.searchInstances().keySet();
        for (InetAddress i : activeIPs) {
            listInstances.add(i.getHostName());
        }
        return listInstances;
    }

    public void starSSL() {
        NetworkService.isVisibleToOthers(true);
        NetworkService.startSSLServer();
    }

    public boolean newSSLConnection(String selectedValue) {
        for (InetAddress i: activeIPs) {
            if(selectedValue.equals(i.getHostName()))
                return NetworkService.establishSSLConnectionToUser(i);
        }
        return false;
    }
}
