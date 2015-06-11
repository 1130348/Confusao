/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.startsharing;

import csheets.core.Cell;
import csheets.ext.startsharing.ui.SendCellsAction;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class StartSharingController {

	public StartSharingController() {

	}

	public void changePort(int port) {
		NetworkService.setPort(port);
	}

	public void startServer(SendCellsAction cellsAction) {
		NetworkService.startServer(cellsAction);
	}

	public boolean establishConnection(List<String> addresses,
									   SendCellsAction action) {
		return NetworkService.establishConnection(addresses, action);
	}

	public void sendCells(List<Cell> selectedCells) throws IOException {
		NetworkService.sendCells(selectedCells);
	}

	public void setVisibility(boolean b) {
		NetworkService.isVisibleToOthers(b);
	}

	public Map<InetAddress, Integer> searchInstances() {
		return NetworkService.searchInstances();
	}

	public void setSendPort(int port) {
		NetworkService.setPort(port);
	}

	public void interruptConnection() {
		NetworkService.interruptConnection();
	}
}
