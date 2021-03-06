/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;

/**
 * A subtracter of a numeric operand from another.
 *
 * @author Einar Pehrson
 */
public class Subtracter implements BinaryOperator {

	/**
	 * The unique version identifier used for serialization
	 */
	private static final long serialVersionUID = 2660304336585762625L;

	/**
	 * Creates a new subtracter.
	 */
	public Subtracter() {
	}

	public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
		int leftColumn = 0;
		int rightColumn = 0;
		int leftRow = 0;
		int rightRow = 0;

		Value.Type typeLeft = leftOperand.evaluate().getType();
		Value.Type typeRight = leftOperand.evaluate().getType();

		//enum Type
		if ((typeLeft == typeRight) && (typeLeft == Value.Type.MATRIX)) {
			Value[][] leftMatrix = leftOperand.evaluate().toMatrix();
			Value[][] rightMatrix = rightOperand.evaluate().toMatrix();

			for (Value[] row : leftMatrix) {
				leftRow++; // Incrementa Linha(esquerda)
				leftColumn += row.length;
			}

			for (Value[] row : rightMatrix) {
				rightRow++;
				rightColumn += row.length;
			}

			//Diferentes Tamanhos!
			//Operação de Soma para matrizes de diferentes dimensões não é possível.
			if ((leftRow != rightRow) && (leftColumn != rightColumn)) {
				return new Value("#Type");
			} else {
				//Matrizes iguais, calcular a respectiva adiçao
				Value[][] resultMatrix = new Value[rightMatrix.length][rightMatrix[0].length];
				for (int i = 0; i < rightMatrix.length; i++) {
					for (int j = 0; j < rightMatrix[i].length; j++) {
						resultMatrix[i][j] = new Value(leftMatrix[i][j].
							toDouble() - rightMatrix[i][j].toDouble());
					}
				}
				return new Value(resultMatrix);
			}
		} else {
			return new Value(leftOperand.evaluate().toDouble() - rightOperand.
				evaluate().toDouble());
		}
	}

	public String getIdentifier() {
		return "-";
	}

	public Value.Type getOperandValueType() {
		return Value.Type.NUMERIC;
	}

	public String toString() {
		return getIdentifier();
	}
}
