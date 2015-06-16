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
 * Import/Export text" some of the code of the first will be used. When it's
 * necessary to import information will be called the Import Process. If it's
 * necessary to export will be called the Export Process that is already done.
 *
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the ipc
 * functionality of this use case is to be able to import and export information
 * when linked to a text file. From this moment, I don't see the necessity of
 * doing more that the actual tests that are already implemented. Since all the
 * used methods in this use case were made previosly and I assumed they were
 * working. As usual, in a test driven development approach tests normally fail
 * in the beginning. The idea is that the tests will pass in the end.<br>
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
