/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contact;

import csheets.ext.contact.ui.ContactController;
import csheets.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Egidio73
 */
public class Notification implements Runnable {

    private ContactController controller;

    public Notification(ContactController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {

        while (true) {

            if (!controller.getNotification()) {
                break;
            }
            List<Contact> lContact = Persistence.getRepositoryFactory().getContactRepository().all();
            List<Event> lEvent = new ArrayList<Event>();

            for (Contact c : lContact) {
                lEvent.addAll(c.getAgenda().toList());
            }

            for (Event e : lEvent) {
                if (!e.getNotified()) {
                    Date eventDate = e.getTimestamp();

                    Date systemDate = new Date();

                    if (eventDate.getYear() == systemDate.getYear() && eventDate.getMonth() == systemDate.getMonth() && eventDate.getDay() == systemDate.getDay()) {
                        JOptionPane.showMessageDialog(null, "Event: " + e.getDescription(), "Event Alert", JOptionPane.INFORMATION_MESSAGE);
                        e.setNotified(true);
                        for (Contact c : lContact) {
                            List<Event> replaceEvent = c.getAgenda().toList();
                            for (Event e1 : replaceEvent) {
                                if (e.equals(e1)) {
                                    c.rmvEvent(e1);
                                    c.addEvent(e);
                                    Persistence.getRepositoryFactory().getContactRepository().edit(c);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

}
