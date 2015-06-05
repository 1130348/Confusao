/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.Reference;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class Attribution implements BinaryOperator {

	/**
	 * The unique version identifier used for serialization
	 */
	private static final long serialVersionUID = 4364553607579868067L;

	/**
	 * Creates a new attribution
	 */
	public Attribution() {
	}

	@Override
	/**
	 *
	 * Gets the result of the rigth operand and saves int the left operand
	 *
	 *
	 */
	public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
		//Validates if the left operand is a CellReference
		if (!(leftOperand instanceof CellReference)) {
			return new Value(new IllegalArgumentException("#OPERAND!"));
		}
		CellReference ref1 = (CellReference) leftOperand;

		// Fetches the cell
		Cell cell;
		try {

			cell = getCell(ref1);
		} catch (IllegalArgumentException e) {
			return new Value(e);
		}
		Value value = rightOperand.evaluate();

		try {

			cell.setContent(value.toString());
		} catch (FormulaCompilationException ex) {
			Logger.getLogger(Attribution.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		value = new Value();
		return value;
	}

	/**
	 * Returns the range of cells formed by the two cell references.
	 *
	 * @param reference1 the first reference
	 * @param reference2 the other reference
	 * @return an array of the cells that constitute the range
	 */
	public Cell getCell(Reference reference1) {
		// Casts operands
		if (!(reference1 instanceof CellReference)) {
			throw new IllegalArgumentException("#OPERAND!");
		}
		CellReference ref1 = (CellReference) reference1;

		// Checks that the references point to cells in the same spreadsheet
		Spreadsheet spreadsheet = ref1.getCell().getSpreadsheet();

		// Fetches coordinates
		int column1 = ref1.getCell().getAddress().getColumn();

		int row1 = ref1.getCell().getAddress().getRow();

		//Get Cell
		Cell cell = spreadsheet.
			getCell(column1, row1);

		return cell;
	}

	@Override
	public String getIdentifier() {
		return ":=";
	}

	@Override
	public Value.Type getOperandValueType() {
		return Value.Type.TEXT;
	}

	@Override
	public String toString() {
		return getIdentifier();
	}
}
