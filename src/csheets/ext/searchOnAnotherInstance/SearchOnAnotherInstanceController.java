/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import csheets.ext.searchOnAnotherInstance.ui.SearchOnAnotherInstanceDialog;
import java.net.InetAddress;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class SearchOnAnotherInstanceController {

    public SearchOnAnotherInstanceController() {
    }
    
    public void startServer(SearchOnAnotherInstanceDialog dialog){
        ReportWatch reportWatch = new ReportWatch();
        reportWatch.addObserver(dialog);
    }
    
    public void sendSearchRequest(String address, String workbookName){
        
    }
    
    public SpreadsheetImpl[] searchWorkbook(Workbook[] workbookList, String workbookName){
      return null;  
    }
    
    public void sendSpreadSheetList(InetAddress address, SpreadsheetImpl[] spreadSheetList){
        
    }
}
