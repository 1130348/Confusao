/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import java.net.InetAddress;
import java.util.ArrayList;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class StartSharingController {

    public StartSharingController() {
    
    }
    
    public ArrayList<String> searchClients(){
        return Network.searchClient();
    }
    
    public void changePort(int port){
        Network.setPort(port);
    }
    
    public boolean establishConnection(InetAddress address){
        return false;
    }
    
    public boolean sendObject(Object obj){
        return Network.sendData(obj);
    }
}
