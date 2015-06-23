package csheets.core.formula.lang;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.ExcelExpressionCompiler;
import csheets.core.formula.compiler.FormulaCompilationException;
import javax.swing.JOptionPane;

/**
 * This class represents and defines the EVAL macro The EVAL macro has a
 * parameter, a string, witch parses it to give a numeric result. As an example,
 * the syntax can be: =EVAL("100+1+2")+EVAL("123456+654") This will output
 * 124.213 witch is sum between (100+1+2)+(123456+654)
 */
public class Eval implements Function {

	/**
	 * Parameters: condition and multiple expressions
	 */
	ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();
	private Cell cell = null;

	// private SpreadsheetTable focusOwner;
	public static final FunctionParameter[] parameters = new FunctionParameter[]{
		new FunctionParameter(Value.Type.TEXT, "Expressions", false,
							  "Expressions")
	};

	/**
	 * Empty constructor
	 */
	public Eval() {
	}

	/**
	 * This returns the Function identifier When parsing, the code will request
	 * this to call the correct function
	 *
	 * @return "EVAL" The function name.
	 */
	@Override
	public String getIdentifier() {
		return "EVAL";
	}

	/**
	 * This will apply the transformation accordingly
	 *
	 * @param arguments The expression
	 * @return The result of the arithmethic expression
	 * @throws IllegalValueTypeException - Throws when the data type is wrong
	 */
	@Override
	public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {
		if (arguments != null) {
			Value val = arguments[0].evaluate();
			String temp = "=" + val.toString();

			try {

				Expression express = compiler.compile(cell, temp);

				return express.evaluate();
			} catch (FormulaCompilationException ex) {
				JOptionPane.showMessageDialog(null, "Error not permited");
			}

		}
		return new Value();

	}

	/**
	 * It returns the functions parameters
	 *
	 * @return Function parameter
	 */
	@Override
	public FunctionParameter[] getParameters() {
		return parameters;
	}

	/**
	 * Represents the inability to acept diferent number of parameters In this
	 * function the result will allways be no.
	 *
	 * @return false - The number of arguments is 1
	 */
	@Override
	public boolean isVarArg() {
		return false;
	}

}
