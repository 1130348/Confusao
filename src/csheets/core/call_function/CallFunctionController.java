/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.call_function;

import csheets.core.call_function.ui.CallFunctionUI;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.UnknownElementException;
import java.util.List;

/**
 *
 * @author Andre
 */
public class CallFunctionController {

    private CallFunctionUI m_ui;

    public CallFunctionController(CallFunctionUI ui) {
        m_ui = ui;
    }

    public List<Function> fillList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String chooseFunction(String identifier) throws UnknownElementException {
        Function func = Language.getInstance().getFunction(identifier);
        String func_def = "="+func.getIdentifier()+"(";
        for (FunctionParameter p : func.getParameters()) {
            func_def += p.getName()+ ";";
        }
        func_def = func_def.substring(0, func_def.length()-1);
        if (func.isVarArg()) {
            func_def += ";...";
        }
        func_def += ")";
        return func_def;
    }

    public void callFunction(String func_def) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
