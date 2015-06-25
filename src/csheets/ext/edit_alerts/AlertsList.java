/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_alerts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class AlertsList {

    ArrayList<Alert> alertsList;

    public AlertsList() {
        alertsList = new ArrayList<>();
    }

    public void addAlert(String name, String description, String year, String month, String day, String hours, String minutes, String seconds) {
        try {
            validateCalendar(year, month, day, hours, minutes, seconds);
        } catch (NumberFormatException number) {
            throw number;
        } catch (IllegalArgumentException illegal) {
            throw illegal;
        }
        Calendar timestamp = new GregorianCalendar(
                Integer.parseInt(year),
                Integer.parseInt(month) - 1,
                Integer.parseInt(day),
                Integer.parseInt(hours),
                Integer.parseInt(minutes),
                Integer.parseInt(seconds)
        );
        Alert alert = new Alert(name, description, timestamp);
        alertsList.add(alert);
        alert.start();
    }

    public void removeAlert(int index) {
        alertsList.remove(index);
    }

    public void editAlertName(int index, String name) {
        alertsList.get(index).changeName(name);
    }

    public void editAlertDescription(int index, String description) {
        alertsList.get(index).changeDescription(description);
    }

    public void editAlertTimestamp(int index, Calendar timestamp) {
        alertsList.get(index).changeTimeStamp(timestamp);
    }

    public ArrayList<Alert> getAlertsList() {
        return alertsList;
    }

    public void validateCalendar(String year, String month, String day, String hours, String minutes, String seconds) {
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH);
        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
        int currentHours = currentDate.get(Calendar.HOUR);
        int currentMinutes = currentDate.get(Calendar.MINUTE);
        int currentSeconds = currentDate.get(Calendar.SECOND);
        int auxYear;
        int auxMonth;
        int auxDay;
        int auxHours;
        int auxMinutes;
        int auxSeconds;
        try {
            auxYear = Integer.parseInt(year);
            auxMonth = Integer.parseInt(month) - 1;
            auxDay = Integer.parseInt(day);
            auxHours = Integer.parseInt(hours);
            auxMinutes = Integer.parseInt(minutes);
            auxSeconds = Integer.parseInt(seconds);
        } catch (NumberFormatException e) {
            throw e;
        }
        if (auxYear < currentYear) {
            throw new IllegalArgumentException();
        } else if (auxYear == currentYear && auxMonth < currentMonth) {
            throw new IllegalArgumentException();
        } else if (auxYear == currentYear && auxMonth == currentMonth && auxDay < currentDay) {
            throw new IllegalArgumentException();
        } else if (auxYear == currentYear && auxMonth == currentMonth && auxDay == currentDay && auxHours < currentHours) {
            throw new IllegalArgumentException();
        } else if (auxYear == currentYear && auxMonth == currentMonth && auxDay == currentDay && auxHours == currentHours && auxMinutes < currentMinutes) {
            throw new IllegalArgumentException();
        } else if (auxYear == currentYear && auxMonth == currentMonth && auxDay == currentDay && auxHours == currentHours && auxMinutes == currentMinutes && auxSeconds < currentSeconds) {
            throw new IllegalArgumentException();
        }
        
        if (auxMonth < 1 || auxMonth > 12) {
            throw new IllegalArgumentException();
        }
        if (auxMonth == 1
                || auxMonth == 3
                || auxMonth == 5
                || auxMonth == 7
                || auxMonth == 8
                || auxMonth == 10
                || auxMonth == 12) {
            if (auxDay < 0 || auxDay > 31) {
                throw new IllegalArgumentException();
            }
        }
        if (auxMonth == 4
                || auxMonth == 6
                || auxMonth == 9
                || auxMonth == 11) {
            if (auxDay < 0 || auxDay > 30) {
                throw new IllegalArgumentException();
            }
        }
        if (auxMonth == 2) {
            if (auxYear % 4 == 0
                    && auxYear % 100 == 0
                    && auxYear % 400 == 0) {
                if (auxDay < 0 || auxDay > 29) {
                    throw new IllegalArgumentException();
                }
            } else if (auxDay < 0 || auxDay > 28) {
                throw new IllegalArgumentException();
            }
        }
        if (auxHours < 0 || auxHours > 60
                || auxMinutes < 0 || auxMinutes > 60
                || auxSeconds < 0 || auxSeconds > 60) {
            throw new IllegalArgumentException();
        }
    }
}
