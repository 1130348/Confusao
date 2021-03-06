/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import csheets.core.Cell;
import csheets.core.Workbook;
import csheets.ext.searchOnAnotherInstance.ReportWatch;
import csheets.ext.searchOnAnotherInstance.SearchOnAnotherInstanceClient;
import csheets.ext.searchOnAnotherInstance.ui.SearchOnAnotherInstanceDialog;
import csheets.ext.secure_comunication.SSLServer;
import csheets.ext.selectgame.Player;
import csheets.ext.selectgame.SearchPartnersServer;
import csheets.ext.selectgame.ui.ChoosePartner;
import csheets.ext.selectgame.ui.GameScene;
import csheets.ext.startsharing.ui.SendCellsAction;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo Pereira
 */
public class NetworkService {

    private static Thread gameServerThread;
    private static Thread serverThread;
    private static ArrayList<Socket> clientConnections = clientConnections = new ArrayList<>();
    private static int portTCP = 8888;
    private static final int portUDP = 9050;
    public static Map<InetAddress, Integer> activeInstances = new HashMap<>();
    public static SendCellsController controller = new SendCellsController();

    public static void sendSearchRequest(InetAddress newAddress,
            String workbookName) {
        SearchOnAnotherInstanceClient client = new SearchOnAnotherInstanceClient();
        client.sendWorkbookName(newAddress, workbookName);
    }

    static void sendCell(Cell cell) {
        controller.sendCell(cell);

    }

    static void sendCellContent(Cell cell) {
        List<Cell> c = new ArrayList<>();
        c.add(cell);
        sendCellsContent(c);
    }

    /*
     * To make sure that this class is a service class
     */
    private NetworkService() {
    }

    public static int getPort() {
        return portTCP;
    }

    public static void setPort(int newPort) {
        portTCP = newPort;
    }

    /**
     * Method that sets the visibility in the local network of the running
     * instance of cleansheets
     *
     * @param cond boolean condition that defines if the application stays
     * visible or if it stays hidden from the local network
     */
    public static void isVisibleToOthers(boolean cond) {
        if (cond) {
            NetworkReceiveService.startReceivingUDPDatagrams(portUDP, portTCP);
        } else {
            NetworkReceiveService.stopReceivingUDPDatagrams(portUDP);
        }
    }

    public static void startGameServer(GameScene dialog, Player player,
            ChoosePartner partnersDialog) {
        gameServerThread = new Thread(new SearchPartnersServer(dialog, player, partnersDialog));
        gameServerThread.start();
    }

    public static void establishConnectionToUser(String playerName) {
        try {
            NetworkSendService.
                    establishConnectionToUser(InetAddress.getByName(playerName));
        } catch (UnknownHostException ex) {
            Logger.getLogger(NetworkService.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }

    public static Map<InetAddress, Integer> searchInstances() {
        activeInstances = NetworkSendService.
                searchActiveInstances(portUDP, portTCP);

        return activeInstances;
    }

    public static boolean establishConnection(List<String> addresses,
            SendCellsAction action) {
        try {
            InetAddress addr;
            for (String address : addresses) {
                System.out.println("Clientes: "+address);
                addr = InetAddress.getByName(address);
                clientConnections.
                        add(new Socket(addr, activeInstances.get(addr)));
                System.out.println("O cliente conectou-se ao servidor!");
            }
            action.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public static void disconnectFromClients(List<String> clientAddresses) {
        InetAddress addr;
        for (String clientAddress : clientAddresses) {
            try {
                addr = InetAddress.getByName(clientAddress);
                for (Socket client : clientConnections) {
                    if (client.getInetAddress().equals(addr)) {
                        client.close();
                        clientConnections.remove(client);
                    }
                }
            } catch (UnknownHostException ex) {
                Logger.getLogger(NetworkService.class.getName()).
                        log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NetworkService.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void sendCells(List<Cell> selectedCells) {
        for (Socket clientConnection : clientConnections) {
            for (Cell selectedCell : selectedCells) {
                try {
                    NetworkSendService.
                            sendObject(selectedCell, new ObjectOutputStream(clientConnection.
                                            getOutputStream()));
                } catch (IOException ex) {
                    Logger.getLogger(NetworkService.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void sendCellsContent(List<Cell> selectedCells) {
        byte[] data = new byte[300];
        List<Socket> lSend = (List) clientConnections.clone();
        for (Socket clientConnection : lSend) {
            System.out.println("ENVIAR: "+clientConnection.getInetAddress().getHostName());
            DataOutputStream sOut = null;
            try {
                sOut = new DataOutputStream(clientConnection.
                        getOutputStream());
                data = "Share Cells Content".getBytes();
                sOut.write((byte) "Share Cells Content".length());
                sOut.write(data, 0, "Share Cells Content".length());
                for (Cell selectedCell : selectedCells) {
                    NetworkSendService.
                            sendString(selectedCell.getContent(), sOut);
                    NetworkSendService.
                            sendString(String.
                                    format("%d", selectedCell.getAddress().getColumn()), sOut);
                    NetworkSendService.
                            sendString(String.
                                    format("%d", selectedCell.getAddress().getRow()), sOut);
                }
                data = "end".getBytes();
                sOut.write((byte) "end".length());
                sOut.write(data, 0, "end".length());
               
            } catch (SocketException ex) {
               clientConnections.remove(clientConnection);
                JOptionPane.showMessageDialog(null, "The other user is no longer connected...", "Error", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                Logger.getLogger(NetworkService.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void addClientToMap(int port, InetAddress clientAddress) {
        activeInstances.put(clientAddress, port);
    }

    public static void startServer(SendCellsAction sendCells) {
        serverThread = new Thread(new Server(sendCells, portTCP));
        serverThread.start();
    }


    public static void interruptConnection() {
        serverThread.interrupt();
    }


    public static void receiveCells(List<Cell> newCells,
            SendCellsAction cellsAction) {
        cellsAction.replaceCells(newCells);
    }

    public static void receiveCellsContent(List<String> cellsContent,
            List<String> cellsColumns,
            List<String> cellsRows,
            SendCellsAction cellsAction) {

        cellsAction.replaceCellsContent(cellsContent, cellsColumns, cellsRows);
    }

    public static void addObserver(SearchOnAnotherInstanceDialog dialog,
            ReportWatch reportWatch) {
        NetworkReceiveService.addObserver(dialog, reportWatch);
    }

    public static void sendWorkbook(InetAddress address,
            Workbook workbook) {
        SearchOnAnotherInstanceClient client = new SearchOnAnotherInstanceClient();
        client.sendWorkbook(address, workbook);
    }
}
