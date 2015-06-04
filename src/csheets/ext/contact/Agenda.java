package csheets.ext.contact;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristina
 */
public class Agenda {

	/**
	 * List of all the events
	 */
	//@ManyToOne
	private List<Event> eventList;

	/**
	 * Constructor without parameters
	 */
	public Agenda() {
		eventList = new ArrayList<Event>();
	}

	/**
	 * Adds an event to the agenda
	 *
	 * @param e event
	 * @return true or false
	 */
	public boolean add(Event e) {
		return this.eventList.add(e);
	}

	/**
	 * Removes an event of the agenda
	 *
	 * @param tmp event
	 * @return true or false
	 */
	public boolean rmv(Event tmp) {
		for (Event e : this.eventList) {
			if (Integer.toHexString(System.
				identityHashCode(e)).equals(Integer.toHexString(System.
						identityHashCode(tmp)))) {
				return eventList.remove(e);
			}
		}
		return false;
	}

	/**
	 * Edits an event of the agenda
	 *
	 * @param tmp event
	 * @return true or false
	 */
	public boolean edit(Event tmp) {
		for (Event e : this.eventList) {
			if (Integer.toHexString(System.
				identityHashCode(e)).equals(Integer.toHexString(System.
						identityHashCode(tmp)))) {
				e.setDescription(tmp.getDescription());
				e.setTimestamp(tmp.getTimestamp());
				return true;
			}
		}
		return false;
	}
}
