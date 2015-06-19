/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing.ui;

import csheets.ext.file_sharing.Connection;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos
 */
public class FileSharingController {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * User interface panel *
     */
    private FileSharingPanel FSPanel;

    /**
     * ChatUI User Interface *
     */
    private static FileSharingUI FSUI;

    private static Connection activeCon = null;

    private static Connection server = null;

    private String inboxPath = "", outboxPath = "";

    private List inlist = new ArrayList(), outlist = new ArrayList();

    /**
     * Creates a new File Sharing controller.
     *
     * @param uiController the user interface controller
     * @param uiPanel the user interface panel
     */
    public FileSharingController(UIController uiController, FileSharingPanel uiPanel) {
        this.uiController = uiController;
        this.FSPanel = uiPanel;
    }

    public void setOutBox(String outboxPath) {
        this.outboxPath = outboxPath;
        CheckConfigFolder();
        createFileList(true);
        createFileList(false);
        FSUI.fillList(outlist);
    }

    public void setInBox(String inboxPath) {
        this.inboxPath = inboxPath;
    }

    public String getOutBox() {
        return outboxPath;
    }

    public String getInBox() {
        return inboxPath;
    }

    public void setFileSharingUI(FileSharingUI s) throws IOException {
        FSUI = s;
    }

    public void CheckConfigFolder() {
        File d = new File(File.listRoots()[0] + "/CleanSheet FileSharingConfig");
        if (!d.exists()) {
            d.mkdir();
        }
        String path = d.getAbsolutePath();
        CreateConfigFile(path);
    }

    private void CreateConfigFile(String path) {

        Formatter x;
        try {
            x = new Formatter(path + "/csheets.config", "ISO-8859-1");

            x.format("inbox:" + inboxPath + "\n");
            x.format("outbox:" + outboxPath + "\n");

            x.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(FileSharingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createFileList(boolean opc) {
        File folder;
        if (opc) {
            folder = new File(outboxPath);
        } else {
            folder = new File(inboxPath);
        }
        try {
            File[] listOfFiles = folder.listFiles();
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    if (opc) {
                        outlist.add(listOfFile.getName() + "   Size: " + listOfFile.length() + "B");
                    } else {
                        inlist.add(listOfFile.getName() + "   Size: " + listOfFile.length() + "B");
                    }
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Insert Path's.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static void StartCon() throws IOException {
        activeCon = new Connection(FSUI.getSelectedCon(), 3439);
        activeCon.setUI(FSUI);
        activeCon.createThreads();
        
    }
    
     private void createServer() {
        Thread Server = new Thread(){
            @Override
            public void run(){
                try {
                    if(server == null){
                        server = new Connection(3439);
                    }
                server.createThreads();
                server.setUI(FSUI);
                FSUI.SetConnection(server.getConSocket().getInetAddress().toString().substring(1,server.getConSocket().getInetAddress().toString().length()));
                    
            } catch (IOException ex) {
                
            }
            }
        };
           Server.start();
    }
}
