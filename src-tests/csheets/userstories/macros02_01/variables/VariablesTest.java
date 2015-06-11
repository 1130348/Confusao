/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.userstories.macros02_01.variables;

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
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 1130395
 */
public class VariablesTest {

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
    public void testNewVariable() {
        String line = "=@ola";
        Value exp_result = new Value("");
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
        } catch (Exception e) {
            // System.err.println(e);
            e.printStackTrace();
        }
        assertEquals(exp_result, result);
    }

    /**
     * Test Read Variable
     */
    @Test
    public void testReadVariable() {
        String line = "=@ola";
        Value exp_result = new Value("");
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
                result = workbook.getVariableValue("@ola");
            }
        } catch (Exception e) {
            // System.err.println(e);
            e.printStackTrace();
        }
        assertEquals(exp_result, result);
    }

    /**
     * Test Edit a variable
     * @throws org.antlr.runtime.RecognitionException
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    public void testEditVariable() throws RecognitionException, IllegalValueTypeException {
        String line = "=@ola:=3*3";
        Value exp_result = new Value(9);
        Value result = new Value(9);
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
                result = workbook.getVariableValue("@ola");
            }
        } catch (RecognitionException e) {
        } catch (FormulaCompilationException e) {
        } catch (IllegalValueTypeException e) {
        }
        Assert.assertTrue(exp_result.toDouble()==result.toDouble());

    }

    /**
     * Test Variables equal in different spreedsheets
     */
    @Test
    public void testVariableDiffSpreedSheets() throws RecognitionException {
        String line = "=@ola:=3";
        Value result = new Value();
        Value result2 = new Value();
        ANTLRStringStream input = new ANTLRStringStream(line);

        ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();

        Workbook workbook = new Workbook(2);
        Spreadsheet sheet = workbook.getSpreadsheet(0);
        Spreadsheet sheet2 = workbook.getSpreadsheet(1);
        Cell cell = sheet.getCell(new Address(0, 0));
        Cell cell2 = sheet2.getCell(new Address(0, 0));

        FormulaLexer lexer = new FormulaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        FormulaParser parser = new FormulaParser(tokens);
        try {
            CommonTree ast = (CommonTree) parser.expression().getTree();
            if (ast != null) {
                Expression expression = compiler.convert(cell, ast);
                expression.evaluate();
                result = workbook.getVariableValue("@ola");

                Expression expression2 = compiler.convert(cell2, ast);
                expression2.evaluate();
                result2 = workbook.getVariableValue("@ola");
            }
        } catch (Exception e) {
            // System.err.println(e);
            e.printStackTrace();
        }
        assertEquals(result, result2);

    }

}
