/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searchOnAnotherInstance.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Paulo Pereira <1130419@isep.ipp.pt>
 */
class SearchOnAnotherInstanceAction extends BaseAction {

    private UIController controller;
    
    public SearchOnAnotherInstanceAction(UIController uiController) {
        controller = uiController;
    }

    @Override
    protected String getName() {
        return "Search On Another Instance...";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SearchOnAnotherInstanceDialog dialog = SearchOnAnotherInstanceDialog.getInstance(controller);
        dialog.setVisible(true);
    }
    
}
