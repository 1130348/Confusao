/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing.ui;

import csheets.ext.Send_Message.Connection;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    private ArrayList<Connection> connections;

    private static Connection activeCon = null;

    private static Connection SERVER = null;

    private String inboxPath = "", outboxPath = "";

    /**
     * Creates a new File Sharing controller.
     *
     * @param uiController the user interface controller
     * @param uiPanel the user interface panel
     */
    public FileSharingController(UIController uiController, FileSharingPanel uiPanel) {
        this.uiController = uiController;
        this.FSPanel = uiPanel;
        CheckConfigFolder();
    }

    public void setOutBox(String outboxPath) {
        this.outboxPath = outboxPath;
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
        File d = new File(File.listRoots()[0] + "/CleanSheet Config");
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

}
