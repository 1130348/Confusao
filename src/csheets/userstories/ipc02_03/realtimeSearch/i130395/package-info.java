/**
 * Technical documentation regarding the user story ipc02_03: Realtime Search.
 * <br/>
 * <br/>
 * <h2>1. Requirements</h2>
 * The purpose of this use case is to add a search functionality to CleanSheets
 * that detects all current workbooks on the computer running the program. The
 * workbook search must cover all folders and directories selected by the user
 * and present a list of all found workbooks. The list will be presented on a
 * sidebar, and must be updated as the files are found. It should be possible to
 * open the workbooks from the search's resulting list or see a preview of them.
 * <br/>
 * <br/>
 * <b>Use Case "Realtime Search":</b>
 * The user starts the workbook search. The user is given the option to add or
 * remove paths for the program to search. When the user selects the option to
 * start the search, CleanSheets starts the search and retrieves all workbook
 * files found . The files are displayed on a sidebar in the main window. The
 * user has then the option to open a file from the sidebar or watch a preview.
 * <br/>
 * <br/>
 * <h2>2. Analysis</h2>
 * In order to search for all workbook files in the given paths it is
 * fundamental to understand how to search files in a given directory on the
 * Java language. The Java native file searching process will be used in this
 * aproach. This translates to having a class, in this case SearchWorkBookFiles
 * that implements the interface SimpleFileVisitor which holds all the necessary
 * methods required to a fast and successful search. There will be at least
 * three overriden methods in this class, respectively visitFile,
 * postVisitDirectory, visitFailed which will be necessary to ensure a succesful
 * search. These will be further explained on the Design section of this
 * documentation. There must also be a good understanding of the application's
 * structure because on a later stage there will be a sidebar with all the found
 * files that should support an option to preview or open the files directily.
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For this
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * which states that the element is not a design element and, therefore, does
 * not exist as such in the code of the application (at least at the moment that
 * this diagram was created).<br/>
 * <br/>
 * <img src="doc-files/find_workbooks_analysis_diagram.png"/>
 * <br/>
 * Through this early draft we can see that the class SearchWorkbookFiles will
 * have total responsibilities in regards to the workbook files search. The user
 * interface will have to communicate through a controller in order to gain
 * access to all the functionalities provided by the SearchWorkbooksFilesClass.
 * The controller must receive all the paths the user wants to search
 * <br/>
 * <br/>
 * <h3>Analysis of The Core Technical Problem</h3>
 * The core technical problem still remains on the usage and implementation of
 * the SimpleFileVisitor interface which embodies a search tree algorithm to
 * search through all the directories present in the selected paths.
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to search workbooks on the given
 * paths/directories continously.
 * <br/>
 * Because our model class <code>FindWorkbooks</code> implements the interface
 * SimpleFileVisitor and the only methods in the class are overriden methods of
 * that interface that mandatorily return the static constant CONTINUE no unit
 * tests were made to this class. The class <code>StartSearch</code> is
 * responsible for creating a thread of the class for each given path,
 * <code>FindWorkbooks</code> and since it only calls the start() method of the
 * Thread class no unit tests could be made. Instead functional tests were made
 * in order to make sure that the use case was functioning properly. These were
 * creating .cls files in multiple locations on the local disk, and making sure
 * they would appear on the sidebar and making sure that the found files would
 * open when double-clicked.
 * <br/>
 * <h2>4. Design</h2>
 * To realize this user story we will need to extend the class Extension since
 * we want to create a new extension for CleanSheets. We will also need to
 * create a subclass of UIExtension. In the code of the extension
 * <code>csheets.ext.style</code> we can find examples that illustrate how to
 * implement these technical requirements.
 * <br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.
 * <br/>
 * <h3>Search for workbooks on multiple paths and open them</h3>
 * The following diagram illustrates what happens when the user searches for all
 * existing workbooks on the given paths/directories. When the user selects the
 * menu item "Find Workbooks..." a window is opened. The user selects or removes
 * the paths to search in a jlist. when the yuser starts the search, a new
 * thread is created for each path in the list that implements the
 * SimpleFileVisitor. This thread will be responsible for every aspect of the
 * search proccess. After at least one workbook is found the user has the option
 * to open it. This proccess is explained carefully on the openFoundWorkbooks()
 * subsequent calls on the following diagram.
 * <br/>
 * <br/>
 * <img src="doc-files/find_workbooks_design_sequence_diagram.png"/>
 */
package csheets.userstories.ipc02_03.realtimeSearch.i130395;

/**
 *
 * @author João Paiva (1130395)
 */
class _RealtimeSearch_ {
}
