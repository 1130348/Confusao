/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.core.Cell;
import csheets.ext.Insert_Image.InsertImageCell;
import csheets.ext.Insert_Image.InsertImageCellListener;
import csheets.ext.Insert_Image.InsertImageExtension;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marcos
 */
public class InsertImagePanel extends JPanel implements SelectionListener, InsertImageCellListener {

    /**
     * The label in which the image of the cell is displayed.
     */
    private JLabel l = new JLabel();

    /**
     * The string path for the image
     */
    private String PATH = "";

    /**
     * The assertion controller
     */
    private InsertImageController controller;

    /**
     * The image cell currently being displayed in the panel
     */
    private InsertImageCell cell;

    /**
     * Creates a new insert image panel.
     *
     * @param uiController the user interface controller
     */
    public InsertImagePanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        
        // Creates controller
        controller = new InsertImageController(uiController, this);
        uiController.addSelectionListener(this);

        // Add 2 buttons (Insert and Delete)
        JButton in = new JButton("Insert");
        in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PATH = controller.ChooserIMG();
                setImage(PATH);
                controller.setImage(cell, PATH);
            }
        });

        JButton del = new JButton("Delete");
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setImage(null);
                controller.setImage(cell, null);
            }
        });

        // Lays out image and button components
        setLayout(null);
        l.setBounds(0, 0, 310, 230);
        add(l);
        JLabel buttonholder = new JLabel();
        buttonholder.setBounds(0, 230, 310, 40);
        buttonholder.setLayout(new FlowLayout());
        buttonholder.add(in);
        buttonholder.add(del);
        add(buttonholder);

    }

    public void setImage(String Path) {
        Image img = new ImageIcon(Path).getImage();
        Image newimg = img.getScaledInstance(310, 230, java.awt.Image.SCALE_SMOOTH);
        l.setIcon(new ImageIcon(newimg));
    }

    /**
     * Updates the image label
     *
     * @param event the selection event that was fired
     */
    @Override
    public void selectionChanged(SelectionEvent event) {
        Cell cell = event.getCell();
        if (cell != null) {
            InsertImageCell activeCell
                    = (InsertImageCell) cell.getExtension(InsertImageExtension.NAME);
            activeCell.addInsertImageCellListener(this);

            imageChanged(activeCell);
        } else {
            l.setIcon(null);
        }

        // Stops listening to previous active cell
        if (event.getPreviousCell() != null) {
            ((InsertImageCell) event.getPreviousCell().getExtension(InsertImageExtension.NAME))
                    .removeInsertImageCellListener(this);
        }
    }

    /**
     * Updates the image label when the image of the active cell is changed.
     *
     * @param cell the cell whose image changed
     */
    @Override
    public void imageChanged(InsertImageCell cell) {
        // Stores the cell for use when applying image
        this.cell = cell;

        // The controller must decide what to do...
        controller.cellSelected(cell);
    }
}
