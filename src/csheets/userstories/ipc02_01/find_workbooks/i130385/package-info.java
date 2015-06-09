/**
 * Technical documentation regarding the user story ipc02_01: find workbooks. 
 * <br/>
 * <br/>
 * <h2>1. Requirements</h2>
 * The purpose of this use case is to add a search functionality to CleanSheets
 * that detects all current workbooks on the local disk. The workbook search 
 * must cover all folders and directories and present a list of all found
 * workbooks. The list will be presented on a sidebar, and must be updated as 
 * the files are found. It should be possible to open the workbooks from the
 * search's resulting list.
 * <br/>
 * <br/>
 * <b>Use Case "Find Workbooks":</b>
 * The user starts the workbook search. CleanSheets starts the search and
 * retrieves all workbook files found on the local disk. The files are displayed
 * on a sidebar in the main window. The user has then the option to open a file
 * from the sidebar.
 * <br/>
 * <br/> 
 * <h2>2. Analysis</h2>
 * In order to search for all workbook files in the local directory it is
 * fundamental to understand how to search files in a given directory on the 
 * Java language. The Java native file searching process will be used in this
 * aproach. This translates to having a class, in this case SearchWorkBookFiles
 * that implements the interface SimpleFileVisitor which holds all the necessary
 * methods required to a fast and successful search. There will be at least 
 * three overriden methods in this class, respectively visitFile,
 * postVisitDirectory,visitFailed which will be necessary to ensure a succesful
 * search. These will be further explained on the Design section of this
 * documentation. There must also be a good understanding of the application's 
 * structure because on a later stage there will be a sidebar with all the
 * found files that should support an option to open the files directily.
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the 
 * previously described use case. We call this diagram an "analysis" use case 
 * realization because it functions like a draft that we can do during analysis 
 * or early design in order to get a previous approach to the design. For this 
 * reason we mark the elements of the diagram with the stereotype "analysis" 
 * which states that the element is not a design element and, therefore, does 
 * not exist as such in the code of the application (at least at the moment 
 * that this diagram was created).<br/> 
 * <br/>
 * <img src="doc-files/find_workbooks_analysis_diagram.png"/>
 * <br/>
 * Through this early draft we can see that the class SearchWorkbookFiles will
 * have total responsibilities in regards to the workbook files search. The user
 * interface will have to communicate through a controller in order to gain
 * access to all the functionalities provided by the SearchWorkbooksFilesClass.
 * <br/>
 * <br/> 
 * <h3>Analysis of Core Technical Problem</h3>
 * The core technical problem still remains on the usage and implementation of 
 * the SimpleFileVisitor interface which embodies a search tree algorithm to
 * search through all the directories present in the local disk.
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core 
 * functionality of this use case is to be able communicate with other instances
 * of "CleanSheets" and send them a selected amount of cells.<br/>
 * Following this approach we can start by coding a unit test that uses the
 * class <code>Connect</code> and tests its attribute port. Furthermore we also have
 * to perform functional tests to see if the client is properly receiving the 
 * information.<br/>
 * As usual, in a test driven development approach tests normally fail in the 
 * beginning. The idea is that the tests will pass in the end.<br> 
 * <br/>
 * see: <code>csheets.ext.start_sharing.StartSharingTest</code><br/>
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. 
 * We will also need to create a subclass of UIExtension. In the code of the extension 
 * <code>csheets.ext.style</code> we can find examples that illustrate how to 
 * implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution 
 * for this use case.<br/>
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Start Sharing" extension when 
 * cleansheets is run.<br/><br/>
 * <img src="doc-files/Extension_setup_ipc_01_01.png"/>
 * <br/>
 * <h3>User Select Cells And Clicks Botton To Send</h3>
 * The following diagram illustrates what happens when the user select cells.
 * When the user selects the cells the object StartSharingAction has access to 
 * SpreedSheatTable who knows the user selected cells. After the user selected 
 * cells, he press the button to send  and active actionPerformed() method of class
 * StartSharingAction<br/>
 * <br/>
 * <img src="doc-files/select_cells_and_click_ipc_01_01.png"/>
 */

package csheets.userstories.ipc02_01.find_workbooks.i130385;

/**
 *
 * @author João Paiva (1130385)
 */
class _Dummy_ {}


