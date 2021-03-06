/**
 * Technical documentation regarding the user story ipc01_01: start sharing.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Allow connect to another instance of cleansheets and send a range of cells
 * for other instance. The received content should be presented in the same
 * "local". For this, in each instance cleansheets must be possible to define a
 * port for connections. It should be possible to find other cleansheets
 * instances on the same LAN. Instances should appear in a window and used to
 * make the connection. At this stage it is only necessary to transmit the
 * contents of the cells.
 * <br/>
 * <br/>
 * <b>Use Case "Start Sharing":</b>
 * The user selects the cells that he wants to share. Then begins the process of
 * connecting to another online user. The system displays a list of users to
 * which it can connect. The user selects customer that he wants to share cells
 * and the system sends the previously selected information.<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * Since the connection between the users is necessary to study how the data
 * transmission protocols (TCP) and the search server protocol (UDP), and with
 * the definition of network and ports. On the other hand we must understand the
 * functioning of cells in order to submit their content to another user.
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).<br/>
 * <br/>
 * <img src="doc-files/start_sharing_ipc_01_01.png"/>
 * <br/>
 * <br/>
 * Through the earlier draft we can see that was needed to create a new class.
 * This class will be responsible for the connection between users as well as
 * the transmission of the cells, so it is defined as a class of service.
 * <br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * Since a connection port is needed, we need to add an attribute in the class
 * Conection in order to be able to change the port. Later you need a method
 * that takes the contents of the cells and another that sharing this data, so
 * that the information is shared between users. In addiction would be
 * interesting that this general class were generic, so that can be shared other
 * objects, as evolved in the project.
 * <br/>
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from the requirements and analysis we revealed that the main
 * feature of this use case is to be able to share information of a given range
 * of cells, you must set the port value where it will connect. Following this
 * approach, we can start by coding a unit test that uses a new attribute to the
 * port with the corresponding accessor methods (set and get). A simple test to
 * set this attribute with one point to see if the get method returns this same
 * port. In another approach we can functionally test whether another instance
 * of the "CleanSheets" after connecting receives information transmitted by the
 * other instance.
 * <br/>
 * see: <code>csheets.ext.start_sharing.StartSharingTest</code>
 * <br/>
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. In the code of the
 * extension <code>csheets.ext.style</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
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
 * cells, he press the button to send and active actionPerformed() method of
 * class StartSharingAction<br/>
 * <br/>
 * <img src="doc-files/select_cells_and_click_ipc_01_01.png">
 *
 */
package csheets.userstories.ipc01_01.start_sharing.i130399;

/**
 *
 * @author Sérgio Gomes (1130399)
 */
class _Dummy_ {
}
