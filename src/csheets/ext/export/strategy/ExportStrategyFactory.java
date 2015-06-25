/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.export.strategy;

import csheets.ext.export.strategy.XML.ExportXML;

/**
 *
 * @author Luis Lopes <1130752@isep.ipp.pt>
 */
public class ExportStrategyFactory {
    
    private static ExportStrategyFactory instance = null;

	private ExportStrategyFactory() {
	}

	public static synchronized ExportStrategyFactory getInstance() {
		if (instance == null) {
			instance = new ExportStrategyFactory();
		}
		return instance;
	}

	public ExportStrategy getExportStrategy(String type) {
		if (".xml".equalsIgnoreCase(type)) {
			return new ExportXML();
		}
                return null;
	}
}
