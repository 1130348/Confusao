/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.ui.ctrl.BaseAction;
import java.awt.event.ActionEvent;

/**
 *
 * @author Marcos
 */
public class RemoveImageAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected InsertImageController uiController;

    public RemoveImageAction() {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Remove Image";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("MORDEFOKASasdasd");
    }

}
