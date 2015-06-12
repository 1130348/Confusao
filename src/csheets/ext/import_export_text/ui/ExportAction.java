/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.import_export_text.ui;

import csheets.CleanSheets;
import csheets.ext.import_export_text.ImportExportController;
import csheets.ui.FileChooser;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Silva <1130664@isep.ipp.pt>
 */
public class ExportAction extends BaseAction{
    
    private UIController uiController;
    private CleanSheets app;

    public ExportAction(CleanSheets app, UIController uiController) {
        this.uiController = uiController;
        this.app = app;
    }

    @Override
    protected String getName() {
        return "Export...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       ExportDialog dialog = new ExportDialog(null, true, uiController, app);
       dialog.setVisible(true);
    }
    
    
    
}
