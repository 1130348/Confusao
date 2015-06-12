/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks;

import csheets.CleanSheets;
import csheets.core.Workbook;
import csheets.ui.FileChooser;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class OpenWorkbook {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    public OpenWorkbook(CleanSheets app, UIController uiController) {

        this.uiController = uiController;

    }
    
    private void openWorkbook(Path path){
        File file = path.toFile();
        if (file != null) {
           // Workbook workbook = app.getWorkbook(file);;
          // uiController.setActiveWorkbook(workbook);
        }
    
    }
    

}
