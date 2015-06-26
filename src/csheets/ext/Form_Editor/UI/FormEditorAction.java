/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Form_Editor.UI;

import csheets.ui.ctrl.BaseAction;
import java.awt.event.ActionEvent;

/**
 *
 * @author DMMCA
 */
class FormEditorAction extends BaseAction {

    private FormEditorController controller;
    private int typeofEditor;

    FormEditorAction(FormEditorController controller, int i) {
        this.controller = controller;
        this.typeofEditor = i;

    }

    @Override
    protected String getName() {
        return NAME;

    }

    @Override
    protected void defineProperties() {

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        switch (typeofEditor) {
            case 0:
                controller.CreateForm();
                break;
            case 1:
                controller.Edit();
                break;
            case 2:
                controller.Display();
                break;

            case 3:
                controller.Remove();
                break;

        }
    }
}
