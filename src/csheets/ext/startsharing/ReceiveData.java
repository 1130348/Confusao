/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import csheets.core.Cell;
import csheets.ext.startsharing.ui.SendCellsAction;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

	private ObjectInputStream objectIn;
	private DataInputStream dataIn;
	Semaphore sem;
	private static SendCellsAction cellsAction;

	public ReceiveData(Socket sock, SendCellsAction cellsAction) {
		try {
			this.dataIn = new DataInputStream(sock.getInputStream());
			this.objectIn = new ObjectInputStream(sock.getInputStream());
			this.sem = new Semaphore(1);
			ReceiveData.cellsAction = cellsAction;
		} catch (IOException ex) {
			Logger.getLogger(ReceiveData.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run() {
		int nChars;
		byte[] data = new byte[300];
		try {
			while (true) {

				nChars = dataIn.read();
				if (nChars == 0) {
					break;
				}

				dataIn.read(data, 9, nChars);
				String functionality = new String(data, 0, nChars);
				choosenFunctionality(functionality);
			}
		} catch (IOException ex) {
			Logger.getLogger(ReceiveData.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

	private void choosenFunctionality(String functionality) {
		try {
			sem.acquire();
			Object data;

			if (functionality.equals("Share Cells")) {
				List<Cell> receivedCells = new ArrayList<Cell>();
				while (true) {
					data = objectIn.read();
					if (data == null) {
						NetworkService.receiveCells(receivedCells, cellsAction);
						break;
					}
					receivedCells.add((Cell) data);
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