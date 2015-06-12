/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import csheets.ext.startsharing.ui.SendCellsAction;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 */
public class ReceiveData implements Runnable {

	//private ObjectInputStream objectIn;
	private DataInputStream dataIn;
	Semaphore sem;
	private static SendCellsAction cellsAction;
	private Socket sock;

	public ReceiveData(Socket sock, SendCellsAction cellsAction) {
		try {
			this.dataIn = new DataInputStream(sock.getInputStream());
			//this.objectIn = new ObjectInputStream(sock.getInputStream());
			this.sem = new Semaphore(1);
			this.sock = sock;
			ReceiveData.cellsAction = cellsAction;
		} catch (IOException ex) {
			Logger.getLogger(ReceiveData.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run() {
		int nChars;

		try {
			while (true) {
				dataIn = new DataInputStream(sock.getInputStream());
				byte[] data = new byte[300];
				System.out.println("func");
				nChars = dataIn.read();
				if (nChars == 0) {
					break;
				}

				if (nChars > 0) {
					dataIn.read(data, 0, nChars);
					String functionality = new String(data, 0, nChars);
					choosenFunctionality(functionality);
				}

			}
		} catch (IOException ex) {
			Logger.getLogger(ReceiveData.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	private void choosenFunctionality(String functionality) {
		try {
			sem.acquire();
			byte[] data = new byte[300];
			int nChars;
//			if (functionality.equals("Share Cells")) {
//				Object obj;
//				List<Cell> receivedCells = new ArrayList<Cell>();
//				while (true) {
//					obj = objectIn.read();
//					if (obj == null) {
//						NetworkService.receiveCells(receivedCells, cellsAction);
//						break;
//					}
//					receivedCells.add((Cell) obj);
//				}
//			} else
			if (functionality.equals("Share Cells Content")) {
				String message;
				List<String> cellsContent = new ArrayList<String>();
				List<String> cellsColumns = new ArrayList<String>();
				List<String> cellsRows = new ArrayList<String>();
				while (true) {
					nChars = dataIn.read();
					dataIn.read(data, 0, nChars);
					message = new String(data, 0, nChars);
					if (message.equals("end")) {
						NetworkService.
							receiveCellsContent(cellsContent, cellsColumns, cellsRows, cellsAction);
						break;
					}
					cellsContent.add(message);

					nChars = dataIn.read();
					dataIn.read(data, 0, nChars);
					message = new String(data, 0, nChars);
					cellsColumns.add(message);

					nChars = dataIn.read();
					dataIn.read(data, 0, nChars);
					message = new String(data, 0, nChars);
					cellsRows.add(message);
				}
			}

			sem.release();
		} catch (IOException ex) {
			Logger.getLogger(ReceiveData.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (InterruptedException ex) {
			Logger.getLogger(ReceiveData.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}
}
