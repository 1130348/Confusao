/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class StartWorkbooksSearch extends Thread {

    private final ArrayList<Path> workBooksFoundList;

    public StartWorkbooksSearch() {
        this.workBooksFoundList = new ArrayList<Path>();
    }

    public void startWorkbooksSearch() throws InterruptedException {
        StartWorkbooksSearch thread = new StartWorkbooksSearch();
        thread.start();
    }

    @Override
    public void run() {
        File file = FileSystemView.getFileSystemView().getDefaultDirectory();
        String os = System.getProperty("os.name");
        String localDrive;
        if (os.contains("Windows")) {
            localDrive = "C:\\";
        } else if (os.contains("OS")) {
            localDrive = file.toString();
        } else {
            JOptionPane.showMessageDialog(
                null,
                "This functionality is not available on your operative system!\n",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
            return;
        }

        Path startingDir = Paths.get(localDrive);

        FindWorkbooks pf = new FindWorkbooks(workBooksFoundList);

        try {
            Files.walkFileTree(startingDir, pf);
        } catch (IOException ex) {
            System.out.println("Error!");
        }
        JOptionPane.showMessageDialog(
                null,
                "Workbook search completed!\n",
                "Search Completed",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
