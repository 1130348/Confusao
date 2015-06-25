/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importXML.ui;

import csheets.CleanSheets;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Sérgio Gomes
 */
public class ImportAsAction extends FocusOwnerAction {

	private UIController uiController;
	private CleanSheets app;

	public ImportAsAction(CleanSheets app, UIController uiController) {
		this.uiController = uiController;
		this.app = app;
	}

	@Override
	protected String getName() {
		return "Import as...";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImportAsDialog dialog = new ImportAsDialog(null, true, uiController, app);
		dialog.setVisible(true);
	}

}
