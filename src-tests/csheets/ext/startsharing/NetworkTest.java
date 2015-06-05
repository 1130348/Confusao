/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paulo Pereira
 */
public class NetworkTest {
    
    public NetworkTest() {
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
     * Test of getPort method, of class Network.
     */
    @Test
    public void testGetPort() {
        System.out.println("getPort");
        int expResult = 0;
        int result = Network.getPort();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPort method, of class Network.
     */
    @Test
    public void testSetPort() {
        System.out.println("setPort");
        int newPort = 9009;
        Network.setPort(newPort);
        assertEquals(9009, Network.getPort());
    }

    /**
     * Test of sendData method, of class Network.
     */
    @Test
    public void testSendData() throws IOException {
        System.out.println("sendData");
        Object object = null;
        boolean expResult = false;
        boolean result = Network.sendData(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receiveData method, of class Network.
     */
    @Test
    public void testReceiveData() {
        System.out.println("receiveData");
        Object expResult = null;
        Object result = Network.receiveData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
