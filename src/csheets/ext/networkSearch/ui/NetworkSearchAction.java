/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkSearch.ui;

import csheets.ext.findworkbooks.FindWorkbooksController;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class NetworkSearchAction extends BaseAction {

	private UIController controller;

	/**
	 * The network controller
	 */
	private final FindWorkbooksController findWorkBooksController;

	public NetworkSearchAction(UIController uiController) {
		controller = uiController;
		this.findWorkBooksController = new FindWorkbooksController();
	}

	@Override
	protected String getName() {
		return "Workbook Network Search";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(
			null,
			"Workbook search has started!\n"
			+ "You can track the progress of your search "
			+ "on the sidebar under \"Find Workbooks\"",
			"Search Started",
			JOptionPane.INFORMATION_MESSAGE
		);
		try {
			findWorkBooksController.startWorkbooksSearch();
		} catch (InterruptedException ex) {
			System.out.println("Error");
		}
	}

}
