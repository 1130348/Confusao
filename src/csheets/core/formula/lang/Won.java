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
import csheets.core.formula.Literal;
import csheets.core.formula.util.MoneyService;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author joaomonteiro
 */
public class Won implements Function {

	/**
	 * The function's parameters
	 */
	public static final FunctionParameter[] parameters = new FunctionParameter[]{
		new FunctionParameter(Value.Type.UNDEFINED, "Expression", false,
							  "An expression whose value is checked for type compliance"), new FunctionParameter(Value.Type.UNDEFINED, "Expression", false,
																												 "An expression whose value is checked for type compliance"), new FunctionParameter(Value.Type.UNDEFINED, "Expression", false,
																																																	"An expression whose value is checked for type compliance"), new FunctionParameter(Value.Type.UNDEFINED, "Expression", false,
																																																																					   "An expression whose value is checked for type compliance"), new FunctionParameter(Value.Type.UNDEFINED, "Expression", false,
																																																																																										  "An expression whose value is checked for type compliance")
	/* new FunctionParameter(Value.Type.TEXT, "Type", true,
	 'The type to look for. Accepted values are "NUMERIC" (default),'
	 + '"TEXT", "BOOLEAN", "DATE", "MATRIX" and "ERROR".'); */
	};

	@Override
	public String getIdentifier() {
		return "won";
	}

	@Override
	public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {

		Expression[] exp = new Expression[3];
		exp[0] = arguments[2];
		exp[1] = arguments[0];
		exp[2] = arguments[3];

		Value op1 = ((Literal) exp[1]).getValue();
		Value op2 = ((Literal) exp[2]).getValue();

		Double d1 = op1.toDouble();
		Double d2 = op2.toDouble();

		double operator1 = d1;
		double operator2 = d2;

		Value currency1 = ((Literal) arguments[1]).getValue();
		Value currency2 = ((Literal) arguments[4]).getValue();
		Value operator = ((Literal) exp[0]).getValue();

		String s1 = currency1.toString();
		String s2 = currency2.toString();
		String s3 = operator.toString();

		double exchange;
		if (!s1.equals("€")) {
			exchange = MoneyService.searchCurrencyExchangeValue(s1);
			d1 /= exchange;
		}

		if (!s2.equals("€")) {
			exchange = MoneyService.searchCurrencyExchangeValue(s2);
			d2 /= exchange;
		}

		exchange = MoneyService.searchCurrencyExchangeValue("₩");
		switch (s3) {
			case "+":
				return new Value((d1 + d2) * exchange);

			case "-":
				return new Value((d1 - d2) * exchange);

			case "/":
				return new Value((d1 / d2) * exchange);

			case "*":
				return new Value((d1 * d2) * exchange);

			default:
				throw new AssertionError();
		}
	}

	@Override
	public FunctionParameter[] getParameters() {
		return parameters;
	}

	@Override
	public boolean isVarArg() {
		return false;
	}

	@Override
	public void setUIController(UIController ui) {
	}
}
