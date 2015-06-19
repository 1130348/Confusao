/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing;

import csheets.ext.file_sharing.ui.FileSharingController;
import csheets.ext.file_sharing.ui.FileSharingUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class Connection {

    private Socket clientsocket;
    private ServerSocket serverscocket;
    private InputStream inStream = null;
    private static OutputStream outStream = null;
    private Thread receive, send;
    private static FileSharingUI ui;
    private static HashMap<String, String> map = new HashMap<String, String>();

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

    public static void send(String lista) throws IOException {
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
                            ui.setMsg(msg);
                        }
                    } catch (SocketException se) {
                    } catch (IOException i) {
                    }
                }
            }
        };
    }

    public static void searchActiveInstances() throws IOException {

        Thread f = new Thread() {
            public void run() {
                try {
                    while (true) {
                        int port = 5000;
                        String group = "239.255.0.0";
                        MulticastSocket s = new MulticastSocket(port);
                        s.joinGroup(InetAddress.getByName(group));
                        byte buf[] = new byte[1024];

                        DatagramPacket pack = new DatagramPacket(buf, buf.length);
                        s.receive(pack);
                        if (!map.containsKey(pack.getAddress().toString())) {
                            map.put(pack.getAddress().toString(), "");
                            if (!InetAddress.getLocalHost().getHostAddress().equalsIgnoreCase(pack.getAddress().toString().substring(1, pack.getAddress().toString().length()))) {
                                System.out.println(Arrays.toString(InetAddress.getLocalHost().getAddress()));
                                System.out.println(">" + InetAddress.getLocalHost().getHostAddress());
                                if (!InetAddress.getLocalHost().getHostAddress().equalsIgnoreCase(pack.getAddress().toString().substring(1, pack.getAddress().toString().length()))) {
                                    Connection n = new Connection(pack.getAddress().toString().substring(1, pack.getAddress().toString().length()), 3439);
                                    n.createThreads();
                                    ui.SetConnection(pack.getAddress().toString().substring(1, pack.getAddress().toString().length()));
                                    n.send(FileSharingController.Lists());

                                }
                            }
                        }

                        s.leaveGroup(InetAddress.getByName(group));
                        s.close();
                        Thread.sleep(1500);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Connection.class.getName()).
                            log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Connection.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        };
        f.start();
    }

    public static void setListenner() {
        System.out.println("starting listenner");
        Thread f = new Thread() {
            public void run() {
                try {
                    while (true) {
                        int port = 5000;
                        String group = "239.255.0.0";

                        MulticastSocket s = new MulticastSocket();
                        byte buf[] = new byte[10];
                        for (int i = 0; i < buf.length; i++) {
                            buf[i] = (byte) i;
                        }

                        DatagramPacket pack = new DatagramPacket(buf, buf.length,
                                InetAddress.getByName(group), port);
                        s.send(pack);
                        s.close();
                        Thread.sleep(5000);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Connection.class.getName()).
                            log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Connection.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        };
        f.start();
    }

}
