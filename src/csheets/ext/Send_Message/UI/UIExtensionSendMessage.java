/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message.UI;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import javax.swing.JMenu;

/**
 *
 * @author DMMCA
 */
public class UIExtensionSendMessage extends UIExtension {

    /**
     * A side bar that provides Radio Button to start or stop service
     */
    private JComponent sideBar;

    /**
     * The menu of the extension
     */
    private SendMessageMenu menu;

    public UIExtensionSendMessage(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a side bar that provides the image
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new SendMessageSideBar(uiController);
        }
        return sideBar;
    }

    /**
     * Returns an instance of a class that implements JMenu.
     *
     * @see SendMessageMenu
     * @return a JMenu component
     */
    public JMenu getMenu() {
		if (menu == null)
			menu = new SendMessageMenu(uiController);
		return menu;
	}

}
