/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.secure_comunication.ui;

import csheets.ext.secure_comunication.SecureComunicationController;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
    /**
     * The controller
     */
    private final SecureComunicationController secureComunicationController;

    public SecureComunicationPanel(UIController uiController) {
        super(new BorderLayout());
        this.uiController = uiController;
        this.secureComunicationController = new SecureComunicationController();
        setLayout(new BorderLayout());
        initComponents();
        addActions();
    }

    private void initComponents() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(clientList);
        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(connectedList);
        refresh = new JButton("Refresh");

        //add(scrollPane, BorderLayout.NORTH);
        //add(refresh, BorderLayout.SOUTH);
        JPanel panel = new JPanel();
        panel.setLayout(
                new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(
                new Dimension(130, 130));
        panel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        panel.add(scrollPane);

        // Adds borders
        TitledBorder border = BorderFactory.
                createTitledBorder("Instance List");

        border.setTitleJustification(TitledBorder.CENTER);

        panel.setBorder(border);

        JPanel panel2 = new JPanel();
        panel2.setLayout(
                new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        panel2.setPreferredSize(
                new Dimension(130, 130));
        panel2.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        panel2.add(scrollPane2);

        // Adds borders
        TitledBorder border2 = BorderFactory.
                createTitledBorder("Connected List");

        border2.setTitleJustification(TitledBorder.CENTER);

        panel2.setBorder(border2);
        add(panel, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
        add(refresh, BorderLayout.SOUTH);

    }

    private void addActions() {
        if (clientList != null) {
            clientList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    if (evt.getClickCount() == 2) {
                        int option;
                        String inet = clientList.getSelectedValue().toString();
                        if (secureComunicationController.refreshConnections().contains(inet)) {
                            option = JOptionPane.showConfirmDialog(null, "You want to disconnect with " + inet, "Remove Secure Connection", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (option == 0) {
                                secureComunicationController.removeConnection(inet);
                            }
                        } else {
                            option = JOptionPane.showConfirmDialog(null, "You want to connect with " + inet, "New Secure Connection", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (option == 0) {

                                if (secureComunicationController.newSSLConnection(inet)) {
                                    JOptionPane.showMessageDialog(null, "You are now connected with " + clientList.getSelectedValue().toString(), "Connection Success", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Some error occured during the connection", "Connection Failed", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                }

            }
            );
        }
        if (connectedList != null) {
            connectedList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    if (evt.getClickCount() == 2) {
                        String message = JOptionPane.showInputDialog("Enter text", "");
                        secureComunicationController.sendMessage(connectedList.getSelectedValue().toString(), message);
                    }
                }
            });
        }
        refresh.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clientList.setListData(secureComunicationController.refreshInstances().toArray());
                connectedList.setListData(secureComunicationController.refreshConnections().toArray());
            }
        });

    }
}
