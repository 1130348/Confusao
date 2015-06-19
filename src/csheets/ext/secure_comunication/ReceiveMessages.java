/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.swing.JOptionPane;
import org.h2.store.DataReader;

/**
 *
 * @author rddm
 */
public class ReceiveMessages implements Runnable {

    Semaphore sem;
    private SSLSocket socket;
    private BufferedReader bufferedreader;
    private DataReader datareader;
    public Thread thread;
    private String name;

    public ReceiveMessages(SSLSocket socket) {
        try {
            //bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            datareader = new DataReader(socket.getInputStream());
            this.sem = new Semaphore(1);
            this.socket = socket;
            name = this.socket.
                    getInetAddress().
                    getCanonicalHostName();
            this.thread = new Thread(this);
            this.thread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        String msg;

        try {
            while (true) {
                /*  System.out.println("estou sempre a ler!");
                 while ((msg = bufferedreader.readLine()) != null) {
                 /* JOptionPane.showMessageDialog(null, msg, "New Message from " + socket.
                 getInetAddress().
                 getCanonicalHostName(), JOptionPane.INFORMATION_MESSAGE);*/
                // msg = bufferedreader.readLine();
                System.out.println("tentar ler");
                msg = datareader.readString();
                System.out.println("li algo");
                if (msg.equals("")) {
                    JOptionPane.showMessageDialog(null, msg, this.name + " Disconnected!", JOptionPane.INFORMATION_MESSAGE);
                    SSLService.disconnectSecureConnectionToUser(socket.getInetAddress());
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, msg, "New Message from " + this.name, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(
                "fechei esta merda toda");
    }

    public void interrupt() {
        try {
            socket.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            this.thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
