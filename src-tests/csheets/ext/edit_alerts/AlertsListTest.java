/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_alerts;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class AlertsListTest {

    public AlertsListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = NumberFormatException.class)
    public void testValidateCalendarIllegalInputYear() {
        Calendar currentDate = Calendar.getInstance();
        String year = "year";
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }

    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarSmallerThanCurrentYear() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR - 1));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = NumberFormatException.class)
    public void testValidateCalendarIllegalInputMonth() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = "month";
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarSmallerThanCurrentMonth() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH - 1));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfLowerBoundsMonth() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = "0";
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfUpperBoundsMonth() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = "13";
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = NumberFormatException.class)
    public void testValidateCalendarIllegalInputDay() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = "day";
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }

    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarSmallerThanCurrentDay() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH - 1));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfLowerBoundsDay() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = "0";
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfUpperBoundsDayNormalMonth() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = "1";
        String day = "32";
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
     /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfUpperBoundsDaySmallerMonth() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = "4";
        String day = "31";
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
     /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfUpperBoundsDayFebruaryNormalYear() {
        Calendar currentDate = Calendar.getInstance();
        String year = "2015";
        String month = "2";
        String day = "30";
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfUpperBoundsDayFebruaryLeapYear() {
        Calendar currentDate = Calendar.getInstance();
        String year = "2016";
        String month = "2";
        String day = "29";
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
     /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = NumberFormatException.class)
    public void testValidateCalendarIllegalInputHour() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = "hours";
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }

    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarSmallerThanCurrentHour() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR - 1));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfLowerBoundsHour() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = "-1";
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
     /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfUpperBoundsHour() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = "61";
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = NumberFormatException.class)
    public void testValidateCalendarIllegalInputMinute() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = "minutes";
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }

    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarSmallerThanCurrentMinute() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfLowerBoundsMinute() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = "-1";
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
     /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfUpperBoundsMinute() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = "61";
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = NumberFormatException.class)
    public void testValidateCalendarIllegalInputSecond() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = "seconds";
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }

    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarSmallerThanCurrentSecond() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = String.valueOf(currentDate.get(Calendar.SECOND - 1));
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
    /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfLowerBoundsSecond() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = "-1";
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
    
     /**
     * Test of validateCalendar method, of class AlertsList.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidateCalendarOutOfUpperBoundsSecond() {
        Calendar currentDate = Calendar.getInstance();
        String year = String.valueOf(currentDate.get(Calendar.YEAR));
        String month = String.valueOf(currentDate.get(Calendar.MONTH));
        String day = String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH));
        String hours = String.valueOf(currentDate.get(Calendar.HOUR));
        String minutes = String.valueOf(currentDate.get(Calendar.MINUTE));
        String seconds = "61";
        AlertsList instance = new AlertsList();
        instance.validateCalendar(year, month, day, hours, minutes, seconds);
    }
}
