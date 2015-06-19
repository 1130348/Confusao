/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.export.strategy.XML;

import csheets.core.Cell;
import csheets.ext.export.strategy.ExportProcess;
import csheets.ext.export.strategy.ExportStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Luis Lopes <1130752@isep.ipp.pt>
 */
public class ExportXML implements ExportStrategy{
 
    
    
    public ExportXML() {
	}
   
    
    /**
     *
     * @param eProcess
     * @return
     */
    @Override
    public File export(ExportProcess eProcess,Cell[][] cells,boolean tags,String filename)  {
        Document doc =null;
       try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
            doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("CleanSheets");
            doc.appendChild(rootElement);
            int tamanho = cells.length;

            for (int i = 0; i < tamanho; i++) {
                   for (int j = 0; j < cells[i].length; j++) {
                       
                       Element cell =  doc.createElement("Cell");
                       rootElement.appendChild(cell);
                       
                       Attr attr = doc.createAttribute("id");
                       attr.setValue(i + ":" +  j);
                       cell.setAttributeNode(attr);
                       
                      Element content = doc.createElement("content");
                      content.appendChild(doc.createTextNode(cells[i][j].getContent()));
                      cell.appendChild(content);
                      
                                                             }
		
                                                 }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(filename));
            

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ExportXML.class.getName()).
				log(Level.SEVERE, null, ex);
		} catch (TransformerConfigurationException ex) {
			Logger.getLogger(ExportXML.class.getName()).
				log(Level.SEVERE, null, ex);
		}
      String uri= doc.getDocumentURI();
      File f = new File(uri);
      JOptionPane.showMessageDialog(null, "File Saved");
      return f;
    }



    
}
