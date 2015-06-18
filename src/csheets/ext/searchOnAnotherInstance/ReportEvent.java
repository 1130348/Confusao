/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance;

import csheets.core.Workbook;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
public class ReportEvent {

	private Workbook workbook;
	private String instancia;

	public ReportEvent(Workbook workbook) {
		this.workbook = workbook;
	}

	public ReportEvent(Workbook workbook, String instancia) {
		this.workbook = workbook;
		this.instancia = instancia;
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public String getInstancia() {
		return instancia;
	}

}
