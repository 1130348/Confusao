/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message.UI;

import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Jose
 */
public class FindInstancesUI extends JFrame {

	private DefaultListModel conList = new DefaultListModel();
	;
	private JButton okButton = new JButton("OK");
	private JList instanceList = new JList(conList);
	private JList fileList, outList;

	public FindInstancesUI() {

		setPreferredSize(new Dimension(595, 395));
		setSize(new Dimension(595, 395));
		setResizable(false);
		setDefaultCloseOperation(1);
		setTitle("Find Participants");

		conList = new DefaultListModel();

		JList InstancesList = new JList(conList);
		InstancesList.
			setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		InstancesList.setLayoutOrientation(JList.VERTICAL);
		InstancesList.setVisibleRowCount(-1);
		InstancesList.setOpaque(false);

		JScrollPane listScroller = new JScrollPane(InstancesList);
		listScroller.setBounds(10, 75, 180, 285);
		listScroller.setOpaque(false);
		add(listScroller);

		setUndecorated(true);
		setLocationRelativeTo(null);

	}

	public void SetConnection(String msg) {
		if (!msg.equals("")) {
			if (!conList.contains(msg)) {
				conList.addElement(msg);
			}
		}
	}

	public void active() {
		this.setVisible(true);

	}

}
