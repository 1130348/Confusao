/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import csheets.core.Cell;
import csheets.core.CellListener;

/**
 *
 * @author i130348
 */
public class AutomaticCellListener implements CellListener{

    @Override
    public void valueChanged(Cell cell) {
        System.out.println("ola");
    }

    @Override
    public void contentChanged(Cell cell) {
        NetworkService.sendCell(cell);
        System.out.println("ola2");
    }

    @Override
    public void dependentsChanged(Cell cell) {
        System.out.println("ola3");
    }

    @Override
    public void cellCleared(Cell cell) {
       System.out.println("ola4");
    }

    @Override
    public void cellCopied(Cell cell, Cell source) {
        System.out.println("ola5");
    }
    
}
