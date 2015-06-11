package csheets.ext.contact;

import csheets.ext.address.Address;
import java.awt.image.BufferedImage;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	 * Constructor without parameters
	 */
	public Contact() {
		agenda = new Agenda();
		first_name = "";
		last_name = "";
		machine_name = "";
		main_address = new Address();
		secundary_address = new Address();
	}

	/**
	 * Constructor with parameters
	 *
	 * @param firstN
	 * @param lastN
	 * @param machineN
	 * @param img
	 */
	public Contact(String firstN, String lastN, String machineN,
				   BufferedImage img, Address mainA, Address secundaryA) {
		this.first_name = firstN;
		this.last_name = lastN;
		this.machine_name = machineN;
		this.image = img;
		this.agenda = new Agenda();
		this.main_address = mainA;
		this.secundary_address = secundaryA;
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
	 * Returns the agenda of the contact
	 *
	 * @return agenda
	 */
	public Agenda getAgenda() {
		return this.agenda;
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

}
