/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Marcos
 */
class FileSharingPanel extends JPanel {

    private JCheckBox fs;
    private JTextField in;
    private JTextField out;
    private FileSharingController controller;
    private FileSharingUI fsui;

    public FileSharingPanel(UIController uiController) {
        setLayout(null);

        JLabel myLabel = new JLabel("File Sharing");
        fs = new JCheckBox("Activate", false);
        myLabel.setBounds(20, 20, 80, 25);
        fs.setBounds(20, 100, 80, 25);

        in = new JTextField();
        in.setBounds(20, 47, 125, 20);
        in.setText("Insert Inbox Path");
        add(in);
        out = new JTextField();
        out.setText("Insert Outbox Path");
        out.setBounds(20, 75, 125, 20);
        add(out);

        controller = new FileSharingController(uiController, this);
        
        fs.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (fs.isSelected()) {
                    fs.setText("Deactivate");
                    fsui = new FileSharingUI();
                    try {
                        controller.setFileSharingUI(fsui);
                        controller.setInBox(in.getText());
                        controller.setOutBox(out.getText());     
                    } catch (IOException ex) {

                    }

                } else {
                    fs.setText("Activate");
                    fsui.dispose();
                }
            }
        });

        add(myLabel);
        add(fs);

    }

}
