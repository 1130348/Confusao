/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.import_export_text;

import csheets.CleanSheets;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Carlos Silva <1130664@isep.ipp.pt>
 */
public class ImportExportController {

    private UIController uiController;

    public ImportExportController(UIController uiController) {
        this.uiController = uiController;
    }

    public void importFile(CleanSheets app, File[] files, String separator, int header, int includeHeader) throws FileNotFoundException {
        Thread th = new Thread(new CustomImportation(app, uiController, files, separator, header, includeHeader));
        th.start();
    }

    public void exportFile(CleanSheets app, String fileName, String separator, int header, int includeHeader) throws FileNotFoundException {
        Thread th = new Thread(new CustomExportation(app, uiController, fileName, separator, header, includeHeader));
        th.start();
    }

}
