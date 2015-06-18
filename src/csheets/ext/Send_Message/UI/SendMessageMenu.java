/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Send_Message.UI;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author DMMCA
 */
public class SendMessageMenu extends JMenu{
    /**
	 * Creates a new simple menu.
	 * This constructor creates and adds the menu options. 
	 * In this simple example only one menu option is created.
	 * A menu option is an action (in this case {@link csheets.ext.simple.ui.ExampleAction})
	 * @param uiController the user interface controller
	 */
        SendMessageController controller;
        
	public SendMessageMenu(UIController uiController) {
		super("Send Message");
                //controller = new SendMessageController(uiController, this);
		// Adds font actions
                
                
	}
    
}
