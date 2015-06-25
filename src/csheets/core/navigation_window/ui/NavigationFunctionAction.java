/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.navigation_window.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Luis
 */
public class NavigationFunctionAction extends BaseAction {

	private UIController controller;

	public NavigationFunctionAction(UIController uiController) {
		controller = uiController;
	}

	@Override
	protected String getName() {
		return "Navigation Window";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NavigationFunctionUI dialog = NavigationFunctionUI.
			getInstance(controller);
		dialog.setVisible(true);
	}

}
