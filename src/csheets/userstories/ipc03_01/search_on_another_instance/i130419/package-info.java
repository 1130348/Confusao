/**
 * Technical documentation regarding the user story ipc03_01: search on another instances 
 * <br/>
 * <br/>
 * 
 * <h2>1. Requirement</h2>
 * Be able to identify multiple instances of cleansheets. It should be possible 
 * to send a search request of workbooks on another machine(search by name). 
 * Research should cover only the workbooks that are open in the other instance 
 * of cleansheets. The origin should receive an answer if the file was found or 
 * not. If the file is found the source should receive the summary of the 
 * contents of this workbook (name of the sheets and the first cell values ​​with 
 * value of sheet).
 * <br/>
 * <br/>
 * <b>Use Case "Search on another Instance":</b>
 * The user selects the option to search workbooks on another instance of 
 * "CleanSheets". The system displays a list of machines available to perform 
 * the search then the system asks the workbook name to search. At the end if 
 * the file is found the user receives a summary of the content in found 
 * workbook. Otherwise you receive a notification telling that the file was not
 * found.
 * <br/>
 * <br/>
 *  
 * <h2>2. Analysis</h2>
 * In order to know where we could find open workbooks, we need to study where
 * the program saves these workbooks. The part responsible for finding 
 * instances of "CleanSheets" in same LAN has been implemented previously in the
 * use case IPC_01_01 Start Sharing. The program must be constantly waiting to 
 * receive a search request. After receiving such a request the program should 
 * check if any of the open workbooks match with shipped name and send a report
 * with the information of workbook found. All these tasks must be performed 
 * without prevent the user to use the other features of "CleanSheets".
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
 * workbook with the desired name.
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
 * <img src="doc-files/select_cells_and_click_ipc_01_01.png">
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.startsharing</a><br/>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.startsharing.ui</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * We cant achieve the objectives because we have a problem with ports<br/>
 * <br/>
 * <br/>
 * 
 */

package csheets.userstories.ipc03_01.search_on_another_instance.i130419;

/**
 *
 * @author Paulo Pereira (1130419)
 */
class _Dummy_ {}

