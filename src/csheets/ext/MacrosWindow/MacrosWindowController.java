/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.MacrosWindow;

import csheets.core.formula.Function;
import csheets.core.formula.lang.Language;
import csheets.ext.call_function.FunctionCaller;
import java.util.ArrayList;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class MacrosWindowController {

	private final Language language;

	FunctionCaller functionCaller;

	/**
	 * The vector with the code of the macros
	 */
	private ArrayList<String> savedMacros;

	/**
	 * The names of the macros
	 */
	private ArrayList<String> savedMacrosName;

	/**
	 * Constructor without parameters
	 */
	public MacrosWindowController() {
		language = Language.getInstance();
	}

	/**
	 * Gets all the function of the cleansheets project
	 *
	 * @return
	 */
	public Function[] retrieveFunctionsList() {
		return language.getFunctions();
	}

	/**
	 * Changes the value of the ArrayList savedMacros
	 *
	 * @param tmp
	 */
	public void setMacros(ArrayList<String> tmp) {
		savedMacros = tmp;
	}

	/**
	 * Changes the value of the ArrayList savedMacrosName
	 *
	 * @param tmp
	 */
	public void setMacrosName(ArrayList<String> tmp) {
		savedMacrosName = tmp;
	}

	/**
	 * Returns the code of the macros
	 *
	 * @return
	 */
	public ArrayList<String> getMacros() {
		return savedMacros;
	}
}
