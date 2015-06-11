/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contact.ui;

import csheets.CleanSheets;
import csheets.ext.contact.Contact;
import csheets.ext.contact.Email;
import csheets.ext.contact.Event;
import csheets.ext.contact.Note;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Egidio Santos
 */
public class EditContact extends javax.swing.JFrame {

    private JFileChooser fileChooser;

    private List eventList;

    private List noteList;

    private List emailList;

    private ContactController controller;

    private Contact contact;

    private ImageIcon img;

    /**
     * Creates new form AddContact
     *
     * @param c
     */
    public EditContact(ContactController c) {
        controller = c;
        contact = new Contact();
        initComponents();
        eventList = new ArrayList<Event>();
        noteList = new ArrayList<Note>();
        emailList = new ArrayList<Email>();
        setTitle("Add Contact");
        initFrame();
        actionButtons(0);

        jList3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    EditNote en = new EditNote(controller, contact, EditContact.this, (Note) noteList.get(jList3.getSelectedIndex()));
                    en.setVisible(true);
                }
            }
        });

    }

    public EditContact(ContactController c, final Contact contact) {
        controller = c;
        initComponents();
        this.contact = contact;
        eventList = contact.getAgenda().toList();
        noteList = contact.getNotes().getNoteList();
        emailList = contact.getEmails();
        setTitle("Edit Contact");
        initFrame();
        actionButtons(2);

        jList2.setListData(eventList.toArray());
        if (contact.getImage() != null) {
            jLabel6.setIcon(new ImageIcon(contact.getImage()));
        }
        String lablePrimary = "Primary Email: ";
        if (!emailList.isEmpty()) {
            lablePrimary += emailList.get(0);
        }
        jLabelPrimaryEmail.setText(lablePrimary);
        jTextField3.setText(contact.getFirst_Name());
        jTextField4.setText(contact.getLast_Name());
        jTextHomeNumber.setText(contact.getHomeNumber().toString());
        jTextWorkNumber.setText(contact.getWorkNumber().toString());
        jTextWorkMNumber.setText(contact.getWorkMobileNumber().toString());
        jTextMobileNumber.setText(contact.getMobileNumber().toString());
        jListEmails.setListData(emailList.toArray());
        jListEmails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    String newText = JOptionPane.showInputDialog("Enter the new email Address");
                    if (!controller.editEmail(contact, (Email) emailList.get(jListEmails.getSelectedIndex()), newText)) {
                        JOptionPane.showMessageDialog(null,
                                "Write a Valid email!", "Invalid E-Mail",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        jList3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    EditNote en = new EditNote(controller, contact, EditContact.this, (Note) noteList.get(jList3.getSelectedIndex()));
                    en.setVisible(true);
                }
            }
        });

    }

    private void initFrame() {
        setResizable(false);
        setLocationByPlatform(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                CleanSheets.class.getResource("res/img/sheet.gif")));
    }

    private void actionButtons(final int n) {

        jButton1.setBorderPainted(false);
        jButton1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().
                getImage("src-resources\\csheets\\res\\img\\reload.png")));

        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                fileChooser = new JFileChooser();
                //fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(filter(".jpeg"));
                fileChooser.addChoosableFileFilter(filter(".gif"));
                fileChooser.addChoosableFileFilter(filter(".png"));

                if (fileChooser.showDialog(EditContact.this, "Import") == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fileChooser.getSelectedFile().getPath());
                    String fich = fileChooser.getSelectedFile().getPath();
                    if (fich.contains(".jpg") || fich.contains(".jpeg") || fich.
                            contains(".gif") || fich.contains(".png")) {

                        jLabel6.setText("");
                        img = new ImageIcon(fileChooser.
                                getSelectedFile().getPath());
                        img.setImage(img.getImage().
                                getScaledInstance(77, 68, 100));
                        jLabel6.setIcon(img);
                        jLabel6.updateUI();

                    } else {
                        jLabel6.setIcon(null);
                        jLabel6.setText("Wrong Type!");
                        jLabel6.updateUI();
                    }
                }

            }
        }
        );

        jList2.setListData(eventList.toArray());
        jList3.setListData(noteList.toArray());
        jListEmails.setListData(emailList.toArray());
        jButton2.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                if (!controller.addHomeNumber(contact, jTextHomeNumber.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Home Number Invalid!", "Invalid Number",
                            JOptionPane.ERROR_MESSAGE);
                }
                if (!controller.addWorkNumber(contact, jTextWorkNumber.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Work Number Invalid!", "Invalid Number",
                            JOptionPane.ERROR_MESSAGE);
                }
                if (!controller.addMobileNumber(contact, jTextMobileNumber.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Mobile Number Invalid!", "Invalid Number",
                            JOptionPane.ERROR_MESSAGE);
                }
                if (!controller.addWorkMobileNumber(contact, jTextWorkMNumber.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Work Mobile Number Invalid!", "Invalid Number",
                            JOptionPane.ERROR_MESSAGE);
                }
                contact.setFirst_Name(jTextField3.getText());
                contact.setLast_Name(jTextField4.getText());
                if (n == 2) {
                    controller.updateContact(contact);
                } else {
                    contact.setMachine_Name(System.getProperty("user.name"));
                    contact.setImage(saveImage(img));
                    controller.addContact(contact);
                }
                controller.update();
                dispose();

            }
        }
        );

        jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (contact.getFirst_Name().isEmpty()) {
                    final JPanel panel = new JPanel();
                    JOptionPane.
                            showMessageDialog(panel, "You need to confirm the contact first!!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    EditEvent eventFrame = new EditEvent(controller, contact, EditContact.this);
                    eventFrame.setVisible(true);
                }
            }
        });

        jButton4.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                contact.getAgenda().rmv((Event) eventList.get(jList2.
                        getSelectedIndex()));

                updateEvent();

            }
        });

        jButton5.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {
                contact.removeNote((Note) noteList.get(jList3.getSelectedIndex()));
                updateNotes();

            }
        });

        jButton6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                EditNote en = new EditNote(controller, contact, EditContact.this);
                en.setVisible(true);
            }
        });
        addEmailButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String emailText = JOptionPane.showInputDialog("Enter the new E-Mail Address");
                if (!controller.newEmail(contact, emailText)) {
                    JOptionPane.showMessageDialog(null,
                            "Write a Valid email!", "Invalid E-Mail",
                            JOptionPane.ERROR_MESSAGE);
                }
                updateEmails();
            }
        });
        RemoveEmailButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!emailList.isEmpty()) {
                    controller.removeEmail(contact, (Email) emailList.get(jListEmails.getSelectedIndex()));
                    updateEmails();
                }
            }
        });
        setPrimaryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!emailList.isEmpty()) {
                    Email temp = (Email) emailList.get(jListEmails.getSelectedIndex());
                    controller.setPrimaryEmail(contact, temp);
                    jLabelPrimaryEmail.setText("Primary EMail: " + contact.getPrimaryEmail());
                    updateEmails();
                }
            }
        });

    }

    private BufferedImage saveImage(ImageIcon icon) {
        if (icon != null) {
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
        return new BufferedImage(1, 1, 4);
    }

    public FileFilter filter(final String type) {

        return new FileFilter() {

            @Override
            public boolean accept(File f) {
                if (f.getName().contains(type)) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return type;
            }
        };

    }

    public void updateEvent() {
        eventList = contact.getAgenda().toList();

        jList2.setListData(eventList.toArray());
        jList2.updateUI();
    }

    public void updateNotes() {
        noteList = contact.getNotes().getNoteList();

        jList3.setListData(noteList.toArray());
        jList3.updateUI();
    }

    public void updateEmails() {
        emailList = contact.getEmails();
        jListEmails.setListData(emailList.toArray());
        jListEmails.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextHomeNumber = new javax.swing.JTextField();
        lable4 = new javax.swing.JLabel();
        jTextMobileNumber = new javax.swing.JTextField();
        jTextWorkNumber = new javax.swing.JTextField();
        lable6 = new javax.swing.JLabel();
        jTextWorkMNumber = new javax.swing.JTextField();
        lable2 = new javax.swing.JLabel();
        jLabelPrimaryEmail = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListEmails = new javax.swing.JList();
        setPrimaryButton = new javax.swing.JButton();
        addEmailButton = new javax.swing.JButton();
        RemoveEmailButton = new javax.swing.JButton();
        lable3 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("First Name : ");

        jLabel5.setText("Last Name :");

        jLabel6.setText("No Image");

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jButton2.setText("Confirm");

        jButton3.setText("Add Event");

        jButton4.setText("Remove Event");

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        jButton5.setText("Remove Note");

        jButton6.setText("Add Note");

        lable4.setText("Mobile Number:");

        lable6.setText("Work M. Number:");

        lable2.setText("Work Number:");

        jLabelPrimaryEmail.setText("Primary EMail: ");

        jListEmails.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jListEmails);

        setPrimaryButton.setText("Set Primary EMail");

        addEmailButton.setText("Add EMail");

        RemoveEmailButton.setText("Remove EMail");

        lable3.setText("Home Number: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelPrimaryEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lable3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lable2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextHomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lable4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextWorkNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lable6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextWorkMNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(31, 31, 31)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(setPrimaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(addEmailButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveEmailButton))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(lable3)
                            .addComponent(jTextHomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lable4)
                            .addComponent(jTextMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lable2)
                            .addComponent(jTextWorkNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lable6)
                            .addComponent(jTextWorkMNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelPrimaryEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(setPrimaryButton))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RemoveEmailButton)
                            .addComponent(addEmailButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RemoveEmailButton;
    private javax.swing.JButton addEmailButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelPrimaryEmail;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jListEmails;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextHomeNumber;
    private javax.swing.JTextField jTextMobileNumber;
    private javax.swing.JTextField jTextWorkMNumber;
    private javax.swing.JTextField jTextWorkNumber;
    private javax.swing.JLabel lable2;
    private javax.swing.JLabel lable3;
    private javax.swing.JLabel lable4;
    private javax.swing.JLabel lable6;
    private javax.swing.JButton setPrimaryButton;
    // End of variables declaration//GEN-END:variables
}
