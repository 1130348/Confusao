package csheets.ext.toolbar_buttons.ui;

import csheets.ui.ctrl.UIController;
import java.util.ArrayList;

/**
 * The controller of this use case "Buttons on Toolbar" - ButtonsController
 *
 * @author Cristina
 */
public class ButtonsController {

	/**
	 * The names of the icons that are on the file
	 */
	private ArrayList<String> iconNames;

	/**
	 * Constructor without parameters
	 */
	public ButtonsController() {
		iconNames = new ArrayList<String>();
	}

	/**
	 * Constructor with parameters (the UIController)
	 *
	 * @param ui
	 */
	public ButtonsController(UIController ui) {
		iconNames = new ArrayList<String>();
		names();
	}

	/**
	 * Adds all the valid names to the ArrayList iconNames
	 */
	public void names() {
		this.iconNames.add("Calculator");
		this.iconNames.add("Calendar");
		this.iconNames.add("Dollar");
		this.iconNames.add("Go");
		this.iconNames.add("Heart");
		this.iconNames.add("Help");
		this.iconNames.add("Home");
		this.iconNames.add("Key");
		this.iconNames.add("List");
		this.iconNames.add("Next");
		this.iconNames.add("Redo");
		this.iconNames.add("Smile");
		this.iconNames.add("Up");
	}

	/**
	 * Verifie if the name passed by parameter exists on the vector
	 *
	 * @param x
	 * @return true or false
	 */
	public boolean verificationNames(String x) {
		for (String s : this.iconNames) {
			if (s.equals(x)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the ArrayList iconNames
	 *
	 * @return iconNames
	 */
	public ArrayList<String> getIconNames() {
		return this.iconNames;
	}

	/**
	 * Changes the content of iconNames
	 *
	 * @param tmp
	 */
	public void setIconNames(ArrayList<String> tmp) {
		this.iconNames = tmp;
	}
}
