package csheets.ext.import_export_link;

import csheets.ext.import_export_text.CustomExportation;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implements Runnable and has a method that is always checking if are
 * modifications on the cells. If positive then will export to a txt file.
 *
 * @author Cristina
 */
public class Export implements Runnable {

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
	 * The export process
	 */
	public CustomExportation c;

	/**
	 * Import
	 */
	public Import i;

	/**
	 * Constructor with parameters
	 *
	 * @param uiController
	 * @param files
	 * @param separator
	 */
	public Export(UIController uiController, File[] files, String separator,
				  Import i) throws FileNotFoundException {
		this.uiController = uiController;
		this.file = files[0];
		this.separator = separator;
		this.i = i;
	}

	/**
	 * Abstract method that will activate the thread
	 */
	@Override
	public void run() {

		//THREAD checks if the file is linked
		while (uiController.getImportExportLink()) {
			while (uiController.getCondImp()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
					Logger.getLogger(Export.class.getName()).
						log(Level.SEVERE, null, ex);
				}
			}
			if (uiController.getModificationsOnCells()) {// Is a boolean variable that becames true if the cells are changed
				uiController.setCondExp(true);
				try {
					c = new CustomExportation(this.uiController, this.file, separator);
					c.run();
				} catch (FileNotFoundException ex) {
					Logger.getLogger(Export.class.getName()).
						log(Level.SEVERE, null, ex);
				}
				uiController.setModificationOnCells(false);
				// Changes the date that is in the class Import
				i.setDate(file.lastModified());
				uiController.setCondExp(false);
			}

			// To don't check all the time. Not to test right after testing
			try {
				Thread.sleep(600);
			} catch (InterruptedException ex) {
				Logger.getLogger(Import.class.getName()).
					log(Level.SEVERE, null, ex);
			}
		}
	}

}
