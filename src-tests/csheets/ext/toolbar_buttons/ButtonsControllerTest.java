package csheets.ext.toolbar_buttons;

import csheets.ext.toolbar_buttons.ui.ButtonsController;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * The class of tests of the class ButtonsController
 *
 * @author Cristina
 */
public class ButtonsControllerTest {

	/**
	 * A method that tests if the method verificationNames is working
	 */
	@Test
	public void testVerificationNamesIcon1() {

		ButtonsController b = new ButtonsController();
		b.names();

		boolean expResult = true;
		boolean result = false;
		result = b.verificationNames("Smile");
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the method verificationNames is working
	 */
	@Test
	public void testVerificationNamesIcon2() {

		ButtonsController b = new ButtonsController();
		b.names();

		boolean expResult = false;
		boolean result = false;
		result = b.verificationNames("Test");
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the method Names() is working
	 */
	@Test
	public void testVerificationNames() {

		ButtonsController b = new ButtonsController();
		b.names();

		boolean expResult = false;
		boolean result = false;
		ArrayList<String> iconNames = b.getIconNames();
		for (String s : iconNames) {
			if (s.equals("Teste")) {
				result = true;
			}
		}
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the ArrayList iconNames is valid.
	 */
	@Test
	public void testSetGetNamesIcon() {

		ButtonsController b = new ButtonsController();

		ArrayList<String> iconNames = new ArrayList<String>();
		b.setIconNames(iconNames);

		boolean expResult = true;
		boolean result = false;

		if (iconNames == b.getIconNames()) {
			result = true;
		}

		assertEquals(expResult, result);
	}
}
