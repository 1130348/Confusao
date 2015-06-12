package csheets.ext.Email;

import csheets.core.Cell;
import csheets.ext.Email.UI.EmailMenu;
import csheets.ext.contact.Email;
import csheets.ui.ctrl.UIController;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
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

		mailSettings = new Email(mail);//, password, host);
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
			//props.put("mail.smtp.host", mailSettings.getSmtp().getService());
			//props.put("mail.smtp.port", mailSettings.getSmtp().getPort());

			Session session = Session.
				getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						/*return new PasswordAuthentication(mailSettings.
							getEmail(), mailSettings.getPassword());*/
                                            return null;
					}
				});

			// Get the default Session object.
			try {
				Message message = new MimeMessage(session);

				//message.setFrom(new InternetAddress(mailSettings.getEmail()));

				//message.setRecipients(Message.RecipientType.TO,
									//  InternetAddress.parse(mailSettings.
										//  getEmail()));

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

}
