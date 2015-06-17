/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is based on code of Ata Amini. His code can be consult on page
 * http://www.codeproject.com/Articles/405128/Matrix-operations-in-Java.
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class MatrixMathematics {

    /**
     * This class a matrix utility class and cannot be instantiated.
     */
    private MatrixMathematics() {
    }

    /**
     * Transpose of a matrix - Swap the columns with rows
     *
     * @param matrix
     * @return
     */
    public static Value[][] transpose(Value[][] matrix) {
        Value[][] transposedMatrix = new Value[matrix[0].length][matrix.length];
        for (int i = 0; i < transposedMatrix.length; i++) {
            for (int j = 0; j < transposedMatrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    /**
     * Inverse of a matrix - A-1 * A = I where I is the identity matrix A matrix
     * that have inverse is called non-singular or invertible. If the matrix
     * does not have inverse it is called singular. For a singular matrix the
     * values of the inverted matrix are either NAN or Infinity Only square
     * matrices have inverse and the following method will throw exception if
     * the matrix is not square.
     *
     * @param matrix
     * @return
     * @throws NoSquareException
     */
    public static Value[][] inverse(Value[][] matrix) throws NoSquareException, IllegalValueTypeException {
        if (matrix[0].length != matrix.length) {
            throw new NoSquareException("Matrix need to be square.");
        }
        Value[][] tempMatrix = transpose(cofactor(matrix));
        double constant = (1.0 / determinant(matrix).toDouble());
        return multiplyByConstant(tempMatrix, constant);
    }

    /**
     * Determinant of a square matrix The following function find the
     * determinant in a recursively.
     *
     * @param matrix
     * @return
     * @throws NoSquareException
     */
    public static Value determinant(Value[][] matrix) throws NoSquareException, IllegalValueTypeException {
        if (matrix[0].length == 1 && matrix.length == 1) {
            return matrix[0][0];
        }

        if (matrix[0].length == 2 && matrix.length == 2) {
            return new Value((matrix[0][0].toDouble() * matrix[1][1].toDouble()) - (matrix[0][1].toDouble() * matrix[1][0].toDouble()));
        }
        double sum = 0.0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum += changeSign(i) * matrix[0][1].toDouble() * determinant(createSubMatrix(matrix, 0, i)).toDouble();
        }
        return new Value(sum);
    }

    /**
     * Determine the sign; i.e. even numbers have sign + and odds -
     *
     * @param i
     * @return
     */
    private static int changeSign(int i) {
        if (i % 2 == 0) {
            return 1;
        }
        return -1;
    }

    /**
     * Creates a submatrix excluding the given row and column
     *
     * @param matrix
     * @param excluding_row
     * @param excluding_col
     * @return
     */
    public static Value[][] createSubMatrix(Value[][] matrix, int excluding_row, int excluding_col) {
        Value[][] mat = new Value[matrix.length - 1][matrix[0].length - 1];
        int r = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (i == excluding_row) {
                continue;
            }
            r++;
            int c = -1;
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == excluding_col) {
                    continue;
                }
                c++;
                mat[r][c] = matrix[i][j];
            }
        }
        return mat;
    }

    /**
     * The cofactor of a matrix
     *
     * @param matrix
     * @return
     * @throws NoSquareException
     */
    public static Value[][] cofactor(Value[][] matrix) throws NoSquareException, IllegalValueTypeException {
        Value[][] mat = new Value[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                mat[i][j] = new Value(changeSign(i) * changeSign(j) * determinant(createSubMatrix(matrix, i, j)).toDouble());
            }
        }
        return mat;
    }

    /**
     * Multiply two matrices
     *
     * @param matrix1
     * @param matrix2
     * @return
     */
    public static Value[][] multiply(Value[][] matrix1, Value[][] matrix2) throws IllegalDimensionException, IllegalValueTypeException {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalDimensionException("The numbers of columns of the first"
                    + " matrix should be the same numbers of the rows of second matrix!");
        }
        Value[][] multipliedMatrix = new Value[matrix1.length][matrix2[0].length];
        for (int i = 0; i < multipliedMatrix.length; i++) {
            for (int j = 0; j < multipliedMatrix[0].length; j++) {
                double sum = 0.0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    sum += matrix1[i][k].toDouble() * matrix2[k][j].toDouble();
                }
                multipliedMatrix[i][j] = new Value(sum);
            }
        }
        return multipliedMatrix;
    }

    public static Value[][] multiplyByConstant(Value[][] matrix, double constant) throws IllegalValueTypeException {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Value value = new Value((matrix[i][j].toDouble() * constant));
                matrix[i][j] = value;
            }
        }
        return matrix;
    }
}
