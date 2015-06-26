/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message;

import csheets.ext.Send_Message.UI.ChatUI;
import csheets.ext.Send_Message.UI.FindInstancesUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DMMCA
 */
public class Connection {

	private Socket SOCKET;
	private ServerSocket SERVERSOCKET;
	private InputStream inStream = null;
	private OutputStream outStream = null;
	private Thread readThread, writeThread;
	private static ChatUI ui;
	private static FindInstancesUI instancesui;
	private static HashMap<String, String> map = new HashMap<String, String>();
	private FindInstancesUI findUI = new FindInstancesUI();

	private List ar = new ArrayList();

	public Connection(String ip, int port) {
		try {
			this.SOCKET = new Socket(ip, port);
		} catch (IOException ex) {
			System.out.println("Could not connect");
		}
	}

	public Connection(int port) {
		try {
			this.SERVERSOCKET = new ServerSocket(port);
		} catch (IOException ex) {
			System.out.println("Could not connect");
		}
	}

	public Socket getConSocket() {
		return SOCKET;
	}

	public ServerSocket getConServerSocket() {
		return SERVERSOCKET;
	}

	public void createThreads() throws IOException {
		if (SOCKET == null) {
			try {
				SOCKET = SERVERSOCKET.accept();
			} catch (IOException ex) {

			}
		}
		inStream = SOCKET.getInputStream();
		outStream = SOCKET.getOutputStream();
		readThread = readThread();
		readThread.setPriority(Thread.MAX_PRIORITY);
		readThread.start();

		writeThread = writeThread();
		writeThread.setPriority(Thread.MAX_PRIORITY);
		writeThread.start();
	}

	private Thread writeThread() {
		return new Thread() {

			@Override
			public void run() {
				while (SOCKET.isConnected()) {

					try {
						BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
						sleep(100);
						String msg = input.readLine();

						if (msg != null && msg.length() > 0) {

							SendMessage(Arrays.toString(msg.
								getBytes("ISO-8859-1")));
							sleep(100);
						}
					} catch (IOException | InterruptedException i) {
					}
				}
			}
		};
	}

	public void setUI(ChatUI ui) {
		Connection.ui = ui;
	}

	public void setInstancesUI(FindInstancesUI ui) {
		this.instancesui = ui;
	}

	public void SendMessage(String msg) throws IOException {
		outStream.write(msg.getBytes("ISO-8859-1"));
		ui.setMsg(InetAddress.getLocalHost().getHostName() + " says: " + msg);
	}

	private Thread readThread() {
		return new Thread() {
			@Override
			public void run() {
				while (SOCKET.isConnected()) {
					try {
						byte[] readBuffer = new byte[200];
						int num = inStream.read(readBuffer);
						if (num > 0) {
							byte[] arrayBytes = new byte[num];
							System.arraycopy(readBuffer, 0, arrayBytes, 0, num);
							String msg = new String(arrayBytes, "ISO-8859-1");
							ui.
								setMsg(SOCKET.getInetAddress().getHostName() + " says: " + msg);
							if (!ui.isFocused()) {
								JOptionPane.
									showMessageDialog(null, "Message Received!!!!\n from: " + SOCKET.
													  getInetAddress().
													  getHostName());
							}

						}
					} catch (SocketException se) {
					} catch (IOException i) {
					}
				}
			}
		};
	}

	public static void searchActiveInstances() throws IOException {
		System.out.println("search1");
		Thread f = new Thread() {
			public void run() {
				try {
					while (true) {
						int port = 5000;
						String group = "239.255.0.0";
						MulticastSocket s = new MulticastSocket(port);
						s.joinGroup(InetAddress.getByName(group));
						byte buf[] = new byte[1024];

						DatagramPacket pack = new DatagramPacket(buf, buf.length);
						s.receive(pack);
						System.out.println("search2");
						if (!map.containsKey(pack.getAddress().toString())) {
							map.put(pack.getAddress().toString(), "");
							if (!InetAddress.getLocalHost().getHostAddress().
								equalsIgnoreCase(pack.getAddress().toString().
									substring(1, pack.getAddress().toString().
											  length()))) {

								if (!InetAddress.getLocalHost().getHostAddress().
									equalsIgnoreCase(pack.getAddress().
										toString().substring(1, pack.
															 getAddress().
															 toString().length()))) {
									Connection n = new Connection(pack.
										getAddress().toString().
										substring(1, pack.getAddress().
												  toString().length()), 3439);
									n.createThreads();
									ui.SetConnection(pack.getAddress().
										toString().substring(1, pack.
															 getAddress().
															 toString().length()));
									System.out.println("funciona");

								}
							}
						}

						s.leaveGroup(InetAddress.getByName(group));
						s.close();
						Thread.sleep(1500);
					}
				} catch (IOException ex) {
					Logger.getLogger(csheets.ext.file_sharing.Connection.class.
						getName()).
						log(Level.SEVERE, null, ex);
				} catch (InterruptedException ex) {
					Logger.getLogger(csheets.ext.file_sharing.Connection.class.
						getName()).
						log(Level.SEVERE, null, ex);
				}
			}
		};
		f.start();
	}

	public static void setListenner() {
		System.out.println("Listner1");
		Thread f = new Thread() {
			public void run() {
				try {
					while (true) {
						int port = 5000;
						String group = "239.255.0.0";
						System.out.println("Listner2");

						MulticastSocket s = new MulticastSocket();
						byte buf[] = new byte[10];
						for (int i = 0; i < buf.length; i++) {
							buf[i] = (byte) i;
						}

						DatagramPacket pack = new DatagramPacket(buf, buf.length,
																 InetAddress.
																 getByName(group), port);

						s.send(pack);
						s.close();
						Thread.sleep(5000);
					}
				} catch (IOException ex) {
					Logger.getLogger(Connection.class.getName()).
						log(Level.SEVERE, null, ex);
				} catch (InterruptedException ex) {
					Logger.getLogger(Connection.class.getName()).
						log(Level.SEVERE, null, ex);
				}
			}
		};
		f.start();
	}
}
