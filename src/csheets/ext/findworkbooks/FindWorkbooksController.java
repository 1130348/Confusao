/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks;

import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * Controller responsible for the location of xls files in the computer
 * 
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class FindWorkbooksController {

    private StartWorkbooksSearch startWorkbooksSearch;
    
        private ArrayList<Path> workBooksFoundList;
    
    private ArrayList<String> pathList = new ArrayList();

    public FindWorkbooksController() {
        
    }
    
    /**
     * 
     * Starts the threads inside the given paths
     * 
     * @throws java.lang.InterruptedException
     */
    public void startWorkbooksSearch() throws InterruptedException {
        
        workBooksFoundList = new ArrayList<>();
        for(String path : pathList)
        {
        startWorkbooksSearch = new StartWorkbooksSearch(path, workBooksFoundList);
        //startWorkbooksSearch.startWorkbooksSearch(path);
        }
    }
    
    /**
     * 
     * Add path to the end of the list
     * 
     * @param path 
     */
    public void addPath(String path)
    {
        pathList.add(path);
    }
    
    /**
     * 
     * Remove a path by name
     * 
     * @param path
     * @return 
     */
    public boolean removePath(String path)
    {
        return pathList.remove(path);
    }
    
    /**
     * 
     * Get the list of paths 
     * 
     * @return 
     */
    public ArrayList<String> getPaths()
    {
        return pathList;
    }
}
