/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importXML;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;

/**
 *
 * @author Sergio Gomes
 */
public class ImportProcess {

	private String filename;

	private ImportStrategy strategy;

	private Spreadsheet sheet;

	private Workbook activeWorkbook;

	private String cellTag;

	public ImportProcess(String type) {
		strategy = ImportStrategyFactory.getInstance().getImportStrategy(type);
	}

	public Workbook getActiveWorkbook() {
		return activeWorkbook;
	}

	public String getCellTag() {
		return cellTag;
	}

	public String getFilename() {
		return filename;
	}

	public Spreadsheet getSheet() {
		return sheet;
	}

	public void setActiveWorkbook(Workbook activeWorkbook) {
		this.activeWorkbook = activeWorkbook;
	}

	public void setCellTag(String cellTag) {
		this.cellTag = cellTag;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setSpreadSheet(Spreadsheet sheet) {
		this.sheet = sheet;
	}

	public void importXML() {
		strategy.importXML(this);
	}

}
