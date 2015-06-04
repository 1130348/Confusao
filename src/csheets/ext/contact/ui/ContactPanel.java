package csheets.ext.contact.ui;

/*
 * Copyright (c) 2013 Alexandre Braganca, Einar Pehrson
 *
 * This file is part of
 * CleanSheets Extension for Comments
 *
 * CleanSheets Extension for Assertions is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * CleanSheets Extension for Assertions is distributed in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets Extension for Assertions; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import csheets.ext.contact.ExtensionContact;
import csheets.ui.ctrl.UIController;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;

/**
 * A panel for adding ,editing or remove a contact
 *
 * @author Egidio Santos
 * @author Einar Pehrson
 */
@SuppressWarnings("serial")
public class ContactPanel extends JPanel {

    /**
     * The assertion controller
     */
    private ContactController controller;

    /**
     * The text field in which the comment of the cell is displayed.
     */
    private JList contactField = new JList();

    /**
     * The text field in which the comment of the cell is displayed.
     */
    private List contactList;

    /**
     * Creates a new comment panel.
     *
     * @param uiController the user interface controller
     */
    public ContactPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(ExtensionContact.NAME);

        contactList = new ArrayList<String>();
        //getContacts from database

        startList();

        // Creates controller
        controller = new ContactController(uiController, this);

        contactField.setPreferredSize(new Dimension(120, 240));		// width, height
        contactField.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        contactField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Lays out comment components
        JPanel contactPanel = new JPanel();
        contactPanel.setLayout(new BoxLayout(contactPanel, BoxLayout.PAGE_AXIS));
        contactPanel.setPreferredSize(new Dimension(130, 336));
        contactPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        contactPanel.add(contactField);

        // Adds borders
        TitledBorder border = BorderFactory.createTitledBorder("Lista De Contactos");
        border.setTitleJustification(TitledBorder.CENTER);
        contactPanel.setBorder(border);

        // Adds panels
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(contactPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel(new GridLayout(1, 2));
        JButton adicionar = new JButton("Add");
        adicionar.addActionListener(addAction);
        JButton remover = new JButton("Remove");

        southPanel.add(adicionar);
        southPanel.add(remover);
        northPanel.add(southPanel, BorderLayout.SOUTH);

        add(northPanel, BorderLayout.NORTH);
        setPreferredSize(new Dimension(100, 100));

    }

    private void startList() {

        if (contactList.isEmpty()) {
            contactList.add("Empty");
            contactField.setEnabled(false);
        }

        contactField.setListData(contactList.toArray());

    }

    ActionListener addAction = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            EditContact editContactFrame = new EditContact();
            editContactFrame.setVisible(true);

        }
    };

}
