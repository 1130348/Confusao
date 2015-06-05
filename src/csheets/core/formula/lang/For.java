/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.BinaryOperation;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;

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
		//Pior solução temporária de sempre
		int cont = 0;
		BinaryOperation b1 = (BinaryOperation) arguments[0];
		BinaryOperation b2 = (BinaryOperation) arguments[1];

		Double d1 = b1.getRightOperand().evaluate().toDouble();
		Double d2 = b2.getRightOperand().evaluate().toDouble();

		int startingPoint = d1.intValue();
		int endingPoint = d2.intValue();

		System.out.println(d1);
		System.out.println(d2);
		Value valorC = b1.evaluate();

		for (int i = startingPoint; i < endingPoint; i++) {

			for (Expression expression : arguments) {
				if (cont++ > 1) {
					Value valorCS = expression.evaluate();
				}
			}
		}

		Value v = new Value();
		return v;
	}

	public FunctionParameter[] getParameters() {
		return parameters;
	}

	public boolean isVarArg() {
		return true;
	}
}
