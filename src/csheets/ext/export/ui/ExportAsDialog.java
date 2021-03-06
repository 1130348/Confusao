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
import csheets.ext.importXML.XMLTag;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import javax.swing.JFileChooser;
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
	private String[] strings = new String[2];

	/**
	 *
	 * @param object
	 * @param b
	 * @param uiController
	 * @param app
	 */
	ExportAsDialog(java.awt.Frame parent, boolean modal,
				   UIController uiController, CleanSheets app,
				   Cell[][] selectedCells) {
		super(parent, "Export Wizard", modal);
		this.uiController = uiController;
		this.app = app;
		this.ieController = new ExportController(uiController);
		this.jChooser = new JFileChooser();
		this.selectedCells = selectedCells;
		strings[0] = "Cleanshets";
		strings[1] = "Cell";
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

        Cancel.setText("Close");
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
                .addContainerGap(63, Short.MAX_VALUE))
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
		XMLTags window = new XMLTags(this, true);
		window.setVisible(true);
		// change boolean tags to true or false
    }//GEN-LAST:event_SelectTagsActionPerformed

    private void ExportAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportAsActionPerformed
		//janela de escolha
		// get selected cells
		Workbook workbook = uiController.getActiveWorkbook();
		File file = null;

		String xmldesc = "XML File";

		jChooser.setAcceptAllFileFilterUsed(false);
		jChooser.setMultiSelectionEnabled(false);
		jChooser.setFileFilter(new FileNameExtensionFilter(xmldesc, ".xml"));

		boolean promptForFile = true;
		while (promptForFile) {

			if (jChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				String expType = getFileExtension();
				ieController.newProcess(expType);
				XMLTag.getInstance().setCellTag(strings[1]);
				file = ieController.export(tags, selectedCells, jChooser.
										   getSelectedFile().getAbsolutePath(), strings);
			}

			if (file != null) {

				promptForFile = false;
			}
		}
		dispose();
    }//GEN-LAST:event_ExportAsActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
		dispose();
    }//GEN-LAST:event_CancelActionPerformed

	public void setTags(boolean tag, String[] strings) {
		this.tags = tag;
		this.strings = strings;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton ExportAs;
    private javax.swing.JButton SelectTags;
    // End of variables declaration//GEN-END:variables

	private String getFileExtension() {
		FileNameExtensionFilter filenameFilter = (FileNameExtensionFilter) jChooser.
			getFileFilter();

		if (filenameFilter instanceof FileNameExtensionFilter) {
			String[] extensions = ((FileNameExtensionFilter) filenameFilter).
				getExtensions();
			return extensions[0];

		}
		return null;
	}
}
