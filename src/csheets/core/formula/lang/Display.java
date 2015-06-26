/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.ext.Form_Editor.UI.FormEditorController;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author DMMCA
 */
public class Display implements Function{

    
    public static final FunctionParameter[] parameters = new FunctionParameter[] {
		new FunctionParameter(Value.Type.TEXT, "Expression", false,
			"An expression whose value is checked for type compliance")
	};
    
    
    public Display() {
    }

    
    @Override
    public String getIdentifier() {
        return "DISPLAY";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        for (Expression expression : args) {
			Value value = expression.evaluate();
			FormEditorController.Display(value);
		}
        return new Value();
    }

    
    

    @Override
    public boolean isVarArg() {
        return false;
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public void setUIController(UIController ui) {
        
    }

    
}
