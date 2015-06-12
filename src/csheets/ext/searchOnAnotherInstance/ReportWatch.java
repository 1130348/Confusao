/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.core.Workbook;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class ReportWatch extends Observable implements Observer {

    public ReportWatch() {
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof ReportEvent) {
            Workbook workbook = ((ReportEvent) arg).getWorkbook();
            String resume = ReportCreater.createResume(workbook);
            setChanged();
            notifyObservers(resume);
        }
    }

}
