/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.search;

import csheets.core.Address;
import csheets.core.Spreadsheet;
import csheets.ui.sheet.SpreadsheetTable;

/**
 *
 * @author Jose
 */
public class Search {

	public static Address Search(String texto,
								 SpreadsheetTable focusOwner) {

		Spreadsheet spreadsheet = focusOwner.getSpreadsheet();
		int rownr = spreadsheet.getRowCount();
		int columnnr = spreadsheet.getColumnCount();
		for (int i = 0; i <= rownr; i++) {
			for (int j = 0; j <= columnnr; j++) {
				if (spreadsheet.getCell(j, i).getContent().
					matches(texto)) {
					return new Address(j, i);
				}
			}
		}
		return null;
	}
}
