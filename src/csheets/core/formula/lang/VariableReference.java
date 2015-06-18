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
import csheets.core.Workbook;
import csheets.core.formula.Reference;
import csheets.core.formula.util.ExpressionVisitor;
import csheets.core.formula.util.ExpressionVisitorException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * A reference to a cell in a spreadsheet.
 *
 * @author Einar Pehrson
 */
public class VariableReference implements Reference {

	/**
	 * The unique version identifier used for serialization
	 */
	private static final long serialVersionUID = -6600693551615086693L;

	/**
	 * The regular expression pattern used to match cell references:
	 * (\\$??)([a-zA-Z]+)(\\$??)(\\d+)$")
	 */
	private static final Pattern PATTERN = Pattern.compile(
		"@[a-zA-Z]([a-zA-Z]|[1-9])*");

	/**
	 * The string used to match the use of absolute references
	 */
	private static final String ABSOLUTE_OPERATOR = "@";

	/**
	 * The cell to which the reference points
	 */
	private Variable variable;

	private String name;

	private Workbook workbook;

	/**
	 * Creates a new Variable reference to the given address, using the given
	 * reference mode.
	 *
	 * @param variable
	 */
	public VariableReference(Variable variable) {
		this.variable = variable;
		this.name = variable.getName();
		this.workbook = variable.getWorkbook();
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public Value evaluate() {
		return variable.getValue();
	}

	public Object accept(ExpressionVisitor visitor) throws ExpressionVisitorException {
		return visitor.visitReference(this);
	}

	/**
	 * Returns the Variable to which the reference points.
	 *
	 * @return the Variable to which the reference points
	 */
	public Variable getVariable() {
		return variable;
	}

	/**
	 *
	 * It gets the variables cells
	 *
	 */
	@Override
	public SortedSet<Variable> getVariables() {
		SortedSet<Variable> vars = new TreeSet<Variable>();
		vars.add(variable);
		return vars;
	}

	/**
	 * Compares the Variable reference with the given Variable reference for
	 * order.
	 *
	 * @param reference the reference to be compared
	 * @return a negative integer, zero, or a positive integer as this object is
	 * less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Reference reference) {
		Variable otherVariable = reference.getVariables().first();
		int firstDiff = variable.compareTo(otherVariable);
		if (firstDiff != 0) {
			return firstDiff;
		} else {
			if (reference instanceof Reference) {
				// Handle reference modes?
				return -1;
			} else {
				return -1;
			}
		}
	}

	/**
	 * Returns a string representation of the name of the Variable
	 *
	 * @return a string representation of the address of the Variable reference
	 */
	@Override
	public String toString() {
		// Converts column

		return variable.getName();
	}

	@Override
	public SortedSet<Cell> getCells() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
