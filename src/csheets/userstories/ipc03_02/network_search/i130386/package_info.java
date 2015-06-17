/**
 * Technical documentation regarding the user story ipc03_02: Network Search
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Be able to send a request for workbook research by name for all the instances
 * of cleansheets in the local Network. A local research network should include
 * only the workbooks that are open in other instances . There must be a sidebar
 * window with a list to contain this search results. Be able to update the list
 * when more files are found . The list should appear the instance where the
 * workbook has been found, its name and the summary of the content of this
 * workbook (name of the leaves and values ​​of the first cell with a value of
 * each sheet).
 * <br/>
 * <br/>
 * <b>Use Case "Network Search":</b>
 * The user selects the option to send a workbook search by name to all the
 * other instances running of "CleanSheets" runing in the local network. The
 * system displays a list of this instances in a sidebar window. The list must
 * be updated every time it finds a new file.
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * In order to know where we could find open workbooks, we need to study where
 * the program saves these workbooks. The part responsible for finding instances
 * of "CleanSheets" in same LAN has been implemented previously in the use case
 * IPC_01_01 Start Sharing. In order to know where we could search in another
 * instnace, we need to study where the program does this. The part responsible
 * for searching in another instance of "CleanSheets" in same LAN has been
 * implemented previously in the use case IPC_03_01 Search on another instance.
 * The program must be always searching on the local network for active
 * instances and must always refresh the sidebar window when he finds a new one.
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
 * <h3>Sender</h3>
 * <img src="doc-files/draft_search_on_another_instances_sender.png"/>
 * <br/>
 * <h3>Receiver</h3>
 * <img src="doc-files/draft_search_on_another_instances_receivers.png"/>
 * <br/>
 * <br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * Through the diagram above we can see that will have to create a new class
 * responsible for creating a report based on the contents of worbook. Besides
 * it will be necessary to create a mechanism to alert the user that someone
 * wants to search his/her machine (Example.: Observer).
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is search within the open workbooks the
 * workbook with the desired name in the local network.
 * <br/>
 * Following this approach we can start by coding a unit test that uses the
 * class <code>ReportCreater</code> and tests if this class founds the woorkbook
 * with the given name. Furthermore we also have to perform functional tests to
 * see if the client is receiving the prompts to seek the desire workbook.<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * <br/>
 * see: <code>csheets.ext.search_on_another_instances</code><br/>
 * <h2>4. Design</h2>
 * To realize this user story we used Observer pattern for alert UI that Server
 * receive a request for search one woorkbook by name or receive one reponse to
 * that request. <code>csheets.ext.search_on_another_instance</code> we can find
 * examples that illustrate how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 *
 * <h3>Start Server</h3>
 * The following diagram shows the setup of the Server after start this use case
 * <br/>
 * <br/>
 * <img src="doc-files/start_server_sequence_diagram.png"/>
 * <br/>
 * <h3>User Send Search Request</h3>
 * The following diagram shows when user send a search request<br/>
 * <br/>
 * <img src="doc-files/sequence_diagram.png">
 * <h3>User Receive Search Request</h3>
 * The following diagram shows when user receive one search request<br/>
 * <br/>
 * <img src="doc-files/sequence_diagram_receiver.png">
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.search_on_another_instance</a><br/>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.search_on_another_instance.ui</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * We achieve the objectives and in our point of view all requirements have been
 * accomplished.<br/>
 * <br/>
 * <br/>
 *
 */
package csheets.userstories.ipc03_02.network_search.i130386;

/**
 *
 * @author Luis Mouta (1130386)
 */
class _NetWorkSearch_ {
}
