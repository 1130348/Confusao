/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.selectgame.ui;

import csheets.ext.selectgame.Player;
import csheets.ext.selectgame.SelectGameController;

/**
 *
 * @author Sergio
 */
public class GameScene extends javax.swing.JDialog {

	private String activeGame;

	private Player player;

	private SelectGameController controller;

	/**
	 * Creates new form GameScene
	 */
	public GameScene(java.awt.Frame parent, boolean modal,
					 SelectGameController controller,
					 String activeGame) {
		super(parent, modal);
		this.controller = controller;
		this.activeGame = activeGame;
		initComponents();
		myImage.setText("");
		partnerImage.setText("");
	}

	public void setPartnerData(Player player) {
		partnerImage.setIcon(player.getPlayerIcon());
		partnerName.setText(player.getName());
	}

	public Player getPlayerData() {
		return player;
	}

	public void setPlayerData(Player player) {
		playerName.setText(player.getName());
		myImage.setIcon(player.getPlayerIcon());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        partnerName = new javax.swing.JLabel();
        quitGameButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        myImage = new javax.swing.JLabel();
        partnerImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("You:");

        jLabel2.setText("Partner:");

        playerName.setText("Name");

        partnerName.setText("Name");

        quitGameButton.setText("Quit Game");
        quitGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitGameButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("NickName:");

        jLabel4.setText("NickName:");

        myImage.setText("Image");

        partnerImage.setText("Image");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(quitGameButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(myImage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(partnerImage)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(partnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerName)
                    .addComponent(partnerName)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myImage)
                    .addComponent(partnerImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(quitGameButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void quitGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitGameButtonActionPerformed
		// TODO add your handling code here:
		controller.removeActiveGame(activeGame);
		dispose();
    }//GEN-LAST:event_quitGameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel myImage;
    private javax.swing.JLabel partnerImage;
    private javax.swing.JLabel partnerName;
    private javax.swing.JLabel playerName;
    private javax.swing.JButton quitGameButton;
    // End of variables declaration//GEN-END:variables
}
