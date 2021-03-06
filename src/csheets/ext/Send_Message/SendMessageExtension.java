/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message;

import csheets.ext.Extension;
import csheets.ext.Send_Message.UI.UIExtensionSendMessage;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author DMMCA
 */
public class SendMessageExtension extends Extension {

    /**
     * The name of the extension
     */
    public static String NAME = "Send Message";
    /*
     * Creates a new SendMessage extension.
     */

    public SendMessageExtension() {
        super(NAME);
    }

    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionSendMessage(this, uiController);
    }
}
