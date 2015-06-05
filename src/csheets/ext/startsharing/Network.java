/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import com.sun.corba.se.impl.io.IIOPOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Pereira
 */
public class Network {

    private static final int DEFAULT_PORT = 1025;
    private static final int TIMEOUT = 3;
    private static Thread serverThread;
    private static ArrayList<Socket> clientConnections;
    private static int port = DEFAULT_PORT;
    private static int sendPort;


    /*
     * To make sure that this class is a service class
     */
    private Network() {
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int newPort) {
        port = newPort;
    }

    public static void setSendPort(int port) {
        sendPort = port;
    }
    
    public static boolean sendData(Object object) throws IOException {
        //ObjectOutputStream out = new ObjectOutputStream(
        //        clientConnections.get(0).getOutputStream());
        //out.writeObject(object);
        return true;
    }

    public static void isVisibleToOthers(boolean cond) {
        if (cond) {
            serverThread = new Thread(new respond_to_request(port));
            serverThread.start();
        } else {
            try {
                String localHost = localHostAddress().getHostName();

                InetAddress destinationIP = InetAddress.getByName(localHost);

                DatagramSocket socket = new DatagramSocket();
                byte[] data = new byte[300];
                String message = "Exit";
                data = message.getBytes();
                DatagramPacket exitMessage = new DatagramPacket(data, message.
                        length(), destinationIP, port);

                socket.send(exitMessage);
                serverThread.join();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Network.class.getName()).
                        log(Level.SEVERE, null, ex);
            } catch (SocketException ex) {
                Logger.getLogger(Network.class.getName()).
                        log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Network.class.getName()).
                        log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Network.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List<InetAddress> searchInstances(int port) {
        List<InetAddress> activeInstances = new ArrayList<InetAddress>();
        try {

            String localHost = localHostAddress().getHostAddress();

//			InetAddress broadcastAddress = NetworkInterface.
//				getByInetAddress(localHostAddress()).getInterfaceAddresses().
//				get(0).getBroadcast();
            InetAddress destinationIP;

            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);
            socket.setSoTimeout(100 * TIMEOUT);
            destinationIP = InetAddress.getByName("255.255.255.255");

            byte[] data = new byte[300];
            String message = "testing connection";
            data = message.getBytes("ISO-8859-1");
            DatagramPacket request = new DatagramPacket(data, message.
                    length(), destinationIP, port);

            socket.send(request);
            DatagramPacket reply;

            long startTime = 0;
            long endTime = 0;
            long time = 0;

            while (time < 15000) {
                try {
                    startTime = System.currentTimeMillis();
                    time = 0;
                    reply = new DatagramPacket(data, data.length);
                    socket.receive(reply);
                    activeInstances.add(reply.getAddress());
                    message = new String(reply.getData(), 0, reply.getLength());
                    System.out.println(message);
                    endTime += System.currentTimeMillis();
                    time += endTime - startTime;
                    System.out.println(time);
                } catch (SocketTimeoutException ex) {
                    endTime += System.currentTimeMillis();
                    time += endTime - startTime;
                    System.out.println(time);
                    System.out.println("Instance did not respond!");
                }
            }

            socket.close();

        } catch (UnknownHostException ex) {
            Logger.getLogger(Network.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(Network.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Network.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return activeInstances;
    }

    private static InetAddress localHostAddress() throws UnknownHostException {
        return InetAddress.getLocalHost();
    }

    public static void connectToInstances(String[] clientsToConnect) {
        InetAddress[] destinationIPs = new InetAddress[clientsToConnect.length];
        DataOutputStream sOut[] = new DataOutputStream[clientsToConnect.length];
        DataInputStream sIn[] = new DataInputStream[clientsToConnect.length];
        for (int i = 0; i < clientsToConnect.length; i++) {

            try {
                destinationIPs[i] = InetAddress.
                        getByName(clientsToConnect[i]);
            } catch (UnknownHostException ex) {
                System.out.
                        println("The provided server address (" + clientsToConnect + ") is not available");
            }

            try {
                clientConnections.add(new Socket(destinationIPs[i], port));

            } catch (IOException ex) {
                System.out.println("TCP connection failure!");
            }

            try {
                sOut[i] = new DataOutputStream(clientConnections.get(i).
                        getOutputStream());
                sIn[i] = new DataInputStream(clientConnections.get(i).
                        getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Network.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Object receiveData() {
        return null;
    }

    public static boolean establishConnection(String address) {
        try {
            Socket cliente = new Socket(InetAddress.getByName(address), sendPort);
            System.out.println("O cliente se conectou ao servidor!");
            Scanner teclado = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            while (teclado.hasNextLine()) {

                saida.println(teclado.nextLine());

            }
            saida.close();
            teclado.close();
            cliente.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public static void waitForConnection() {
        serverThread = new Thread(new wait_for_message(port));
        serverThread.start();
    }

    public static void interruptConnection() {
        serverThread.interrupt();
    }
}

class respond_to_request implements Runnable {

    DatagramSocket sock;
    int port;

    public respond_to_request(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        byte[] data = new byte[300];
        String message;
        InetAddress clientIP;
        int clientPort;

        try {
            sock = new DatagramSocket(port);
        } catch (BindException ex) {
            System.out.println("O porto esta ocupado");
            System.exit(1);
        } catch (SocketException ex) {
            Logger.getLogger(respond_to_request.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        while (true) {
            try {

                DatagramPacket request = new DatagramPacket(data, data.length);
                sock.receive(request);
                message = new String(request.getData(), 0, request.getLength());
                System.out.println("Mensagem" + message);

                if (message.equals("Exit")) {
                    System.out.println("EXITED!!!!");
                    sock.close();
                    break;
                }

                clientIP = request.getAddress();
                clientPort = request.getPort();

                data = "Active".getBytes();
                DatagramPacket resposta = new DatagramPacket(data, "Active".
                        length(), clientIP, clientPort);
                sock.send(resposta);

            } catch (IOException ex) {
                Logger.getLogger(respond_to_request.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }
}

class wait_for_message implements Runnable {

    int port;

    public wait_for_message(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(port);
            System.out.println("Porta" + port + " aberta!");
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente "
                    + cliente.getInetAddress().getHostAddress()
            );
            Scanner s = new Scanner(cliente.getInputStream());
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());

            }
            s.close();
            servidor.close();
            cliente.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
