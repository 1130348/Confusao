/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.call_function;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.IllegalValueTypeException;
import csheets.core.SpreadsheetImpl;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.call_function.ui.CallFunctionUI;
import csheets.core.call_function.ui.FormulasPanel;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.UnknownElementException;
import csheets.ui.ctrl.UIController;
import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
        CallFunctionController ctrl = new CallFunctionController();
        boolean result = ctrl.fillList().isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of chooseFunction method, of class CallFunctionController.
     * @throws csheets.core.formula.lang.UnknownElementException
     */
    @Test
    public void testchooseFunction() throws UnknownElementException {
        System.out.println("chooseFunction");
        String expResult= "SUM(Term;...)";
        String identifier = "SUM";
        CallFunctionUI ui = new CallFunctionUI();
        CallFunctionController ctrl = new CallFunctionController();
        String result = ctrl.chooseFunction(identifier);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of callFunction method, of class CallFunctionController.
     */
    @Test
    public void testcallFunction() {
        System.out.println("callFunction");
        String func_def= "MAX(3;2)";
        String expResult = new Value(3).toString();
        CallFunctionController ctrl = new CallFunctionController();
        String result = ctrl.callFunction(func_def).toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddResultToCell() throws FormulaCompilationException {
        System.out.println("addresultcell");
        String func_def = "=ABS(-3)";
        CallFunctionController ctrl = new CallFunctionController();
        Workbook wb = new Workbook();
        wb.addSpreadsheet();
        String expResult = "3";
        ctrl.addResultToCell(wb.getSpreadsheet(0).getCell(0, 0), func_def);
        String result = wb.getSpreadsheet(0).getCell(0, 0).getValue().toString();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCallBinaryOperation() throws IllegalValueTypeException, ParseException{
        System.out.println("callbinaryoperation");
        String func_def = "=3+2";
        CallFunctionController ctrl = new CallFunctionController();
        String result = ctrl.callBinaryOperation("+", "3", "2").toString();
        String expResult = "5";
        assertEquals(expResult, result);
    }
    
}

