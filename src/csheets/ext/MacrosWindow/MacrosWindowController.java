/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.MacrosWindow;

import csheets.core.call_function.FunctionCaller;
import csheets.core.formula.Function;
import csheets.core.formula.lang.Language;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class MacrosWindowController {

    private final Language language;
    
    FunctionCaller functionCaller;

    public MacrosWindowController() {
        language = Language.getInstance();
    }
    
    public Function[] retrieveFunctionsList(){
        return language.getFunctions();
    }

}
