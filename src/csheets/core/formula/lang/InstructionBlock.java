/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;

/**
 *
 * @author Andre
 */
public class InstructionBlock implements BinaryOperator {

	/**
	 * The unique version identifier used for serialization
	 */
	private static final long serialVersionUID = -1880245696016234963L;

	/**
	 * Creates a new InstructionBlock.
	 */
	public InstructionBlock() {
	}

	public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
		leftOperand.evaluate();
		Value v = rightOperand.evaluate();
		return v;
	}

	public String getIdentifier() {
		return ";";
	}

	public Value.Type getOperandValueType() {
		return Value.Type.NUMERIC;
	}

	public String toString() {
		return getIdentifier();
	}
}
