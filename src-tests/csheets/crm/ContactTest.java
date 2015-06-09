package csheets.crm;

import csheets.ext.contact.Contact;
import java.awt.image.BufferedImage;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * A Unit Test class to test Contact.
 *
 * @see Contact
 * @author Egidio Santos
 */
public class ContactTest {

	/**
	 * A method that tests if the First Name is valid.
	 */
	@Test
	public void testValidaFirstName() {

		Contact contact = new Contact();
		String fName = "Test";
		contact.setFirst_Name(fName);

		boolean expResult = true;
		boolean result = false;
		if (contact.getFirst_Name().equals(fName)) {
			result = true;
		}
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the Last Name is valid.
	 */
	@Test
	public void testValidaLastName() {

		Contact contact = new Contact();
		String fName = "Test";
		contact.setLast_Name(fName);

		boolean expResult = true;
		boolean result = false;
		if (contact.getLast_Name().equals(fName)) {
			result = true;
		}
		assertEquals(expResult, result);
	}

	/**
	 * A method that tests if the image File is valid.
	 */
	@Test
	public void testAddImage() {
		Contact contact = new Contact();
		BufferedImage image = new BufferedImage(2, 3, 4);
		contact.setImage(image);

		boolean expResult = true;
		boolean result = false;

		if (contact.getImage() == image) {
			result = true;
		}

		assertEquals(expResult, result);

	}

	/**
	 * A method that tests if the main address is valid
	 */
//	@Test
//	public void testValidaMainAddress() {
//		Contact contact = new Contact();
//		Address a = new Address();
//		contact.setMainAddress(a);
//
//		boolean expResult = true;
//		boolean result = false;
//
//		if (contact.getMainAddress().equals(a)) {
//			result = true;
//		}
//
//		assertEquals(expResult, result);
//	}
	/**
	 * A method that tests if the secundary address is valid
	 */
//	@Test
//	public void testValidaSecundaryAddress() {
//		Contact contact = new Contact();
//		Address a = new Address();
//		contact.setSecundaryAddress(a);
//
//		boolean expResult = true;
//		boolean result = false;
//
//		if (contact.getSecundaryAddress().equals(a)) {
//			result = true;
//		}
//		assertEquals(expResult, result);
//	}
          
//    @Test
//    public void testaddNote()
//    {
//        
//        Contact c = new Contact();
//        String title = "title";
//        String text = "text";
//        
//        boolean expResult = true;
//        boolean result = c.addNote(new Note("title", "text"));
//        
//        assertEquals(expResult,result);
//    }
//    
//    @Test
//    public void testremoveNote()
//    {
//        Contact c = new Contact();
//        String title = "title";
//        String text = "text";
//        
//        Note n = new Note("title", "text");
//        
//        c.addNote(n);
//        
//        
//        boolean expResult = true;
//        boolean result = c.removeNote(n);
//        
//    }
}
