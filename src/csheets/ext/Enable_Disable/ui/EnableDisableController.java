/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Enable_Disable.ui;

import csheets.ui.ctrl.UIController;

/**
 *
 * @author Paulinho
 */
public class EnableDisableController {

	public UIController ui;

	private UIController uiController;

	/**
	 * EnableDisablePanel interface panel *
	 */
	private EnableDisablePanel uiPanel;

	/**
	 * Creates a new EnableDisable controller.
	 *
	 * @param uiController the EnableDisable interface controller
	 * @param uiPanel the EnableDisable interface panel
	 */
	public EnableDisableController(UIController uiController,
								   EnableDisablePanel uiPanel) {
		this.uiController = uiController;
		this.ui = uiController;
		this.uiPanel = uiPanel;
	}
}
