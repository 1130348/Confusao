/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contact.ui;

import csheets.CleanSheets;
import csheets.ext.contact.Contact;
import csheets.ext.contact.Event;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
		setTitle("Add Contact");
		initFrame();
		actionButtons(0);

	}

	public EditContact(ContactController c, Contact contact) {
		controller = c;
		initComponents();
		this.contact = contact;
		eventList = contact.getAgenda().toList();

		setTitle("Edit Contact");
		initFrame();
		actionButtons(2);

		jList2.setListData(eventList.toArray());
		if (contact.getImage() != null) {
			jLabel6.setIcon(new ImageIcon(contact.getImage()));
		}

		jTextField3.setText(contact.getFirst_Name());
		jTextField4.setText(contact.getLast_Name());

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

		jButton2.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				if (n == 2) {
					contact.setFirst_Name(jTextField3.getText());
					contact.setLast_Name(jTextField4.getText());
					controller.updateContact(contact);
				} else {
					contact.setFirst_Name(jTextField3.getText());
					contact.setLast_Name(jTextField4.getText());
					contact.setMachine_Name(System.getProperty("user.name"));
					contact.setImage(saveImage(img));
					controller.
						addContact(contact);
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

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton4))
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jTextField3))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
