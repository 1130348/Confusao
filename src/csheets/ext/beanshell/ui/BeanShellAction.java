package csheets.ext.beanshell.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * This action will trigger the creation of a BeanShell console.
 *
 * @author 1130616
 */
public class BeanShellAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new action.
     *
     */
    public BeanShellAction(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Action name that will be displayed on the menu option
     */
    protected String getName() {
        return "Open console";
    }

    protected void defineProperties() {
        // assigns a shortcut key
        putValue(MNEMONIC_KEY, KeyEvent.VK_O);
    }

    /**
     * A simple action that shows a window with a BeanShell console.
     *
     * @param e the event that was fired
     */
    public void actionPerformed(ActionEvent e) {

        // creates a console window
        BeanShellInterface cWindow = new BeanShellInterface(uiController);
    }

}
