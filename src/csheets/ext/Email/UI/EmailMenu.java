/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Email.UI;

import csheets.ext.Email.EmailController;
import csheets.ext.Email.ExtensionEmail;
import csheets.ext.Email.SmtpConfig;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class EmailMenu extends JPanel {

	/**
	 * The assertion controller
	 */
	private EmailController controller;

	private JLabel label, labelAction = new JLabel(), labelAction2 = new JLabel();
	private JTextField textEmail, textAction, textService;
	private JPasswordField pass;
	private JButton setConfig;

	public EmailMenu(final UIController uiController) {

		super(new BorderLayout());
		setName(ExtensionEmail.NAME);
		//System.out.println(uiController.getExtensions().length);
		//Creates controller

		controller = new EmailController(uiController, this);

		JPanel EmailPanel = new JPanel();
		EmailPanel.setLayout(new GridLayout(5, 5));
		label = new JLabel(" Email ");
		textEmail = new JTextField();
		EmailPanel.add(label);
		EmailPanel.add(textEmail);
		label = new JLabel(" Password ");

		pass = new JPasswordField();
		EmailPanel.add(label);
		EmailPanel.add(pass);
		textService = new JTextField();
		textService.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				SmtpConfig smtp = new SmtpConfig(textService.getText().
					toLowerCase());
				labelAction.setText(smtp.getPort());
				labelAction.setBackground(Color.red);
				textAction.setEnabled(false);
				labelAction.setFont(new Font("Serif", Font.BOLD, 12));
				labelAction2.setText(smtp.getService());
				labelAction2.setBackground(Color.red);
				labelAction2.setFont(new Font("Serif", Font.BOLD, 12));
			}
		});

		textAction = new JTextField();
		label = new JLabel("Service");
		EmailPanel.add(label);
		EmailPanel.add(textService);

		label = new JLabel("Port");
		EmailPanel.add(label);
		EmailPanel.add(labelAction);

		label = new JLabel("Smtp");
		EmailPanel.add(label);
		EmailPanel.add(labelAction2);

		//Add Borders
		TitledBorder border = BorderFactory.createTitledBorder("Email");
		border.setTitleJustification(TitledBorder.CENTER);
		EmailPanel.setBorder(border);

		// Adds panels
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.add(EmailPanel, BorderLayout.NORTH);

		//Create a button to config and sent Email test
		JButton bt = new JButton("Config");
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textEmail.getText().isEmpty() || pass.getText().isEmpty()) {
					JOptionPane.
						showMessageDialog(null, "Preencher o mail ou password");
				} else {
					EmailController.
						setMailSettings(textEmail.getText(), textService.
										getText(), pass.
										getText(), uiController.getActiveCell());
				}
			}
		});
		add(northPanel, BorderLayout.NORTH);
		add(bt, BorderLayout.SOUTH);

	}

}
