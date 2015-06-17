/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class NoSquareException extends Exception {

    NoSquareException(String matrix_need_to_be_square) {
        super(matrix_need_to_be_square);
    }
    
}
