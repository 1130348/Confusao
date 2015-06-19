/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.export.strategy;

import csheets.core.Cell;
import java.io.File;

/**
 *
 * @author Luis Lopes <1130752@isep.ipp.pt>
 */
public class ExportProcess {
    
    ExportStrategy strategy;
    
    public ExportProcess(String type) {
		strategy = ExportStrategyFactory.getInstance().getExportStrategy(type);
	}
    
    public File export(boolean tags, Cell[][] cells,String filename,String[]strings) {	
        return strategy.export(this,cells,tags,filename,strings);
	}
}
