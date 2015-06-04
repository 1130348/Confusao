package csheets.ext.contact.ui;

import csheets.ui.ctrl.UIController;

/**
 * A controller for updating the user-specified comment of a cell.
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class ContactController {

	/** The user interface controller */
	private UIController uiController;
        
        /** User interface panel **/
        private ContactPanel uiPanel;
        
	/**
	 * Creates a new comment controller.
	 * @param uiController the user interface controller
         * @param uiPanel the user interface panel
	 */
	public ContactController(UIController uiController, ContactPanel uiPanel) {
		this.uiController = uiController;
                this.uiPanel = uiPanel;
	}
        
        //method to getContacts form DB

	
}
