/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.navigation_window;

/**
 *
 * @author Luis
 */
public class NavigationFunctionController {

	private NavigationWindow ui;

	public NavigationFunctionController() {
		ui = new NavigationWindow();
	}

	public String[] getWorkbookInfo() {
		int a = 2;
		int b = 3;
		return ui.getWorkbookInfo();
	}

}
