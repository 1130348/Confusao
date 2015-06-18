/**
 * Technical documentation regarding the user story IPC05_01: Send Message.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * Make an extension that allows the user to send text messages to another
 * cleansheets instance (for which we know the address) and this message appears
 * in a "popup" window in the target instance . It should also be a sidebar in
 * which all the incoming incoming messages will appear. From this window
 * sidebar should be possible Reply to the received messages. The messages in
 * that window must be grouped by "origin" of the message.
 * <br/>
 * <br/>
 * <b>Use Case "Send Message":</b> The user selects the extension on the SideBar
 * "Navigator" tab where he can start/open the ChatUI to send messages to the
 * desired instance.<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * User Story IPC05_01 objective is to allow the sending of messages.<br />
 * To achieve that objective the application will hold a button on the SideBar
 * that will allow the user to "Login" in the chat. This button when clicked
 * will Start the Chat Service and open/create a new graphical
 * interface(ChatUI), this new UI will allow the user to send messages to
 * another instance of the cleansheets, with a known instance IP.
 * <br/>
 *
 * * <h2>a) First "Analysis" Sequence Diagram</h2>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).<br/>
 * <br/>
 *
 * <img src="doc-files/IPC05_01_send_message_ext_design_analysis.png">
 *
 * * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to communicate with other
 * instances of "CleanSheets" and send a message.<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * In the end this use case requires only Functional Tests:
 *  #Send Message;
 *  #See if message reached its destination;
 *  #See if can receive answer from sent message;
 * <br/>
 *
 * <br/>
 * see: <code>csheets.ext.Send_Message</code><br/>
 *
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension
 * <code>csheets.ext.send_message</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 *
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Send Message" extension when
 * cleansheets is run.<br/><br/>
 *
 * <img src="doc-files/IPC05_01_send_message_ext_design1.png">
 *
 * <h3>User Turns Service On/Off</h3>
 * The following diagram illustrates what happens when the user turn the Chat
 * Service On or Off. The idea is that when this happens the extension must
 * display in the sidebar a Radio Button to Start or Stop the Service, in
 * case of Starting the service it will create a new Jframe ChatUI that will allow the
 * user to send or see messages<br/>
 * <br/>
 *
 * <img src="doc-files/IPC05_01_send_message_ext_design2.png">
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <h3>Created</h3>
 *
 * <a href="../../../../csheets/ext/Send_Message/package-summary.html">csheets.ext.Send_Message</a><br/>
 * <a href="../../../../csheets/ext/Send_Message/ui/package-summary.html">csheets.ext.Send_Message.ui</a>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author 1120810
 *
 */
package csheets.userstories.ipc05_01.send_message.i120810;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1120810
 *
 */
class _Dummy_ {
}
