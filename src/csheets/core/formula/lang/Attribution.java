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
import csheets.core.Variable;
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
	private static final long serialVersionUID = 4364553607579868087L;

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
		if (!(leftOperand instanceof CellReference) && !(leftOperand instanceof VariableReference) && !(leftOperand instanceof ArrayReference)) {
			return new Value(new IllegalArgumentException("#OPERAND!"));
		}

		Value value;
		if (leftOperand instanceof CellReference) {

			CellReference ref1 = (CellReference) leftOperand;

			Cell cell;
			try {

				cell = getCell(ref1);
			} catch (IllegalArgumentException e) {
				return new Value(e);
			}
			value = rightOperand.evaluate();

			try {

				cell.setContent(value.toString());
			} catch (FormulaCompilationException ex) {
				Logger.getLogger(Attribution.class.getName()).
					log(Level.SEVERE, null, ex);
			}
		} else if (leftOperand instanceof VariableReference) {

			VariableReference ref1 = (VariableReference) leftOperand;

			Variable variable;
			try {

				variable = ref1.getVariable();
			} catch (IllegalArgumentException e) {
				return new Value(e);
			}
			value = rightOperand.evaluate();
			Variable temp = ref1.getWorkbook().getVariable(leftOperand.
				toString());
			temp.setPositionValue(0, value);
			variable.setValue(value);
		} else if (leftOperand instanceof ArrayReference) {
			ArrayReference ref1 = (ArrayReference) leftOperand;

			Variable array;
			try {

				array = ref1.getArray();
			} catch (IllegalArgumentException e) {
				return new Value(e);
			}

			int actualPosition = array.getActualPosition();
			value = rightOperand.evaluate();
			if (actualPosition == 0) {
				array.setValue(value);
			}
			array.setPositionValue(actualPosition, value);
			System.out.
				println("Valor da posição " + actualPosition + " = " + array.
					getPositionValue(actualPosition));
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
