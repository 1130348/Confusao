/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing.ui;

import csheets.ext.auto_download.ui.DownloadFileUI;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Marcos
 */
public class FileSharingUI extends JFrame {

    private JList filesList;

    private DefaultListModel fileList, ConList, outlistS;

    private String selectedCon;
    private String selectedFile;

    private JButton myinbox = new JButton(), myoutbox = new JButton(), download = new JButton();

    public FileSharingUI() {

        setPreferredSize(new Dimension(595, 395));
        setSize(new Dimension(595, 395));
        setResizable(false);
        setDefaultCloseOperation(0);
        setTitle("FileSharingUI");
        download.setEnabled(true);

        JPanel jp = new JPanel();

        ConList = new DefaultListModel();

        JList InstancesList = new JList(ConList);
        InstancesList.
            setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
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
                        FileSharingController.StartCon();
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

        myinbox.setText("<html><center>My</center>InBox</hmtl>");
        myinbox.setBounds(10, 10, 85, 50);
        myinbox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().open(new File(FileSharingController.
                        getInBox()));
                } catch (IOException ex) {

                }
            }
        });
        add(myinbox);
        myoutbox.setText("<html><center>My</center>OutBox</hmtl>");
        myoutbox.setBounds(105, 10, 85, 50);
        myoutbox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().open(new File(FileSharingController.
                        getOutBox()));
                } catch (IOException ex) {

                }
            }
        });
        add(myoutbox);

        download.setText("<html><center>Download</center></hmtl>");
        download.setBounds(10, 300, 85, 20);
        download.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DownloadFileUI down = new DownloadFileUI(selectedFile, FileSharingController.
                    getInBox());
                down.setVisible(true);
            }
        });
        add(download);

        JScrollPane listScroller = new JScrollPane(InstancesList);
        listScroller.setBounds(10, 75, 180, 285);
        listScroller.setOpaque(false);
        add(listScroller);

        fileList = new DefaultListModel();
        filesList = new JList(fileList);
        filesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        filesList.setLayoutOrientation(JList.VERTICAL);
        filesList.setVisibleRowCount(-1);
        filesList.setOpaque(false);
        filesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                selectedFile = fileList.get(index).toString();
                download.setEnabled(true);
            }
        });
        JScrollPane FilelistScroller = new JScrollPane(filesList);
        FilelistScroller.setBounds(200, 10, 380, 350);
        FilelistScroller.setOpaque(false);
        add(FilelistScroller);

        add(jp);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public JButton getMyInbox() {
        return myinbox;
    }

    public JButton getMyOutbox() {
        return myoutbox;
    }

    public void SetConnection(String msg) {
        if (!msg.equals("")) {
            if (!ConList.contains(msg)) {
                ConList.addElement(msg);
            }
        }
    }

    public void fillList(List l) {
        for (Object x : l) {
            outlistS.addElement(x.toString());
        }
    }

    public String getSelectedCon() {
        return selectedCon;
    }

    public void setMsg(String msg) {
        if (!msg.equals("")) {
            String[] ar = msg.split(",");
            for (int i = 0; i < ar.length; i++) {
                System.out.println(ar[i]);
                fileList.addElement(ar[i]);
            }
        }
    }

}
