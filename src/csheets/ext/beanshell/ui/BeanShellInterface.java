package csheets.ext.beanshell.ui;

import bsh.util.JConsole;
import csheets.ext.beanshell.BeanShellController;
import csheets.ui.ctrl.UIController;
import javax.swing.JFrame;

/**
 * The window where a console will be displayed for creating/executing BeanShell
 * scripts.
 *
 * @author jose
 */
public class BeanShellInterface extends JFrame {

    /**
     * Title to display on the window.
     */
    private final String WINDOW_TITLE = "BeanShell Console";
    /**
     * Width window size.
     */
    private final int WINDOW_WIDTH = 600;
    /**
     * Heigh window size.
     */
    private final int WINDOW_HEIGHT = 400;

    private UIController uiController;
    /**
     * Component to create/execute BeanShell scripts.
     */
    private JConsole console;
    
    private BeanShellController bsc;
    
    private final String INITIAL_TEXT
            = "Welcome to the BeanShell console!\n"
            + "Here are a few examples to get you started:\n"
            + "Recognize all packages and librarys: addClassPath(\".\");import *;\n"
            + "Controllers that can be use:\n - uic (UIController) \n - macros (MacrosWindowController)\n\n\n"
            + "Defining a variable: number = 5, cat = \"Meow\"\n"
            + "Printing a variable: print(number - 0.5), print(cat)\n"
            + "Using a loop: for (i=0; i<3; i++) print(i)\n"
            + "Creating objects: object=new Object();\n"
            + "Creating new workbook: uic.getApp().create(); \n or w=new Workbook(numberOfSpreedSheets); uic.setActiveWorkbook(w);\n"
            + "Creating new macros: m=\"SUM(2;3)\\nEXPRS(n;n)\";\n"
            + "Saving macros: macros.addMacro(MacroName,m);\n"
            + "Running macros: out=macros.runMacro(m or macroName);print(out);\n"
            + "Note: all instructions should end with a semicolon ';'\n"
            + "Have fun! :)\n";

    public BeanShellInterface(UIController uiController){
        this.uiController = uiController;
        this.console = new JConsole();
        console.println(INITIAL_TEXT);
        console.setVisible(true);
        this.setTitle(WINDOW_TITLE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        bsc=new BeanShellController(uiController,console);
        this.add(console);
        this.setVisible(true);
    }
}
