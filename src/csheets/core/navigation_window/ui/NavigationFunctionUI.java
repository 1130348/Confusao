/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.navigation_window.ui;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.navigation_window.NavigationFunctionController;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author Luis
 */
public class NavigationFunctionUI extends javax.swing.JDialog {

	private static UIController uiController;
	private NavigationFunctionController controller;
	private static NavigationFunctionUI dialog;

	/**
	 * This JDialog gives the user the option to choose and execute a function
	 * from a list.
	 *
	 * @param parent The parent of this JDialog.
	 * @param modal The modality of this JDialog. Currently set to false by
	 * default.
	 * @param controller
	 */
	private NavigationFunctionUI() {
		setTitle("Description of the current Cleansheets");
		setModal(true);
		initComponents();

		controller = new NavigationFunctionController();

		Spreadsheet currentSpreadSheet = uiController.getActiveSpreadsheet();
		Workbook workbook = currentSpreadSheet.getWorkbook();
		int tamanho = workbook.getSpreadsheetCount();
		labelSheetCountLeft.setVisible(true);
		if (tamanho == 1) {
			jTextField1.setEditable(false);
			jTextField1.setText(workbook.getSpreadsheet(0).getTitle());
			rowCountSheet1.setText(Integer.toString(workbook.getSpreadsheet(0).
				getRowCount()));
			columnCountSheet1.setText(Integer.toString(workbook.
				getSpreadsheet(0).getColumnCount()));

			jTextField2.setEditable(false);
			jTextField2.setText("--Doesnt Exist--");
			rowCountSheet2.setEditable(false);
			columnCountSheet2.setEditable(false);

			jTextField3.setEditable(false);
			jTextField3.setText("--Doesnt Exist--");
			rowCountSheet3.setEditable(false);
			columnCountSheet3.setEditable(false);

			rowCountSheet1.setEditable(false);
			rowCountSheet2.setEditable(false);
			rowCountSheet3.setEditable(false);
			columnCountSheet1.setEditable(false);
			columnCountSheet2.setEditable(false);
			columnCountSheet3.setEditable(false);
		} else if (tamanho == 2) {
			jTextField1.setEditable(false);
			jTextField1.setText(workbook.getSpreadsheet(0).getTitle());
			rowCountSheet1.setText(Integer.toString(workbook.getSpreadsheet(0).
				getRowCount()));
			columnCountSheet1.setText(Integer.toString(workbook.
				getSpreadsheet(0).getColumnCount()));

			jTextField2.setEditable(false);
			jTextField2.setText(workbook.getSpreadsheet(1).getTitle());
			rowCountSheet2.setText(Integer.toString(workbook.getSpreadsheet(1).
				getRowCount()));
			columnCountSheet2.setText(Integer.toString(workbook.
				getSpreadsheet(1).getColumnCount()));

			jTextField3.setEditable(false);
			jTextField3.setText("--Doesnt Exist--");
			rowCountSheet3.setEditable(false);
			columnCountSheet3.setEditable(false);

			rowCountSheet1.setEditable(false);
			rowCountSheet2.setEditable(false);
			rowCountSheet3.setEditable(false);
			columnCountSheet1.setEditable(false);
			columnCountSheet2.setEditable(false);
			columnCountSheet3.setEditable(false);
		} else if (tamanho == 3) {
			jTextField1.setEditable(false);
			jTextField1.setText(workbook.getSpreadsheet(0).getTitle());
			rowCountSheet1.setText(Integer.toString(workbook.getSpreadsheet(0).
				getRowCount()));
			columnCountSheet1.setText(Integer.toString(workbook.
				getSpreadsheet(0).getColumnCount()));

			jTextField2.setEditable(false);
			jTextField2.setText(workbook.getSpreadsheet(1).getTitle());
			rowCountSheet2.setText(Integer.toString(workbook.getSpreadsheet(1).
				getRowCount()));
			columnCountSheet2.setText(Integer.toString(workbook.
				getSpreadsheet(1).getColumnCount()));

			jTextField3.setEditable(false);
			jTextField3.setText(workbook.getSpreadsheet(2).getTitle());
			rowCountSheet3.setText(Integer.toString(workbook.getSpreadsheet(2).
				getRowCount()));
			columnCountSheet3.setText(Integer.toString(workbook.
				getSpreadsheet(2).getColumnCount()));

			rowCountSheet1.setEditable(false);
			rowCountSheet2.setEditable(false);
			rowCountSheet3.setEditable(false);
			columnCountSheet1.setEditable(false);
			columnCountSheet2.setEditable(false);
			columnCountSheet3.setEditable(false);
		} else {
			jTextField1.setEditable(false);
			jTextField1.setText(workbook.getSpreadsheet(0).getTitle());
			rowCountSheet1.setText(Integer.toString(workbook.getSpreadsheet(0).
				getRowCount()));
			columnCountSheet1.setText(Integer.toString(workbook.
				getSpreadsheet(0).getColumnCount()));

			jTextField2.setEditable(false);
			jTextField2.setText(workbook.getSpreadsheet(1).getTitle());
			rowCountSheet2.setText(Integer.toString(workbook.getSpreadsheet(1).
				getRowCount()));
			columnCountSheet2.setText(Integer.toString(workbook.
				getSpreadsheet(1).getColumnCount()));

			jTextField3.setEditable(false);
			jTextField3.setText(workbook.getSpreadsheet(2).getTitle());
			rowCountSheet3.setText(Integer.toString(workbook.getSpreadsheet(2).
				getRowCount()));
			columnCountSheet3.setText(Integer.toString(workbook.
				getSpreadsheet(2).getColumnCount()));

			int tamanhoQueSobra = workbook.getSpreadsheetCount() - 3;
			String tamanhoQueSobraString = Integer.toString(tamanhoQueSobra);
			String stringFinal = "There still exists more " + tamanhoQueSobraString + " sheets!";
			labelSheetCountLeft.setText(stringFinal);
			labelSheetCountLeft.setVisible(true);

			rowCountSheet1.setEditable(false);
			rowCountSheet2.setEditable(false);
			rowCountSheet3.setEditable(false);
			columnCountSheet1.setEditable(false);
			columnCountSheet2.setEditable(false);
			columnCountSheet3.setEditable(false);

		}

		setLocationRelativeTo(null);
	}

	public static NavigationFunctionUI getInstance(
		UIController controller) {
		uiController = controller;
		if (dialog == null) {
			dialog = new NavigationFunctionUI();
		}

		dialog.setModal(false);
		return dialog;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelPrincipal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        columnCountSheet1 = new javax.swing.JTextField();
        rowCountSheet2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rowCountSheet1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        columnCountSheet2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rowCountSheet3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        columnCountSheet3 = new javax.swing.JTextField();
        labelSheetCountLeft = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Navigation Window");
        setIconImages(null);
        setModal(true);
        setResizable(false);

        labelPrincipal.setText("Description of the Current CleanSheet:");

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Name of Sheet 2:");

        jLabel2.setText("Name of Sheet 3:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Name of Sheet 1:");

        jLabel4.setText("Row count:");

        jLabel5.setText("Column count:");

        jLabel6.setText("Row count:");

        rowCountSheet1.setToolTipText("");

        jLabel7.setText("Column count:");

        jLabel8.setText("Row count:");

        jLabel9.setText("Column count:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSheetCountLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPrincipal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(rowCountSheet1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(columnCountSheet1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(rowCountSheet2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(columnCountSheet2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(rowCountSheet3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(columnCountSheet3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(columnCountSheet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rowCountSheet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rowCountSheet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(columnCountSheet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rowCountSheet3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(columnCountSheet3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(labelSheetCountLeft))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField columnCountSheet1;
    private javax.swing.JTextField columnCountSheet2;
    private javax.swing.JTextField columnCountSheet3;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel labelPrincipal;
    private javax.swing.JLabel labelSheetCountLeft;
    private javax.swing.JTextField rowCountSheet1;
    private javax.swing.JTextField rowCountSheet2;
    private javax.swing.JTextField rowCountSheet3;
    // End of variables declaration//GEN-END:variables
}
