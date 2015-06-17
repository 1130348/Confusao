/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication;

import java.io.DataOutputStream;
import java.io.IOException;
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

    boolean isRunning;
    int port;
    Map<SSLSocket, DataOutputStream> clientConnections;
    SSLServerSocket serverSocket;
    Semaphore sem;

    public SSLServer(int port) {
        this.port = port;
        this.clientConnections = new HashMap<>();
        this.sem = new Semaphore(1);
        this.isRunning = true;
    }

    @Override
    public void run() {
        int option;
        try {
            SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(port);
            SSLSocket client;
            while (isRunning) {
                sem.acquire();
                client = (SSLSocket) serverSocket.accept();
                option = JOptionPane.showConfirmDialog(null, client.
                        getInetAddress().
                        getCanonicalHostName() + " wants to establish a secure comunication, do you accept it?", "Secure comunication request", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (option == 0) {
                    clientConnections.
                            put(client, new DataOutputStream(client.
                                            getOutputStream()));

                    // new Thread(new ReceiveData(client, sendCells)).start();
                } else {
                    client.close();
                }
                sem.release();
            }
        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
