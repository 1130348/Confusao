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
import java.util.Set;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author rddm
 */
public class SecureComunicationController {

    Set<InetAddress> activeIPs;
    Set<SSLSocket> connectedIPs;

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
        for (InetAddress i : activeIPs) {
            if (selectedValue.equals(i.getHostName())) {
                return NetworkService.establishSSLConnectionToUser(i);
            }
        }
        return false;
    }

    public List<String> refreshConnections() {
        List<String> listInstances = new ArrayList<>();
        connectedIPs = NetworkService.getSSLConnectionsActive();
        for (SSLSocket ssls : connectedIPs) {
            listInstances.add(ssls.getInetAddress().getHostName());
        }
        return listInstances;
    }

    public void sendMessage(String ssls, String message) {
        for (SSLSocket ssl : connectedIPs) {
            if (ssls.equals(ssl.getInetAddress().getHostName())) {
                NetworkService.sendSecureMessages(message, ssl);
            }
        }
    }
}
