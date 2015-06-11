/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.userstories.macros03_01.baseOperators.i130386;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.ExcelExpressionCompiler;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaLexer;
import csheets.core.formula.compiler.FormulaParser;
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
 * @author Luis
 */
public class BaseOperators {

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
	 * Test AdderBaseOperator = AVERAGE({1;2;3}+{4;5;6});
	 */
	@Test
	public void testAdderWithAverageFunctionBaseOperator() {
		String line = "=AVERAGE({1;2;3}+{4;5;6})";
		Value exp_result = new Value(9.0);
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
				result = expression.evaluate();
			}
		} catch (RecognitionException e) {
			//String message="Fatal recognition exception " + e.getClass().getName()+ " : " + e;
			String message = parser.getErrorMessage(e, FormulaParser.tokenNames);
			System.out.
				println("At (" + e.line + ";" + e.charPositionInLine + "): " + message);
		} catch (FormulaCompilationException exception) {
			System.out.
				println("Exception[FormulaCompilationException]: " + exception);
		} catch (IllegalValueTypeException exception) {
			System.out.
				println("Exception[IllegalValueTypeException]: " + exception);
		}
		assertEquals(exp_result, result);
	}

	/**
	 * Test AdderBaseOperator = SUM({1;2;3}+{4;5;6});
	 */
	@Test
	public void testAdderWithSumFunctionBaseOperator() {
		String line = "=SUM({1;2;3}+{4;5;6})";
		Value exp_result = new Value(9.0);
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
				result = expression.evaluate();
			}
		} catch (RecognitionException e) {
			//String message="Fatal recognition exception " + e.getClass().getName()+ " : " + e;
			String message = parser.getErrorMessage(e, FormulaParser.tokenNames);
			System.out.
				println("At (" + e.line + ";" + e.charPositionInLine + "): " + message);
		} catch (FormulaCompilationException exception) {
			System.out.
				println("Exception[FormulaCompilationException]: " + exception);
		} catch (IllegalValueTypeException exception) {
			System.out.
				println("Exception[IllegalValueTypeException]: " + exception);
		}
		assertEquals(exp_result, result);
	}

	/**
	 * Test SubtracterBaseOperator = AVERAGE({1;2;3}-{4;5;6});
	 */
	@Test
	public void testSubtracterWithAverageFunctionBaseOperator() {
		String line = "=AVERAGE({1;2;3}-{4;5;6})";
		Value exp_result = new Value(-3.0);
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
				result = expression.evaluate();
			}
		} catch (RecognitionException e) {
			//String message="Fatal recognition exception " + e.getClass().getName()+ " : " + e;
			String message = parser.getErrorMessage(e, FormulaParser.tokenNames);
			System.out.
				println("At (" + e.line + ";" + e.charPositionInLine + "): " + message);
		} catch (FormulaCompilationException exception) {
			System.out.
				println("Exception[FormulaCompilationException]: " + exception);
		} catch (IllegalValueTypeException exception) {
			System.out.
				println("Exception[IllegalValueTypeException]: " + exception);
		}
		assertEquals(exp_result, result);
	}

	/**
	 * Test SubtracterBaseOperator = SUM({1;2;3}-{4;5;6});
	 */
	@Test
	public void testSubtracterWithSumFunctionBaseOperator() {
		String line = "=SUM({1;2;3}-{4;5;6})";
		Value exp_result = new Value(-3.0);
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
				result = expression.evaluate();
			}
		} catch (RecognitionException e) {
			//String message="Fatal recognition exception " + e.getClass().getName()+ " : " + e;
			String message = parser.getErrorMessage(e, FormulaParser.tokenNames);
			System.out.
				println("At (" + e.line + ";" + e.charPositionInLine + "): " + message);
		} catch (FormulaCompilationException exception) {
			System.out.
				println("Exception[FormulaCompilationException]: " + exception);
		} catch (IllegalValueTypeException exception) {
			System.out.
				println("Exception[IllegalValueTypeException]: " + exception);
		}
		assertEquals(exp_result, result);
	}

}
