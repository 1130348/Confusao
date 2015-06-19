/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author rddm
 */
public class SSLServer implements Runnable {

    int port;
    Map<InetAddress, ReceiveMessages> clientConnections;
    SSLServerSocket serverSocket;
    Semaphore sem;
    public Thread thread;
    boolean join = false;

    public SSLServer(int port) {
        this.port = port;
        this.clientConnections = new HashMap<>();
        this.sem = new Semaphore(1);
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        int option;
        try {
            SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(port);
            SSLSocket client;
            while (true) {
                sem.acquire();
                client = (SSLSocket) serverSocket.accept();
                if (SSLService.getConnectionsActive().contains(client.getInetAddress())) {
                    clientConnections.
                            put(client.
                                    getInetAddress(), new ReceiveMessages(client));
                } else {
                    option = JOptionPane.showConfirmDialog(null, client.
                            getInetAddress().
                            getCanonicalHostName() + " wants to establish a secure comunication, do you accept it?", "Secure comunication request", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (option == 0) {
                        clientConnections.
                                put(client.
                                        getInetAddress(), new ReceiveMessages(client));
                        SSLService.establishSecureConnectionToUser(client.getInetAddress());
                    } else {
                        client.close();
                    }
                }
                sem.release();
            }

        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }
    }

    public void interrupt() {
        /*for (InetAddress i : clientConnections.keySet()) {
         SSLService.disconnectSecureConnectionToUser(i);
         }*/
        for (ReceiveMessages rm : clientConnections.values()) {
            rm.interrupt();
        }
        try {
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            this.thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void removeConnection(InetAddress address) {
        if (this.clientConnections.containsKey(address)) {
            this.clientConnections.get(address).interrupt();
            this.clientConnections.remove(address);
        }
    }
}
