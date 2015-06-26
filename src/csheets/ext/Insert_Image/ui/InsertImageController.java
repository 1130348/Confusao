/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.ext.Insert_Image.ExportImage;
import csheets.ext.Insert_Image.InsertImageCell;
import csheets.ui.ctrl.UIController;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Marcos
 */
/**
 *
 *
 * A controller for updating the path image of a cell.
 *
 */
public class InsertImageController {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * User interface panel
     */
    private InsertImagePanel uiPanel;

    /**
     * Creates a new InsertImage controller.
     *
     * @param uiController the user interface controller
     * @param uiPanel the user interface panel
     */
    public InsertImageController(UIController uiController, InsertImagePanel uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;
    }

    /**
     * Attempts to create a new image from the given string. If successful, adds
     * the image to the given cell. If the input string is empty or null, the
     * image is set to null.
     *
     * @param cell the cell for which the comment should be set
     * @param path the comment, as entered by the user
     * @return true if the cell's comment was changed
     */
    public boolean setImage(InsertImageCell cell, String path) {
        // Clears image, if insufficient input
        if (path == null || path.equals("")) {
            cell.setImagePath(null);
            return true;
        }
        // Stores the image
        cell.setImagePath(path);
        uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
        return true;
    }

    /**
     * A cell is selected.
     *
     * @param cell the cell whose image changed
     */
    public void cellSelected(InsertImageCell cell) {
        // Updates the label field and validates the image.
        if (cell.hasImage()) {
            uiPanel.setImage(cell.getImage());
        } else {
            uiPanel.setImage(null);
        }
    }

    /**
     * A FileChooser to load the image.
     *
     * @return String path
     */
    public String ChooserIMG() {
        JFileChooser fc = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(imageFilter);

        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    public void exportImage(Icon icon, File f) {
        ExportImage expImage = new ExportImage();
        expImage.export(icon, f);
    }

    /**
     * Converts the file choosed to a jpg File
     *
     * @param f
     * @return
     */
    public File getFileName(File f) {
        String OS = System.getProperty("os.name").toLowerCase();
        String path = f.getAbsolutePath();
        int sep;
        if(OS.indexOf("win") > 0){ // verifies if it is windows
            sep = path.lastIndexOf("\\");
        }else {
            sep = path.lastIndexOf("/"); //it is mac
        }
        String pathWithoutName = path.substring(0, sep + 1);
        String name = f.getName();
        String newName;
        String extension;
        int index = name.lastIndexOf(".");

        if (index == -1) {
            newName = path.substring(sep + 1) + ".jpg";
            return new File(pathWithoutName + newName);
        } else {
            extension = name.substring(index);
            if (extension.compareTo(".jpg") == 0) {
                return new File(pathWithoutName + name);
            }else {
                newName = f.getName().substring(0, index);
                newName += ".jpg";
                return new File(pathWithoutName + newName);
            }
        }
    }
}
