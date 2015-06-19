/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication;

import csheets.ext.startsharing.NetworkService;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rddm
 */
public class SecureComunicationController {

    Set<InetAddress> activeIPs = new HashSet<>();
    Set<InetAddress> connectedIPs = new HashSet<>();

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
        SSLService.startServer();
    }

    public boolean newSSLConnection(String selectedValue) {
        for (InetAddress i : activeIPs) {
            if (selectedValue.equals(i.getHostName())) {
                return SSLService.establishSecureConnectionToUser(i);
            }
        }
        return false;
    }

    public List<String> refreshConnections() {
        List<String> listInstances = new ArrayList<>();
        connectedIPs = SSLService.getConnectionsActive();
        for (InetAddress i : connectedIPs) {
            listInstances.add(i.getHostName());
        }
        return listInstances;
    }

    public void sendMessage(String name, String message) {
        for (InetAddress ssl : connectedIPs) {
            if (name.equals(ssl.getHostName())) {
                System.out.println("encontrei " + name);
                SSLService.sendSecureMessages(message, ssl);
            }
        }
    }

    public void removeConnection(String name) {
        for (InetAddress ssl : connectedIPs) {
            if (name.equals(ssl.getHostName())) {
                SSLService.disconnectSecureConnectionToUser(ssl);
            }
        }
    }

    public void stopSSL() {
        NetworkService.isVisibleToOthers(false);
        for (InetAddress ssl : connectedIPs) {
            SSLService.disconnectSecureConnectionToUser(ssl);
            connectedIPs.remove(ssl);
        }
        SSLService.stopServer();
        activeIPs.clear();
        connectedIPs.clear();
    }

}
