/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.search;

import csheets.core.Address;
import csheets.core.Spreadsheet;
import csheets.ui.sheet.SpreadsheetTable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class Search {

    public static List<Address> search(String texto, SpreadsheetTable focusOwner) {

        List<Address> list_addresses = new ArrayList<>();
        Spreadsheet spreadsheet = focusOwner.getSpreadsheet();
        int rownr = spreadsheet.getRowCount();
        int columnnr = spreadsheet.getColumnCount();
        for (int i = 0; i <= rownr; i++) {
            for (int j = 0; j <= columnnr; j++) {
                if (spreadsheet.getCell(j, i).getValue().toString().matches(texto)) {
                    list_addresses.add(new Address(j, i));
                }
            }
        }
        return list_addresses;
    }
}
