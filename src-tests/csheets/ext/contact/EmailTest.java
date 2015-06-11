/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contact;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rddm
 */
public class EmailTest {
    
    public EmailTest() {
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
     * Test of toString method, of class Email.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Email instance = new Email("");
        //expResult is null, because the constructor will validate the string sended.
        String expResult = null;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class Email.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        String text = "1130616@isep.ipp.pt";
        boolean expResult = true;
        boolean result = Email.validate(text);
        assertEquals(expResult, result);
    }
    
}
