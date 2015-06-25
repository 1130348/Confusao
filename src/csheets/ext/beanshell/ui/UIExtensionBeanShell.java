package csheets.ext.beanshell.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import javax.swing.JMenu;

/**
 * This class implements the UI interface extension for the beanshell
 * extension. A UI interface extension must extend the UIExtension abstract
 * class.
 *
 * @see UIExtension
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class UIExtensionBeanShell extends UIExtension {

    /**
     * A menu that provides beanshell
     */
    private BeanShellMenu menu;
    /**
     * Creates a new user interface extension for beanshell.
     *
     * @param extension the extension for which components are provided
     * @param uiController the user interface controller
     */
    public UIExtensionBeanShell(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a menu
     *
     * @return a JMenu component
     */
    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new BeanShellMenu(uiController);
        }
        return menu;
    }
}
