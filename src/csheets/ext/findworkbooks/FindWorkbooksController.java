/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class FindWorkbooksController {

    private StartWorkbooksSearch startWorkbooksSearch;

    public FindWorkbooksController() {
        startWorkbooksSearch = new StartWorkbooksSearch();
    }

    public void startWorkbooksSearch() throws InterruptedException {
        startWorkbooksSearch.startWorkbooksSearch();
    }
}
