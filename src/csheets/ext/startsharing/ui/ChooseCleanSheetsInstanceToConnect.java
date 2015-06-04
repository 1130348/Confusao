/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing.ui;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class ChooseCleanSheetsInstanceToConnect extends javax.swing.JDialog {

    private final ArrayList<String> listOfAvailableCleanSheetsInstances = new ArrayList<String>();
    private final ArrayList<Boolean> connectDisconnectToggleButtonClick = new ArrayList<Boolean>();

    /**
     * This JDialog gives the user the option to define its connection port and
     * to connect to another instance of CleanSheets.
     *
     * @param parent The parent of this JDialog.
     * @param modal The modality of this JDialog. Currently set to false by
     * default.
     */
    public ChooseCleanSheetsInstanceToConnect(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        retrieveAvailableCleanSheetsInstances();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connectDisconnectToggleButton = new javax.swing.JToggleButton();
        changeConnectionPortLabel = new javax.swing.JLabel();
        chooseCleanSheetsInstanceToConnectSeparator = new javax.swing.JSeparator();
        connectionPortSpinner = new javax.swing.JSpinner();
        availableCleanSheetsInstancesScrollPane = new javax.swing.JScrollPane();
        availableCleanSheetsInstancesList = new javax.swing.JList();
        cancelButton = new javax.swing.JButton();
        availableCleanSheetsInstancesOnLANLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connect");
        setIconImages(null);
        setModal(true);
        setResizable(false);

        connectDisconnectToggleButton.setText("Connect");
        connectDisconnectToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectDisconnectToggleButtonActionPerformed(evt);
            }
        });

        changeConnectionPortLabel.setText("Change connection port (max. 65535):");

        connectionPortSpinner.setModel(new javax.swing.SpinnerNumberModel(1024, 1024, 65535, 1));

        availableCleanSheetsInstancesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = listOfAvailableCleanSheetsInstances.toArray(new String[listOfAvailableCleanSheetsInstances.size()]);
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        availableCleanSheetsInstancesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableCleanSheetsInstancesListMouseClicked(evt);
            }
        });
        availableCleanSheetsInstancesScrollPane.setViewportView(availableCleanSheetsInstancesList);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        availableCleanSheetsInstancesOnLANLabel.setText("Available CleanSheets instances on LAN:");

        refreshButton.setText("Refresh List");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(availableCleanSheetsInstancesScrollPane)
                    .addComponent(chooseCleanSheetsInstanceToConnectSeparator)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(availableCleanSheetsInstancesOnLANLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeConnectionPortLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(connectionPortSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(connectDisconnectToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeConnectionPortLabel)
                    .addComponent(connectionPortSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseCleanSheetsInstanceToConnectSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(availableCleanSheetsInstancesOnLANLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(availableCleanSheetsInstancesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(connectDisconnectToggleButton)
                    .addComponent(refreshButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method retrieves a list of all the available CleanSheets instances
     * on the same LAN.
     */
    private void retrieveAvailableCleanSheetsInstances() {
        //O código seguinte serve como bootsrapper para testar a interface. Será
        //posteriormente substituído pela pesquisa broadcast em UDP.
        listOfAvailableCleanSheetsInstances.add("Carlos Silva");
        listOfAvailableCleanSheetsInstances.add("João Monteiro");
        listOfAvailableCleanSheetsInstances.add("João Paiva");
        listOfAvailableCleanSheetsInstances.add("Paulo Pereira");
        listOfAvailableCleanSheetsInstances.add("Sérgio Gomes");
        //Código para substituição termina aqui.

        int i;
        for (i = 0; i < listOfAvailableCleanSheetsInstances.size(); i++) {
            connectDisconnectToggleButtonClick.add(true);
        }
    }

    /**
     * This method disposes the window when the cancel button is pressed.
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * This method alters the connect/disconnect toggle button's text with the
     * Strings "Connect" and "Disconnect" if pressed.
     */
    private void connectDisconnectToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectDisconnectToggleButtonActionPerformed
        if (availableCleanSheetsInstancesList.getSelectedValue() == null) {
            connectDisconnectToggleButton.setSelected(false);
            JOptionPane.showMessageDialog(
                    rootPane,
                    "You have to select one or more instances of CleanSheets from the list!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        } else {
            int index = availableCleanSheetsInstancesList.getSelectedIndex();
            if (connectDisconnectToggleButtonClick.get(index)) {
                connectDisconnectToggleButtonClick.set(index, false);
                connectDisconnectToggleButton.setText("Disconnect");
            } else {
                connectDisconnectToggleButtonClick.set(index, true);
                connectDisconnectToggleButton.setText("Connect");
            }
        }
    }//GEN-LAST:event_connectDisconnectToggleButtonActionPerformed

    /**
     * This method refreshes the connect/disconnect toggle button according to
     * the CleanSheets instance selected.
     */
    private void availableCleanSheetsInstancesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableCleanSheetsInstancesListMouseClicked
        availableCleanSheetsInstancesList.updateUI();
        int index = availableCleanSheetsInstancesList.getSelectedIndex();
        if ("Disconnect".equals(connectDisconnectToggleButton.getText()) && connectDisconnectToggleButtonClick.get(index)) {
            connectDisconnectToggleButton.setSelected(false);
            connectDisconnectToggleButton.setText("Connect");
        } else if ("Connect".equals(connectDisconnectToggleButton.getText()) && !connectDisconnectToggleButtonClick.get(index)) {
            connectDisconnectToggleButton.setSelected(true);
            connectDisconnectToggleButton.setText("Disconnect");
        }
    }//GEN-LAST:event_availableCleanSheetsInstancesListMouseClicked

    /**
     * This button calls a method that retrieves a list of all the available
     * CleanSheets instances on the same LAN.
     */
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        retrieveAvailableCleanSheetsInstances();
//        JOptionPane.showMessageDialog(
//                rootPane,
//                "The list has been successfully updated!",
//                "Info",
//                JOptionPane.INFORMATION_MESSAGE
//        );
    }//GEN-LAST:event_refreshButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList availableCleanSheetsInstancesList;
    private javax.swing.JLabel availableCleanSheetsInstancesOnLANLabel;
    private javax.swing.JScrollPane availableCleanSheetsInstancesScrollPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel changeConnectionPortLabel;
    private javax.swing.JSeparator chooseCleanSheetsInstanceToConnectSeparator;
    private javax.swing.JToggleButton connectDisconnectToggleButton;
    private javax.swing.JSpinner connectionPortSpinner;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
