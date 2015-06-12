/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.ui.ctrl.BaseAction;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
class InsertImageAction extends BaseAction {

    /**
     * The user interface controller
     */


    public InsertImageAction() {
    }

    @Override
    protected String getName() {
        return "Insert Image";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
           InsertImageController.getCont().filechooser();
        } catch (IOException ex) {
            Logger.getLogger(InsertImageAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
