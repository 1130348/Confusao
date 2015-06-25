/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importXML;

/**
 *
 * @author Sergio Gomes
 */
public class XMLTag {

	private static XMLTag instance = null;

	private String cellTag;

	public XMLTag() {

	}

	public static XMLTag getInstance() {
		if (instance == null) {
			instance = new XMLTag();
		}
		return instance;
	}

	public void setCellTag(String cellTag) {
		this.cellTag = cellTag;
	}

	public String getCellTag() {
		return this.cellTag;
	}

}
