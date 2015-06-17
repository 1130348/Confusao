package csheets.ext.comments.ui;

import csheets.ext.comments.CommentableCell;
import csheets.ui.ctrl.UIController;

/**
 * A controller for updating the user-specified comment of a cell.
 *
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class CommentController {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * User interface panel *
     */
    private CommentPanel uiPanel;

    /**
     * Creates a new comment controller.
     *
     * @param uiController the user interface controller
     * @param uiPanel the user interface panel
     */
    public CommentController(UIController uiController, CommentPanel uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;
    }

    /**
     * Attempts to create a new comment from the given string. If successful,
     * adds the comment to the given cell. If the input string is empty or null,
     * the comment is set to null.
     *
     * @param cell the cell for which the comment should be set
     * @param commentString the comment, as entered by the user
     * @return true if the cell's comment was changed
     */
    public boolean setComment(CommentableCell cell, String commentString,
                              int index) {


            if (index == cell.getUserComment().size()) {
                // Stores the new comment
                cell.setUserComment(commentString);
                cell.setUser(System.getProperty("user.name"));
                uiController.setWorkbookModified(cell.getSpreadsheet().
                    getWorkbook());
                
            } else {
                // Stores the comment
                cell.removeComment(index);
                cell.setUserComment(commentString, index);
                cell.setUser(System.getProperty("user.name"));
                uiController.setWorkbookModified(cell.getSpreadsheet().
                    getWorkbook());
            }
        
        return true;
    }

    /**
     * A cell is selected.
     *
     * @param cell the cell whose comments changed
     */
    public void cellSelected(CommentableCell cell) {
        // Updates the text field and validates the comment, if any
        if (cell.hasComment()) {

            uiPanel.setCommentText(cell.getSingleUserComment(0));
        } else {
            uiPanel.setCommentText("");
        }
    }
}
