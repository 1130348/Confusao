/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message;

import csheets.ext.Send_Message.UI.ChatUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DMMCA
 */
public class Connection{



    private Socket SOCKET;
    private ServerSocket SERVERSOCKET;
    private InputStream inStream = null;
    private OutputStream outStream = null;
    private Thread readThread, writeThread;
    private static ChatUI ui;

    private List ar = new ArrayList();

    public Connection(String ip, int port) {
        try {
            this.SOCKET = new Socket(ip, port);
        } catch (IOException ex) {
            System.out.println("Could not connect");
        }
    }

    public Connection(int port) {
        try {
            this.SERVERSOCKET = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Could not connect");
        }
    }

    public Socket getConSocket() {
        return SOCKET;
    }

    public ServerSocket getConServerSocket() {
        return SERVERSOCKET;
    }

    public void createThreads() throws IOException {
        if (SOCKET == null) {
            try {
                SOCKET = SERVERSOCKET.accept();
            } catch (IOException ex) {

            }
        }
        inStream = SOCKET.getInputStream();
        outStream = SOCKET.getOutputStream();
        readThread = readThread();
        readThread.setPriority(Thread.MAX_PRIORITY);
        readThread.start();

        writeThread = writeThread();
        writeThread.setPriority(Thread.MAX_PRIORITY);
        writeThread.start();
    }

    private Thread writeThread() {
        return new Thread() {
            
            @Override
            public void run() {
                while (SOCKET.isConnected()) {

                    try {
                        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                        sleep(100);
                        String msg = input.readLine();

                        if (msg != null && msg.length() > 0) {

                            SendMessage(Arrays.toString(msg.
                                getBytes("ISO-8859-1")));
                            sleep(100);
                        }
                    } catch (IOException | InterruptedException i) {
                    }
                }
            }
        };
    }
    
    public void setUI(ChatUI ui){
        Connection.ui = ui;
    }

    public void SendMessage(String msg) throws IOException {
        outStream.write(msg.getBytes("ISO-8859-1"));
        ui.setMsg(InetAddress.getLocalHost().getHostName() + " says: " + msg);
    }

    private Thread readThread() {
        return new Thread() {
            @Override
            public void run() {
                while (SOCKET.isConnected()) {
                    try {
                        byte[] readBuffer = new byte[200];
                        int num = inStream.read(readBuffer);
                        if (num > 0) {
                            byte[] arrayBytes = new byte[num];
                            System.arraycopy(readBuffer, 0, arrayBytes, 0, num);
                            String msg = new String(arrayBytes, "ISO-8859-1");
                            ui.setMsg(SOCKET.getInetAddress().getHostName()+" says: " + msg);
                            if(!ui.isFocused()){
                                JOptionPane.showMessageDialog(null,"Message Received!!!!\n from: " +SOCKET.getInetAddress().getHostName() );
                            }
                            
                        } 
                    } catch (SocketException se) {
                    } catch (IOException i) {
                    }
                }
            }
        };
    }
    
    

}
