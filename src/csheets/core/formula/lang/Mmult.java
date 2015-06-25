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
import csheets.ui.ctrl.UIController;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class Mmult implements Function {

	/**
	 * The only (but repeatable) parameter: a numeric term
	 */
	public static final FunctionParameter[] parameters = new FunctionParameter[]{
		new FunctionParameter(Value.Type.NUMERIC, "Term", false,
							  "A number to be included in the matrix")
	};

	@Override
	public String getIdentifier() {
		return "MMULT";
	}

	@Override
	public Value applyTo(Expression[] args) {
		Value[][] sum = null;
		Value ret = new Value("#ERROR!");
		try {
			if (args.length == 2) {
				Value leftValue = args[0].evaluate();
				Value rightValue = args[1].evaluate();
				if (leftValue.getType() == Value.Type.MATRIX
					&& rightValue.getType() == Value.Type.MATRIX) {
					Value[][] matrix1 = leftValue.toMatrix();
					Value[][] matrix2 = rightValue.toMatrix();
					sum = MatrixMathematics.multiply(matrix1, matrix2);
					ret = new Value(sum);
				} else {
					JOptionPane.
						showMessageDialog(null, "Arguments are incorrect!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (IllegalDimensionException ex) {
			JOptionPane.
				showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalValueTypeException ex) {
			JOptionPane.
				showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return ret;
	}

	@Override
	public FunctionParameter[] getParameters() {
		return parameters;
	}

	@Override
	public boolean isVarArg() {
		return true;
	}

	@Override
	public void setUIController(UIController ui) {
	}

}
