package csheets.crm;

import csheets.ext.address.Address;
import csheets.ext.contact.Agenda;
import csheets.ext.contact.Contact;
import csheets.ext.contact.Event;
import csheets.ext.contact.PhoneNumber;
import csheets.persistenceTest.PersistenceTest;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A Unit Test class to test DataBase.
 *
 * @see Contact
 * @author Egidio Santos
 */
public class DataBaseTest {

    public DataBaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {

        addData();

    }

    /**
     * A method that tests if data is added to BD.
     */
    public static void addData() {

        Contact c = new Contact("TestF", "TestL", "TestMachine", new BufferedImage(1, 2, 3),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"), new Address(),new Address());
        Contact c1 = new Contact("Antonio", "Pinheiro", "Antonio96", new BufferedImage(1, 2, 3),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"), new Address(),new Address());
        Contact c2 = new Contact("Cristina", "Lopes", "Cris", new BufferedImage(1, 2, 3),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"), new Address(),new Address());
        Contact c3 = new Contact("Andre", "Sousa", "Andrezinho", new BufferedImage(1, 2, 3),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"), new Address(),new Address());
        Contact c4 = new Contact("Egidio", "Santos", "EgidioS", new BufferedImage(1, 2, 3),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"), new Address(),new Address());

        PersistenceTest.getRepositoryFactory().getContactRepository().add(c);
        PersistenceTest.getRepositoryFactory().getContactRepository().add(c1);
        PersistenceTest.getRepositoryFactory().getContactRepository().add(c2);
        PersistenceTest.getRepositoryFactory().getContactRepository().add(c3);
        PersistenceTest.getRepositoryFactory().getContactRepository().add(c4);

    }

    /**
     * A method that tests if data is added to BD.
     */
    @Test
    public void addContactTest() {

        Contact c = new Contact("TestAddF", "TestAddL", "TestAddMachine", new BufferedImage(1, 2, 3),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"),new PhoneNumber("99999999"), new Address(),new Address());
        PersistenceTest.getRepositoryFactory().getContactRepository().add(c);

        List<Contact> lresult = PersistenceTest.getRepositoryFactory().getContactRepository().all();

        Contact expected = c;
        Contact result = lresult.get(lresult.size() - 1);

        assertEquals(expected.getMachine_Name(), result.getMachine_Name());

    }

    /**
     * A method that tests if data is updated to BD.
     */
    @Test
    public void updateContactTest() {

        List<Contact> lContact = PersistenceTest.getRepositoryFactory().getContactRepository().all();
        Contact expectedContact = lContact.get(0);

        expectedContact.setFirst_Name("EditSuccessF");
        expectedContact.setLast_Name("EditSuccessL");
        expectedContact.setMachine_Name("TestEditSuccess");
        PersistenceTest.getRepositoryFactory().getContactRepository().edit(expectedContact);

        List<Contact> lresult = PersistenceTest.getRepositoryFactory().getContactRepository().all();

        String expected = "TestEditSuccess";
        Contact result = lresult.get(0);

        assertEquals(expected, result.getMachine_Name());

    }

    /**
     * A method that tests if data is removed to BD.
     */
    @Test
    public void removeContactTest() {

        List<Contact> lContact = PersistenceTest.getRepositoryFactory().getContactRepository().all();
        Contact expectedContact = lContact.get(0);

        PersistenceTest.getRepositoryFactory().getContactRepository().remove(expectedContact);

        List<Contact> lresult = PersistenceTest.getRepositoryFactory().getContactRepository().all();
        System.out.println(lresult.toString());
        String expected = "Antonio96";
        Contact result = lresult.get(0);

        assertEquals(expected, result.getMachine_Name());

    }

    /**
     * A method that tests if data is removed to BD.
     */
    @Test
    public void addEventTest() {

        List<Contact> lContact = PersistenceTest.getRepositoryFactory().getContactRepository().all();
        Contact expectedContact = lContact.get(0);
        expectedContact.addEvent(new Event("Test2", new Date(2015, 6, 11)));

        PersistenceTest.getRepositoryFactory().getContactRepository().edit(expectedContact);

        List<Contact> lresult = PersistenceTest.getRepositoryFactory().getContactRepository().all();
        String expected = "Test2";
        String result = lresult.get(0).getAgenda().toList().get(0).getDescription();

        assertEquals(expected, result);

    }

    /**
     * A method that tests if data is removed to BD.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeEventTest() {

        List<Contact> lContact = PersistenceTest.getRepositoryFactory().getContactRepository().all();
        Contact expectedContact = lContact.get(0);
        Event e = expectedContact.getAgenda().toList().get(0);
        expectedContact.rmvEvent(e);

        PersistenceTest.getRepositoryFactory().getContactRepository().edit(expectedContact);

        List<Contact> lresult = PersistenceTest.getRepositoryFactory().getContactRepository().all();
        String expected = "Test2";
        Event result = lresult.get(0).getAgenda().toList().get(0);

    }

}
