package csheets.ext.comments;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * An extension of a cell in a spreadsheet, with support for comments.
 *
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class CommentableCell extends CellExtension {

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = 1L;

    /**
     * The cell's user-specified comment
     */
    private ArrayList<String> userComment;

    /**
     * The cell's comment last author
     */
    private String user;

    /**
     * The listeners registered to receive events from the comentable cell
     */
    private transient List<CommentableCellListener> listeners
        = new ArrayList<CommentableCellListener>();

    /**
     * Creates a comentable cell extension for the given cell.
     *
     * @param cell the cell to extend
     */
    CommentableCell(Cell cell) {
        super(cell, CommentsExtension.NAME);
        this.userComment = new ArrayList<>();
    }


    /*
     * DATA UPDATES
     */
//	public void contentChanged(Cell cell) {
//	}
    /*
     * COMMENT ACCESSORS
     */
    /**
     * Get the cell's user comment.
     *
     * @return The user supplied comment for the cell or <code>null</code> if no
     * user supplied comment exists.
     */
    public String getSingleUserComment(int index) {
        
        return userComment.get(index);
    }

    /**
     * Returns whether the cell has a comment.
     *
     * @return true if the cell has a comment
     */
    public boolean hasComment() {
        return userComment.size()>0;
    }

    /**
     *
     * Returns the author of the comment
     *
     * @return
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * Returns all comments on the cell
     *
     * @return
     */
    public ArrayList<String> getUserComment() {
        return userComment;
    }

    public String getAllComments() {
        String tmp = "";
        for (int i = 0; i < userComment.size(); i++) {
            tmp += userComment.get(i)+ "<br>";
        }
        return tmp;
    }


    /*
     * COMMENT MODIFIERS
     */
    /**
     * Sets the user-specified comment for the cell in the index position.
     *
     * @param comment the user-specified comment
     * @param index
     */
    public void setUserComment(String comment, int index) {

        this.userComment.add(index, comment);
        // Notifies listeners
        fireCommentsChanged();

    }

    /**
     * Sets the user-specified comment for the cell.
     *
     * @param comment the user-specified comment
     */
    public void setUserComment(String comment) {
        if (userComment == null) {
            userComment = new ArrayList<>();
        }

        this.userComment.add(comment);
        // Notifies listeners
        fireCommentsChanged();

    }

    /**
     *
     * Sets the author of the last editing comment
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /*
     * EVENT LISTENING SUPPORT
     */
    /**
     * Registers the given listener on the cell.
     *
     * @param listener the listener to be added
     */
    public void addCommentableCellListener(CommentableCellListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes the given listener from the cell.
     *
     * @param listener the listener to be removed
     */
    public void removeCommentableCellListener(CommentableCellListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notifies all registered listeners that the cell's comments changed.
     */
    protected void fireCommentsChanged() {
        for (CommentableCellListener listener : listeners) {
            listener.commentChanged(this);
        }
    }

    /**
     * Customizes serialization, by recreating the listener list.
     *
     * @param stream the object input stream from which the object is to be read
     * @throws IOException If any of the usual Input/Output related exceptions
     * occur
     * @throws ClassNotFoundException If the class of a serialized object cannot
     * be found.
     */
    private void readObject(java.io.ObjectInputStream stream)
        throws java.io.IOException, ClassNotFoundException {
        stream.defaultReadObject();
        listeners = new ArrayList<CommentableCellListener>();
    }

    public void removeComment(int selectedIndex) {
        userComment.remove(selectedIndex);
        user = null;
        
    }
}
