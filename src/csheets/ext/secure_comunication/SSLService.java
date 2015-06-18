/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author rddm
 */
public class SSLService {

    private static final Map<InetAddress, SSLSocket> connectionsActive = new HashMap<>();
    private static SSLServer sslServer;
    private static final int portSSL = 1337;

    public static void startServer() {
        sslServer = new SSLServer(portSSL);
    }

    public static void interruptSSLConnection() {
        sslServer.interrupt();
    }

    public static boolean establishSecureConnectionToUser(InetAddress address) {
        try {
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.
                    getDefault();
            SSLSocket newSocket;
            System.out.println(address.getHostName());
            newSocket = (SSLSocket) sslsocketfactory.createSocket(address, portSSL);
            newSocket.startHandshake();
            System.out.println("O cliente se conectou ao servidor SSL!");
            connectionsActive.put(address, newSocket);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean disconnectSecureConnectionToUser(InetAddress address) {
        try {
            sendSecureMessages("", address);
            connectionsActive.get(address).close();
            connectionsActive.remove(address);
            sslServer.removeConnection(address);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static void sendSecureMessages(String str, InetAddress client) {
        BufferedWriter bufferedwriter = null;
        try {
            SSLSocket socketClient = connectionsActive.get(client);

            bufferedwriter = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));

            /*DataOutputStream sOut = new DataOutputStream(socketClient.getOutputStream());
             byte[] data = new byte[300];
             data = str.getBytes();
             sOut.write((byte) str.length());
             sOut.write(data, 0, str.length());*/
            bufferedwriter.write(str);
            bufferedwriter.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Set<InetAddress> getConnectionsActive() {
        return connectionsActive.keySet();
    }
}
