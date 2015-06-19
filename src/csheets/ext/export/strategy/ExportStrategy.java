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
public interface ExportStrategy  {
    
    public File export(ExportProcess eProcess,Cell [][] cells,boolean tags,String filename);
}
