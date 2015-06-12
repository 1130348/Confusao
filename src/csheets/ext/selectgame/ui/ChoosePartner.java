/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame.ui;

import csheets.ext.selectgame.Player;
import csheets.ext.selectgame.SelectGameController;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class ChoosePartner extends javax.swing.JDialog {

	private GameScene dialog;
	private Player player;
	private static ChoosePartner instance;
	private String activeGame;
	private boolean startStopSearchingToggleButtonStatus = false;
	private final ArrayList<String> listOfAvailableCleanSheetsInstances = new ArrayList<String>();
	private final ArrayList<Boolean> connectDisconnectToggleButtonClick = new ArrayList<Boolean>();
	private SelectGameController controller;

	private ChoosePartner(java.awt.Frame parent,
						  boolean modal,
						  SelectGameController controller, Player player,
						  String activeGame) {
		super(parent, modal);
		this.controller = controller;
		this.player = player;
		this.activeGame = activeGame;
		initComponents();
		dialog = new GameScene(null, true, controller, activeGame);
	}

	/**
	 * Creates new form ChoosePartnerToConnect
	 */
	public ChoosePartner() {
	}

	public static synchronized ChoosePartner getInstance(
		java.awt.Frame parent, boolean modal, SelectGameController controller,
		Player player, String activeGame) {
		if (instance == null) {
			instance = new ChoosePartner(parent, modal, controller, player, activeGame);
		}
		return instance;
	}

	/**
	 * This method retrieves a list of all the available CleanSheets instances
	 * on the same LAN.
	 */
	private void retrieveAvailableCleanSheetsInstances() {
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
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchPartnerButton = new javax.swing.JToggleButton();
        availableCleanSheetsInstancesOnLANLabel = new javax.swing.JLabel();
        connectDisconnectToggleButton = new javax.swing.JToggleButton();
        refreshListButton = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableCleanSheetsInstancesList = new javax.swing.JList();

        searchPartnerButton.setText("Search Partner");
        searchPartnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPartnerButtonActionPerformed(evt);
            }
        });

        availableCleanSheetsInstancesOnLANLabel.setText("Available CleanSheets instances on LAN:");

        connectDisconnectToggleButton.setText("Connect");
        connectDisconnectToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectDisconnectToggleButtonActionPerformed(evt);
            }
        });

        refreshListButton.setText("Refresh List");
        refreshListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshListButtonActionPerformed(evt);
            }
        });

        availableCleanSheetsInstancesList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        availableCleanSheetsInstancesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableCleanSheetsInstancesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(availableCleanSheetsInstancesList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(availableCleanSheetsInstancesOnLANLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchPartnerButton)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshListButton)
                        .addGap(18, 18, 18)
                        .addComponent(connectDisconnectToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPartnerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(availableCleanSheetsInstancesOnLANLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectDisconnectToggleButton)
                    .addComponent(refreshListButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchPartnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPartnerButtonActionPerformed
		// TODO add your handling code here:
		if (startStopSearchingToggleButtonStatus) {
			startStopSearchingToggleButtonStatus = false;
			refreshListButton.setEnabled(false);
			connectDisconnectToggleButton.setEnabled(false);
			availableCleanSheetsInstancesList.setEnabled(false);
			searchPartnerButton.setText("Start Searching");
			controller.setVisibility(false);
			listOfAvailableCleanSheetsInstances.clear();
		} else {
			startStopSearchingToggleButtonStatus = true;
			refreshListButton.setEnabled(true);
			connectDisconnectToggleButton.setEnabled(true);
			availableCleanSheetsInstancesList.setEnabled(true);
			searchPartnerButton.setText("Stop Searching");
			controller.setVisibility(true);
			retrieveAvailableCleanSheetsInstances();
			controller.startGameServer(dialog, player, this);
		}
    }//GEN-LAST:event_searchPartnerButtonActionPerformed

    private void refreshListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshListButtonActionPerformed
		// TODO add your handling code here:
		retrieveAvailableCleanSheetsInstances();
    }//GEN-LAST:event_refreshListButtonActionPerformed

    private void availableCleanSheetsInstancesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableCleanSheetsInstancesListMouseClicked
		// TODO add your handling code here:
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

    private void connectDisconnectToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectDisconnectToggleButtonActionPerformed
		// TODO add your handling code here:
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
					establishConnection((String) availableCleanSheetsInstancesList.
						getSelectedValue());
				controller.sendUserInfo(player);
				connectDisconnectToggleButtonClick.set(index, false);
				connectDisconnectToggleButton.setText("Disconnect");
				controller.setActiveGame(activeGame);
				dialog.setPlayerData(player);
				dispose();
				dialog.setVisible(true);
			} else {
				controller.interruptConnection();
				connectDisconnectToggleButtonClick.set(index, true);
				connectDisconnectToggleButton.setText("Connect");
			}
		}
    }//GEN-LAST:event_connectDisconnectToggleButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList availableCleanSheetsInstancesList;
    private javax.swing.JLabel availableCleanSheetsInstancesOnLANLabel;
    private javax.swing.JToggleButton connectDisconnectToggleButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton refreshListButton;
    private javax.swing.JToggleButton searchPartnerButton;
    // End of variables declaration//GEN-END:variables
}
