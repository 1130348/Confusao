/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.Array;
import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.Variable;
import csheets.core.formula.Reference;
import csheets.core.formula.util.ExpressionVisitor;
import csheets.core.formula.util.ExpressionVisitorException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 *
 * @author Sergio
 */
public class ArrayReference implements Reference {

	/**
	 * The unique version identifier used for serialization
	 */
	private static final long serialVersionUID = -6700695451615096683L;

	/**
	 * The regular expression pattern used to match cell references:
	 * (\\$??)([a-zA-Z]+)(\\$??)(\\d+)$")
	 */
	private static final Pattern PATTERN = Pattern.compile(
		"@[a-zA-Z]([a-zA-Z]|[1-9])*\\[[1-9][0-9]*\\]");

	/**
	 * The string used to match the use of absolute references
	 */
	private static final String ABSOLUTE_OPERATOR = "@";

	/**
	 * The cell to which the reference points
	 */
	private Array array;

	private String name;

	private Vector<Value> positions;

	private int actualPosition;

	/**
	 * Creates a new Variable reference to the given address, using the given
	 * reference mode.
	 *
	 * @param array
	 */
	public ArrayReference(Array array) {
		this.array = array;
		this.name = array.getName();
		this.positions = array.getPositions();
		this.actualPosition = array.getActualPosition();

	}

	public Value evaluate() {
		return positions.get(actualPosition);
	}

	public Object accept(ExpressionVisitor visitor) throws ExpressionVisitorException {
		return visitor.visitReference(this);
	}

	/**
	 * Returns the Variable to which the reference points.
	 *
	 * @return the Variable to which the reference points
	 */
	public Array getArray() {
		return array;
	}

	/**
	 *
	 * It gets the variables cells
	 *
	 */
	@Override
	public SortedSet<Variable> getVariables() {
		SortedSet<Variable> vars = new TreeSet<Variable>();
		vars.add(array);
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
		int firstDiff = array.compareTo(otherVariable);
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

		return array.getName();
	}

	@Override
	public SortedSet<Cell> getCells() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
