/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        NetworkService.setPort(8888);
        int expResult = 8888;
        int result = NetworkService.getPort();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPort method, of class Network.
     */
    @Test
    public void testSetPort() {
        System.out.println("setPort");
        int newPort = 9009;
        NetworkService.setPort(newPort);
        assertEquals(9009, NetworkService.getPort());
    }

    /**
     * Test of sendData method, of class Network.
     */
    @Test
    public void testSendData() throws IOException {
//        System.out.println("sendData");
//        Object object = null;
//        boolean expResult = false;
//        boolean result = NetworkService.sendSelectedCellRange(object);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of receiveData method, of class Network.
     */
    @Test
    public void testReceiveData() {
//        System.out.println("receiveData");
//        Object expResult = null;
//        Object result = NetworkService.receiveData();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
