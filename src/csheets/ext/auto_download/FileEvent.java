/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.auto_download;

import java.io.Serializable;

/**
 *
 * @author Andre
 */
public class FileEvent implements Serializable {

    public FileEvent() {
    }

    private static final long serialVersionUID = 1L;

    private String destinationDirectory;
    private String sourceDirectory;
    private boolean updatable;
    private boolean overwrite;
    private String filename;
    private long fileSize;
    private byte[] fileData;
    private String status;

    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    public void setDestinationDirectory(String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }
    
    public boolean getUpdatableOption() {
        return updatable;
    }

    public void setUpdatableOption(boolean update) {
        this.updatable = update;
    }
    
    public boolean getOverwriteOption() {
        return overwrite;
    }

    public void setOverwriteOption(boolean over) {
        this.overwrite = over;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
