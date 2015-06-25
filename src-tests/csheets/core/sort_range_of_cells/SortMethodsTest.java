/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.sort_range_of_cells;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ext.Sort.ui.SortController;
import csheets.ext.Sort.ui.SortMenu;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 */
public class SortMethodsTest {

    ArrayList<Double> cells;
    SortController st;
    Spreadsheet ss;

    public SortMethodsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            CleanSheets cs = new CleanSheets();
            File f = new File("testes.cls");
            cs.load(f);
            Workbook wb = cs.getWorkbook(f);
            ss = wb.getSpreadsheet(0);
            cells = new ArrayList<>();
            cells.add(ss.getCell(0, 0).getValue().toDouble());
            cells.add(ss.getCell(0, 1).getValue().toDouble());
            cells.add(ss.getCell(0, 2).getValue().toDouble());
            cells.add(ss.getCell(0, 3).getValue().toDouble());
            cells.add(ss.getCell(0, 4).getValue().toDouble());
//            cells.add(sp.getCell(1, 0));
//            cells.add(sp.getCell(1, 1));
//            cells.add(sp.getCell(1, 2));
//            cells.add(sp.getCell(1, 3));
//            cells.add(sp.getCell(1, 4));

            UIController controller = new UIController(cs);
            controller.setActiveSpreadsheet(ss);
            SortMenu menu = new SortMenu(controller);
            st = new SortController(controller, menu);
        } catch (IOException ex) {
            Logger.getLogger(SortMethodsTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SortMethodsTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(SortMethodsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void cellContentsTest() {
        st.cellsContent(0);
        assertEquals(cells, st.getCellsI());
    }

    @Test
    public void sortTestAscending() {
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("123,0");
        expectedResult.add("123,0");
        expectedResult.add("123,0");
        expectedResult.add("423,0");
        expectedResult.add("2432,0");

        st.cellsContent(0);
        st.sort(0);

        assertEquals(expectedResult, st.getCellsAll());
    }

    @Test
    public void sortTestDescending() {
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("2432,0");
        expectedResult.add("423,0");
        expectedResult.add("123,0");
        expectedResult.add("123,0");
        expectedResult.add("123,0");

        st.cellsContent(0);
        st.sort(1);

        assertEquals(expectedResult, st.getCellsAll());
    }

    @Test
    public void fillSortedTestAscending() {
        try {
            st.cellsContent(0);
            st.sort(0);
            st.fillSorted(0);

            ArrayList<Double> expectedResult = new ArrayList<>();
            expectedResult.add(123.0);
            expectedResult.add(123.0);
            expectedResult.add(123.0);
            expectedResult.add(423.0);
            expectedResult.add(2432.0);

            ArrayList<Double> result = new ArrayList<>();
            result.add(ss.getCell(0, 0).getValue().toDouble());
            result.add(ss.getCell(0, 1).getValue().toDouble());
            result.add(ss.getCell(0, 2).getValue().toDouble());
            result.add(ss.getCell(0, 3).getValue().toDouble());
            result.add(ss.getCell(0, 4).getValue().toDouble());
            
            assertEquals(expectedResult, result);

        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(SortMethodsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void fillSortedTestDescending() {
        try {
            st.cellsContent(0);
            st.sort(1);
            st.fillSorted(0);

            ArrayList<Double> expectedResult = new ArrayList<>();
            expectedResult.add(2432.0);
            expectedResult.add(423.0);
            expectedResult.add(123.0);
            expectedResult.add(123.0);
            expectedResult.add(123.0);

            ArrayList<Double> result = new ArrayList<>();
            result.add(ss.getCell(0, 0).getValue().toDouble());
            result.add(ss.getCell(0, 1).getValue().toDouble());
            result.add(ss.getCell(0, 2).getValue().toDouble());
            result.add(ss.getCell(0, 3).getValue().toDouble());
            result.add(ss.getCell(0, 4).getValue().toDouble());
            
            assertEquals(expectedResult, result);

        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(SortMethodsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
