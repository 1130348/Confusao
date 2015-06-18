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

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.Variable;
import csheets.core.formula.BinaryOperation;
import csheets.core.formula.Reference;
import csheets.core.formula.util.ExpressionVisitor;
import csheets.core.formula.util.ExpressionVisitorException;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A binary reference operation in a formula.
 * @author Einar Pehrson
 */
public class ReferenceOperation extends BinaryOperation implements Reference {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = 1767227655524985408L;

	/** The cells that constitute the range */
	private SortedSet<Cell> cells;
        
        	/** The cells that constitute the range */
	private SortedSet<Variable> vars;

	/**
	 * Creates a new reference operation.
	 * @param leftOperand the left(first) operand
	 * @param operator the reference operator
	 * @param rightOperand the right(second) operand
	 */
	public ReferenceOperation(Reference leftOperand, RangeReference operator, Reference rightOperand) {
		super(leftOperand, operator, rightOperand);
	}

	public SortedSet<Cell> getCells() {
		if (cells == null) {
			cells = new TreeSet<Cell>();
			Cell[][] range = getOperator().getCells(getLeftOperand(), getRightOperand());
			for (int row = 0; row < range.length; row++)
				for (int column = 0; column < range[row].length; column++)
					cells.add(range[row][column]);
		}
		return cells;
	}

	public RangeReference getOperator() {
		return (RangeReference)operator;
	}

	public Reference getLeftOperand() {
		return (Reference)super.getLeftOperand();
	}

	public Reference getRightOperand() {
		return (Reference)super.getRightOperand();
	}

	public Value evaluate() {
		return getOperator().applyTo(getLeftOperand(), getRightOperand());
	}

	public Object accept(ExpressionVisitor visitor) throws ExpressionVisitorException {
		return visitor.visitReference(this);
	}

	public int compareTo(Reference reference) {
            if(reference instanceof CellReference)
            {
		Cell otherCell = reference.getCells().first();
		int firstDiff = getCells().first().compareTo(otherCell);
		if (firstDiff != 0)
			return firstDiff;
		else
			if (reference instanceof CellReference)
				return 1;
			else
				return getCells().last().compareTo(reference.getCells().last());
            } else if(reference instanceof VariableReference )
            {
                 Variable otherVar = reference.getVariables().first();
		int firstDiff = getVariables().first().compareTo(otherVar);
		if (firstDiff != 0)
			return firstDiff;
		else
			if (reference instanceof Reference)
				return 1;
			else
				return getVariables().last().compareTo(reference.getVariables().last());
            } else if(reference instanceof ReferenceOperation){
                ReferenceOperation ref = ((ReferenceOperation)reference);
                if(!this.getLeftOperand().equals(ref.getLeftOperand())
                        || !this.getRightOperand().equals(ref.getRightOperand())){
                    return 1;
                }
            }
            return 0;
	}


    @Override
    public SortedSet<Variable> getVariables() {
        return vars.first().getWorkbook().getVariables();
    }
}