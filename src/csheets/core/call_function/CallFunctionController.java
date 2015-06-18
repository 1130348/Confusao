/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.call_function;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.call_function.ui.FormulasPanel;
import csheets.core.formula.BinaryOperation;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.Literal;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.IllegalFunctionCallException;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.UnknownElementException;
import java.beans.Expression;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class CallFunctionController {

    private FunctionCaller caller;

    public CallFunctionController() {
        caller = new FunctionCaller();
    }

    public List<String> fillList() {
        List<String> list = new ArrayList<>();
        for (Function f : Language.getInstance().getFunctions()) {
            list.add(f.getIdentifier());
        }
        sort(list);
        return list;
    }

    public List<String> fillListOperators(List<String> list) {
        try {
            list.add(Language.getInstance().getBinaryOperator("+").getIdentifier());
            list.add(Language.getInstance().getBinaryOperator("*").getIdentifier());
            list.add(Language.getInstance().getBinaryOperator("-").getIdentifier());
            list.add(Language.getInstance().getBinaryOperator("/").getIdentifier());
        } catch (UnknownElementException ex) {
            Logger.getLogger(CallFunctionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        sort(list);
        return list;
    }

    public String chooseFunction(String identifier) throws UnknownElementException {
        Function func = Language.getInstance().getFunction(identifier);
        String func_def = func.getIdentifier() + "(";
        for (FunctionParameter p : func.getParameters()) {
            func_def += p.getName() + ";";
        }
        func_def = func_def.substring(0, func_def.length() - 1);
        if (func.isVarArg()) {
            func_def += ";...";
        }
        func_def += ")";
        return func_def;
    }

    public String newChooseFunction(String identifier, List<String> ls) throws UnknownElementException {
        Function func = Language.getInstance().getFunction(identifier);
        String func_def = func.getIdentifier() + "(";
        for (String st : ls) {
            func_def += st + ";";
        }
        func_def = func_def.substring(0, func_def.length() - 1);
        func_def += ")";
        return func_def;
    }

    public Value callFunction(String func_def) {
        Value value = new Value();
        try {
            value = caller.executeFunc(func_def);
            String formula = func_def.substring(0) + " = " + value;
            //FormulasPanel.addFormula(formula);
        } catch (ParseException | IllegalFunctionCallException | UnknownElementException | IllegalValueTypeException ex) {
            Logger.getLogger(CallFunctionController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
    public Value callBinaryOperation(String item, String parameter1, String parameter2) throws IllegalValueTypeException, ParseException{
        Value value = new Value();
        try {
            BinaryOperator operator = Language.getInstance().
                    getBinaryOperator(item);
            Literal leftOperand = new Literal(Value.parseNumericValue(parameter1));
            Literal rightOperand = new Literal(Value.parseNumericValue(parameter2));
            BinaryOperation operation = new BinaryOperation(leftOperand, operator, rightOperand);
            value = operation.evaluate();
        } catch (UnknownElementException ex) {
            Logger.getLogger(CallFunctionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    public void addFunctionToFormulasPanel(String func_def) {
        FormulasPanel.addFormula(func_def);
    }

    public String showResult(String func_def) {
        Value value;
        String formula = "";
        try {
            value = caller.executeFunc(func_def);
            formula = func_def + " = " + value.toString().replace(".", ",");
        } catch (ParseException | IllegalFunctionCallException | UnknownElementException | IllegalValueTypeException ex) {
            JOptionPane.showMessageDialog(null, "Function is not supported yet!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return formula;
    }

    public int validateParameters(List<String> ls, Function func) {
        int parameter = 1;
        for (String value : ls) {
            ParsePosition position = new ParsePosition(0);
            Number number = NumberFormat.getInstance().parse(value, position);
            if (position.getIndex() != value.length()) {
                return parameter; //parameter 2 is invalid
            }
            parameter++;
        }
        if (ls.size() != func.getParameters().length) {
            return 4; // "4" means that is missing some data
        }

        return 0; // valid
    }

    public boolean validateSpecialParameters(String str) {
        double test;
        int index1 = str.indexOf("(");
        int index2 = str.indexOf(")");
        str = str.substring(index1 + 1, index2);
        String[] st = str.split(";");
        for (String value : st) {
            ParsePosition position = new ParsePosition(0);
            Number number = NumberFormat.getInstance().parse(value, position);
            if (position.getIndex() != value.length()) {
                return false;
            }
        }
        return true;
    }
    
    public int validateOperatorsParameters(List<String> ls) {
        int parameter = 1;
        for (String value : ls) {
            if(value.isEmpty()) return 3;
            ParsePosition position = new ParsePosition(0);
            Number number = NumberFormat.getInstance().parse(value, position);
            if (position.getIndex() != value.length()) {
                return parameter; //the invalid parameter
            }
            parameter++;
        }
        if (ls.size() != 2) {
            return 3; // "3" means that is missing some data
        }

        return 0; // valid
    }

    public void addResultToCell(Cell cell, String func_def) throws FormulaCompilationException {
        cell.setContent(func_def);
    }

    public Value callMacroFunction(String func_def) throws ParseException, IllegalFunctionCallException, UnknownElementException, IllegalValueTypeException {
        return caller.executeFunc(func_def);
    }

}
