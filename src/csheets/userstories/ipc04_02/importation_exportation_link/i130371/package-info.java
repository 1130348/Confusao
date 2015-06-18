/**
 * Technical documentation regarding the user story ipc04_02: importation and
 * exportation link.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Rather than import or export should be possible a link of a text file. The
 * processo is similar, but from the moment that settles the link whenever he
 * text file is change the spreadsheet should be updated too. Similarly,
 * whenever it is updated one of the import/export area of cells, the text file
 * must be updated.
 * <br/>
 * <br/>
 * <b>Use Case "Importation and Exportation Link":</b>
 * The user will need to choose the option "importation and exportation link".
 * After that it should be possible to link to a file text and to choose the
 * separator. From the moment the link is establish, whenever the cells are
 * changed, the text file needs to be updated and when the text file is changed
 * the cells need to be updated too.
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * The user needs to choose the option and then one text file to link (import -
 * text file changed and the cells must be updated; export - cells changed and
 * the text file needs to be updated). In order to understand the importation
 * link process and the exportation link process the ssd and the sequence
 * analysis diagram will be divided between importation and exportation. Let's
 * now see the ssd for importation link. When the user selects the file and the
 * separator, all the information on the file will be importes and now if the
 * user changes the content of the text file the cells will be updated.
 * <br/><br/>
 * <img src = "doc-files/ipc_04_02_ssd_import.png"/>
 * <br/><br/>
 * <img src = "doc-files/ipc_04_02_analysis_sequece_import.png"/>
 * <br/><br/>
 * Now for the exportation link process. When the user selects the file and the
 * separator, the information is imported and if he changes the cells the system
 * exports all the modifications to the file.
 * <br/><br/>
 * <img src = "doc-files/ipc_04_02_ssd_export.png"/>
 * <br/><br/>
 * <img src = "doc-files/ipc_04_02_analysis_sequence_export.png"/>
 * <br/><br/>
 * Exportation and Importation Link needs to be done together. So the user
 * choose that option and all the information is imported from the text file. By
 * now all the modifications on the cells need to be updated on the text file
 * and all the changes on the text file needs to be updated on the cells. The
 * classes Import and Export (implements Runnable) will extend a thread and will
 * have a method run. On the class Import the thread will be waiting that the
 * text file changes in order to change the content of the cells. On the
 * otherside, the class Export has a thread that waits for modifications on the
 * cells to update the text file.
 * <br/><br/>
 * <img src = "doc-files/ipc_04_02_analysis_classes.png"/>
 * <br/><br/>
 * Beeing this the second of two use cases in the same sub-area "IPC
 * Import/Export text" some of the code of the first will be used. If it's
 * necessary to export will be called the Export Process that is already
 * done.Although the importation process was already implement was a problem.
 * The method open a new sheet whenever it imported from the file. The problem
 * was that the sheet from importation and exportation needs to be the same so
 * don't make logic to open a new sheet because the sheet was always change. I
 * decided to create a private class on the class Import that implements
 * Runnable and has a method that import from the file but writes all the
 * information on the sheet that was open already. I could refactor the code
 * that was already done but i prefere this way in order to keep all the code
 * doing for other person save.
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the ipc
 * functionality of this use case is to be able to import and export information
 * when linked to a text file. From this moment, I don't see the necessity of
 * doing more that the actual tests that are already implemented. Since all the
 * used methods in this use case were made previosly and I assumed they were
 * working. Almost all the methods that I implemented use threads or are methods
 * from the interface or using it (the class uiController). The controller
 * (ImportationExportationLinkCOntroller) has got the constructor, two methods
 * that calls the threads Import and Export, one that sets a variable on the
 * uiController and another to know if the thread is alive. The class Import and
 * Export has the abstract methods cause implements Runnable and the class
 * Import has a private class that was created because the method done on the
 * CustomImportation was openning a new sheet and I prefere not to change the
 * code of the person that had implemented because was working too. All this
 * methods I tested by functional tests and using debugging. The new class I
 * test the importation seeing the file and that everything was alright. I try
 * to find some methods to do unitary tests because the teacher said that was
 * important to do tests and use the test driven development but I don't see the
 * necessity to do more than the tests that were already implemented so I did
 * functional tests. As usual, in a test driven development approach tests
 * normally fail in the beginning. The idea is that the tests will pass in the
 * end.<br>
 * <br/>
 *
 * * <h2>4. Design</h2>
 * A sequence diagram shows object interactions arranged in time sequence. It
 * depicts the objects and classes involved in the scenario and the sequence of
 * messages exchanged betwween the objets needed to carry out the functionality
 * of the scenario.<br/>
 * A new item on the menu will be created in order to the user do the
 * importation and exportation link. The user just need to choose the file and
 * the separator and then the choosen text file will be linked. If the user
 * changes the content of any cell the text file needs to updated. For the
 * system know about the modification it is necessary a thread that will be
 * constantly checking if any changes were made to any cell of the workbook. If
 * any changes is made on the cells the file will be exported again. From now,
 * will be called the importation/exportation that is already implemented on the
 * cleansheets project. Let's now see the sequence diagram for the exportation
 * process. To do exportation I used the class that was already done
 * "CustomExportation" that is implemented like a thread and has got a method
 * that allows exportation.
 * <br/><br/>
 * <br/><img src="doc-files/ipc_04_02_design_sequence_export.png" <br/> <br/>
 * <br/>
 * If the user changes the text file the cells need to be updated with the new
 * content. In order to the system know about a modification that is a thread
 * constantly checking if any change was taken to the text file. If were changes
 * that is necessary to import all the information and update the content of all
 * cells. I thought that was possible to call the class already created on the
 * first use case but were some problems. To do importation was not possible to
 * work with the code already done because will open a new sheet. The
 * importation and exportation link will be done in the sheet that is open.
 * Observe now the sequence diagram for the importation process.
 * <br/><br/>
 * <br/><img src="doc-files/ipc_04_02_design_sequence_import.png" <br/> <br/>
 * <br/>
 * It was necessary to separate in Importation Link and Exportation Link because
 * it is impossible to know from what order the user will execute all the
 * modifications. If he first changes the content of cells exportation will be
 * done. But the user can call importation link process first. Because of that I
 * opted to a division in Importation Link and Exportation Link.
 *
 * <h2>5. Coding</h2>
 * All the interface was doing on the classes LinkDialog and
 * LinkImportExportAction. The controller has two methods that calls the threads
 * Export and Import (two other new classes). I used to the class
 * CustomExportation but was not created for me I just write a new constructor
 * and changed a small mistake. see:
 * <code>csheets.ext.import_export_link.Export</code><br/> (this class will test
 * if the cells were modifie using the CellListeners and if there were
 * modifications will Export to the txt file) see:
 * <code>csheets.ext.import_export_link.Import</code><br/> (the class Import
 * will confirm if the date_last_update is before the date of the last
 * modification in the file and will export all the information to the cells)
 * This two classes (Export and Import) implements Runnable so has got all the
 * abstract methods <br/>
 * see:
 * <code>csheets.ext.import_export_link.ImportationExportationLinkController</code><br/>
 * The controller is created to call the threads Export and Import.  <br/>
 * The interface was simple: a new option on the menu that opens a window asking
 * the separator and the file.<br/>
 * see: <code>csheets.ext.import_export_link.ui.LinkDialog</code><br/>
 * see:
 * <code>csheets.ext.import_export_link.ui.LinkImportExportAction</code><br/>
 * All the classes has complemented with javadoc documentation and some
 * important comments on some relevant lines of the code. One thing that is
 * important to detach is that the threads has got some sleeps. It happens to
 * the thread not run too fast. It was happen that the thread as running soo
 * fast that didn't do the if condition and using debbuging I understand that
 * putting a SystemOutPrintln it doesn't happen.<br/>
 *
 * <h2>6. Final Remarks</h2>
 * This use case is the second and the last of this sub-area "IPC Export/Import
 * Text". The main problem I believe was the understanding of the code that was
 * already done on the first use case. This was necessary because this use case
 * will call the Importation and Exportation Process.
 * <br/>
 *
 */
package csheets.userstories.ipc04_02.importation_exportation_link.i130371;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package!
 *
 * @author Cristina Lopes
 */
class _Dummy_ {
}
