/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author Marcos
 */
public class UIExtensionInsertImage extends UIExtension {

    /**
     * A cell decorator that visualizes image on cells
     */
    private CellDecorator cellDecorator;
    
    /**
     * A side bar that provides the view of image
     */
    private JComponent sideBar;

    public UIExtensionInsertImage(Extension extension, UIController uiController) {
        super(extension, uiController);
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns a cell decorator that visualizes image on cells.
     *
     * @return decorator for cells with image
     */
    @Override
    public CellDecorator getCellDecorator() {
        if (cellDecorator == null) {
            cellDecorator = new InsertImageCellDecorator();
        }
        return cellDecorator;
    }

    /**
     * Returns a side bar that provides the image
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new InsertImagePanel(uiController);
        }
        return sideBar;
    }
}
