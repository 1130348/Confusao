/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import csheets.ext.startsharing.ui.ChooseCleanSheetsInstanceToConnect;
import csheets.ext.startsharing.ui.SendCellsAction;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 */
public class Server implements Runnable {

    SendCellsAction sendCells;
    boolean isRunning;
    int port;
    Map<Socket, DataOutputStream> clientConnections;
    ServerSocket svSocket;
    Semaphore sem;

    public Server(SendCellsAction sendCellsAction, int port) {
        this.sendCells = sendCellsAction;
        this.port = port;
        this.clientConnections = new HashMap<Socket, DataOutputStream>();
        this.sem = new Semaphore(1);
        this.isRunning = true;
    }

    @Override
    public void run() {
        int option;
        try {
            svSocket = new ServerSocket(port);
            System.out.println("Porta" + port + " aberta!");
            Socket client;
            while (isRunning) {
                sem.acquire();
                client = svSocket.accept();
                option = JOptionPane.showConfirmDialog(null, client.
                        getInetAddress().
                        getCanonicalHostName() + " wants to establish a remote connection to your computer, do you accept it?", "Remote connection request", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (option == 0) {
                    if (!clientConnections.containsKey(client)) {
                       // if (!sendCells.isFlagSend()) {
                        //if (!sendCells.isFlagCrossConnection()) {
                        clientConnections.
                                put(client, new DataOutputStream(client.
                                                getOutputStream()));

                        //NetworkService.addClientToMap(port + 1, client.getInetAddress());
                        StartSharingController controller = new StartSharingController();
                        ChooseCleanSheetsInstanceToConnect sa = ChooseCleanSheetsInstanceToConnect.getInstance(null, true, controller, sendCells);
                        sa.setVisible(true);

                        List<String> cli = new ArrayList<>();
                        cli.add(client.getInetAddress().getHostName());
                        //controller.establishConnection(cli, sendCells);

                        controller.
                                establishConnection(cli, sendCells);

                        sendCells.getSpreadsheetTable().getSpreadsheet().addCellListener(new AutomaticCellListener());

                        /*  List<String> cli = new ArrayList<>();
                         cli.add(client.getInetAddress().getHostName());
                         controller.establishConnection(cli, sendCells);

                         sendCells.getSpreadsheetTable().getSpreadsheet().addCellListener(new AutomaticCellListener());*/
                        new Thread(new ReceiveData(client, sendCells)).start();
                        //sendCells.setFlagCrossConnection(true);
                    }
                    //  }
                } else {
                    client.close();
                }
                sem.release();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
