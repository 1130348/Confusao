package csheets.ext.contact;

import java.sql.Timestamp;

/**
 * import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.Temporal; import javax.persistence.TemporalType;
 */
/**
 *
 * @author Cristina
 */
public class Event {

	/**
	 * id of the event (database)
	 */
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Description of the event
	 */
	private String description;

	/**
	 * Timestamp of the event
	 */
	//@Temporal(TemporalType.TIMESTAMP)
	private Timestamp timestamp;

	/**
	 * Constructor without parameters
	 */
	public Event() {
	}

	/**
	 * Constructor with parameters
	 *
	 * @param description
	 * @param time
	 */
	public Event(String description, Timestamp time) {
		this.description = description;
		this.timestamp = time;
	}

	/**
	 * Returns the description of the event
	 *
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Returns the timestamp of the event
	 *
	 * @return timestamp
	 */
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	/**
	 * Changes the value of description
	 *
	 * @param d description
	 */
	public void setDescription(String d) {
		this.description = d;
	}

	/**
	 * Changes the value of timestamp
	 *
	 * @param t timestamp
	 */
	public void setTimestamp(Timestamp t) {
		this.timestamp = t;
	}
}
