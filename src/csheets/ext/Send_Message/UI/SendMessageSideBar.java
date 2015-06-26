/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message.UI;

import csheets.ext.Send_Message.ChatUser;
import csheets.ui.ctrl.UIController;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DMMCA
 */
class SendMessageSideBar extends JPanel {

	private JCheckBox Chat;
	private SendMessageController controller;
	private ChatUI chatui;

	public SendMessageSideBar(UIController uiController) {
		setLayout(new FlowLayout());

		JLabel myLabel = new JLabel("Chat:");
		Chat = new JCheckBox("Activate", false);

		controller = new SendMessageController(uiController, this);

		Chat.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (Chat.isSelected()) {
					Chat.setText("Deactivate");
					chatui = new ChatUI();
					try {
						ChatUI f = chatui;

						controller.setChatUI(chatui);
					} catch (IOException ex) {

					}

				} else {
					Chat.setText("Activate");
					chatui.dispose();

					try {//create user for posterior edition as aply image
						ChatUser user = new ChatUser(InetAddress.
							getByName(chatui.getIP()), true, chatui.
													 getMessages());
					} catch (UnknownHostException ex) {
						Logger.getLogger(SendMessageSideBar.class.getName()).
							log(Level.SEVERE, null, ex);
					}

				}
			}
		});

		add(myLabel);
		add(Chat);

	}

}
