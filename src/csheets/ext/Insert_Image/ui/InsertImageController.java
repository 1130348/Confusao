/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.ext.Insert_Image.InsertImageCell;
import csheets.ui.ctrl.UIController;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Marcos
 */
public class InsertImageController {

    private static InsertImageController controller;

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * User interface panel *
     */
    private InsertImagePanel uiPanel;

    private InsertImagePanel panel;

    /**
     * Creates a new image controller.
     *
     * @param uiController the user interface controller
     * @param uiPanel the user interface panel
     */
    public InsertImageController(UIController uiController, InsertImagePanel uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;
        this.controller = this;

    }

    /**
     * Attempts to insert a new image from the given string. If successful, adds
     * the image to the given cell. If the input string is empty or null, the
     * image is set to null.
     *
     * @param cell the cell for which the image should be set
     * @param path the image path
     * @return true if the cell's image was changed
     */
    public boolean setImage(InsertImageCell cell, String path) {
        // Clears image, if insufficient input
        if (path == null || path.equals("")) {
            cell.setUserImage(null);
            return true;
        }
        System.out.println("PHASE1");
        // Stores the image
        cell.setUserImage(path);
        System.out.println("PHASE2");
        uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
        return true;
    }

    /**
     * A cell is selected.
     *
     * @param cell the cell whose image changed
     */
//    public void cellSelected(InsertImageCell cell) {
//        // Updates the image field and validates the image
//        if (cell.hasImage()) {
//            panel.setImage(cell.getImage());
//        } else {
//            panel.setImage("");
//        }
//    }
    public void filechooser() throws IOException {
        JFileChooser fc = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(imageFilter);

        int returnVal = fc.showOpenDialog(panel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + fc.getSelectedFile().getAbsolutePath());
            Icon image = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
            JLabel imageLabel = new JLabel(image, JLabel.CENTER);
            panel.add(imageLabel);
        }

    }

    public static InsertImageController getCont() {
        return controller;
    }

}
