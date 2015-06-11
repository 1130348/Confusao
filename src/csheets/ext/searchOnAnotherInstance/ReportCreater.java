/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.core.Spreadsheet;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class ReportCreater {


    private ReportCreater() {

    }

    public static String createResume(Workbook workbook) {
        if(workbook == null){
            return "Workbook not found";
        }
        int spreadSheets = workbook.getSpreadsheetCount();
        Spreadsheet[] spreadSheetList = new Spreadsheet[spreadSheets];
        for (int i = 0; i < spreadSheets; i++) {
            spreadSheetList[i] = workbook.getSpreadsheet(i);
        }
        String resume = "";
        int hasContent;
        for (int i = 0; i < spreadSheetList.length; i++) {
            hasContent = 0;
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
                if(hasContent == 1){
                    break;
                }
            }
            if(hasContent == 0){
                resume+= "\nNo content in this spreadsheet";                        
            }
        }
        return resume;
    }
}
