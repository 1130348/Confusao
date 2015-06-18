/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.userstories.macros04_01.conditionalformating;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jose
 */
public class Formatingtest {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test create new variable
	 */
	@Test
	public void testcolor() throws IOException, ClassNotFoundException {

//		Workbook workbook = new Workbook(1);
//		Spreadsheet sheet = workbook.getSpreadsheet(0);
//		ConditionalFormatAction cfa = null;
		CleanSheets cs = new CleanSheets();
		UIController contr = new UIController(cs);
		File file = new File("src-tests\\csheets\\\\userstories\\\\macros04_01\\teste1.cls");
		cs.load(file);
		Spreadsheet ss = cs.getWorkbooks()[0].getSpreadsheet(0);
		SpreadsheetTable focusOwner = new SpreadsheetTable(ss, contr);
		Cell cell = ss.getCell(0, 0);
		System.out.println(cell.getContent());
		StylableCell stylableCell = (StylableCell) cell.
			getExtension(
				StyleExtension.NAME);
		Color expResult = Color.BLACK;
		Color result = stylableCell.getBackgroundColor();
		assertEquals(expResult, result);
	}
}
