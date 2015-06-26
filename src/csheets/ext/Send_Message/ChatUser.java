/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;

/**
 *
 * @author Jose
 */
public class ChatUser {

	private InetAddress ip;
	private boolean status;
	private String[] messages;

	public ChatUser() {

	}

	public ChatUser(InetAddress ip, boolean status, String messages[]) {
		this.ip = ip;
		this.status = status;
		for (int i = 0; i < messages.length; i++) {
			this.messages[i] = messages[i];

		}
	}

	public String toString() {
		return "Ip " + ip + " status " + status;
	}

	public void save() throws FileNotFoundException, IOException {
		String name = "Messages" + ip.toString() + ".txt";
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name));
		out.writeChars("User: " + ip.toString() + "\n");
		for (int i = 0; i < messages.length; i++) {
			out.writeChars(messages[i] + "\n");
		}
		out.close();
	}
}
