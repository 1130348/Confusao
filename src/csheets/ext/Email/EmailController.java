package csheets.ext.Email;

import csheets.core.Cell;
import csheets.ext.Email.UI.EmailMenu;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EmailController {

	private static Email mailSettings;
	private static boolean flagEmail;

	private EmailMenu panel;
	private UIController ui;

	/**
	 * Controller to access Email object with parameters verfication
	 *
	 * @param args
	 */
	public EmailController(UIController ui, EmailMenu panel) {
		this.ui = ui;
		this.panel = panel;
	}

	public static void setMailSettings(String mail, String host,
									   String password, Cell cell) {

		mailSettings = new Email(mail, password, new SmtpConfig(host));
		saveEmail(mailSettings);
		flagEmail = true;
		JOptionPane.
			showMessageDialog(null, "Email set successfuly", "Email set", JOptionPane.INFORMATION_MESSAGE);
		sendTestEmail(cell);

	}

	/**
	 * Method to send an test Email to the email account setted before. Test
	 * text by default
	 *
	 * @return
	 */
	public static boolean sendTestEmail(Cell cell) {

		if (!flagEmail) {
			JOptionPane.
				showMessageDialog(null, "An Email has not been set", "Warning",
								  JOptionPane.WARNING_MESSAGE);
			return false;

		} else {

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", mailSettings.getSmtp().getService());
			props.put("mail.smtp.port", mailSettings.getSmtp().getPort());

			Session session = Session.
				getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(mailSettings.
							getEmail(), mailSettings.getPassword());

					}
				});

			// Get the default Session object.
			try {
				Message message = new MimeMessage(session);

				message.setFrom(new InternetAddress(mailSettings.getEmail()));
				message.setRecipients(Message.RecipientType.TO,
									  InternetAddress.parse(mailSettings.
										  getEmail()));
				message.setSubject("Test");
				message.setText(cell.getContent());

				Transport.send(message);
				JOptionPane.showMessageDialog(null, "Email sent");
				return true;
			} catch (AuthenticationFailedException aex) {
				JOptionPane.
					showMessageDialog(null, "Authentication Failed", "Warning",
									  JOptionPane.WARNING_MESSAGE);
				return false;
			} catch (MessagingException mex) {
				JOptionPane.
					showMessageDialog(null, "Something went wrong!", "Warning",
									  JOptionPane.WARNING_MESSAGE);
				mex.printStackTrace();
				return false;
			}
		}
	}

	public static Email getMailSettings() {
		return mailSettings;
	}

	public static void saveEmail(Email em) {

		try {

			String content = "This is the content to write into file";

			File file = new File("EmailTeste.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			} else {
				FileOutputStream fou = new FileOutputStream(file, true);
				byte[] mybytes = (mailSettings.toString() + "\n").getBytes();
				fou.write(mybytes);
				fou.close();
//				FileWriter fw = new FileWriter(file.getAbsoluteFile());
//				BufferedWriter bw = new BufferedWriter(fw);
//				bw.write();
//				bw.close();
			}
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}

}
