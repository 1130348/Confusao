/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.search;

import csheets.ext.Extension;
import csheets.ext.search.ui.SearchPanel;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author Andre
 */
public class UIExtensionSearch extends UIExtension {

    /**
     * A menu that provides call function
     */
    
    private JComponent sideBar;

    /**
     * Creates a new user interface extension for call function.
     *
     * @param extension the extension for which components are provided
     * @param uiController the user interface controller
     */
    public UIExtensionSearch(Extension extension,
                                   UIController uiController) {
        super(extension, uiController);
    }

    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new SearchPanel(uiController);
        }
        return sideBar;
    }

}
