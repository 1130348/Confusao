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
public class PhoneNumberTest {
    
    public PhoneNumberTest() {
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
     * Test of toString method, of class PhoneNumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PhoneNumber instance = new PhoneNumber("");
         //expResult is null, because the constructor will validate the string sended.
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class PhoneNumber.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        String text = "+351912560859";
        boolean expResult = true;
        boolean result = PhoneNumber.validate(text);
        assertEquals(expResult, result);
    }
    
}
