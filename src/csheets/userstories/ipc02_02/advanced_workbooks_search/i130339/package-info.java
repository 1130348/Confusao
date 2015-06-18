/**
 * Technical documentation regarding the user story ipc02_02: Advanced WorkBook Seach 
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * The sidebar window that contains the search result must have an area of ​​"preview"
 * that must submit a " sample" of the sheet content without open it
 * (for open , it is understood to be any visible or accessible way in cleansheets).
 * The sample must contain the paper sheets and for each sheet the content of the first cells with value.
 * <br/>
 * <br/>
 * <b>Use Case "Advanced WorkBook Search":</b>
 * The User starts the workbook search and all the results are displayed o the sidebar. The User has then the possibility to see the preview
 * of the file content, where he can see the first cells with content of each sheet, then after that if he chooses it he can open the file.<br/>
 * <br/>
 * <h2>2. Analysis</h2>
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram of the Advanced Note Editon</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created). <br/>
 * Let's now see the sequence diagram. This is just a summary of a proposal.
 * This analyse diagram will probably be changed in the Design part after
 * thinking and analyzed all the project and will updates to a sequence diagram.
 * <br/>
 * <br/>
 * <img src="doc-files/ipc_02_02_sequence_diagram_analysis.png">
 * <br/>
 * <br/>
 * From the previous diagram we can see that after the user choose the workbook ,
 * we have to get all the leaves from the workbook, and for each one we will need to get the first cells with value. 
 * After having the cells , we can show the user the "preview" and then give the option to open the file .
 * <br/>
 * 
 * <img src="doc-files/ipc_02_02_class_diagram_analysis.png">
 * <br/><br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * When i started to analyze this use case, there was an issue that came up on the interface.
 * The question was "Is it worth reusing the interface(sidebar) of the previous use case of this
 * iteration?", to clarify this doubt i went to talk to our organizer. In this talk we conclude,
 * it would make more sense to reuse the interface of the previous use case of this iteration.
 * We made this conclusion since the changes that will be done to the interface will not change
 * the way the previous uc works. 
 * <br/>
 * Before it would appear a sidebar with the list of workbook files that were found, and if we
 * double click the file on the list it would open and turn that workbook the active one on the
 * cleansheet. The change that i will implement is, when the user double clicks, a new window
 * will be open, where the user will see the preview of the workbook, after that there are 2 
 * buttons Open and Cancel, with the Open button it will be possible to keep how the last uc worked
 * since the only change is that after the double click he will have to click Open on the new window,
 * if the button is pressed it will open the workbook, with the Cancel button it will cloose
 * the window and return to the main window.
 * <br/>
 * <h2>3. Tests</h2>
 * For this use case, there will be no additional tests, since all the methods that are used
 * in this UC were already implemented in the original program, so i assume that the given
 * code was correct, even without having tests, since who made the program didnt do a approach 
 * based on tests.
 * <h2>4. Design</h2>
 * <br/>
 * A sequence diagram shows object interactions arranged in time sequence. It
 * depicts the objects and classes involved in the scenario and the sequence of
 * messages exchanged betwween the objets needed to carry out the functionality
 * of the scenario.<br/>
 * <img src="doc-files/ipc_02_02_sequence_diagram_design.png">
 * </br>
 * 
 * The first approach to this use case was to do a separated window to show the preview
 * since with the table and the several tabs to show all the sheets it was to much 
 * information for a sidebar. <br>
 * But then i was told that it would be important to try to put the "preview" on the sidebar
 * to try to have all the information in the main window. That was a challenge since the information
 * doesnt fit all in the sidebar, and the user needs to increase the size of the window to see the
 * rest of the information, but at least this way its possible to have all on the sidebar. </br>
 * Then there are 2 buttons, one that allows the user to load more cells to show and one that 
 * gives the option to open the workbook.
 * <br/><br/>
 * <h2>5. Coding</h2>
 * 
 * <h2>6. Final Remarks</h2>
 * 
 * <br/>
 * <br/>
 *
 */


package csheets.userstories.ipc02_02.advanced_workbooks_search.i130339;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package!
 *
 * @author Antonio Pinheiro
 */
class _Dummy_ {
}

