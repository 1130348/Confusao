/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Email;

/*
 *
 * @author Paulinho
 */
public class Email {

	private String emailAccount;
	private String password;

	private SmtpConfig smtp;

	public Email() {
	}

	public Email(String emailAccount, String pass, SmtpConfig smtp) {
		this.emailAccount = emailAccount;
		this.password = pass;
		this.smtp = smtp;
	}

	public Email(String emailAccount, String pass, String smtpService) {
		this.emailAccount = emailAccount;
		this.password = pass;
		this.smtp = new SmtpConfig(smtpService);
	}

	public String getEmail() {
		return emailAccount;
	}

	public String getPassword() {
		return password;
	}

	public SmtpConfig getSmtp() {
		return smtp;
	}
}
