/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.beanshell;

import bsh.EvalError;
import bsh.Interpreter;
import bsh.util.JConsole;
import csheets.ext.MacrosWindow.MacrosWindowController;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author rddm
 */
public class BeanShellController {

    private UIController uiController;

    public BeanShellController(UIController uic,JConsole bc) {
        uiController=uic;
        Interpreter interpreter = new Interpreter( bc);
        try {
            interpreter.set("uic", uiController);
            interpreter.set("macros", new MacrosWindowController());
        } catch (EvalError ex) {
            ex.printStackTrace();
        }
        new Thread(interpreter).start();
    }

}
