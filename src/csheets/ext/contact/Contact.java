package csheets.ext.contact;

import csheets.ext.address.Address;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.OneToOne;
 */
/**
 *
 * @author Cristina
 */
@Entity
public class Contact {

    /**
     * Id of contact (database)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * The first name of the contact
     */
    private String first_name;

    /**
     * The last name of the contact
     */
    private String last_name;

    /**
     * The machine name in order to notify the user about the next events
     */
    private String machine_name;

    /**
     * The image of the contact
     */
    @Transient
    private BufferedImage image;

    /**
     * Agenda of contact
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AGENDA_ID")
    private Agenda agenda;

    /**
     * The main address of contact
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Address main_address;

    /**
     * The secundary address of contact
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Address secundary_address;
    /**
     * Emails List of the contact
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<Email> listEmail;

    /**
     * Mobile Number of the contact
     */
    @OneToOne(cascade = CascadeType.ALL)
    private PhoneNumber mobileNumber;

    /**
     * Work Number of the contact
     */
    @OneToOne(cascade = CascadeType.ALL)
    private PhoneNumber workNumber;

    /**
     * Home Number of the contact
     */
    @OneToOne(cascade = CascadeType.ALL)
    private PhoneNumber homeNumber;

    /**
     * Work Mobile Number of the contact
     */
    @OneToOne(cascade = CascadeType.ALL)
    private PhoneNumber workMobileNumber;

    /**
     * Notes where all the versions of notes of this contact are stored
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    
    /**
     * Constructor without parameters
     */
    public Contact() {
        agenda = new Agenda();
        first_name = "";
        last_name = "";
        machine_name = "";
        listEmail = new ArrayList<Email>();
        mobileNumber = new PhoneNumber("");
        workMobileNumber = new PhoneNumber("");
        workNumber = new PhoneNumber("");
        homeNumber = new PhoneNumber("");
        main_address = new Address();
        secundary_address = new Address();
        this.notes= new Notes();
    }

    /**
     * Constructor with parameters
     *
     * @param first_name
     * @param last_name
     * @param machine_name
     * @param image
     * @param mobileNumber
     * @param workMobileNumber
     * @param workNumber
     * @param homeNumber
     * @param secundary_address
     * @param main_address
     */
    public Contact(String first_name, String last_name, String machine_name, BufferedImage image, PhoneNumber mobileNumber, PhoneNumber workMobileNumber, PhoneNumber workNumber, PhoneNumber homeNumber, Address secundary_address, Address main_address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.machine_name = machine_name;
        this.image = image;
        this.mobileNumber = mobileNumber;
        this.workMobileNumber = workMobileNumber;
        this.workNumber = workNumber;
        this.homeNumber = homeNumber;
        this.main_address = main_address;
        this.secundary_address = secundary_address;
        this.agenda = new Agenda();
        this.listEmail = new ArrayList<Email>();
        this.notes=new Notes();
    }

    /**
     * Returns the last name of the contact
     *
     * @return last_name
     */
    public String getLast_Name() {
        return this.last_name;
    }

    /**
     * Returns the machine name
     *
     * @return machine_name
     */
    public String getMachine_Name() {
        return this.machine_name;
    }

    /**
     * Returns the image of the contact
     *
     * @return image
     */
    public BufferedImage getImage() {
        return this.image;
    }

    /**
     * Returns the first name of the contact
     *
     * @return first_name
     */
    public String getFirst_Name() {
        return this.first_name;
    }

    /**
     * Returns the main address of the contact
     *
     * @return main_address
     */
    public Address getMainAddress() {
        return this.main_address;
    }

    /**
     * Returns the secundary address of the contact
     *
     * @return secundary_address
     */
    public Address getSecundaryAddress() {
        return this.secundary_address;
    }

    /**
     * Changes the value of the first name
     *
     * @param firstN
     */
    public void setFirst_Name(String firstN) {
        this.first_name = firstN;
    }

    /**
     * Changes the value of the last name
     *
     * @param lastN
     */
    public void setLast_Name(String lastN) {
        this.last_name = lastN;
    }

    /**
     * Changes the value of the machine name
     *
     * @param machineN
     */
    public void setMachine_Name(String machineN) {
        this.machine_name = machineN;
    }

    /**
     * Changes the value of the image
     *
     * @param image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Adds a new event to the agenda
     *
     * @param e event
     */
    public void addEvent(Event e) {
        agenda.add(e);
    }

    /**
     * Removes a event to the agenda
     *
     * @param e event
     */
    public void rmvEvent(Event e) {
        agenda.rmv(e);
    }

    /**
     * Edits a event of the agenda
     *
     * @param e event
     */
    public void editEvent(Event e) {
        agenda.edit(e);
    }

    @Override
    public String toString() {
        return getFirst_Name() + " " + getLast_Name();
    }

    /**
     * @param mobileNumber the mobileNumber to add
     */
    public void addMobileNumber(PhoneNumber mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @param workMobileNumber the workMobileNumber to add
     */
    public void addWorkMobileNumber(PhoneNumber workMobileNumber) {
        this.workMobileNumber = workMobileNumber;
    }

    /**
     * @param workNumber the workNumber to add
     */
    public void addWorkNumber(PhoneNumber workNumber) {
        this.workNumber = workNumber;
    }

    /**
     * @param homeNumber the homeNumber to add
     */
    public void addHomeNumber(PhoneNumber homeNumber) {
        this.homeNumber = homeNumber;
    }

    PhoneNumber newPhoneNumber(String newNumber) {
        return new PhoneNumber(newNumber);
    }

    public Email newEmail(String text) {
        return new Email(text);
    }

    public void addEmail(Email email) {
        listEmail.add(email);
    }

    public void removeEmail(Email email) {
        listEmail.remove(email);
    }

    public void setPrimaryEmail(Email email) {
        Email tempEmail = listEmail.get(0);
        removeEmail(email);
        listEmail.set(0, email);
        addEmail(tempEmail);
    }

    /**
     * Returns the agenda of the contact
     *
     * @return agenda
     */
    public Agenda getAgenda() {
        return this.agenda;
    }

    /**
     * Changes the value of the main address
     *
     */
    public void setMainAddress(String tmp_street, String tmp_locality,
            String tmp_postal_code, String tmp_city,
            String tmp_country) {
        this.main_address.setStreet(tmp_street);
        this.main_address.setLocality(tmp_locality);
        this.main_address.setPostalCode(tmp_postal_code);
        this.main_address.setCity(tmp_city);
        this.main_address.setCountry(tmp_country);
    }

    /**
     * Changes the value of the secundary address
     *
     * @param tmp_street
     * @param tmp_locality
     * @param tmp_postal_code
     * @param tmp_city
     * @param tmp_country
     */
    public void setSecundaryAddress(String tmp_street, String tmp_locality,
            String tmp_postal_code, String tmp_city,
            String tmp_country) {
        this.secundary_address.setStreet(tmp_street);
        this.secundary_address.setLocality(tmp_locality);
        this.secundary_address.setPostalCode(tmp_postal_code);
        this.secundary_address.setCity(tmp_city);
        this.secundary_address.setCountry(tmp_country);
    }
    
    /**
     * @return the notes
     */
    public Notes getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public boolean addNote(Note note) {
        return this.notes.addNote(note);
    }

    public boolean removeNote(Note n) {
        return this.notes.removeNote(n);
    }
}
