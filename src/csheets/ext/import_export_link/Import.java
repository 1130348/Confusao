package csheets.ext.import_export_link;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristina
 */
public class Import implements Runnable {

	/**
	 * UI Controller
	 */
	private UIController uiController;

	/**
	 * The linked file
	 */
	private File file;

	/**
	 * The separator
	 */
	private String separator;

	/**
	 * The date of the last update (milliseconds)
	 */
	public long date_last_update;

	/**
	 * Constructor with parameters
	 *
	 * @param uiController
	 * @param files
	 * @param separator
	 */
	public Import(UIController uiController, File[] files, String separator) {
		this.uiController = uiController;
		this.file = files[0];
		this.separator = separator;
		this.date_last_update = new Date().getTime();
	}

	/**
	 * Changes the content of data
	 *
	 * @param d
	 */
	public void setDate(long d) {
		this.date_last_update = d;
	}

	/**
	 * Will call the class Listener that will implement cell listeners. If the
	 * content of cells were changed the variable ModicationOnCells of
	 * uiController will be setted to true and then the thread will export the
	 * cells to the file.
	 */
	private void modifications() {
//		// Collums A -> AZ
//		for (int i = 0; i < 52; i++) {
//			// Lines 1 -> 128
//			for (int j = 0; j < 128; j++) {
//				Cell c = uiController.getActiveSpreadsheet().getCell(i, j);
//				// put a listener on each cell to know if the cells were changed
//				c.addCellListener(new CellListener() {
//
//					@Override
//					public void valueChanged(Cell cell) {
//						uiController.setModificationOnCells(true);
//					}
//
//					@Override
//					public void contentChanged(Cell cell) {
//						uiController.setModificationOnCells(true);
//					}
//
//					@Override
//					public void dependentsChanged(Cell cell) {
//						uiController.setModificationOnCells(true);
//					}
//
//					@Override
//					public void cellCleared(Cell cell) {
//						uiController.setModificationOnCells(true);
//					}
//
//					@Override
//					public void cellCopied(Cell cell, Cell source) {
//						uiController.setModificationOnCells(true);
//					}
//				});
//			}
//		}
	}

	/**
	 * Abstract method that will activate the thread
	 */
	@Override
	public void run() {
//		uiController.setCondImp(true);
//		uiController.setModificationOnCells(false);
//		Thread th = new Thread(new FileImporterFirstSheet(file, uiController, separator));
//		th.start();
//
//		while (th.isAlive()) {
//		}
//		uiController.setCondImp(false);
//		modifications();
//		while (uiController.getImportExportLink()) {
//			while (uiController.getCondExp()) {
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException ex) {
//					Logger.getLogger(Export.class.getName()).
//						log(Level.SEVERE, null, ex);
//				}
//			}
//			// if the date_last_update is before the date of the last modification in the file will export all the information to the cells
//			if (date_last_update < file.lastModified()) {
//				uiController.setCondImp(true);
//				Thread th1 = new Thread(new FileImporterFirstSheet(file, uiController, separator));
//				th1.start();
//				// updates the date_last_update
//				date_last_update = file.lastModified();
//				uiController.setCondImp(false);
//			}
//			// To don't check all the time. Not to test right after testing
//			try {
//				Thread.sleep(600);
//			} catch (InterruptedException ex) {
//				Logger.getLogger(Import.class.getName()).
//					log(Level.SEVERE, null, ex);
//			}
//		}
	}

	/**
	 * Private class that was created because the way that the importation on
	 * CustomImportation was do was almost impossible to do importation and
	 * exportation by link because it opens a new sheet. Because of that I
	 * created this class that implements Runnable and will clear all the cells
	 * of the sheet and then sets all the content read on the text file.
	 */
	private class FileImporterFirstSheet implements Runnable {

		/**
		 * UI Controller
		 */
		private UIController uiController;

		/**
		 * The linked file
		 */
		private File file;

		/**
		 * The separator
		 */
		private String separator;

		/**
		 * Constructor with parameters
		 *
		 * @param file
		 * @param ui
		 * @param s
		 */
		public FileImporterFirstSheet(File file, UIController ui, String s) {
			this.file = file;
			this.uiController = ui;
			this.separator = s;
		}

		/**
		 * The method to import (first clear all the cells and then imports all
		 * the information from the text file)
		 */
		@Override
		public void run() {
			try {
				clearAllCells();
			} catch (FormulaCompilationException ex) {
				Logger.getLogger(Import.class.getName()).
					log(Level.SEVERE, null, ex);
			}

			/**
			 * BufferedReader
			 */
			BufferedReader bF = null;

			/**
			 * FileReader
			 */
			FileReader fR = null;

			/**
			 * List of strings
			 */
			List<String> info;

			/**
			 * Each line
			 */
			String nextLine = "";

			/**
			 * The Spreadsheet to get the cells
			 */
			Spreadsheet sheet;

			int cont = 0;

			if (file != null) {
				try {
					fR = new FileReader(file.getAbsolutePath());
				} catch (FileNotFoundException ex) {
					JOptionPane.
						showMessageDialog(null, "ERROR File not found!!!\n");
				}

				/**
				 * Cell
				 */
				Cell c;

				if (fR != null) {
					bF = new BufferedReader(fR);
					c = uiController.getActiveCell();
					// The spreadsheet of the active cell
					sheet = c.getSpreadsheet();

					try {
						//Reads the first line
						nextLine = bF.readLine();
					} catch (IOException ex) {
						JOptionPane.
							showMessageDialog(null, "ERROR Cannot read the first line\n");
					}

					// While there has a new line
					while (nextLine != null) {
						// Split by the separator
						info = Arrays.asList(nextLine.split(separator));

						// Start in the first cell of the sheet
						for (int i = 0; i < info.size(); i++) {
							c = sheet.
								getCell(i, cont);

							try {
								// Set the content to the cell
								c.setContent(info.get(i));
							} catch (FormulaCompilationException ex) {
								JOptionPane.
									showMessageDialog(null, "ERROR Cannot insert information on the cell\n");
							}
						}
						cont++; // Number of rows
						// Next line
						try {
							nextLine = bF.readLine();
						} catch (IOException ex) {
							JOptionPane.
								showMessageDialog(null, "ERROR Reading the file\n");
						}
					}

					// Close the BufferedReader (the file)
					try {
						bF.close();
					} catch (IOException ex) {
						JOptionPane.
							showMessageDialog(null, "ERROR Closing the file\n");
					}
				}
			}
		}

		/**
		 * Puts all cells black to fill again
		 *
		 * @throws FormulaCompilationException
		 */
		private void clearAllCells() throws FormulaCompilationException {
			// Number of columns
			int columns = this.uiController.getActiveSpreadsheet().
				getColumnCount();
			// Number of rows
			int rows = this.uiController.getActiveSpreadsheet().getRowCount();

			// Fill all the cells with ""
			for (int i = 0; i < rows + 1; i++) {
				for (int j = 0; j < columns + 1; j++) {
					this.uiController.getActiveSpreadsheet().getCell(i, j).
						setContent("");
				}
			}
		}

	}

}
