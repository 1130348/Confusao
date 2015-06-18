/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing.ui;

import csheets.ext.startsharing.AutomaticCellListener;
import csheets.ext.startsharing.StartSharingController;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class ChooseCleanSheetsInstanceToConnect extends javax.swing.JDialog {

    private static ChooseCleanSheetsInstanceToConnect instance;
    private boolean startStopSharingToggleButtonStatus = false;
    private final ArrayList<String> listOfAvailableCleanSheetsInstances = new ArrayList<String>();
    private final ArrayList<Boolean> connectDisconnectToggleButtonClick = new ArrayList<Boolean>();
    private StartSharingController controller;
    private static SendCellsAction sendCellAction;

    /**
     * This JDialog gives the user the option to define its connection port and
     * to connect to another instance of CleanSheets.
     *
     * @param parent The parent of this JDialog.
     * @param modal The modality of this JDialog. Currently set to false by
     * default.
     */
    private ChooseCleanSheetsInstanceToConnect(java.awt.Frame parent,
            boolean modal,
            StartSharingController controller,
            SendCellsAction action) {
        super(parent, modal);
        this.controller = controller;
        initComponents();
        availableCleanSheetsInstancesScrollPane.getVerticalScrollBar().
                setEnabled(false);
        availableCleanSheetsInstancesScrollPane.getVerticalScrollBar().
                setEnabled(false);
        availableCleanSheetsInstancesScrollPane.getViewport().setEnabled(false);
        ChooseCleanSheetsInstanceToConnect.sendCellAction = action;
    }

    public ChooseCleanSheetsInstanceToConnect() {
    }

    public static synchronized ChooseCleanSheetsInstanceToConnect getInstance(
            java.awt.Frame parent, boolean modal, StartSharingController controller,
            SendCellsAction action) {
        if (instance == null) {
            instance = new ChooseCleanSheetsInstanceToConnect(parent, modal, controller, action);
        }
        return instance;
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
        availableCleanSheetsInstancesOnLANLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        startStopSharingToggleButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Start Sharing");
        setIconImages(null);
        setModal(true);
        setResizable(false);

        connectDisconnectToggleButton.setText("Connect");
        connectDisconnectToggleButton.setEnabled(false);
        connectDisconnectToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectDisconnectToggleButtonActionPerformed(evt);
            }
        });

        changeConnectionPortLabel.setText("Select new connection port (max. 65535):");

        connectionPortSpinner.setModel(new javax.swing.SpinnerNumberModel(1026, 1026, 65535, 1));

        availableCleanSheetsInstancesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = listOfAvailableCleanSheetsInstances.toArray(new String[listOfAvailableCleanSheetsInstances.size()]);
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        availableCleanSheetsInstancesList.setEnabled(false);
        availableCleanSheetsInstancesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableCleanSheetsInstancesListMouseClicked(evt);
            }
        });
        availableCleanSheetsInstancesScrollPane.setViewportView(availableCleanSheetsInstancesList);

        availableCleanSheetsInstancesOnLANLabel.setText("Available CleanSheets instances on LAN:");

        refreshButton.setText("Refresh List");
        refreshButton.setEnabled(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        startStopSharingToggleButton.setText("Start Sharing");
        startStopSharingToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startStopSharingToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(availableCleanSheetsInstancesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(chooseCleanSheetsInstanceToConnectSeparator)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connectDisconnectToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(connectionPortSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startStopSharingToggleButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(availableCleanSheetsInstancesOnLANLabel)
                            .addComponent(changeConnectionPortLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(changeConnectionPortLabel)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectionPortSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startStopSharingToggleButton))
                .addGap(18, 18, 18)
                .addComponent(chooseCleanSheetsInstanceToConnectSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(availableCleanSheetsInstancesOnLANLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(availableCleanSheetsInstancesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
        try {
            listOfAvailableCleanSheetsInstances.clear();
            Map<InetAddress, Integer> activeInstances = controller.searchInstances();
            for (Map.Entry<InetAddress, Integer> activeInstance : activeInstances.
                    entrySet()) {
                listOfAvailableCleanSheetsInstances.add(activeInstance.getKey().
                        getHostName());
            }

            availableCleanSheetsInstancesList.
                    setListData(listOfAvailableCleanSheetsInstances.toArray());

            int i;
            for (i = 0; i < listOfAvailableCleanSheetsInstances.size(); i++) {
                connectDisconnectToggleButtonClick.add(true);
            }
        } catch (Exception ex) {
            System.out.println("Erro HashMap");
        }
    }

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
                controller.
                        establishConnection((List<String>) availableCleanSheetsInstancesList.
                                getSelectedValuesList(), sendCellAction);
                connectDisconnectToggleButtonClick.set(index, false);
                connectDisconnectToggleButton.setText("Disconnect");
            } else {
                controller.interruptConnection();
                connectDisconnectToggleButtonClick.set(index, true);
                connectDisconnectToggleButton.setText("Connect");
            }
        }
        sendCellAction.getSpreadsheetTable().getSpreadsheet().addCellListener(new AutomaticCellListener());
    }//GEN-LAST:event_connectDisconnectToggleButtonActionPerformed

    /**
     * This method refreshes the connect/disconnect toggle button according to
     * the CleanSheets instance selected.
     */
    private void availableCleanSheetsInstancesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableCleanSheetsInstancesListMouseClicked
        try {
            availableCleanSheetsInstancesList.updateUI();
            int index = availableCleanSheetsInstancesList.getSelectedIndex();
            if ("Disconnect".equals(connectDisconnectToggleButton.getText()) && connectDisconnectToggleButtonClick.
                    get(index)) {
                connectDisconnectToggleButton.setSelected(false);
                connectDisconnectToggleButton.setText("Connect");
            } else if ("Connect".equals(connectDisconnectToggleButton.getText()) && !connectDisconnectToggleButtonClick.
                    get(index)) {
                connectDisconnectToggleButton.setSelected(true);
                connectDisconnectToggleButton.setText("Disconnect");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //Just to not give error before click button start sharing
        }

    }//GEN-LAST:event_availableCleanSheetsInstancesListMouseClicked

    /**
     * This button calls a method that retrieves a list of all the available
     * CleanSheets instances on the same LAN.
     */
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        retrieveAvailableCleanSheetsInstances();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void startStopSharingToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startStopSharingToggleButtonActionPerformed
        if (startStopSharingToggleButtonStatus) {
            startStopSharingToggleButtonStatus = false;
            refreshButton.setEnabled(false);
            connectDisconnectToggleButton.setEnabled(false);
            availableCleanSheetsInstancesList.setEnabled(false);
            availableCleanSheetsInstancesScrollPane.getVerticalScrollBar().
                    setEnabled(false);
            availableCleanSheetsInstancesScrollPane.getVerticalScrollBar().
                    setEnabled(false);
            availableCleanSheetsInstancesScrollPane.getViewport().
                    setEnabled(false);
            startStopSharingToggleButton.setText("Start Sharing");
            controller.setVisibility(false);
            listOfAvailableCleanSheetsInstances.clear();
        } else {
            int port = (Integer) connectionPortSpinner.getValue();
            JOptionPane.showMessageDialog(
                    rootPane,
                    "You are now connected with the port " + port + "!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
            startStopSharingToggleButtonStatus = true;
            refreshButton.setEnabled(true);
            connectDisconnectToggleButton.setEnabled(true);
            availableCleanSheetsInstancesList.setEnabled(true);
            availableCleanSheetsInstancesScrollPane.getHorizontalScrollBar().
                    setEnabled(true);
            availableCleanSheetsInstancesScrollPane.getVerticalScrollBar().
                    setEnabled(true);
            availableCleanSheetsInstancesScrollPane.getVerticalScrollBar().
                    setEnabled(true);
            availableCleanSheetsInstancesScrollPane.getViewport().
                    setEnabled(true);
            startStopSharingToggleButton.setText("Stop Sharing");
            controller.changePort(port);
            controller.setVisibility(true);
            retrieveAvailableCleanSheetsInstances();
            controller.startServer(sendCellAction);
        }
    }//GEN-LAST:event_startStopSharingToggleButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList availableCleanSheetsInstancesList;
    private javax.swing.JLabel availableCleanSheetsInstancesOnLANLabel;
    private javax.swing.JScrollPane availableCleanSheetsInstancesScrollPane;
    private javax.swing.JLabel changeConnectionPortLabel;
    private javax.swing.JSeparator chooseCleanSheetsInstanceToConnectSeparator;
    private javax.swing.JToggleButton connectDisconnectToggleButton;
    private javax.swing.JSpinner connectionPortSpinner;
    private javax.swing.JButton refreshButton;
    private javax.swing.JToggleButton startStopSharingToggleButton;
    // End of variables declaration//GEN-END:variables
}
