/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.findworkbooks;

import csheets.ext.findworkbooks.ui.FindWorkbooksPanel;
import static java.nio.file.FileVisitResult.*;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author João Paiva da Costa Pinto <1130385@isep.ipp.pt>
 */
public class FindWorkbooks extends SimpleFileVisitor<Path> {

    private final ArrayList<Path> workBooksFoundList;

    public FindWorkbooks(ArrayList<Path> workBooksFoundList) {
        this.workBooksFoundList = workBooksFoundList;
    }

    /**
     * Print information about each type of file.
     *
     * @param path
     * @param attrs
     * @return
     * @throws IOException
     */
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            if (path.toString().endsWith(".cls")) {
                workBooksFoundList.add(path);
                FindWorkbooksPanel.foundWorkbooksList.setListData(workBooksFoundList.toArray());
            }
        }
        return CONTINUE;
    }

    /**
     * Print information about each type of file.
     *
     * @param dir
     * @param exc
     * @return
     * @throws java.io.IOException
     */
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        //System.out.format("Directory: %s%n", dir);
        return CONTINUE;
    }

    /**
     * Print each directory visited.
     *
     * @param file
     * @param exc
     * @return
     * @throws IOException
     */
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        // System.err.println(exc);
        return CONTINUE;
    }

}
