/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication.ui;

import csheets.ext.startsharing.NetworkService;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 *
 * @author rddm
 */
public class SecureComunicationPanel extends JPanel {

    public static JList clientList = new JList();
    public static JList connectedList = new JList();
    public static JButton refresh;
    private UIController uiController;

    public SecureComunicationPanel(UIController uiController) {
        super(new BorderLayout());
        this.uiController = uiController;
        setLayout(new BorderLayout());
        initComponents();
        addActions();
    }

    private void initComponents() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(clientList);
        refresh = new JButton("Refresh");

        add(scrollPane, BorderLayout.NORTH);
        add(refresh, BorderLayout.SOUTH);

    }

    private void addActions() {
        if (clientList != null) {
            clientList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    if (evt.getClickCount() == 2) {
                        NetworkService.establishSSLConnectionToUser((InetAddress) clientList.getSelectedValue());
                    }
                }
            });
        }
        refresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clientList.setListData(NetworkService.searchInstances().keySet().toArray());
            }
        });

    }
}
