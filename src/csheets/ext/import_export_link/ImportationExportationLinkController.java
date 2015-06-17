package csheets.ext.import_export_link;

import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Cristina
 */
public class ImportationExportationLinkController {

	/**
	 * The UI controller
	 */
	private UIController uiController;

	/**
	 * Import
	 */
	private Import i;

	/**
	 * Thread to export
	 */
	private Thread texport;

	/**
	 * Thread to import
	 */
	private Thread timport;

	/**
	 * Constructor with parameters
	 *
	 * @param uiController
	 */
	public ImportationExportationLinkController(UIController uiController) {
		this.uiController = uiController;
	}

	/**
	 * To call the thread to import
	 *
	 * @param files
	 * @param separator
	 * @throws FileNotFoundException
	 */
	public void importation(File[] files, String separator) throws FileNotFoundException {
		timport = new Thread(this.i = new Import(uiController, files, separator));
		timport.start();
	}

	/**
	 * To call the thread to export
	 *
	 * @param files
	 * @param separator
	 * @throws FileNotFoundException
	 */
	public void exportation(File[] files, String separator) throws FileNotFoundException {
		texport = new Thread(new Export(uiController, files, separator, i));
		texport.start();
	}

	/**
	 * To put false the variable ImportExportLink
	 */
	public void closeLink() {
//		uiController.setImportExportLink(false);
	}

	/**
	 * To know if the thread is alive
	 */
	public boolean isThreadActive() {
		if (timport == null) {
			return false;
		}
		return timport.isAlive();
	}

}
