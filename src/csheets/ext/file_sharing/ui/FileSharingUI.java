/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing.ui;

import csheets.ext.Send_Message.UI.SendMessageController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
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
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Marcos
 */
public class FileSharingUI extends JFrame {

    /* Under TESTs */
    private JList MessagesList;

    private JTextField txt, addnewTT;

    private JButton send, addnewTB;

    /* WORKING */
    private DefaultListModel MsgList, ConList;

    private String selectedCon;

    public FileSharingUI() {

        setPreferredSize(new Dimension(595, 395));
        setSize(new Dimension(595, 395));
        setResizable(false);
        setDefaultCloseOperation(0);
        setTitle("FileSharingUI");

        JPanel jp = new JPanel();

        ConList = new DefaultListModel();

        JList InstancesList = new JList(ConList);
        InstancesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        InstancesList.setLayoutOrientation(JList.VERTICAL);
        InstancesList.setVisibleRowCount(-1);
        InstancesList.setOpaque(false);

        InstancesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    selectedCon = ConList.get(index).toString();
                    try {
                        SendMessageController.StartCon();
                    } catch (IOException ex) {
                        Logger.getLogger(FileSharingUI.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                } else if (evt.getClickCount() == 3) {
                    // Triple-click detected
                    int index = list.locationToIndex(evt.getPoint());
                }
            }
        });
        
        JButton myinbox = new JButton();
        myinbox.setText("<html><center>My</center>InBox</hmtl>");
        myinbox.setBounds(10, 10, 85, 50);
        add(myinbox);
        JButton myoutbox = new JButton();
        myoutbox.setText("<html><center>My</center>OutBox</hmtl>");
        myoutbox.setBounds(105, 10, 85, 50);
        add(myoutbox);

        JScrollPane listScroller = new JScrollPane(InstancesList);
        listScroller.setBounds(10, 75, 180, 285);
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
        MsglistScroller.setBounds(200, 10, 380, 350);
        MsglistScroller.setOpaque(false);
        add(MsglistScroller);

        add(jp);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void SetConnection(String msg) {
        if (!msg.equals("")) {
            if (!ConList.contains(msg)) {
                ConList.addElement(msg);
            }
        }

    }

    public String getSelectedCon() {
        return selectedCon;
    }
}
