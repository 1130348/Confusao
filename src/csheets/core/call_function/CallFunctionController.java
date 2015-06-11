/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.call_function;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.IllegalFunctionCallException;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.UnknownElementException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        List<String> list = new ArrayList<String>();
        for (Function f : Language.getInstance().getFunctions()) {
            list.add(f.getIdentifier());
        }
        return list;
    }

    public String chooseFunction(String identifier) throws UnknownElementException {
        Function func = Language.getInstance().getFunction(identifier);
        String func_def = "=" + func.getIdentifier() + "(";
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

    public void callFunction(String func_def) {
        try {
            Value value = caller.executeFunc(func_def);
        } catch (ParseException ex) {
            Logger.getLogger(CallFunctionController.class.getName()).
                log(Level.SEVERE, null, ex);
        } catch (IllegalFunctionCallException ex) {
            Logger.getLogger(CallFunctionController.class.getName()).
                log(Level.SEVERE, null, ex);
        } catch (UnknownElementException ex) {
            Logger.getLogger(CallFunctionController.class.getName()).
                log(Level.SEVERE, null, ex);
        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(CallFunctionController.class.getName()).
                log(Level.SEVERE, null, ex);
        }
    }

}
