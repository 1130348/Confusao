/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.util.ExpressionVisitor;

/**
 *
 * @author Big-D2xl
 */
public class DoWhile implements Expression {

	/**
	 * The arguments passed to the function
	 */
	private Expression[] args;

	/**
	 * Creates a new block call.
	 *
	 * @param args the arguments passed to the block
	 *
	 */
	public DoWhile(Expression[] args) {
		this.args = args;
	}

	@Override
	public Value evaluate() throws IllegalValueTypeException {

		while (args[1].evaluate().toBoolean()) {
			args[0].evaluate();
		}

		return new Value();
	}

	@Override
	public Object accept(ExpressionVisitor visitor) {
		return null;
	}

}
