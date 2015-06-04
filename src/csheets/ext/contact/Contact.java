package csheets.ext.contact;

import java.awt.image.BufferedImage;

/**
 * import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.OneToOne;
 */
/**
 *
 * @author Cristina
 */
public class Contact {

	/**
	 * Id of contact (database)
	 */
	/**
	 * @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
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
	private BufferedImage image;

	/**
	 * Agenda of contact
	 */
	//@OneToOne
	private Agenda agenda;

	/**
	 * Constructor without parameters
	 */
	public Contact() {
		agenda = new Agenda();
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
				   BufferedImage img) {
		this.first_name = firstN;
		this.last_name = lastN;
		this.machine_name = machineN;
		this.image = img;
		agenda = new Agenda();
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

}
