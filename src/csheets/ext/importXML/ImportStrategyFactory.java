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
public class ImportStrategyFactory {

	private static ImportStrategyFactory instance = null;

	private ImportStrategyFactory() {
	}

	public static synchronized ImportStrategyFactory getInstance() {
		if (instance == null) {
			instance = new ImportStrategyFactory();
		}
		return instance;
	}

	public ImportStrategy getImportStrategy(String type) {
		if (".xml".equalsIgnoreCase(type)) {
			return new ImportXML();
		}
		return null;
	}

}
