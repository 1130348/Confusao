/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.core.Cell;
import csheets.ext.Insert_Image.InsertImageCell;
import csheets.ext.Insert_Image.InsertImageExtension;
import csheets.ui.ext.CellDecorator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author Marcos
 */
public class InsertImageCellDecorator extends CellDecorator {

    /**
     * Creates a new cell decorator.
     */
    public InsertImageCellDecorator() {
    }

    /**
     * Decorates the given graphics context if the cell being rendered has a
     * image.
     *
     * @param component the cell renderer component
     * @param g the graphics context on which drawing should be done
     * @param cell the cell being rendered
     * @param selected whether the cell is selected
     * @param hasFocus whether the cell has focus
     */
    public void decorate(JComponent component, Graphics g, Cell cell,
            boolean selected, boolean hasFocus) {
        if (enabled) {
            InsertImageCell InsertImageCell = (InsertImageCell) cell.getExtension(InsertImageExtension.NAME);
            if (InsertImageCell.hasImage()) {
                // Stores current graphics context properties
                Graphics2D g2 = (Graphics2D) g;
                
                g2.setColor(Color.BLUE);
                g2.drawString("*", 4, 9);
            }
        }
    }
}
