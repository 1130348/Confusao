/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Email;

/**
 *
 * @author Paulinho
 */
public class SmtpConfig {

	private String smtpService;
	private String smtpPort;

	public SmtpConfig() {
	}

	public SmtpConfig(String smtpService) {

		if (smtpService.equalsIgnoreCase("gmail")) {
			this.smtpService = "smtp.gmail.com";
			smtpPort = "587";
		}

		if (smtpService.equalsIgnoreCase("hotmail")) {
			this.smtpService = "smtp.live.com";
			smtpPort = "587";
		}

		if (smtpService.equalsIgnoreCase("isep")) {
			this.smtpService = "smtp.office365.com";
			smtpPort = "587";
		}

	}

	public String getService() {
		return smtpService;
	}

	public String getPort() {
		return smtpPort;
	}

}
