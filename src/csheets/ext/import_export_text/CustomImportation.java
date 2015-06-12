/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.import_export_text;

import csheets.CleanSheets;
import csheets.SpreadsheetAppEvent;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ext.import_export_text.ui.ImportDialog;
import csheets.io.Codec;
import csheets.io.CodecFactory;
import csheets.ui.ctrl.UIController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Carlos Silva <1130664@isep.ipp.pt>
 */
public class CustomImportation implements Runnable {

    private CleanSheets app;
    private UIController uiController;
    private File[] files;
    private String separator;
    private int header;
    private int includeHeader;
    
    //checks if the file is valid
    public int fileNotValid;

    public CustomImportation(CleanSheets app, UIController uiController, File[] files,
            String separator, int header, int includeHeader) {
        this.app = app;
        this.uiController = uiController;
        this.files = files;
        this.separator = separator;
        this.header = header;
        this.includeHeader = includeHeader;
    }

    public void importText() throws FileNotFoundException {
        fileNotValid = 0;
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter(null, "txt");
        Workbook workbook = uiController.getActiveWorkbook();
        int checkLine = 0;
        for (File file : files) {

            FileInputStream stream = new FileInputStream(file);
            if (extensionFilter.accept(file)) {
                try {
                    // Wraps stream
                    Reader streamReader = new InputStreamReader(stream);
                    BufferedReader reader = new BufferedReader(streamReader);

                    // Reads content of rows
                    String line;
                    int columns = 0;
                    List<String[]> rows = new LinkedList<String[]>();
                    while ((line = reader.readLine()) != null) {
                        if(checkLine == 0 && ((includeHeader == 0 && header == 0) || (includeHeader == 0 && header == 1))){
                            checkLine++;
                            continue;
                        }
                        String[] row = line.split(separator);
                        rows.add(row);
                        if (row.length > columns) {
                            columns = row.length;
                        }
                        checkLine++;
                    }

                    // Builds content matrix
                    String[][] content = new String[rows.size()][columns];
                    int i = 0;
                    for (String[] row : rows) {
                        content[i++] = row;
                    }

                    // Frees resources
                    reader.close();
                    streamReader.close();
                    stream.close();
                    workbook.addSpreadsheet(content);
                    JOptionPane.showMessageDialog(null, "Your file has been imported", "Importation Complete", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(CustomImportation.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "The file " + file.getName() + " is not a valid text file!", "File not supported", JOptionPane.WARNING_MESSAGE, null);
                fileNotValid = 1;
            }
        }
    }

    @Override
    public void run() {
        try {
            importText();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomImportation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
