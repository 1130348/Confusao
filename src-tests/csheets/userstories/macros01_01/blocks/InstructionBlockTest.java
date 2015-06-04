/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.userstories.macros01_01.blocks;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.ExcelExpressionCompiler;
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
 * @author Andre
 */
public class InstructionBlockTest {

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
	 * Test Instruction Block ={2+3;3+4}
	 */
	@Test
	public void testSimpleTwoInstructionsBlock() {
		String line = "={2+3;3+4}";
		Value exp_result = new Value(7);
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
			String message = parser.getErrorMessage(e, parser.tokenNames);
			System.out.
				println("At (" + e.line + ";" + e.charPositionInLine + "): " + message);
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}
		assertEquals(exp_result, result);
	}

	/**
	 * Test Instruction Block ={A1:=2+3;A1-2}
	 */
	@Test
	public void testAtributionInstructionBlock() {
		String line = "={A1:=5+5;A1-2}";
		Value exp_result = new Value(8);
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
			String message = parser.getErrorMessage(e, parser.tokenNames);
			System.out.
				println("At (" + e.line + ";" + e.charPositionInLine + "): " + message);
		} catch (Exception e) {
			// System.err.println(e);
			e.printStackTrace();
		}
		assertEquals(exp_result, result);
	}

	/**
	 * Test Identify { and } tokens
	 */
	@Test
	public void testIdentifyOpen_CloseTokens() throws RecognitionException {
		String line = "={2+3}";
		String exp_result = "(+ 2 3)";
		String result;

		ANTLRStringStream input = new ANTLRStringStream(line);

		FormulaLexer lexer = new FormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		FormulaParser parser = new FormulaParser(tokens);
		CommonTree ast = (CommonTree) parser.expression().getTree();

		result = ast.toStringTree();

		assertEquals(result, exp_result);

	}

	/**
	 * Test Identify { } and ; tokens
	 */
	@Test
	public void testIdentifyBlockTokens() throws RecognitionException {
		String line = "={2+3;3-4}";
		String exp_result = "(+ 2 3) ; (- 3 4)";
		String result;

		ANTLRStringStream input = new ANTLRStringStream(line);

		FormulaLexer lexer = new FormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		FormulaParser parser = new FormulaParser(tokens);
		CommonTree ast = (CommonTree) parser.expression().getTree();

		result = ast.toStringTree();

		assertEquals(result, exp_result);

	}

	/**
	 * Test Identify := token
	 */
	@Test
	public void testIdentifyAtributionTokens() throws RecognitionException {
		String line = "={A1:=2+3;A1-2}";
		String exp_result = "(:= (+ 2 3) A1);(- A1 2)";
		String result;

		ANTLRStringStream input = new ANTLRStringStream(line);

		FormulaLexer lexer = new FormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		FormulaParser parser = new FormulaParser(tokens);
		CommonTree ast = (CommonTree) parser.expression().getTree();

		result = ast.toStringTree();

		assertEquals(result, exp_result);

	}
}
