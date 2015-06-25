/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Sort.ui;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DMMCA
 */
public class SortController {

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * User interface panel *
     */
    private final SortMenu sortPanel;
    private final ArrayList<String> cells = new ArrayList<>();
    private final ArrayList<Double> cellsI = new ArrayList<>();
    private final ArrayList cellsAll = new ArrayList();

    /**
     * Creates a new comment controller.
     *
     * @param uiController the user interface controller
     * @param sortPanel
     */
    public SortController(UIController uiController, SortMenu sortPanel) {
        this.uiController = uiController;
        this.sortPanel = sortPanel;
    }

    public ArrayList<String> getCells() {
        return cells;
    }

    public ArrayList getCellsAll() {
        return cellsAll;
    }

    public ArrayList<Double> getCellsI() {
        return cellsI;
    }

    /**
     *
     * @param typeOfSort
     * @param column
     */
    public void sortCells(int typeOfSort, int column) {
        cellsContent(column);
        sort(typeOfSort);
        fillSorted(column);
    }

    public void cellsContent(int column) {

        int col = column;

        if (col < 0) {
            col = uiController.getActiveCell().getAddress().getColumn();
        }
        
        int size = uiController.getActiveSpreadsheet().getColumn(col).length;
        String Content = "";
        for (int i = 0; i < size; i++) {
            Content = uiController.getActiveSpreadsheet().getCell(col, i).getContent();
            if (!"".equals(Content)) {
                // sees if content is numeric
                if (Content.matches("-?\\d+(\\,\\d+)?")) {
                        //adds to numeric

                    cellsI.add(Double.valueOf(Content.replace(",", ".")));
                } else {
                    cells.add(Content);
                }

            }
            uiController.getActiveSpreadsheet().getCell(col, i).clear();
        }

    }

    public void sort(int typeOfSort) {
        if (0 == typeOfSort) {
            Collections.sort(cells);
            Collections.sort(cellsI);
            for (Double x : cellsI) {
                cellsAll.add(x.toString().replace(".", ","));
            }
            //cellsAll.addAll(cellsI);
            cellsI.clear();
            cellsAll.addAll(cells);
            cells.clear();

        } else {
            Collections.sort(cells);
            Collections.reverse(cells);
            Collections.sort(cellsI);
            Collections.reverse(cellsI);

            //cellsAll.addAll(cellsI);
            cellsAll.addAll(cells);
            cells.clear();
            for (Double x : cellsI) {
                cellsAll.add(x.toString().replace(".", ","));
            }
            cellsI.clear();
        }

    }

    public void fillSorted(int column) {
        int col = column;
        int size = cellsAll.size();
        
        if (col < 0){
            col = uiController.getActiveCell().getAddress().getColumn();
        }
        
        for (int i = 0; i < size; i++) {
            try {
                uiController.getActiveSpreadsheet().getCell(col, i).setContent(cellsAll.get(i).toString());
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(SortController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cellsAll.clear();
    }
}
