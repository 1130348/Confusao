/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.import_export_text.ui;

import csheets.CleanSheets;
import csheets.ext.import_export_text.ImportExportController;
import csheets.ext.startsharing.StartSharingController;
import csheets.ui.FileChooser;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Carlos Silva <1130664@isep.ipp.pt>
 */
public class ImportAction extends BaseAction{

   /**
     * The user interface controller
     */
    private UIController uiController;
    
    private CleanSheets app;

    public ImportAction(CleanSheets app, UIController uiController) {
        this.uiController = uiController;
        this.app = app;
    }

    @Override
    protected String getName() {
        return "Import...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImportDialog dialog = new ImportDialog(null,true, uiController, app);
        dialog.setVisible(true);
    }
    
}
