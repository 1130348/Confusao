package csheets.crm;

import csheets.ext.contact.Contact;
import csheets.ext.contact.Note;
import csheets.ext.contact.ui.ContactController;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * A Unit Test class to test CreateContact.
 *
 * @see ContactController
 * @author Egidio Santos
 */
public class ContactControllerTest {

	/**
	 * // * A method that tests if the contact was created. //
	 */
//    @Test
//    public void testCreateNewContact() {
//
//        CreateContact createContact = new CreateContact();
//
//        Contact expResult=new Contact();
//        Contact result=createContact.createNewContact();
//
//        assertEquals(expResult, result);
//
//    }
	/**
	 * A method that tests if the contact isn't null.
	 */
//    @Test
//    public void testValidaContact() {
//
//        EditContact editContact = new  EditContact();
//        Contact contact= null;
//
//        boolean expResult = false;
//        boolean result = editContact.validaContact(contact);
//
//        assertEquals(expResult, result);
//
//    }
	/**
	 * A method that tests if the contact to be removed isn't null.
	 */
//    @Test
//    public void testRemoveContact() {
//
//        RemoveContact removeContact = new RemoveContact();
//        Contact contact = null;
//
//        boolean expResult=false;
//        boolean result=removeContact.removeContact(contact);
//
//        assertEquals(expResult, result);
//
//    }
	/**
	 * A method that tests if the contact to be removed isn't null.
	 */
//    @Test
//    public void testUpdateAddress() {
//
//		Address a1 = new Address();
//		Address a2 = new Address();
//		Contact c = new Contact();
//
//		boolean expResult=false;
//      boolean result = updateAddress(c, a1, a2);
//
//      assertEquals(expResult, result);
//
//    }
    
    
    @Test
    public void testaddNote()
    {
        ContactController ctrl = new ContactController(null, null);
        
        Contact c = new Contact();
        String title = "title";
        String text = "text";
        
        boolean expResult = true;
        boolean result = ctrl.addNote(c, title, text);
        
        assertEquals(expResult,result);
    }
    
    @Test
    public void testremoveNote()
    {
        ContactController ctrl = new ContactController(null, null);
        
        Contact c = new Contact();
        String title = "title";
        String text = "text";
        
        Note n = new Note("title", "text");
        
        c.addNote(n);
        
        
        boolean expResult = true;
        boolean result = ctrl.removeNote(c, n);
    }
}
