/**
 * Technical documentation regarding the user story ipc08_2: Auto Download.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * Allow the user to download a selected file in paralel, specify if is an
 * unique download or an auto updatable download and select if the file is
 * overwritable or not.
 * <br/>
 * <br/>
 * <b>Use Case "Auto Download":</b> The user select "Download File". The system
 * show a window where the user must select a file and decide if he wants to
 * make an unique or auto updatable download. <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * The UC IPC08.2 objective is to gave the user the possibility to download
 * files from another instance of the cleasheet. To reach this objective the app
 * will have a download menu, one that will allow the user to start the download
 * from any instances. The button "Download" will open a frame that will ask for
 * file and download type selection.
 *
 * <br/>
 *
 * <h2>a) First "Analysis" Sequence Diagram</h2>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).<br/>
 * <br/>
 * <img src="doc-files/ipc08_02_analysis.png">
 * <br/>
 * <br/>
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to communicate with other
 * instances of "CleanSheets" and download files.<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * In the end this use case requires only Functional Tests:
 *  #Send File to another Cleansheet instance;
 *  #Download File from another Cleansheet instance;
 *  #Check if the downloaded file is equal to the selected file;
 * 
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension
 * <code>csheets.ext.file_sharing</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "File Sharing" extension when
 * cleansheets is run.<br/><br/>
 * <img src="doc-files/ipc08_01_design1.png">
 * <br/>
 *
 * <h3>User Turn Service ON/OFF</h3>
 * The following diagram illustrates what happens when the user turns the File
 * Sharing service on or off. The idea is that when this happens the extension
 * must display a new Radio Button to start or stop the service, and if it
 * start's the service a new JFrame will appear and allow the user to see the
 * server files and client files.<br/>
 * <br/>
 * <img src="doc-files/ipc08_01_design2.png">
 * <br/>
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/file_sharing/package-summary.html">csheets.ext.file_sharing</a><br/>
 * <a href="../../../../csheets/ext/file_sharing/ui/package-summary.html">csheets.ext.file_sharing.ui</a><br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author 1130346
 */
package csheets.userstories.ipc08_02.auto_download.i130346;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1130346
 *
 */
class _AutoDownload_ {
}
