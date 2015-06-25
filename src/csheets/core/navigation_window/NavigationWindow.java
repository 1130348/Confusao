/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.navigation_window;

import csheets.core.Workbook;

/**
 *
 * @author Luis
 */
public class NavigationWindow {

	private NavigationFunctionController nav_contrl;
	private Workbook workbook;

	public NavigationWindow(
		NavigationFunctionController navigationFunctionController) {
		this.nav_contrl = navigationFunctionController;
		this.workbook = new Workbook();
	}

	public NavigationWindow() {
		this.workbook = new Workbook();
	}

	public String[] getWorkbookInfo() {
		String[] info = null;
		int tamanho = workbook.getSpreadsheetCount();
		for (int i = 0; i < tamanho; i++) {
			info[i] = workbook.getSpreadsheet(i).getTitle();
		}
		return info;
	}

}
