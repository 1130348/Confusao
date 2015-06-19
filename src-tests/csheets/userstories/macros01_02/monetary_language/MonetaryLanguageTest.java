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
import csheets.core.formula.util.MoneyService;
import csheets.ext.startsharing.NetworkService;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
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
        File f = new File("Cambios_v1.csv");

        MoneyService.importCurrenciesFromCSVFile(f);

        String line = "#euro{10,00€ + 20,00€}";
        Value exp_result = new Value(30.00);
        Value result = new Value();
        ANTLRStringStream input = new ANTLRStringStream(line);
        MoneyExpressionCompiler compiler = new MoneyExpressionCompiler();

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
        assertEquals(exp_result.toString(), result.toString());
    }
    
    @Test
    public void ImportCurrencyExchangeFile(){
        File f = new File("Cambios_v1.csv");

        MoneyService.importCurrenciesFromCSVFile(f);
        
        Map<String, Double> m = new HashMap<>();
        m.put("Sterling pound", 0.717);
        m.put("Japanese yen", 139.78);
        m.put("South Korea won", 1263.34);
        m.put("US dollar", 1.1279);
        m.put("Indian Rupee", 72.3435);

        MoneyService.importCurrenciesFromCSVFile(f);
        assertEquals(m, MoneyService.currencyExchanges);
    }
    
    @Test
    public void searchCurrencyExchange(){
        
        ArrayList<Double> ar = new ArrayList<>();
        ar.add(0.717);
        ar.add(139.78);
        ar.add(1263.34);
        ar.add(1.1279);
        ar.add(72.3435);
        
        ArrayList<Double> results = new ArrayList<>();
        results.add(MoneyService.searchCurrencyExchangeValue("£"));
        results.add(MoneyService.searchCurrencyExchangeValue("¥"));
        results.add(MoneyService.searchCurrencyExchangeValue("₩"));
        results.add(MoneyService.searchCurrencyExchangeValue("$"));
        results.add(MoneyService.searchCurrencyExchangeValue("₹"));
        
        assertEquals(ar, results);
    }

    @After
    public void tearDown() {
    }
}
