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
        BinaryOperation atributionOne = (BinaryOperation) arguments[0];
        BinaryOperation atribuitionTwo = (BinaryOperation) arguments[1];

        Value valStartingPoint = atributionOne.getRightOperand().evaluate();
        Value valEndingPoint = atribuitionTwo.getRightOperand().evaluate();

        Double doubleStartingPoint = valStartingPoint.toDouble();
        Double doubleEndingPoint = valEndingPoint.toDouble();

        int startingPoint = doubleStartingPoint.intValue();
        int endingPoint = doubleEndingPoint.intValue();

        System.out.println(startingPoint);
        System.out.println(endingPoint);

        //aqui temos de dividir a formula que vai estar presente na celula a fazer o evaluate
        for (int i = startingPoint; i < endingPoint; i++) {

            for (Expression expression : arguments) {
                if (cont++ > 1) {
                    //aqui temos de dividir a formula que vai estar presente na celula a fazer o evaluate
                    Value valorCS = expression.evaluate();
                }
            }
        }

        Value v = new Value();
        return v;
        
        /*
        arguments[0].evaluate();

		System.out.println(arguments[1].evaluate().toBoolean());

		while (arguments[1].evaluate().toBoolean()) {

			for (int i = 3; i < arguments.length; i++) {

				arguments[i].accept(null);
			}
		}

		Value v = new Value("");
		return v;
        */
    }

    public FunctionParameter[] getParameters() {
        return parameters;
    }

    public boolean isVarArg() {
        return true;
    }
}
