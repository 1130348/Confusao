package csheets.ext.contact.ui;

import csheets.ext.contact.Contact;
import csheets.ext.contact.Email;
import csheets.ext.contact.Note;
import csheets.ext.contact.Notification;
import csheets.ext.contact.PhoneNumber;
import csheets.persistence.Persistence;
import csheets.ui.ctrl.UIController;
import java.util.List;

/**
 * A controller for updating the user-specified comment of a cell.
 *
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class ContactController {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * User interface panel *
     */
    private ContactPanel uiPanel;
    
    
    private boolean flagNotification;

    /**
     * Creates a new comment controller.
     *
     * @param uiController the user interface controller
     * @param uiPanel the user interface panel
     */
    public ContactController(UIController uiController, ContactPanel uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;
        this.flagNotification=true;
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
     * Adds a contact to the database
     *
     * @param c contact
     * @return true or false
     */
    public boolean addContact(Contact c) {
        return Persistence.getRepositoryFactory().getContactRepository().add(c);
    }

    /**
     * Removes a contact
     *
     * @param c contact
     * @return true or falase
     */
    public boolean removeContact(Contact c) {
        return Persistence.getRepositoryFactory().getContactRepository().
                remove(c);
    }

    /**
     * To update the list of contacts that is showed to the user
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

    public boolean addNote(Contact c, String title, String text) {
        return c.addNote(new Note(title, text));
    }

    public boolean removeNote(Contact c, Note n) {
        return c.removeNote(n);
    }

    public boolean addMobileNumber(Contact c, String newNumber) {
        PhoneNumber number = c.newPhoneNumber(newNumber);
        if (numberValid(newNumber, number)) {
            c.addMobileNumber(number);
            return true;
        }
        return false;
    }

    public boolean addWorkMobileNumber(Contact c, String newNumber) {
        PhoneNumber number = c.newPhoneNumber(newNumber);
        if (numberValid(newNumber, number)) {
            c.addWorkMobileNumber(number);
            return true;
        }
        return false;
    }

    public boolean addHomeNumber(Contact c, String newNumber) {
        PhoneNumber number = c.newPhoneNumber(newNumber);
        if (numberValid(newNumber, number)) {
            c.addHomeNumber(number);
            return true;
        }
        return false;
    }

    public boolean addWorkNumber(Contact c, String newNumber) {
        PhoneNumber number = c.newPhoneNumber(newNumber);
        if (numberValid(newNumber, number)) {
            c.addWorkNumber(number);
            return true;
        }
        return false;
    }

    private boolean numberValid(String text, PhoneNumber number) {
        return text.equals(number.toString());
    }
    
    public void setPrimaryEmail(Contact c, Email e){
        c.setPrimaryEmail(e);
    }
    
    public void removeEmail(Contact c, Email e){
        c.removeEmail(e);
    }
    
    public boolean newEmail(Contact c,String text){
        Email temp=c.newEmail(text);
        if(temp.toString().equals(text)){
            c.addEmail(temp);
            return true;
        }
        return false;
    }
    
    public boolean editEmail(Contact c,Email e,String text){
        return c.editEmail(e, text);
    }

    public boolean getNotification() {
        return this.flagNotification;
    }
    
    public void setNotification(boolean flag) {
        this.flagNotification=flag;
    }
    
    public void startNotification(){
        Thread notify = new Thread(new Notification(this));
                notify.start();
    }

}
