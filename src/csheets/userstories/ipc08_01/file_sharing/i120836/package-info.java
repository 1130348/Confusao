/**
 * Technical documentation regarding the user story ipc08_1: File Sharing.
 * <br/>
 * <br/>
 * <h2>1. Requirements</h2>
 * Making an extension that enables sharing files contained in a folder (outbox)
 * specified in cleansheets. The cleansheets should show the name of the shared
 * files on another instance of cleansheets that call. In addition to the name
 * should still see the file size. It should also be possible to set a folder
 * for receipt of files (inbox) from another cleansheets. The shared folders
 * must be configured in an appropriate file. For now is not necessary to make
 * the download, however it is necessary to maintain the updated file list
 * automatically.
 * <br/>
 * <br/>
 * <b>Use Case "File Sharing":</b> The user selects the extension File Sharing
 * on the sidebar, where we can start the service to allow sharing files. <br/>
 * <br/>
 * 
 * <h2>2. Analysis</h2>
 * The UC IPC08.1 objective is to gave the user the possibility to share files
 * with another instance of the cleasheet. To reach this objective the app will
 * have two button's on the sidebar, one that will allow the user to start the
 * file sharing with any instances and the other to stop the service. The button
 * "Start Service" will open a frame that will have all the instances of the
 * cleansheet in the network and the folder's "outbox" and "inbox".
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
 * <img src="doc-files/ipc08_01_analysis.png">
 * <br/>
 * <br/>
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to communicate with other
 * instances of "CleanSheets" and share files.<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * In the end this use case requires only Functional Tests:
 *  #Send Outbox folder;
 *  #See if files in folder reached its destination;
 *  #See if can receive the files from other CleanSheets;
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
 * @author 1120836
 */
package csheets.userstories.ipc08_01.file_sharing.i120836;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1120836
 *
 */
class _FileSharing_ {
}
