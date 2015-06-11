/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.core.SpreadsheetImpl;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class ReportCreater {

    private ReportCreater() {

    }

    public static String createResume(SpreadsheetImpl[] spreadSheetList) {
        if(spreadSheetList == null){
            return "Workbook not found";
        }
        String resume = "";
        int hasContent = 0;
        for (int i = 0; i < spreadSheetList.length; i++) {
            resume += "\nTitle: ";
            resume += spreadSheetList[i].getTitle();
            for (int j = 0; j < spreadSheetList[i].getRowCount(); j++) {
                for (int k = 0; k < spreadSheetList[i].getColumnCount(); k++) {
                    if(!spreadSheetList[i].getCell(k, j).getContent().equalsIgnoreCase("")){
                        resume+= "\nContent of first cell with value: " + spreadSheetList[i].getCell(k, j).getContent();
                        hasContent = 1;
                        break;
                    }
                }
            }
            if(hasContent == 0){
                resume+= "\nNo content in this spreadsheet";                        
            }
        }
        return resume;
    }
}
