package csheets.crm;

import csheets.ext.address.Address;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * A Unit Test class to test Address.
 *
 * @see Address
 * @author Cristina Lopes
 */
public class AddressTest {

	/**
	 * A method that tests if the Street is valid.
	 */
	@Test
	public void testValidaStreet() {

		Address a = new Address();
		String tmp_Street = "Test";
		a.setStreet(tmp_Street);

		boolean expResult = true;
		boolean result = false;
		if (a.getStreet().equals(tmp_Street)) {
			result = true;
		}
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the City is valid.
	 */
	@Test
	public void testValidaCity() {

		Address a = new Address();
		String tmp_City = "Test";
		a.setCity(tmp_City);

		boolean expResult = true;
		boolean result = false;
		if (a.getCity().equals(tmp_City)) {
			result = true;
		}
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the Locality is valid.
	 */
	@Test
	public void testValidaLocality() {

		Address a = new Address();
		String tmp_Locality = "Test";
		a.setLocality(tmp_Locality);

		boolean expResult = true;
		boolean result = false;
		if (a.getLocality().equals(tmp_Locality)) {
			result = true;
		}
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the Country is valid.
	 */
	@Test
	public void testValidaCountry() {

		Address a = new Address();
		String tmp_Country = "Test";
		a.setCountry(tmp_Country);

		boolean expResult = true;
		boolean result = false;
		if (a.getCountry().equals(tmp_Country)) {
			result = true;
		}
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the Postal Code is valid.
	 */
	@Test
	public void testValidaPostalCode() {

		Address a = new Address();
		String tmp_Postalcode = "Test";
		a.setPostalCode(tmp_Postalcode);

		boolean expResult = true;
		boolean result = false;
		if (a.getPostalCode().equals(tmp_Postalcode)) {
			result = true;
		}
		assertEquals(expResult, result);
	}
}
