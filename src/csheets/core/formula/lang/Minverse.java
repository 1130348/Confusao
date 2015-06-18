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
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class Minverse implements Function {

    /**
     * The only (but repeatable) parameter: a numeric term
     */
    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.NUMERIC, "Term", false,
        "A number to be included in the matrix")
    };

    public Minverse() {
    }

    @Override
    public String getIdentifier() {
        return "MINVERSE";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        Value ret = new Value("#ERROR");
        Value value = args[0].evaluate();
        if (value.getType() == Value.Type.MATRIX
                && args.length == 1) {
            Value[][] matrix1 = value.toMatrix();
            try {
                Value[][] sum = MatrixMathematics.inverse(matrix1);
                ret = new Value(sum);
            } catch (NoSquareException | MatrixIsNotInvertibleException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            throw new IllegalValueTypeException(args[0].evaluate(), Value.Type.NUMERIC);
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

}
