/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_alerts;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class EditAlertsController {

    AlertsList alertsList;

    public EditAlertsController() {
        alertsList = new AlertsList();
    }

    public void addAlert(String name, String description, String year, String month, String day, String hours, String minutes, String seconds) throws IllegalArgumentException {
        alertsList.addAlert(name, description, year, month, day, hours, minutes, seconds);
    }

    public void removeAlert(int index) {
        alertsList.removeAlert(index);
        
    }

    public void editAlertName(int index, String name) {
        alertsList.editAlertName(index, name);
    }

    public void editAlertDescription(int index, String description) {
        alertsList.editAlertDescription(index, description);
    }

    public void editAlertTimestamp(int index, Calendar timestamp) {
        alertsList.editAlertTimestamp(index, timestamp);
    }

    public ArrayList<Alert> retrieveAlertsList() {
        return alertsList.getAlertsList();
    }

}
