/** 
 * Technical documentation regarding the user story ipc04_01: import/export text. 
 * <br/>
 * <br/>
 * 
 * <h2>1. Requirement</h2>
 * It must be possible to import / export data from a text file , whose columns 
 * are divided by a character that should be specified in the wizard window. 
 * Also specify if there should be a first header line or not and whether it 
 * should be included in the operation. In the case of import, the data should 
 * appear from a cell that is identified as the top left corner. In the case of 
 * export , the data must be exported from a cell that is identified as the top 
 * left corner.
 * <br/>
 * <br/>
 * <b>Use Case "Import/export text":</b>
 * The user selects the option to import or export data from a text file. The
 * system displays a window wizard and requests which character will serve as 
 * separator for the columns of the text file, it also asks if there is a first
 * row header , and whether it should be included in the operation. It is also
 * necessary to choose the file to do the exportation/importation. Now it is 
 * only needed to import or export the text file.
 * <br/>
 * <br/>
 *  
 * <h2>2. Analysis</h2>
 * In order to import or export the data from a text file I need to understand how 
 * manipulate a text file. It is also necessary to understand how threads work 
 * so that we can navigate the application without having to stop the 
 * exportation/importation.
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the 
 * previously described use case. We call this diagram an "analysis" use case 
 * realization because it functions like a draft that we can do during analysis 
 * or early design in order to get a previous approach to the design. For that 
 * reason we mark the elements of the diagram with the stereotype "analysis" 
 * that states that the element is not a design element and, therefore, does 
 * not exists as such in the code of the application (at least at the moment 
 * that this diagram was created).<br/> 
 * <br/>
 * <h4> Import analysis diagram</h4>
 * <img src="doc-files/ipc04_01_analysis_Import.png"/>
 * <br/>
 * <br/>
 * <h4> Export analysis diagram</h4>
 * <img src="doc-files/ipc04_01_analysis_Export.png"/>
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core 
 * functionality of this use case is to be able to import or export data from
 * a text file.<br/>
 * I have to perform functional tests to see if the file is being created when
 * doing an exportation. I also need to test if the data from the text file is 
 * being imported correctly. Furthermore I also have to test if the file created 
 * by the exportation has the correct data.<br/>
 * As usual, in a test driven development approach tests normally fail in the 
 * beginning. The idea is that the tests will pass in the end.<br> 
 * <br/>
 * see: <code>csheets.ext.start_sharing.ImportExportText</code><br/>
 * <h2>4. Design</h2>
 * The following diagrams illustrate core aspects of the design of the solution 
 * for this use case.<br/>
 * 
 * <h3>Import from a text file</h3>
 * The following diagram illustrates what happens when the user wants to import
 * data from a text file.
 * When the user selects the option to import, the ImportExportAction has access to 
 * SpreedSheatImpl who has access to all cells. After that the user chooses the column's 
 * separator and if the header is supposed to be included in the importation. 
 * Finally the importation is done.<br/><br/>
 * <img src="doc-files/import_from_text_file_ipc04_01.png"/>
 * <br/>
 * <h3>Export to a text file</h3>
 * The following diagram illustrates what happens when the user wants to export
 * data to a text file.
 * When the user selects the option to export, the ImportExportAction has access to 
 * SpreedSheatImpl who has access to all cells. After that the user chooses the column's 
 * separator and if the header is supposed to be included in the exportation. 
 * Finally the exportation is done.
 * <br/>
 * <br/>
 * <img src="doc-files/export_to_text_file_ipc04_01.png"/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * I've achieved the objectives and in my point of view all requirements have been
 * accomplished.<br/>
 * 
 */

package csheets.userstories.ipc04_01.import_export_text.i130664;

/**
 *
 * @author Carlos Silva (1130664)
 */
class _Dummy_ {}

