/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_variables;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Spreadsheet;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Antonio Pinheiro
 */
public class EditVariablesControllerTest {
    
    
//    @Test
//    /**
//     * Test of the method getAddressVariable of EditVariablesController
//     */
//    public void testgetAddressVariable() throws FormulaCompilationException {
//
//        
//        
//        CleanSheets c = new CleanSheets();
//        
//        UIController uic = new UIController(c);
//        
//        Workbook w = new Workbook(1);
//        
//        Spreadsheet s  = w.getSpreadsheet(0);
//        
//        s.getCell(23, 11).setContent("=@var:=23");
//        uic.setActiveSpreadsheet(s);
//        
//        EditVariablesController evc = new EditVariablesController(uic, null);
//        
//        List<Address> l = evc.getAddressVariable("@var");
//        
//        
//
//        assertEquals(s.getCell(23,11).getAddress(),l.get(0));
//
//    }
    
}
