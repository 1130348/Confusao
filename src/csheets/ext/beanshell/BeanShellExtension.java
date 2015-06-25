package csheets.ext.beanshell;

import csheets.ext.Extension;
import csheets.ext.beanshell.ui.UIExtensionBeanShell;
import csheets.ui.ctrl.UIController;

/**
 * An extension for creating and executing BeanShell scripts.
 *
 * @author rddm
 */
public class BeanShellExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "BeanShell scripts";

    /**
     * Creates a new task management extension.
     */
    public BeanShellExtension() {
        super(NAME);
    }
    
    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtensionBeanShell getUIExtension(UIController uiController) {
        return new UIExtensionBeanShell(this, uiController);
    }
}
