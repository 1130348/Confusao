/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.edit_variables;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.formula.Formula;
import csheets.core.formula.Reference;
import csheets.ext.edit_variables.ui.EditVariablesPanel;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

/**
 *
 * @author Antonio Pinheiro
 */
public class EditVariablesController {
    
    private final UIController uicontroller;
    private final EditVariablesPanel panel;
    
    public EditVariablesController (UIController uicontroller, EditVariablesPanel  panel)
    {
        this.uicontroller=uicontroller;
        this.panel=panel;
    }
    
    public List<Address> getAddressVariable(String var)
    {
                 Spreadsheet spreadsheet = uicontroller.getActiveSpreadsheet();
        
                 int row = spreadsheet.getRowCount();
                 int column = spreadsheet.getColumnCount();
        
                 List<Address> listTmp = new ArrayList<>();
                for (int i = 0; i <= row; i++) 
                {
                  for (int j = 0; j <= column; j++) 
                  {
                    Formula f = spreadsheet.getCell(j,i).getFormula();
                    if(f!=null)
                    {
                        SortedSet<Reference> s = f.getReferences();
                        for (Reference s1 : s) {
                            if(s1.getVariables().first().getName().equals(var))
                            {
                                listTmp.add(spreadsheet.getCell(j,i).getAddress());
                            }
                        }
                    }
                  }
                }   
                return listTmp;
    }
    
    /**
	 * Will call the class Listener that will implement cell listeners. If the
	 * content of cells were changed the variable ModicationOnCells of
	 * uiController will be setted to true and then the thread will export the
	 * cells to the file.
	 */
	public void modifications() {
		// Collums A -> AZ
		for (int i = 0; i < 52; i++) {
			// Lines 1 -> 128
			for (int j = 0; j < 128; j++) {
				Cell c = uicontroller.getActiveSpreadsheet().getCell(i, j);
				// put a listener on each cell to know if the cells were changed
				c.addCellListener(new CellListener() {

					@Override
					public void valueChanged(Cell cell) {
					}

					@Override
					public void contentChanged(Cell cell) {
					}

					@Override
					public void dependentsChanged(Cell cell) {
					}

					@Override
					public void cellCleared(Cell cell) {
					}

					@Override
					public void cellCopied(Cell cell, Cell source) {
					}

                                    @Override
                                    public void formulaChanged() {
                                        panel.update();
                                    }
				});
			}
		}
	}
    
    
}
