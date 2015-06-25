/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sendEmail;

import csheets.core.Cell;
import csheets.ext.sendEmail.UI.OutBoxPanel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Paulo
 */
public class SendEmail {

	private Session session;
	private String smtpService;
	private String smtpPort;
	private String mail;
	private String password;

	public SendEmail() {
	}

	public void initiateSession() throws FileNotFoundException, IOException {
		File f = new File("mailConfig.txt");
		if (f.exists()) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(f));
				mail = br.readLine().trim();
				password = br.readLine().trim();
				smtpService = br.readLine().trim();
				smtpPort = br.readLine().trim();
				br.close();
			} catch (FileNotFoundException ex) {
				throw new FileNotFoundException("Error loading mail configuration!");
			} catch (IOException ex) {
				throw new IOException("Error reading mail configuration file!");
			}
		} else {
			throw new FileNotFoundException("Set up your email first!");
		}
		Properties props = new Properties();
		props.setProperty("mail.smtp.ssl.trust", smtpService);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpService);
		props.put("mail.smtp.port", smtpPort);
		session = Session.
			getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mail, password);
				}
			});
	}

	public boolean sendEmail(String[] allReceivers, String subject,
							 String message, Cell[][] cells) throws MessagingException {
		boolean ret = false;
		if (cells != null) {
			message += "\n\n";
			for (Cell[] cell : cells) {
				for (Cell cell1 : cell) {
					message += cell1.getContent() + ";";
				}
				message += "\n";
			}
		}

		for (String receiver : allReceivers) {
			try {
				Message mailToSend = new MimeMessage(session);
				mailToSend.setFrom(new InternetAddress(mail));
				mailToSend.setRecipients(Message.RecipientType.TO,
										 InternetAddress.
										 parse(receiver));
				mailToSend.setSubject(subject);
				mailToSend.setText(message);
				Transport.send(mailToSend);
				updateOutBox(receiver, subject, mailToSend.getDescription(), message);
				ret = true;
			} catch (MessagingException e) {
				throw new MessagingException("Error sending mail");
			}
		}
		return ret;
	}

	private void updateOutBox(String receiver, String subject,
							  String description, String message) {
		OutBoxPanel.getInstance().
			insertNewOutBoxItem(receiver, subject, description, message);
	}

}
