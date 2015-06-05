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
import csheets.ext.contact.Contact;
import csheets.ext.contact.Event;
import csheets.ext.contact.ExtensionContact;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

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

        // Creates controller
        controller = new ContactController(uiController, this);
        contactList = new ArrayList<Contact>();
        Event e = new Event("Teste: ola adeus.", new Date());
        ImageIcon image = new ImageIcon("C:\\Users\\Egidio73\\Desktop\\props.png");
        Contact c = new Contact("Egidio", "Santos", "PC-Egidio",saveImage(image));
        c.addEvent(e);
        contactList.add(c);

        startList();

        contactField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    
                    EditContact editContactFrame = new EditContact(controller, (Contact) contactList.get(index));
                    editContactFrame.setVisible(true);
                 
                }
            }
        });

        contactField.setPreferredSize(
                new Dimension(120, 240));		// width, height
        contactField.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        contactField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Lays out comment components
        JPanel contactPanel = new JPanel();

        contactPanel.setLayout(
                new BoxLayout(contactPanel, BoxLayout.PAGE_AXIS));
        contactPanel.setPreferredSize(
                new Dimension(130, 336));
        contactPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        contactPanel.add(contactField);

        // Adds borders
        TitledBorder border = BorderFactory.
                createTitledBorder("Lista De Contactos");

        border.setTitleJustification(TitledBorder.CENTER);

        contactPanel.setBorder(border);

        // Adds panels
        JPanel northPanel = new JPanel(new BorderLayout());

        northPanel.add(contactPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel(new GridLayout(1, 2));
        JButton adicionar = new JButton("Add");

        adicionar.addActionListener(addAction);
        JButton remover = new JButton("Remove");

        remover.addActionListener(removeAction);

        southPanel.add(adicionar);

        southPanel.add(remover);

        northPanel.add(southPanel, BorderLayout.SOUTH);

        add(northPanel, BorderLayout.NORTH);

        setPreferredSize(
                new Dimension(100, 100));

    }

    private BufferedImage saveImage(ImageIcon icon) {

        BufferedImage bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        // paint the Icon to the BufferedImage.
        icon.paintIcon(null, g, 0, 0);
        g.dispose();
        return bi;
    }

    public void startList() {
        
        contactList.clear();
        contactField.setEnabled(true);
        for (Contact c : controller.getContacts()) {
            contactList.add(c);
        }

        if (contactList.isEmpty()) {
            contactList.add("Empty");
            contactField.setEnabled(false);
        }

        contactField.setListData(contactList.toArray());

    }

    ActionListener addAction = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            EditContact editContactFrame = new EditContact(controller);
            editContactFrame.setVisible(true);
        }
    };

    ActionListener removeAction = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
             Contact tmp = (Contact) contactList.get(contactField.getSelectedIndex());
            for (Contact c : controller.getContacts()) {
                if (c.getMachine_Name().equals(tmp.getMachine_Name())) {
                    controller.removeContact(c);
                }
            }
            controller.update();
        }

    };

}
