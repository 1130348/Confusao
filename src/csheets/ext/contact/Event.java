package csheets.ext.contact;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cristina
 */
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/**
	 * Description of the event
	 */
	private String description;

	/**
	 * Timestamp of the event
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

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
	public Event(String description, Date time) {
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
	public Date getTimestamp() {
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
	public void setTimestamp(Date t) {
		this.timestamp = t;
	}
        
        @Override
        public String toString(){
            return getDescription()+" Time : "+getTimestamp();
        }
}
