package csheets.ext.search;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import static csheets.ext.search.Search.Search;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Jose
 */
public class SearchTest {

	@Test
	public void TestbyString() throws IOException, ClassNotFoundException, FormulaCompilationException {
		System.out.println("Search by String");
		CleanSheets cs = new CleanSheets();
		UIController contr = new UIController(cs);
		File file = new File("src-tests\\csheets\\ext\\search\\teste.cls");
		cs.load(file);
		Spreadsheet ss = cs.getWorkbooks()[0].getSpreadsheet(0);
		SpreadsheetTable focusOwner = new SpreadsheetTable(ss, contr);
		String expression = "jose";
		Search instance = new Search();
		Address expResult = new Address(0, 0);
		Address result = Search(expression, focusOwner);
		assertEquals(expResult, result);

	}

	@Test
	public void TestbyRegularExpression() throws IOException, ClassNotFoundException, FormulaCompilationException {
		System.out.println("Search by Regular Expression");
		CleanSheets cs = new CleanSheets();
		UIController contr = new UIController(cs);
		File file = new File("src-tests\\csheets\\ext\\search\\teste.cls");
		cs.load(file);
		Spreadsheet ss = cs.getWorkbooks()[0].getSpreadsheet(0);
		SpreadsheetTable focusOwner = new SpreadsheetTable(ss, contr);
		String expression = "1[a-z][0-9]*";
		Search instance = new Search();
		Address expResult = new Address(1, 2);
		Address result = Search(expression, focusOwner);
		assertEquals(expResult, result);
	}

	@Test
	public void TestNotFound() throws IOException, ClassNotFoundException, FormulaCompilationException {
		System.out.println("Search and dont found");
		CleanSheets cs = new CleanSheets();
		UIController contr = new UIController(cs);
		File file = new File("src-tests\\csheets\\ext\\search\\teste.cls");
		cs.load(file);
		Spreadsheet ss = cs.getWorkbooks()[0].getSpreadsheet(0);
		SpreadsheetTable focusOwner = new SpreadsheetTable(ss, contr);
		String expression = "teste";
		Search instance = new Search();
		Address expResult = null;
		Address result = Search(expression, focusOwner);
		assertEquals(expResult, result);
	}
}
