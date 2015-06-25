/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importXML;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author Sergio Gomes
 */
public class ImportController {

	private UIController uiController;
	private ImportProcess importProcess;

	public ImportController(UIController uiController) {
		this.uiController = uiController;
	}

	public void importXML(String filename, String type, Spreadsheet sheet,
						  Workbook active) {
		importProcess = new ImportProcess(type);
		importProcess.setActiveWorkbook(active);
		importProcess.setCellTag(XMLTag.getInstance().getCellTag());
		importProcess.setFilename(filename);
		importProcess.setSpreadSheet(sheet);
		importProcess.importXML();
	}

}
