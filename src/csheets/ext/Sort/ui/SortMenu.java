/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Sort.ui;

import csheets.ui.ctrl.UIController;
import static javax.swing.Action.NAME;
import javax.swing.JMenu;

/**
 *
 * @author DMMCA
 */
public class SortMenu extends JMenu {

    
    SortController controller;
	/**
	 * Creates a new simple menu.
	 * This constructor creates and adds the menu options. 
	 * In this simple example only one menu option is created.
	 * A menu option is an action (in this case {@link csheets.ext.simple.ui.ExampleAction})
	 * @param uiController the user interface controller
	 */
        
        
	public SortMenu(UIController uiController) {
		super("Sort");
                controller = new SortController(uiController, this);
		// Adds font actions
                SortAction sa = new SortAction(controller,0);
                sa.putValue(NAME, "Sort Ascending");
		add(sa);
                
                sa = new SortAction(controller,1);
                sa.putValue(NAME, "Sort Descending");
                add(sa);
                
	}
    
    
    
    
}
