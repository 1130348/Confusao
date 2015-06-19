/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing;

import csheets.ext.file_sharing.ui.FileSharingUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;

/**
 *
 * @author Marcos
 */
public class Connection extends Thread {

    private Socket clientsocket;
    private ServerSocket serverscocket;
    private InputStream inStream = null;
    private OutputStream outStream = null;
    private Thread receive, send;
    private static FileSharingUI ui;

    public Connection(String ip, int port) {
        try {
            this.clientsocket = new Socket(ip, port);
        } catch (IOException ex) {
            System.out.println("Could not connect");
        }
    }

    public Connection(int port) {
        try {
            this.serverscocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Could not connect");
        }
    }

    public Socket getConSocket() {
        return clientsocket;
    }

    public ServerSocket getConServerSocket() {
        return serverscocket;
    }

    public void createThreads() throws IOException {
        if (clientsocket == null) {
            try {
                clientsocket = serverscocket.accept();
            } catch (IOException ex) {

            }
        }
        inStream = clientsocket.getInputStream();
        outStream = clientsocket.getOutputStream();
        receive = receive();
        receive.setPriority(Thread.MAX_PRIORITY);
        receive.start();

        send = send();
        send.setPriority(Thread.MAX_PRIORITY);
        send.start();
    }

    private Thread send() {
        return new Thread() {

            @Override
            public void run() {
                while (clientsocket.isConnected()) {

                    try {
                        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                        sleep(100);
                        String msg = input.readLine();
                        if (msg != null && msg.length() > 0) {
                            send(Arrays.toString(msg.getBytes("ISO-8859-1")));
                            sleep(100);
                        }
                    } catch (IOException | InterruptedException i) {
                    }
                }
            }
        };
    }

    public void send(String lista) throws IOException {
        outStream.write(lista.getBytes("ISO-8859-1"));
    }

    public void setUI(FileSharingUI ui) {
        Connection.ui = ui;
    }

    private Thread receive() {
        return new Thread() {
            @Override
            public void run() {
                while (clientsocket.isConnected()) {
                    try {
                        byte[] readBuffer = new byte[200];
                        int num = inStream.read(readBuffer);
                        if (num > 0) {
                            byte[] arrayBytes = new byte[num];
                            System.arraycopy(readBuffer, 0, arrayBytes, 0, num);
                            String msg = new String(arrayBytes, "ISO-8859-1");
                            //metodo para receber a lista
                            System.out.println(msg);

                        }
                    } catch (SocketException se) {
                    } catch (IOException i) {
                    }
                }
            }
        };
    }

}
