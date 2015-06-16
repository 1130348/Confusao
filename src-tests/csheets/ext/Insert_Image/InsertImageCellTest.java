/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcos
 */
public class InsertImageCellTest {

    private boolean isNotified = false;

    /**
     * Test of getImage and SetImagePath method, of class InsertImageCell.
     */
    @Test
    public void testGetImageandSetImagePath() {
        // create a workbook with 2 sheets
        Workbook wb = new Workbook(2);
        Spreadsheet s = wb.getSpreadsheet(0);
        // get the first cell
        Cell c = s.getCell(0, 0);
        // activate the comments on the first cell
        InsertImageCell iic = new InsertImageCell(c);
        iic.setImagePath("c:\\3D.jpg");
        assertTrue("c:\\3D.jpg".compareTo(iic.getImage()) == 0);
    }

    /**
     * Test of hasImage method, of class InsertImageCell.
     */
    @Test
    public void testHasImage() {
        // create a workbook with 2 sheets
        Workbook wb = new Workbook(2);
        Spreadsheet s = wb.getSpreadsheet(0);
        // get the first cell
        Cell c = s.getCell(0, 0);
        // activate the comments on the first cell
        InsertImageCell iic = new InsertImageCell(c);
        boolean hasImage = iic.hasImage();
        assertTrue(hasImage == false);
        iic.setImagePath("c:\\3D.jpg");
        hasImage = iic.hasImage();
        assertTrue(hasImage);
    }

    /**
     * A method that tests the notifications for image cell listeners.
     *
     * @see InsertImageCellListener
     */
    @Test
    public void testInsertImageCellListenner() {

        // create a workbook with 2 sheets
        Workbook wb = new Workbook(2);
        Spreadsheet s = wb.getSpreadsheet(0);
        // get the first cell
        Cell c = s.getCell(0, 0);
        // activate the comments on the first cell
        InsertImageCell iic = new InsertImageCell(c);
        InsertImageCellListener listener = new InsertImageCellListenerImpl();
        iic.addInsertImageCellListener(listener);
        // modify the cell... this should create an event
        iic.setImagePath("c:\\3D.jpg");
        assertTrue(isNotified);
    }

    /**
     * A inner utility class used by the method testCommentableCellListenner.
     */
    class InsertImageCellListenerImpl implements InsertImageCellListener {

        @Override
        public void imageChanged(InsertImageCell cell) {
            isNotified = true;
        }

    }

}
