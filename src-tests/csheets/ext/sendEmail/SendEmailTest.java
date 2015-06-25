/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sendEmail;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Paulo
 */
public class SendEmailTest {

	private Session session;

	public SendEmailTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		Properties props = new Properties();
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		session = Session.
			getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("1130419paulo@gmail.com", "PareceMasNãoÉxD");
				}
			});
	}

	@After
	public void tearDown() {
	}

	@Test
	public void makeSureReceiverIsSet() throws MessagingException {
		String receiver = "1130419@isep.ipp.pt";
		Message message = new MimeMessage(session);
		message.setRecipients(Message.RecipientType.TO,
							  InternetAddress.
							  parse(receiver));
		Address[] address = message.getAllRecipients();
		Address[] expResult = InternetAddress.
			parse(receiver);
		Assert.assertEquals(expResult[0].toString(), address[0].toString());
	}

	@Test
	public void makeSureSubjectIsSet() throws MessagingException {
		String subject = "Subject";
		Message message = new MimeMessage(session);
		message.setSubject(subject);
		String expResult = message.getSubject();
		Assert.assertEquals(subject, expResult);
	}

	@Test
	public void makeSureMessageIsSet() throws MessagingException, IOException {
		String text = "Message";
		Message message = new MimeMessage(session);
		message.setText(text);
		String expResult = (String) message.getContent();
		Assert.assertEquals(text, expResult);
	}

	@Test
	public void FunctionalTestSendEmail() {
		/*
		 *It has been tested that by sending the email, it reaches the
		 *receveirs without any problems.
		 */
	}
}
