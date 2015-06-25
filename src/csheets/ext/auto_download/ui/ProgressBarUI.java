/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.auto_download.ui;

import csheets.ext.file_sharing.ui.FileSharingController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressBarUI {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    private String file_path;
    private String output_path;
    private boolean updatable;
    private boolean overwrite;

    public ProgressBarUI(String file, String out, boolean up, boolean over) {
        prepareGUI();
        file_path = file;
        output_path = out;
        updatable = up;
        overwrite = over;
    }

    private void prepareGUI() {
        mainFrame = new JFrame("In Progress...");
        mainFrame.setSize(300, 100);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                mainFrame.dispose();
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);

        statusLabel.setSize(350, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
    }

    private JProgressBar progressBar;
    private Task task;

    public void showProgressBar() {
        headerLabel.setText("");

        progressBar = new JProgressBar(0, 100);

        progressBar.setValue(0);

        progressBar.setStringPainted(true);

        controlPanel.add(progressBar);

        mainFrame.setVisible(true);

        task = new Task();
        task.start();

//        try {
//             task.join();
//             JOptionPane.showMessageDialog(null, "Download Completed");
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ProgressBarUI.class.getName()).
//                log(Level.SEVERE, null, ex);
//        }
    }

    private class Task extends Thread {

        public Task() {
        }

        public void run() {
            try {
                FileSharingController.download(file_path, output_path);
                for (int i = 0; i <= 100; i += 10) {
                    final int progress = i;
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            progressBar.setValue(progress);
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ProgressBarUI.class.getName()).
                    log(Level.SEVERE, null, ex);
            }
        }
    }
}
