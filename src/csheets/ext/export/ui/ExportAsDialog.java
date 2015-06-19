/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.export.ui;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Workbook;
import csheets.ext.export.strategy.ExportController;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Luís
 */
public class ExportAsDialog extends javax.swing.JDialog {
    
    private UIController uiController;
    private CleanSheets app;
    private ExportController ieController;
    private boolean tags = false;
    private JFileChooser jChooser;
    private SpreadsheetTable table;
    private Cell[][] selectedCells;

    /**
     * 
     * @param object
     * @param b
     * @param uiController
     * @param app 
     */
    ExportAsDialog(java.awt.Frame parent, boolean modal, UIController uiController, CleanSheets app,
                                                                                     Cell[][] selectedCells) {
        super(parent, "Export Wizard", modal);
        this.uiController = uiController;
        this.app = app;
        this.ieController = new ExportController(uiController);
        this.jChooser = new JFileChooser();
        this.selectedCells = selectedCells;
        initComponents();
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExportAs = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        SelectTags = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ExportAs.setText("Export As");
        ExportAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportAsActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        SelectTags.setText("Select Tags");
        SelectTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectTagsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(ExportAs)
                        .addGap(93, 93, 93)
                        .addComponent(Cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(SelectTags)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SelectTags)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExportAs)
                    .addComponent(Cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectTagsActionPerformed
        // TODO add your handling code here:
        //new window, choose all tags
        // change boolean tags to true or false
    }//GEN-LAST:event_SelectTagsActionPerformed

    private void ExportAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportAsActionPerformed
        //janela de escolha
       // get selected cells
        Workbook workbook = uiController.getActiveWorkbook();
        File oldFile = app.getFile(workbook);
        File file = null;

        String xmldesc = "XML File";
        
       
        jChooser.setAcceptAllFileFilterUsed(false);
        jChooser.setMultiSelectionEnabled(false);
        jChooser.setFileFilter(new FileNameExtensionFilter(xmldesc,".xml"));
       
		boolean promptForFile = true;
		while (promptForFile) {
			
                    if (jChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                            String expType = getFileExtension();
                            ieController.newProcess(expType);
                            file = ieController.export(tags,selectedCells,jChooser.getSelectedFile().getName());
                    }
                    
			if (file != null) {
				if (file.exists() && (oldFile == null || !file.equals(oldFile))) {
					// Prompt to overwrite the file
					int option = JOptionPane.showConfirmDialog(
						null,
						"The chosen file " + file + " already exists\n" +
						"Do you want to overwrite it?",
						"Replace existing file?",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE
					);

					if (option == JOptionPane.YES_OPTION)
						promptForFile = false;
					else if (option == JOptionPane.CANCEL_OPTION
						  || option == JOptionPane.CLOSED_OPTION)
						return;
				} else
					promptForFile = false;
			} else
				return;
		}
            
    }//GEN-LAST:event_ExportAsActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        dispose();
    }//GEN-LAST:event_CancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton ExportAs;
    private javax.swing.JButton SelectTags;
    // End of variables declaration//GEN-END:variables

    private String getFileExtension() {
        FileNameExtensionFilter filenameFilter = (FileNameExtensionFilter)jChooser.getFileFilter();
			
				if (filenameFilter instanceof FileNameExtensionFilter) {
					String[] extensions = ((FileNameExtensionFilter)filenameFilter).getExtensions();
                                        return extensions[0];
                                        
			}
                        return null;
    }
}
