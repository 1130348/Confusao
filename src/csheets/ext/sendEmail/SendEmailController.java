/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sendEmail;

import java.io.IOException;
import javax.mail.MessagingException;

/**
 *
 * @author Paulo
 */
public class SendEmailController {

	private SendEmail sendEmail;

	private static SendEmailController controller;

	private SendEmailController() {
		sendEmail = new SendEmail();
	}

	public static SendEmailController getInstance() {
		if (controller == null) {
			controller = new SendEmailController();
		}
		return controller;
	}

	public void initiateSession() throws IOException {
		sendEmail.initiateSession();
	}

	public boolean sendEmail(String[] allReceivers, String subject,
							 String message) throws MessagingException {
		return sendEmail.sendEmail(allReceivers, subject, message);
	}

}
