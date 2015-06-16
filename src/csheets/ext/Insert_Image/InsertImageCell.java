/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.Insert_Image;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class InsertImageCell extends CellExtension {

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = 1L;

    /**
     * The image path
     */
    private String path;

    /**
     * The listeners registered to receive events from the image cell
     */
    private transient List<InsertImageCellListener> listeners
            = new ArrayList<InsertImageCellListener>();

    /**
     * Creates a image cell extension for the given cell.
     *
     * @param cell the cell to extend
     */
    InsertImageCell(Cell cell) {
        super(cell, InsertImageExtension.NAME);
    }

    /*
     * Image ACCESSORS
     */
    /**
     * Get the cell's user image.
     *
     * @return The user supplied image for the cell or <code>null</code> if no
     * user supplied image exists.
     */
    public String getImage() {
        return path;
    }

    /**
     * Returns whether the cell has a image.
     *
     * @return true if the cell has a image.
     */
    public boolean hasImage() {
        return path != null;
    }

    /*
     * IMAGE MODIFIERS
     */
    /**
     * Sets the user-specified image for the cell.
     *
     * @param path the path for the image
     */
    public void setImagePath(String path) {
        this.path = path;
        // Notifies listeners
        fireImageChanged();
    }


    /*
     * EVENT LISTENING SUPPORT
     */
    /**
     * Registers the given listener on the cell.
     *
     * @param listener the listener to be FFFF public void
     *
     */
    public void addInsertImageCellListener(InsertImageCellListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes the given listener from the cell.
     *
     * @param listener the listener to be removed
     */
    public void removeInsertImageCellListener(InsertImageCellListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notifies all registered listeners that the cell's image changed.
     */
    protected void fireImageChanged() {
        for (InsertImageCellListener listener : listeners) {
            listener.imageChanged(this);
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
        listeners = new ArrayList<InsertImageCellListener>();
    }
}
