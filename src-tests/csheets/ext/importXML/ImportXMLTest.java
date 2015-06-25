/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importXML;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.export.strategy.ExportProcess;
import csheets.ui.ctrl.UIController;
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
 * @author Sergio Gomes
 */
public class ImportXMLTest {

	public ImportXMLTest() {
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
	 * Test to verify if the value of a cell when exported is the same when
	 * imported on another spreadsheet cell(same cell that was exported).
	 *
	 * @throws csheets.core.formula.compiler.FormulaCompilationException
	 */
	@Test
	public void verifyCellValueWhenImported() throws FormulaCompilationException {
		System.out.println("verifyCellValueWhenImported");
		String result = "teste";
		String expResult = null;
		File file = null;
		String fileName = "teste";
		Workbook book = new Workbook(3);
		ExportProcess eProcess = new ExportProcess(".xml");
		String[] strings = new String[2];
		strings[0] = "WorkBook";
		strings[1] = "Cell";
		book.getSpreadsheet(0).getCell(0, 0).setContent(result);
		book.getSpreadsheet(0).getCell(0, 1).setContent(result);
		Cell[][] cells = new Cell[1][2];
		cells[0][0] = book.getSpreadsheet(0).getCell(0, 0);
		cells[0][1] = book.getSpreadsheet(0).getCell(0, 1);
		file = eProcess.export(true, cells, fileName, strings);
		ImportProcess iProcess = new ImportProcess(".xml");
		iProcess.setActiveWorkbook(book);
		iProcess.setFilename(file.getAbsolutePath());
		iProcess.setSpreadSheet(book.getSpreadsheet(2));
		iProcess.setCellTag(strings[1]);
		iProcess.importXML();
		expResult = book.getSpreadsheet(2).getCell(0, 0).getContent();
		assertEquals(result, expResult);
	}

	/**
	 * Test to check if the XML tag for the cells is passed correctly to import
	 * XML method when changed in export XML
	 *
	 * @throws FormulaCompilationException
	 */
	@Test
	public void verifyCellTagWhenExported() throws FormulaCompilationException {
		System.out.println("verifyCellTagWhenExported");
		String expResult = null;
		String fileName = "teste2";
		File file = null;
		CleanSheets app = new CleanSheets();
		UIController uiController = new UIController(app);
		ExportProcess eProcess = new ExportProcess(".xml");
		Workbook book = new Workbook(3);
		String[] result = new String[2];
		result[0] = "WorkBook";
		result[1] = "TagTest";
		XMLTag.getInstance().setCellTag(result[1]);
		book.getSpreadsheet(0).getCell(0, 0).setContent("ola");
		book.getSpreadsheet(0).getCell(0, 1).setContent("ola");
		Cell[][] cells = new Cell[1][2];
		cells[0][0] = book.getSpreadsheet(0).getCell(0, 0);
		cells[0][1] = book.getSpreadsheet(0).getCell(0, 1);
		file = eProcess.export(true, cells, fileName, result);
		ImportController controller = new ImportController(uiController);
		controller.importXML(file.getAbsolutePath(), ".xml", book.
							 getSpreadsheet(2), book);
		expResult = XMLTag.getInstance().getCellTag();
		assertEquals(result[1], expResult);
	}

	/**
	 * Test to verify spreadsheet that user will import the data is valid
	 *
	 * @throws FormulaCompilationException
	 */
	@Test
	public void testSpreadSheetToImport() throws FormulaCompilationException {
		System.out.println("testSpreadSheetToImport");
		int index = 2;
		Spreadsheet result = null;
		Spreadsheet expResult = null;
		String fileName = "teste4";
		File file = null;
		Workbook book = new Workbook(3);
		ExportProcess eProcess = new ExportProcess(".xml");
		String[] strings = new String[2];
		strings[0] = "WorkBook";
		strings[1] = "Cell";
		book.getSpreadsheet(0).getCell(0, 0).setContent("45");
		book.getSpreadsheet(0).getCell(0, 1).setContent("45");
		Cell[][] cells = new Cell[1][2];
		cells[0][0] = book.getSpreadsheet(0).getCell(0, 0);
		cells[0][1] = book.getSpreadsheet(0).getCell(0, 1);
		file = eProcess.export(true, cells, fileName, strings);
		ImportProcess iProcess = new ImportProcess(".xml");
		result = book.getSpreadsheet(index);
		iProcess.setActiveWorkbook(book);
		iProcess.setFilename(file.getAbsolutePath());
		iProcess.setSpreadSheet(book.getSpreadsheet(index));
		iProcess.setCellTag(strings[1]);
		iProcess.importXML();
		expResult = iProcess.getSheet();
		assertEquals(result, expResult);
	}

	/**
	 * Test to verify file that user will import is valid
	 *
	 * @throws FormulaCompilationException
	 * @throws IOException
	 */
	@Test
	public void testFileToImport() throws FormulaCompilationException, IOException {
		System.out.println("testFileToImport");
		File result = null;
		File expResult = null;
		String fileName = "teste3";
		Workbook book = new Workbook(3);
		ExportProcess eProcess = new ExportProcess(".xml");
		String[] strings = new String[2];
		strings[0] = "WorkBook";
		strings[1] = "Cell";
		book.getSpreadsheet(0).getCell(0, 0).setContent("45");
		book.getSpreadsheet(0).getCell(0, 1).setContent("45");
		Cell[][] cells = new Cell[1][2];
		cells[0][0] = book.getSpreadsheet(0).getCell(0, 0);
		cells[0][1] = book.getSpreadsheet(0).getCell(0, 1);
		result = eProcess.export(true, cells, fileName, strings);
		ImportProcess iProcess = new ImportProcess(".xml");
		iProcess.setActiveWorkbook(book);
		iProcess.setFilename(result.getAbsolutePath());
		iProcess.setSpreadSheet(book.getSpreadsheet(2));
		iProcess.setCellTag(strings[1]);
		iProcess.importXML();
		expResult = new File(iProcess.getFilename());
		assertEquals(result.getName(), expResult.getName());
	}

}
