/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.advanced_functions;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.lang.IllegalDimensionException;
import csheets.core.formula.lang.MatrixMathematics;
import csheets.core.formula.lang.NoSquareException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class AdvancedFunctionsTest {

    public AdvancedFunctionsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void makeSureMultiplyMatricesAreCorrect() throws IllegalDimensionException {
        Value[][] matrix1 = new Value[2][2];
        Value[][] matrix2 = new Value[2][2];
        Value[][] expresult = new Value[2][2];
        Value v1 = new Value(1);
        Value v2 = new Value(2);
        Value v3 = new Value(3);
        Value v4 = new Value(4);
        matrix1[0][0] = v1;
        matrix1[0][1] = v1;
        matrix1[1][0] = v1;
        matrix1[1][1] = v1;
        matrix2[0][0] = v2;
        matrix2[0][1] = v1;
        matrix2[1][0] = v2;
        matrix2[1][1] = v3;
        expresult[0][0] = v4;
        expresult[0][1] = v4;
        expresult[1][0] = v4;
        expresult[1][1] = v4;
        Value[][] result
                = MatrixMathematics.multiply(matrix1, matrix2);
        double[][] doubleResult = new double[2][2];
        double[][] doubleExpResult = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                try {
                    doubleExpResult[i][j] = expresult[i][j].toDouble();
                    doubleResult[i][j] = result[i][j].toDouble();
                } catch (IllegalValueTypeException ex) {
                    Logger.getLogger(AdvancedFunctionsTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        Assert.assertArrayEquals(doubleExpResult, doubleResult);

    }

    @Test
    public void makeSureInverseMatricesAreCorrect() {
        try {
            Value[][] matrix1 = new Value[2][2];
            Value[][] expresult = new Value[2][2];
            Value v1 = new Value(1);
            Value v2 = new Value(2);
            Value v3 = new Value(3);
            matrix1[0][0] = v3;
            matrix1[0][1] = v1;
            matrix1[1][0] = v1;
            matrix1[1][1] = v2;
            expresult[0][0] = new Value(0.4);
            expresult[0][1] = new Value(-0.2);
            expresult[1][0] = new Value(-0.2);
            expresult[1][1] = new Value(0.6);
            Value[][] result = MatrixMathematics.inverse(matrix1);
            double[][] doubleResult = new double[2][2];
            double[][] doubleExpResult = new double[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    try {
                        double exp = expresult[i][j].toDouble();
                        double res = result[i][j].toDouble();
                        exp = Double.parseDouble((String.format("%.4f", exp)).replaceAll(",", "."));
                        res = Double.parseDouble(String.format("%.4f", res).replaceAll(",", "."));
                        doubleExpResult[i][j] = exp;
                        doubleResult[i][j] = res;
                    } catch (IllegalValueTypeException ex) {
                        Logger.getLogger(AdvancedFunctionsTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            Assert.assertArrayEquals(doubleExpResult,
                    doubleResult);
        } catch (NoSquareException | IllegalValueTypeException ex) {
            Logger.getLogger(AdvancedFunctionsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test(expected = NoSquareException.class)
    public void matrixToInverseIsSquare() throws NoSquareException, IllegalValueTypeException {
        Value[][] matrix1 = new Value[3][2];
        Value v1 = new Value(1);
        Value v2 = new Value(2);
        Value v3 = new Value(3);
        matrix1[0][0] = v3;
        matrix1[0][1] = v1;
        matrix1[1][0] = v1;
        matrix1[1][1] = v2;
        matrix1[2][0] = v1;
        matrix1[2][1] = v2;
        Value[][] result = MatrixMathematics.inverse(matrix1);
    }

    @Test(expected = IllegalDimensionException.class)
    public void matricesToMultiplyNumberOfColumnsOfFirstIsEqualToNumberOfRowsOfSecond() throws IllegalDimensionException {
        Value[][] matrix1 = new Value[2][2];
        Value[][] matrix2 = new Value[3][2];
        Value v1 = new Value(1);
        Value v2 = new Value(2);
        Value v3 = new Value(3);
        matrix1[0][0] = v1;
        matrix1[0][1] = v1;
        matrix1[1][0] = v1;
        matrix1[1][1] = v1;
        matrix2[0][0] = v2;
        matrix2[0][1] = v1;
        matrix2[1][0] = v2;
        matrix2[1][1] = v3;
        matrix2[2][0] = v2;
        matrix2[2][1] = v3;
        MatrixMathematics.multiply(matrix1, matrix2);
    }
}
