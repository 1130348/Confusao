/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

/**
 *
 * @author DMMCA
 */
public class ChatUI extends JFrame {

	/* Under TESTs */
	private JList MessagesList;

	private JTextField txt, addnewTT;

	private JButton send, addnewTB, partButton;

	/* WORKING */
	private DefaultListModel MsgList, ConList;

	private String selectedCon;
	private static FindInstancesUI ui = new FindInstancesUI();
	private static HashMap<String, String> map = new HashMap<String, String>();
	private FindInstancesUI findUI = new FindInstancesUI();

	public ChatUI() {

		setPreferredSize(new Dimension(800, 500));
		setSize(new Dimension(800, 500));
		setResizable(false);
		setDefaultCloseOperation(0);
		setTitle("ChatUI");

		JPanel jp = new JPanel();

		JLabel addnewT = new JLabel("Add new Contact:");
		addnewT.setForeground(Color.BLACK);
		addnewT.setBounds(10, 20, 100, 20);
		add(addnewT);
		addnewTT = new JTextField();
		addnewTT.setBounds(115, 20, 100, 20);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		addnewTT.setBorder(border);
		add(addnewTT);
		addnewTB = new JButton("+");
		addnewTB.setBorder(null);
		addnewTB.setBounds(215, 20, 20, 20);
		addnewTB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetConnection(addnewTT.getText());
			}
		});

		add(addnewTB);

		//UC 5.2
		partButton = new JButton("Find Participants");
		partButton.setBorder(null);
		partButton.setBounds(250, 20, 100, 20);
		partButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FindInstancesController controller = new FindInstancesController();
//				Comented becouse it doesnt work
				//try {
//
////					controller.setFindInstanesUI(ui);
////					controller.create();
//				} catch (IOException ex) {
//					Logger.getLogger(ChatUI.class.getName()).
//						log(Level.SEVERE, null, ex);
//				}
				ui.active();

			}
		});

		add(partButton);

		txt = new JTextField();
		txt.setBounds(200, 430, 495, 40);
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		txt.setBorder(border);
		add(txt);

		send = new JButton("Send");
		send.setBounds(695, 430, 100, 40);
		add(send);

		ConList = new DefaultListModel();

		JList InstancesList = new JList(ConList);
		InstancesList.
			setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		InstancesList.setLayoutOrientation(JList.VERTICAL);
		InstancesList.setVisibleRowCount(-1);
		InstancesList.setOpaque(false);

		InstancesList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {

					// Double-click detected
					int index = list.locationToIndex(evt.getPoint());
					selectedCon = ConList.get(index).toString();
					try {
						SendMessageController.StartCon();
					} catch (IOException ex) {
						Logger.getLogger(ChatUI.class.getName()).
							log(Level.SEVERE, null, ex);
					}
				} else if (evt.getClickCount() == 3) {
					// Triple-click detected
					int index = list.locationToIndex(evt.getPoint());
				}
			}
		});
		JScrollPane listScroller = new JScrollPane(InstancesList);
		listScroller.setBounds(10, 70, 180, 400);
		listScroller.setOpaque(false);
		add(listScroller);

		MsgList = new DefaultListModel();
		MessagesList = new JList(MsgList);
		MessagesList.
			setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		MessagesList.setLayoutOrientation(JList.VERTICAL);
		MessagesList.setVisibleRowCount(-1);
		MessagesList.setOpaque(false);
		JScrollPane MsglistScroller = new JScrollPane(MessagesList);
		MsglistScroller.setBounds(200, 70, 595, 355);
		MsglistScroller.setOpaque(false);
		add(MsglistScroller);

		add(jp);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void setMsg(String msg) {
		if (!msg.substring(msg.indexOf(":") + 2, msg.length()).equals("")) {
			MsgList.addElement(msg);
			MessagesList.ensureIndexIsVisible(MsgList.size() - 1);
		}

	}

	public void SetConnection(String msg) {
		if (!msg.equals("")) {
			if (!ConList.contains(msg)) {
				ConList.addElement(msg);
			}
		}

	}

	public JButton getSend() {
		return send;
	}

	public JTextField getTxt() {
		return txt;
	}

	public String getSelectedCon() {
		return selectedCon;
	}

	public String getIP() {
		return addnewTT.getText();
	}

	public String[] getMessages() {
		String[] messages = new String[MsgList.size()];
		for (int i = 0; i < MsgList.size(); i++) {
			messages[i] = MsgList.getElementAt(i).toString();
		}
		return messages;
	}

}
