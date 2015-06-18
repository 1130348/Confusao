/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.userstories.macros01_02.monetary_language;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.FormulaLexer;
import csheets.core.formula.compiler.FormulaParser;
import csheets.core.formula.compiler.MoneyExpressionCompiler;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaomonteiro
 */
public class MonetaryLanguageTest {
    
    public MonetaryLanguageTest() {
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
    
//    @Test
//    public void readCurrencyExchangeFileTest(){
//        
//    }
    
    /**
	 * Test Instruction Block ={2+3;3+4}
	 */
	@Test
	public void testMoneyExchangeFormula() {
		String line = "#dollar{10,23£ + 20$}";
		Value exp_result = new Value(33.7162132);
		Value result = new Value();
		ANTLRStringStream input = new ANTLRStringStream(line);
		MoneyExpressionCompiler compiler = new MoneyExpressionCompiler();

		Workbook workbook = new Workbook(1);
		Spreadsheet sheet = workbook.getSpreadsheet(0);
		Cell cell = sheet.getCell(new Address(0, 0));

		FormulaLexer lexer = new FormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
              
                String userResult =  tokens.LT(2).getText();
                
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
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
