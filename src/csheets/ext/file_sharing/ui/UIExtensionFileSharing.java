/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.file_sharing.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author Marcos
 */
public class UIExtensionFileSharing extends UIExtension {

    /**
     * A side bar that provides the view of file sharing panel
     */
    private JComponent sideBar;

    public UIExtensionFileSharing(Extension extension, UIController uiController) {
        super(extension, uiController);
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns a side bar that provides the the file sharing panel
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new FileSharingPanel(uiController);
        }
        return sideBar;
    }
}