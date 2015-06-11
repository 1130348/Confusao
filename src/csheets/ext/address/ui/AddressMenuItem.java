package csheets.ext.address.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;

/**
 * Representes the UI extension menu of the simple extension.
 *
 * @author Cristina Lopes
 */
public class AddressMenuItem extends JMenuItem {

	/**
	 * Creates a new simple menu. This constructor creates and adds the menu
	 * options. In this simple example only one menu option is created. A menu
	 * option is an action (in this case
	 * {@link csheets.ext.simple.ui.ExampleAction})
	 *
	 * @param uiController the user interface controller
	 */
	public AddressMenuItem(UIController uiController) {
		super("Address");
		setMnemonic(KeyEvent.VK_Z);

	}
}
