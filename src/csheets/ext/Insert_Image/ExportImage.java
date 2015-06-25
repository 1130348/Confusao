/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Silva <1130664@isep.ipp.pt>
 */
public class ExportImage {

    public ExportImage() {

    }

    public void export(Icon icon, File outputfile) {
        try {
            BufferedImage bi = new BufferedImage(
                    icon.getIconWidth(),
                    icon.getIconHeight(),
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            ImageIO.write(bi, "jpg", outputfile);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error exporting the file!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
