/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import javax.net.ssl.SSLSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author rddm
 */
public class ReceiveMessages implements Runnable {

    //private ObjectInputStream objectIn;
    //private DataInputStream dataIn;
    Semaphore sem;
    private SSLSocket socket;
    private DataInputStream datareader;

    public ReceiveMessages(SSLSocket socket) {
        try {
            datareader = new DataInputStream(socket.getInputStream());
            this.sem = new Semaphore(1);
            this.socket = socket;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        int nChars;
        while (true) {
            try {
                byte[] data = new byte[300]; 
                nChars = datareader.read();
                if (nChars == 0) {
                    break;
                }
                
                if (nChars > 0) {
                    datareader.read(data, 0, nChars);
                    /*  String string = null;
                    while ((string = bufferedreader.readLine()) != null) {
                    JOptionPane.showMessageDialog(null, string, "New Message from " + socket.
                    getInetAddress().
                    getCanonicalHostName(), JOptionPane.INFORMATION_MESSAGE);
                    }*/
                    JOptionPane.showMessageDialog(null, data, "New Message from " + socket.
                    getInetAddress().
                    getCanonicalHostName(), JOptionPane.INFORMATION_MESSAGE);
                    
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
