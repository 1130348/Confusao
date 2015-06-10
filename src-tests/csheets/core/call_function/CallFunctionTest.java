/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.call_function;

import csheets.core.call_function.ui.CallFunctionUI;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Andre
 */
public class CallFunctionTest {
    
    public CallFunctionTest() {
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
     * Test of fillList method, of class CallFunctionController.
     */
    @Test
    public void testFillList() {
        System.out.println("fillList");
        boolean expResult= false;
        CallFunctionUI ui = new CallFunctionUI();
        CallFunctionController ctrl = new CallFunctionController(ui);
        boolean result = ctrl.fillList().isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of chooseFunction method, of class CallFunctionController.
     */
    @Test
    public void testchooseFunction() {
        System.out.println("chooseFunction");
        String expResult= "=SUM()";
        String identifier = "SUM";
        CallFunctionUI ui = new CallFunctionUI();
        CallFunctionController ctrl = new CallFunctionController(ui);
        String result = ctrl.chooseFunction(identifier);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of callFunction method, of class CallFunctionController.
     */
    @Test
    public void testcallFunction() {
        System.out.println("callFunction");
        String func_def= "=SUM(2;3)";
        String expResult = "SUM";
        CallFunctionUI ui = new CallFunctionUI();
        CallFunctionController ctrl = new CallFunctionController(ui);
        ctrl.callFunction(func_def);
        //assertEquals(expResult, result);
        fail();
    }
    
}

