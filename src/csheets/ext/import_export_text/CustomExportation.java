/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.import_export_text;

import csheets.CleanSheets;
import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Silva <1130664@isep.ipp.pt>
 */
public class CustomExportation implements Runnable {

	private CleanSheets app;
	private UIController uiController;
	private FileOutputStream file;
	private String separator;
	private int header;
	private int includeHeader;

	public CustomExportation(CleanSheets app, UIController uiController,
							 String fileName,
							 String separator, int header, int includeHeader) throws FileNotFoundException {
		this.app = app;
		this.uiController = uiController;
		this.separator = separator;
		// to do overwrite
		file = new FileOutputStream(fileName, false);
		this.header = header;
		this.includeHeader = includeHeader;
	}

	/**
	 * Constructor with parameters
	 *
	 * @param uiController
	 * @param fileName
	 * @param separator
	 * @throws FileNotFoundException
	 */
	public CustomExportation(UIController uiController,
							 File fileName,
							 String separator) throws FileNotFoundException {
		this.uiController = uiController;
		this.separator = separator;
		// to do overrite
		file = new FileOutputStream(fileName, false);
		this.header = 1;
		this.includeHeader = 1;
	}

	/**
	 * The method to export to a .txt file
	 *
	 * @throws FileNotFoundException
	 */
	public void exportText() throws FileNotFoundException {

		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(file)));

			// Writes content of rows
			Spreadsheet sheet = uiController.getActiveSpreadsheet();
			for (int row = 0; row < sheet.getRowCount(); row++) {
				if (row == 0 && ((includeHeader == 0 && header == 0) || (includeHeader == 0 && header == 1))) {
					continue;
				}
				for (int column = 0; column < 52; column++) {
					writer.print(sheet.getCell(column, row).getContent()
						+ separator);
				}
				writer.println();
			}

			// Frees resources
			writer.close();
			file.close();

		} catch (IOException ex) {
			Logger.getLogger(CustomExportation.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * The method run that calls exportation method
	 */
	@Override
	public void run() {
		try {
			exportText();

		} catch (FileNotFoundException ex) {
			Logger.getLogger(CustomExportation.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}
}
