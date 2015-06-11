package csheets.ext.address.ui;

import csheets.ext.contact.Contact;
import csheets.persistence.Persistence;
import csheets.ui.ctrl.UIController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * A controller for updating the user-specified comment of a cell.
 *
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class AddressController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * User interface panel *
	 */
	private AddressPanel uiPanel;

	/**
	 * Constructor
	 *
	 * @param uiController the user interface controller
	 * @param uiPanel the user interface panel
	 */
	public AddressController(UIController uiController, AddressPanel uiPanel) {
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
	 * To update the contact on the database
	 *
	 * @param c
	 * @return
	 */
	public boolean updateContact(Contact c) {

		return Persistence.getRepositoryFactory().getContactRepository().edit(c);
	}

	/**
	 * To update the list of contacts that is showed to the user
	 */
	public void update() {
		uiPanel.startList();
	}

	/**
	 * Will validates the postal code from a text file
	 *
	 * @param text
	 * @return
	 */
	boolean validatePostalCode(String text) {
		BufferedReader br = null;

		try {

			String line;

			br = new BufferedReader(new FileReader("./src/csheets/ext/address/ui/ListPostalCodes.txt"));

			// While there are lines to read
			while ((line = br.readLine()) != null) {
				// If one postalcode of the file is equals to the parameter it means that is valid
				if (line.equals(text)) {
					return true;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

}
