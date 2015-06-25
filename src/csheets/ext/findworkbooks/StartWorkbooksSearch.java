/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class StartWorkbooksSearch extends Thread {

    private final ArrayList<Path> workBooksFoundList;
    private String path;

    public StartWorkbooksSearch(String path, ArrayList<Path> workBooksFoundList) {
        this.workBooksFoundList = workBooksFoundList;
        this.path=path;
                this.start();
    }

    /*public void startWorkbooksSearch(String path) throws InterruptedException {
        StartWorkbooksSearch thread = new StartWorkbooksSearch(path);
        thread.start();
    }*/

    @Override
    public void run() {
                while(true)
        {

        String localDrive;

        localDrive=path;
        Path startingDir = Paths.get(localDrive);

        FindWorkbooks pf = new FindWorkbooks(workBooksFoundList);

        try {
            Files.walkFileTree(startingDir, pf);
        } catch (IOException ex) {
            System.out.println("Error!");
        }
        }
        
    }
}
