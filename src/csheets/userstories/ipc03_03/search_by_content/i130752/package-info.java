/**
 * Technical documentation regarding the user story ipc03_03: search by content
 * <br/>
 * <br/>
 * 
 * <h2>1. Requirement</h2>
 * Be able to send a search request of a workbook (sending the name or a pattern
 * correspondent to the content of a workbook) to all instances of cleansheets in
 * the same local network.<br/>
 * The search must present all workbooks present in the disk of other intances of
 * cleansheets. There should be a new sidebar with a list with the results found,
 * this list will be updated while files are being found (the list will be updated
 * in real-time).<br/>
 * In this list will be presented the instance where the workbook were found, its
 * name and a summary of the content of the workbook( name of the sheets and values
 * of the first cells with content of each sheet).
 * <br/>
 * <br/>
 * <b>Use Case "Search by Content":</b>
 * The user selects the option to search workbooks by content to all 
 * other instances running of "CleanSheets" in the local network. The
 * system displays a list of this instances where it was found the name of the
 * workbook correponds to the search and those whose content corresponds to the
 * search being made, this information will be presented in a sidebar window.
 * The list must be updated every time it finds a new file.
 * <br/>
 * <br/>
 *  
 * <h2>2. Analysis</h2>
 * In order to know where we could find open workbooks, we need to study where
 * the program saves these workbooks. The part responsible for finding 
 * instances of "CleanSheets" in same LAN has been implemented previously in the
 * use case IPC_01_01 Start Sharing. In order to know where we could search in another
 * instnace, we need to study where the program does this. The part responsible
 * for searching in another instance of "CleanSheets" in same LAN has been
 * implemented previously in the use case IPC_03_01 Search on another instance. 
 * Now besides looking for a name will also look for the content of the workbook.
 * The program must be constantly waiting to receive a search request.
 * After receiving such a request the program should check if any of the open 
 * workbooks match with shipped name and send a report without prevent the user 
 * to use the other features of "CleanSheets".
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
 * <h3>Search</h3>
 * <img src="doc-files/draft_search_by_content.png"/>
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
 * see: <code>//inserir classe de codigo</code><br/>
 * <h2>4. Design</h2>
  * To realize this user story we used Observer pattern for alert UI that Server
 * receive a request for search one woorkbook by name or receive one reponse to
 * that request. <code>csheets.ext.search_on_another_instance</code> we can find
 * examples that illustrate how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/> 
 * <img src="doc-files/design_search_by_content.png"/>
 * <br/>
 * 
 * <h2>5. Coding</h2>
 * see:<br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * We achieve the objectives and in our point of view all requirements have been
 * accomplished.<br/>
 * <br/>
 * <br/>
 * 
 */

package csheets.userstories.ipc03_03.search_by_content.i130752;

/**
 *
 * @author Luis Lopes (1130752)
 */
class _SearchByContent_ {}

