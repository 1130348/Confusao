/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.MacrosWindow;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Function;
import csheets.core.formula.compiler.IllegalFunctionCallException;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.UnknownElementException;
import csheets.ext.call_function.FunctionCaller;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class MacrosWindowController {

    private final Language language;

    FunctionCaller functionCaller=new FunctionCaller();
    
    private static Map<String,String> macrosCreated=new HashMap<>();

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

    public Value runMacro(String text) {
        Value value = new Value();
        ArrayList<String> formulasList = new ArrayList<>();
        String[] aux = text.split("\n");
        formulasList.addAll(Arrays.asList(aux));
        for (int i = 0; i < formulasList.size(); i++) {
            String temp=formulasList.get(i);
            if(macrosCreated.containsKey(temp)){
                formulasList.remove(i);
                formulasList.add(i, macrosCreated.get(temp));
            }            
        }
        for (String formula : formulasList) {
            try {
                if (formula.charAt(0) != ';') {
                    if (formula.charAt(0) == '=') {
                        formula = formula.substring(1);
                    }
                    value = functionCaller.executeFunc(formula);
                }
            } catch (ParseException | IllegalFunctionCallException | UnknownElementException | IllegalValueTypeException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Some of the functions in the macro are not currently supported!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                break;
            } catch (StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Your macro syntax is invalid!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                break;
            }
        }
        return value;
    }
    
    public void addMacro(String name,String text){
        if(!macrosCreated.containsKey(name)){
        macrosCreated.put(name, text);
        }else System.out.println("already exists..");
    }
}
