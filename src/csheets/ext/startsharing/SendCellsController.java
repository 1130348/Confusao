/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import csheets.core.Cell;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 */
public class SendCellsController {

    public SendCellsController() {
    }

    public void sendCells(Cell[][] selectedCells) {
        List<Cell> cells = new ArrayList<Cell>();
        for (int i = 0; i < selectedCells.length; i++) {
            for (int j = 0; j < selectedCells[i].length; j++) {
                cells.add(selectedCells[i][j]);
            }
        }
        NetworkService.sendCellsContent(cells);
    }

    void sendCell(Cell cell) {
        NetworkService.sendCellContent(cell);
    }
}
