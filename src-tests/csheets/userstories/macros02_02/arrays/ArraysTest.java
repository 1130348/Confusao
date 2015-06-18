/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.userstories.macros02_02.arrays;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Variable;
import csheets.core.Workbook;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.ExcelExpressionCompiler;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaLexer;
import csheets.core.formula.compiler.FormulaParser;
import java.util.SortedSet;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
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
public class ArraysTest {

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
	 * Test create new array
	 */
	@Test
	public void testNewArray() {
		String line = "=@ola[2]";
		String expResult = "@ola";
		String result = "";
		ANTLRStringStream input = new ANTLRStringStream(line);

		ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();

		Workbook workbook = new Workbook(1);
		Spreadsheet sheet = workbook.getSpreadsheet(0);
		Cell cell = sheet.getCell(new Address(0, 0));

		FormulaLexer lexer = new FormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		FormulaParser parser = new FormulaParser(tokens);
		try {
			CommonTree ast = (CommonTree) parser.expression().getTree();
			if (ast != null) {
				Expression expression = compiler.convert(cell, ast);
				Variable var = new Variable("@ola", new Value(""), workbook, 2);
				SortedSet<Variable> vars = workbook.getVariables();
				for (Variable v : vars) {
					if (v.getName().equals(var.getName())) {
						result = v.getName();
					}
				}
			}
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}
		assertEquals(expResult, result);
	}

	/**
	 * Test Read Array
	 */
	@Test
	public void testReadArray() {
		String line = "=@ola[1]:=20";
		String expResult = "20";
		String result = "";
		ANTLRStringStream input = new ANTLRStringStream(line);

		ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();

		Workbook workbook = new Workbook(1);
		Spreadsheet sheet = workbook.getSpreadsheet(0);
		Cell cell = sheet.getCell(new Address(0, 0));

		FormulaLexer lexer = new FormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		FormulaParser parser = new FormulaParser(tokens);
		try {
			CommonTree ast = (CommonTree) parser.expression().getTree();
			if (ast != null) {
				Expression expression = compiler.convert(cell, ast);
				expression.evaluate();
				Variable var = new Variable("@ola", new Value("20"), workbook, 1);
				SortedSet<Variable> vars = workbook.getVariables();
				for (Variable v : vars) {
					if (v.getName().equals(var.getName())) {
						result = v.getPositionValue(1).toString();
					}
				}
			}
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}
		assertEquals(expResult, result);
	}

	/**
	 * Test Edit a array
	 */
	@Test
	public void testEditArray() {
		String line = "=@ola[2]:=3+3";
		Value expResult = new Value(6);
		Value result = new Value();
		ANTLRStringStream input = new ANTLRStringStream(line);

		ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();

		Workbook workbook = new Workbook(1);
		Spreadsheet sheet = workbook.getSpreadsheet(0);
		Cell cell = sheet.getCell(new Address(0, 0));

		FormulaLexer lexer = new FormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		FormulaParser parser = new FormulaParser(tokens);
		try {
			CommonTree ast = (CommonTree) parser.expression().getTree();
			if (ast != null) {
				Expression expression = compiler.convert(cell, ast);
				expression.evaluate();
				SortedSet<Variable> vars = workbook.getVariables();
				for (Variable v : vars) {
					if (v.getName().equals("@ola")) {
						result = v.getPositionValue(2);
					}
				}
			}
		} catch (RecognitionException e) {
		} catch (FormulaCompilationException e) {
		} catch (IllegalValueTypeException e) {
		}
		assertEquals(expResult.toString(), result.toString());
	}

	/**
	 * Test Arrays when accessed by the name without position
	 */
	@Test
	public void testAccessArrayByName() {
		String line = "=@ola:=50";
		Value expResult = new Value(50);
		Value result = new Value();
		ANTLRStringStream input = new ANTLRStringStream(line);

		ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();

		Workbook workbook = new Workbook(1);
		Spreadsheet sheet = workbook.getSpreadsheet(0);
		Cell cell = sheet.getCell(new Address(0, 0));

		FormulaLexer lexer = new FormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		FormulaParser parser = new FormulaParser(tokens);
		try {
			CommonTree ast = (CommonTree) parser.expression().getTree();
			if (ast != null) {
				Expression expression = compiler.convert(cell, ast);
				expression.evaluate();
				SortedSet<Variable> vars = workbook.getVariables();
				for (Variable v : vars) {
					if (v.getName().equals("@ola")) {
						result = v.getPositionValue(0);
					}
				}
			}
		} catch (RecognitionException e) {
		} catch (FormulaCompilationException e) {
		} catch (IllegalValueTypeException e) {
		}
		assertEquals(expResult.toString(), result.toString());
	}

}
