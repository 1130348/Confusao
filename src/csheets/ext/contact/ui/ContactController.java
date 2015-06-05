package csheets.ext.contact.ui;

import csheets.ext.contact.Contact;
import csheets.persistence.Persistence;
import csheets.ui.ctrl.UIController;
import java.util.List;

/**
 * A controller for updating the user-specified comment of a cell.
 *
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class ContactController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * User interface panel *
	 */
	private ContactPanel uiPanel;

	/**
	 * Creates a new comment controller.
	 *
	 * @param uiController the user interface controller
	 * @param uiPanel the user interface panel
	 */
	public ContactController(UIController uiController, ContactPanel uiPanel) {
		this.uiController = uiController;
		this.uiPanel = uiPanel;
	}

	/**
	 * Will get all the contacts that are already on the database
	 *
	 * @return
	 */
	public List<Contact> getContacts() {
		return Persistence.getRepositoryFactory().getContactRepository().all();
	}

	/**
	 * Adds a contact to the database
	 *
	 * @param c contact
	 * @return true or false
	 */
	public boolean addContact(Contact c) {
		return Persistence.getRepositoryFactory().getContactRepository().add(c);
	}

	/**
	 * Removes a contact
	 *
	 * @param c contact
	 * @return true or falase
	 */
	public boolean removeContact(Contact c) {
		return Persistence.getRepositoryFactory().getContactRepository().
			remove(c);
	}

	/**
	 * To update the list of contacts that is showed to the user
	 */
	public void update() {
		uiPanel.startList();
	}

}
