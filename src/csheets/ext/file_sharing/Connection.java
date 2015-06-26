/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing;

import csheets.ext.auto_download.FileEvent;
import csheets.ext.auto_download.FileWatcherMonitor;
import csheets.ext.file_sharing.ui.FileSharingController;
import csheets.ext.file_sharing.ui.FileSharingUI;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private ServerSocket serversocket;
    private InputStream inStream = null;
    private static OutputStream outStream = null;
    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;
    private String sourceFilePath = "";
    private String destinationPath = "";
    private FileEvent fileEvent;
    private File dstFile = null;
    private FileOutputStream fileOutputStream = null;
    private Thread receive, send;
    private static FileSharingUI ui;
    private static HashMap<String, String> map = new HashMap<>();

    public Connection(String ip, int port) {
        try {
            this.clientsocket = new Socket(ip, port);
            //outputStream = new ObjectOutputStream(clientsocket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("Could not connect");
        }
    }

    public Connection(int port) {
        try {
            this.serversocket = new ServerSocket(port);
            //inputStream = new ObjectInputStream(clientsocket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Could not connect");
        }
    }

    public Socket getConSocket() {
        return clientsocket;
    }

    public ServerSocket getConServerSocket() {
        return serversocket;
    }

    public void createThreads() throws IOException {
        if (clientsocket == null) {
            try {
                clientsocket = serversocket.accept();
            } catch (IOException ex) {
            }
        }
        inStream = clientsocket.getInputStream();
        outStream = clientsocket.getOutputStream();
        inputStream = new ObjectInputStream(clientsocket.getInputStream());
        outputStream = new ObjectOutputStream(clientsocket.getOutputStream());
        receive = receive();
        receive.setPriority(Thread.MAX_PRIORITY);
        receive.start();

        send = send();
        send.setPriority(Thread.MAX_PRIORITY);
        send.start();
    }

    /**
     *   Reading the FileEvent object and copying the file to disk.  
     */
    public void downloadFile() {
        try {
            fileEvent = (FileEvent) inputStream.readObject();
            if (fileEvent.getStatus().equalsIgnoreCase("Error")) {
                System.out.println("Error occurred ..So exiting");
                System.exit(0);
            }
            String outputFile = fileEvent.getDestinationDirectory() + fileEvent.
                getFilename();
            if (!new File(fileEvent.getDestinationDirectory()).exists()) {
                new File(fileEvent.getDestinationDirectory()).mkdirs();
            }
            dstFile = new File(outputFile);
            fileOutputStream = new FileOutputStream(dstFile);
            fileOutputStream.write(fileEvent.getFileData());
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.
                println("Output file : " + outputFile + " is successfully saved ");
            
            if (fileEvent.getUpdatableOption()) {
                FileWatcherMonitor monitor = new FileWatcherMonitor(fileEvent);
                monitor.run();
            }
            
            Thread.sleep(3000);
            System.exit(0);

        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *   Sending FileEvent object.  
     *
     * @param file_p
     * @param out
     * @param update
     * @param over
     */
    public void sendFile(String file_p, String out, boolean update, boolean over) {
        sourceFilePath = file_p;
        destinationPath = out;
        fileEvent = new FileEvent();
        String fileName = sourceFilePath.substring(sourceFilePath.
            lastIndexOf("/") + 1, sourceFilePath.length());
        String path = sourceFilePath.substring(0, sourceFilePath.
            lastIndexOf("/") + 1);
        fileEvent.setDestinationDirectory(destinationPath);
        fileEvent.setFilename(fileName);
        fileEvent.setSourceDirectory(sourceFilePath);
        fileEvent.setUpdatableOption(update);
        fileEvent.setOverwriteOption(over);
        File file = new File(sourceFilePath);
        if (file.isFile()) {
            try {
                DataInputStream diStream = new DataInputStream(new FileInputStream(file));
                long len = (int) file.length();
                byte[] fileBytes = new byte[(int) len];
                int read = 0;
                int numRead = 0;
                while (read < fileBytes.length && (numRead = diStream.
                    read(fileBytes, read,
                         fileBytes.length - read)) >= 0) {
                    read = read + numRead;
                }
                fileEvent.setFileSize(len);
                fileEvent.setFileData(fileBytes);
                fileEvent.setStatus("Success");
            } catch (Exception e) {
                e.printStackTrace();
                fileEvent.setStatus("Error");
            }
        } else {
            System.out.println("path specified is not pointing to a file");
            fileEvent.setStatus("Error");
        }
        //Now writing the FileEvent object to socket
        try {
            outputStream.writeObject(fileEvent);
            System.out.println("Done...Going to exit");
            Thread.sleep(3000);
            System.exit(0);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
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
                            if (!InetAddress.getLocalHost().getHostAddress().
                                equalsIgnoreCase(pack.getAddress().toString().
                                    substring(1, pack.getAddress().toString().
                                        length()))) {

                                if (!InetAddress.getLocalHost().getHostAddress().
                                    equalsIgnoreCase(pack.getAddress().
                                        toString().substring(1, pack.
                                            getAddress().toString().length()))) {
                                    Connection n = new Connection(pack.
                                        getAddress().toString().
                                        substring(1, pack.getAddress().
                                            toString().length()), 3439);
                                    n.createThreads();
                                    ui.SetConnection(pack.getAddress().
                                        toString().substring(1, pack.
                                            getAddress().toString().length()));
                                    n.send(FileSharingController.Lists());

                                }
                            }
                        }

                        s.leaveGroup(InetAddress.getByName(group));
                        s.close();
                        Thread.sleep(1500);
                    }
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(Connection.class.getName()).
                        log(Level.SEVERE, null, ex);
                }
            }
        };
        f.start();
    }

    public static void setListenner() {

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
                                                                 InetAddress.
                            getByName(group), port);
                        s.send(pack);
                        s.close();
                        Thread.sleep(5000);
                    }
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(Connection.class.getName()).
                        log(Level.SEVERE, null, ex);
                }
            }
        };
        f.start();
    }

}
