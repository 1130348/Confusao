/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importXML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Sergio Gomes
 */
public class ImportXML implements ImportStrategy {

	@Override
	public void importXML(ImportProcess iProcess) {
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.
				newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(iProcess.getFilename());

			doc.getDocumentElement().normalize();
			String tagName = doc.getFirstChild().
				getFirstChild().getNodeName();
			NodeList nList;

			if (tagName.equals(iProcess.getCellTag())) {
				nList = doc.getElementsByTagName(iProcess.getCellTag());
			} else {
				nList = doc.getElementsByTagName(tagName);
			}

			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					if (iProcess.getSheet() == null) {
						iProcess.getActiveWorkbook().addSpreadsheet();
						int sheetIndex = iProcess.getActiveWorkbook().
							getSpreadsheetCount() - 1;
						iProcess.setSpreadSheet(iProcess.getActiveWorkbook().
							getSpreadsheet(sheetIndex));
					}
					String info = eElement.getAttribute("id");
					int row = Integer.parseInt(info.substring(0, info.
															  lastIndexOf(':')));
					int column = Integer.parseInt(info.substring(info.
						lastIndexOf(':') + 1));

					iProcess.getSheet().getCell(column, row).
						setContent(eElement.
							getElementsByTagName("content").item(0).
							getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
