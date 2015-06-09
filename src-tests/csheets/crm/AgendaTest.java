package csheets.crm;

import csheets.ext.contact.Agenda;
import csheets.ext.contact.Event;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * A Unit Test class to test Agenda.
 *
 * @see Agenda
 * @author Cristina Lopes e Egídio Santos
 */
public class AgendaTest {

	/**
	 * /**
	 * A method that tests if the Event is added to the EventList.
	 */
	@Test
	public void testAdd() {

		Agenda agenda = new Agenda();
		Event event = new Event();
		boolean expResult = true;
		boolean result = agenda.add(event);
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the Event is removed of the EventList.
	 */
	@Test
	public void testRmv() {

		Agenda agenda = new Agenda();
		Event event = new Event();
		agenda.add(event);
		boolean expResult = true;
		boolean result = agenda.rmv(event);
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the Event is edited of the EventList.
	 */
	@Test
	public void testEdit() {

		Agenda agenda = new Agenda();
		Event event = new Event();
		agenda.add(event);
		boolean expResult = true;
		boolean result
			= agenda.edit(event);

		assertEquals(expResult, result);

	}

}
