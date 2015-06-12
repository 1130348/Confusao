/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image.ui;

import csheets.ext.Insert_Image.InsertImageCell;
import csheets.ext.Insert_Image.InsertImageCellListener;
import csheets.ext.Insert_Image.InsertImageExtension;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Marcos
 */
public class InsertImagePanel extends JPanel implements SelectionListener, InsertImageCellListener {

    /**
     * The assertion controller
     */
    private InsertImageController controller;

    /**
     * The image cell currently being displayed in the panel
     */
    private InsertImageCell cell;

    /**
     * The label in which the image of the cell is displayed.
     */
    private JLabel imageLabel = new JLabel();

    //String path;

    /**
     * Creates a new image panel.
     *
     * @param uiController the user interface controller
     */
    public InsertImagePanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(InsertImageExtension.NAME);

        uiController.addSelectionListener(this);

        // Creates controller
        controller = new InsertImageController(uiController, this);
        uiController.addSelectionListener(this);

        // Creates comment components
        ApplyAction applyAction = new ApplyAction();

        imageLabel.setPreferredSize(new Dimension(120, 240));		// width, height
        imageLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        imageLabel.addFocusListener(applyAction);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Lays out comment components
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new BoxLayout(ImagePanel, BoxLayout.PAGE_AXIS));
        ImagePanel.setPreferredSize(new Dimension(130, 336));
        ImagePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        ImagePanel.add(imageLabel);

        // Adds borders
        TitledBorder border = BorderFactory.createTitledBorder("Image");
        border.setTitleJustification(TitledBorder.CENTER);
        ImagePanel.setBorder(border);

        // Adds panels
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(ImagePanel, BorderLayout.NORTH);
        add(northPanel, BorderLayout.NORTH);
        
    }

    /**
     * Updates the image field
     *
     * @param event the selection event that was fired
     */
    public void selectionChanged(SelectionEvent event) {

    }

    /**
     * Updates the image field when the image of the active cell is changed.
     *
     * @param cell the cell whose image changed
     */
    public void imageChanged(InsertImageCell cell) {

    }

    public void setImage(String path) throws IOException {

//        BufferedImage myPicture = ImageIO.read(new File(path));
//        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//        add(picLabel);
        ImageIcon image = new ImageIcon(path);
        JLabel label = new JLabel("", image, JLabel.CENTER);
        add(label, BorderLayout.CENTER);

    }

    protected class ApplyAction implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
//            if (cell != null) {
//                controller.setImage(cell, imageLabel.getText().trim());
//            }
        }
    }
}
