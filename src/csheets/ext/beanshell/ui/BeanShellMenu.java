package csheets.ext.beanshell.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 * A menu for the scripts extension, it will open a new BeanShell window.
 * @author jose
 */
public class BeanShellMenu extends JMenu {

    /**
     * Creates a new menu for the scripts extension
     */
    public BeanShellMenu(UIController uiController) {

        super("BeanShell scripts");
        
        // creates and adds an action for this menu to be triggered when it is selected
        BeanShellAction createAction = new BeanShellAction(uiController);
        this.add(createAction);
    }

}
