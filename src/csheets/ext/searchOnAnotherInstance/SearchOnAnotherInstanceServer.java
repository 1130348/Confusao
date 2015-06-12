/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.core.Workbook;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class SearchOnAnotherInstanceServer extends Observable implements Runnable {

    private int port = 8888;

    public SearchOnAnotherInstanceServer() {
    }

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(port);
            System.out.println("Porta " + port + " aberta!");
            while (true) {
                Socket cliente = servidor.accept();
                System.out.println("Nova conexão com o cliente "
                        + cliente.getInetAddress().getHostAddress());

                ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
                Object object = entrada.readObject();
                if (object instanceof String) {
                    String workbookName = ((String) object);
                    InetAddress requestClient = cliente.getInetAddress();
                    NotificationEvent event = new NotificationEvent(requestClient, workbookName);
                    setChanged();
                    notifyObservers(event);
                } else if (object instanceof Workbook || object == null) {
                    Workbook workbook = ((Workbook) object);
                    ReportEvent rep = new ReportEvent(workbook);
                    setChanged();
                    notifyObservers(rep);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SearchOnAnotherInstanceServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchOnAnotherInstanceServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
