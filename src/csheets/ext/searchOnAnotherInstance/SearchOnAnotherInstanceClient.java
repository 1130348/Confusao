/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.core.Workbook;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */


public class SearchOnAnotherInstanceClient {

    public SearchOnAnotherInstanceClient() {
    
    }

    public void sendWorkbook(InetAddress address, Workbook workbook) {
        try {
            Socket cliente = new Socket(address, 8888);
            System.out.println("O cliente se conectou ao servidor!");
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            saida.writeObject(workbook);
            saida.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchOnAnotherInstanceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendWorkbookName(InetAddress address, String workbookName) {
        try {
            Socket cliente = new Socket(address, 8888);
            System.out.println("O cliente se conectou ao servidor!");
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            saida.writeObject(workbookName);
            saida.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchOnAnotherInstanceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
