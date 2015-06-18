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
    Thread thread;

    public SSLServer(int port) {
        this.port = port;
        this.clientConnections = new HashMap<>();
        this.sem = new Semaphore(1);
        this.thread = new Thread();
        this.thread.start();
    }

    @Override
    public void run() {
        int option;
        try {
            SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(port);
            SSLSocket client;
            while (!thread.isInterrupted()) {
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
        for (ReceiveMessages receive : clientConnections.values()) {
            receive.interrupt();
        }
        thread.interrupt();
    }

    public void removeConnection(InetAddress address) {
        this.clientConnections.get(address).interrupt();
        this.clientConnections.remove(address);
    }
}
