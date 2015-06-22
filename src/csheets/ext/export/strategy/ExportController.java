/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.export.strategy;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.io.File;

/**
 *
 * @author Luis Lopes <1130752@isep.ipp.pt>
 */
public class ExportController {
    
    private UIController uiController;
    private ExportProcess ep;
    
    public ExportController(UIController uiController) {
        this.uiController=uiController;
    }
    
    public boolean newProcess(String type) {
		ep = new ExportProcess(type);
		return true;
	}
    
    public File export(boolean tags, Cell[][] cells, String filename,String[]strings) {
		File f =ep.export(tags, cells,filename,strings);
		return f;
	}
}
