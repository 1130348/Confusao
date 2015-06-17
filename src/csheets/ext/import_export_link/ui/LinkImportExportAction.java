package csheets.ext.import_export_link.ui;

import csheets.CleanSheets;
import csheets.ext.import_export_link.ImportationExportationLinkController;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Cristina
 */
public class LinkImportExportAction extends BaseAction {

	/**
	 * UI Controller
	 */
	private UIController uiController;

	/**
	 * The Cleansheets app
	 */
	private CleanSheets app;

	/**
	 * The ImportationExportationLinkController
	 */
	private ImportationExportationLinkController ieController;

	/**
	 * Constructor
	 *
	 * @param a
	 * @param tmp
	 */
	public LinkImportExportAction(CleanSheets a, UIController tmp) {
		this.app = a;
		this.uiController = tmp;
		ieController = new ImportationExportationLinkController(tmp);
	}

	/**
	 * Method getName()
	 *
	 * @return
	 */
	@Override
	protected String getName() {
		return "Importation and Exportation Link";
	}

	/**
	 * Create the new window
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		LinkDialog dialog = new LinkDialog(null, true, uiController, ieController);
		dialog.setVisible(true);

	}

}
