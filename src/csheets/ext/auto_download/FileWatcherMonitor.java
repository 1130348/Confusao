/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.auto_download;

import csheets.ext.file_sharing.ui.FileSharingController;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andre
 */
public class FileWatcherMonitor implements Runnable {

    private FileEvent file_event;
    private String file_path;

    public FileWatcherMonitor(FileEvent file_eve) {
        file_event = file_eve;
        file_path = file_eve.getDestinationDirectory();
    }

//    public static void main(String args[]) {
//        FileWatcherMonitor f = new FileWatcherMonitor("c:/out/hey.txt");
//        f.run();
//    }
    @Override
    public void run() {
        // monitor a single file
        TimerTask task = new FileWatcher(new File(file_path)) {
            protected void onChange(File file) {
                // here we code the action on a change
                System.out.println("File " + file.getName() + " have change !");
                //if (file_event.getOverwriteOption()) {
                    try {
                        FileSharingController.download(file_event.
                            getSourceDirectory(), file_event.
                            getDestinationDirectory(), file_event.
                            getUpdatableOption(), file_event.
                            getOverwriteOption());
                    } catch (IOException ex) {
                        Logger.getLogger(FileWatcherMonitor.class.getName()).
                            log(Level.SEVERE, null, ex);
                    }
               //}
            }
        };

        Timer timer = new Timer();
        // repeat the check every 5 seconds
        timer.schedule(task, new Date(), 5000);
    }
}
