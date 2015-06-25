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
import csheets.ui.ctrl.UIController;

/**
 *
 * @author Andre
 */
public class For implements Function {

	/**
	 * Parameters: function, function range, condition and condition range
	 */
	public static final FunctionParameter[] parameters = new FunctionParameter[]{
		new FunctionParameter(Value.Type.TEXT, "Starting Point", false,
							  "Atribution to a cell where the FOR cicle will begin"),
		new FunctionParameter(Value.Type.NUMERIC, "Ending Point", false,
							  "A value where the FOR cicle will end when the condition is met"),
		new FunctionParameter(Value.Type.UNDEFINED, "Operation", false,
							  "Obligatory operation to be executed inside the FOR cicle")
	};

	/**
	 * Creates a new instance of the FOR function.
	 */
	public For() {
	}

	public String getIdentifier() {
		return "FOR";
	}

	public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {

		int i;
		//aqui temos de dividir a formula que vai estar presente na celula a fazer o evaluate
		arguments[0].evaluate();

		while (arguments[1].evaluate().toBoolean()) {

			for (i = 2; i < arguments.length; i++) {

				arguments[i].evaluate();
			}
		}

		Value v = new Value("FOR");
		return v;

	}

	public FunctionParameter[] getParameters() {
		return parameters;
	}

	public boolean isVarArg() {
		return true;
	}

	@Override
	public void setUIController(UIController ui) {
	}
}
