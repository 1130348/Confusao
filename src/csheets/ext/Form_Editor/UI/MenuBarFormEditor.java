/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Form_Editor.UI;

import csheets.ui.ctrl.UIController;
import static javax.swing.Action.NAME;
import javax.swing.JMenu;

/**
 *
 * @author DMMCA
 */
public class MenuBarFormEditor extends JMenu {

    private FormEditorController controller;

    MenuBarFormEditor(UIController uiController) {
        super("Form Editor");
        controller = new FormEditorController(uiController, this);

        FormEditorAction sa = new FormEditorAction(controller, 0);
        sa.putValue(NAME, "Create Form");
        add(sa);

        sa = new FormEditorAction(controller, 1);
        sa.putValue(NAME, "Edit Form");
        add(sa);

        sa = new FormEditorAction(controller, 2);
        sa.putValue(NAME, "Display Form");
        add(sa);
        
        sa = new FormEditorAction(controller, 3);
        sa.putValue(NAME, "Remove Form");
        add(sa);
    }

}
