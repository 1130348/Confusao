/** 
 * Technical documentation regarding the user story ipc01_01: start sharing. 
 * <br/>
 * <br/>
 * 
 * <h2>1. Requirement</h2>
 * Allow connect to another instance of cleansheets and
 * send a range of cells for the other instance. The content received must be 
 * presented in the same place. For this, in each instance cleansheets must
 * be possible to define a port for connections. It should be possible to find
 * other cleansheets instances on the same local address. Instances must appear in a 
 * window and used to make the connection. At this stage it is only necessary to
 * transmit cells content.
 * <br/>
 * <br/>
 * <b>Use Case "Start Sharing":</b>
 * The user selects the cells that he/she intends to submit and select the option 
 * to connect to the other customer of "CleanSheets". The system displays a list
 * of possible customers to make connection. The user selects the desired client
 * and the system sends the information to the previously selected customer<br/>
 * <br/>
 *  
 * <h2>2. Analysis</h2>
 * In order to make connection between customers we will need to understand the 
 * communication process through the UDP/TCP protocol. It will also be necessary to 
 * understand how the cells works to know how to send the cell contents
 * to the client. In addition to the previous we must also study the operation of 
 * networks and the definition of gateways.
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
 * <img src="doc-files/ipc01_01_analysis.png"/>
 * <br/>
 * Through the earlier draft we can see that a new class was created. This class
 * will address only the data transmission between clients so it will be placed
 * as a service class. In addition we will need to study the way we going to set 
 * the gateway and how the search ​​of others instances of 
 * "CleanSheets" on the same local network.
 * <br/>
 * <br/> 
 * <h3>Analysis of Core Technical Problem</h3>
 * As will be possible to have a port and change the application's port we must
 * have a port attribute in class connect. In addition each instance of 
 * "CleanSheets" will send or receive information from other "CleanSheets", for 
 * it will then be necessary to construct a method that takes data and another 
 * method to transmit the desired data. Also it would be interesting that this
 * class was generic as later in the project, they can be sent and received 
 * other objects in addition to the cells.
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
 * <img src="doc-files/select_cells_and_share_ipc01_01.png"/>
 * 
 */

package csheets.userstories.ipc01_01.start_sharing.i130664;

/**
 *
 * @author Carlos Silva (1130664)
 */
class _Dummy_ {}

