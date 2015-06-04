package csheets.crm;

import csheets.ext.contact.Event;
import java.sql.Timestamp;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * A Unit Test class to test Event.
 *
 * @see Event
 * @author Cristina Lopes
 */
public class EventTest {

	/**
	 * A method that tests if the Description is valid.
	 */
	@Test
	public void testValidaDescription() {

		Event e = new Event();
		String description = "eventoTeste";
		e.setDescription(description);

		boolean expResult = true;
		boolean result = false;
		if (e.getDescription().equals(description)) {
			result = true;
		}
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the Timestamp is valid.
	 */
	@Test
	public void testValidaTimestamp() {

		Event e = new Event();
		Timestamp t = new Timestamp(10);

		e.setTimestamp(t);

		boolean expResult = true;
		boolean result = false;
		if (e.getTimestamp() == t) {
			result = true;
		}
		assertEquals(expResult, result);
	}
}
