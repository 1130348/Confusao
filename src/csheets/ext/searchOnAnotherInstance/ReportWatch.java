/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.core.SpreadsheetImpl;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class ReportWatch extends Observable implements Observer{

    public ReportWatch() {
    }
    
    @Override
    public void update(Observable o, Object arg) {
        SpreadsheetImpl[] spreadSheetList = ((ReportEvent)arg).getSpreadSheetList();
        String resume = ReportCreater.createResume(spreadSheetList);
        setChanged();
        notifyObservers(resume);
    }
    
}
