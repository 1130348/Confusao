/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.call_function;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionCall;
import csheets.core.formula.Literal;
import csheets.core.formula.compiler.IllegalFunctionCallException;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.UnknownElementException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class FunctionCaller {

    private FunctionCall func_call;

    public FunctionCaller() {
    }

    public Value executeFunc(String func_def) throws ParseException, IllegalFunctionCallException, UnknownElementException, IllegalValueTypeException {
        String identifier = func_def.substring(1, func_def.
            indexOf("("));
        Function function = Language.getInstance().getFunction(identifier);
        List<Expression> args = new ArrayList<Expression>();
        String temp = func_def.substring(func_def.indexOf("(") + 1, func_def.
            lastIndexOf(")"));
        String[] params = temp.split(";");
        for (String s : params) {
            args.add(new Literal(Value.parseNumericValue(s)));
        }
        Expression[] argArray = args.toArray(new Expression[args.size()]);
        func_call = new FunctionCall(function, argArray);
        return func_call.evaluate();
    }

}
