/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.core.Workbook;
import csheets.ext.searchOnAnotherInstance.ui.SearchOnAnotherInstanceDialog;
import csheets.ext.startsharing.NetworkReceiveService;
import csheets.ext.startsharing.NetworkService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class SearchOnAnotherInstanceController {

    public SearchOnAnotherInstanceController() {
    }

    public void startServer(SearchOnAnotherInstanceDialog dialog) {
        ReportWatch reportWatch = new ReportWatch();
        reportWatch.addObserver(dialog);
        NetworkService.addObserver(dialog, reportWatch);
    }

    public void sendSearchRequest(String address, String workbookName) {
        try {
            InetAddress newAddress = InetAddress.getByName(address);
            NetworkService.sendSearchRequest(newAddress, workbookName);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SearchOnAnotherInstanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendWorkbook(InetAddress address, Workbook workbook) {
        NetworkService.sendWorkbook(address, workbook);
    }

    public void setVisibility(boolean b) {
        NetworkService.isVisibleToOthers(b);
    }

    public Map<InetAddress, Integer> searchInstances() {
        return NetworkService.searchInstances();
    }

    public void deactivateServer() {
        NetworkReceiveService.interruptServer();
    }
}
