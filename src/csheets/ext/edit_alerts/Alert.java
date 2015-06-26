/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_alerts;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class Alert extends Thread {

    private String name;

    private String description;

    private Calendar timestamp;

    public Alert(String name, String description, Calendar timeStamp) {
        this.name = name;
        this.description = description;
        this.timestamp = timeStamp;
    }

    public String retrieveName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String retrieveDescription() {
        return description;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public Calendar retrieveTimeStamp() {
        return timestamp;
    }

    public void changeTimeStamp(Calendar timeStamp) {
        this.timestamp = timeStamp;
    }

    @Override
    public void run() {
        Date currentDate;
        Date alertDate = timestamp.getTime();
        String[] buttons = {"OK", "5 minutes"};
        int op;
        while (true) {
            currentDate = Calendar.getInstance().getTime();
            if (alertDate.compareTo(currentDate) == 0 || alertDate.compareTo(currentDate) < 0) {
                op = JOptionPane.showOptionDialog(
                        null,
                        this.description,
                        this.name,
                        0,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        buttons,
                        buttons[0]
                );
                if (op == 1) {
                    timestamp.add(Calendar.MINUTE, 5);
                    alertDate = timestamp.getTime();
                } else {
                    break;
                }
            }
        }
    }
}
