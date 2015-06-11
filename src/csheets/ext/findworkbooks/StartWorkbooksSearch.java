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
//        thread.join();
//
//        System.out.println("Results:");
//        for (Path workBookPath : workBooksFoundList) {
//            System.out.println(workBookPath.getFileName());
//        }
    }

    @Override
    public void run() {
        File file = FileSystemView.getFileSystemView().getDefaultDirectory();
        String os = System.getProperty("os.name");
        String localDrive;
        if (os.contains("Windows")) {
            localDrive = "C:\\";
        } else if (os.contains("OS")) {
            localDrive = "Macintosh HD\\";
        } else {
            System.out.println("Esta funcionalidade não está disponível neste sistema operativo");
            return;
        }

        //Ir buscar o disco local porque nem sempre é o C
        Path startingDir = Paths.get(localDrive);

        FindWorkbooks pf = new FindWorkbooks(workBooksFoundList);

        try {
            Files.walkFileTree(startingDir, pf);
        } catch (IOException ex) {
            System.out.println("Error!");
        }
    }
}
