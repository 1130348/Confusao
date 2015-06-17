/**
 * Technical documentation regarding the user story core07_02 : Multi Match
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * Provide a window to allow search text. It can be a regular expression or a
 * string.
 * <br/>
 * <br/>
 * <b>Use Case "Search Text Multi Match":</b> The user select "Search and
 * Replace"on the "Edit" bar, or press Ctrl+F for shortcut. The system show a
 * window to input the word or the regular expression to search. The System
 * search and returns a list of addresses where the text was matched. If the
 * list is empty, then there was no matches found. <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * User Story Core07.2 aims to automate the process of search text. <br />
 * The search class makes the search of the text that the user entered and
 * returns a list of matches. <br/>
 * The research is carried out in the open Workbook and selected Spreadsheet.
 * The cells that match with the input are sent to a list. The search is done
 * line by line from left to right. <br/>
 * Once found all the possible matches the System send the addresses list to a
 * Search Result panel, located on the right side of the main window. The user
 * can now select a match from the list and the system must activate the
 * correspondent cell in the SpreadSheet Table. <br/>
 * If the search text is not found, the application displays a box with the
 * message that were not found cells with that value.
 *
 * <br/>
 *
 * <h2>a) First Sequence Diagram</h2>
 * <img src="doc-files/core07_02_search_multi.png">
 *
 * * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to esearch for words or regular
 * expressinons. We need to be able to get value of the cells.<br/>
 * Following this approach we can start by coding a unit test that uses the
 * class <code>Search</code> that return true if the text was found . A simple
 * test can be to set this attribute with a simple boolean and to verify if the
 * get method returns the same boolean.<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * <br/>
 * see: <code>csheets.ext.SearchTest</code><br/>
 *
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a calss Search. We will to
 * change the class SearchAction, more specifically the method actionPerformed.
 * <br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 * <img src="doc-files/core07_01_search_text_2.png">
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <h3>Created</h3>
 *
 * <a
 * href="../../../../csheets/ext/Search/package-summary.html">csheets.ext.Search</a><br/>
 *
 * <h3>Modified</h3>
 * <a
 * href="../../../../csheets/ext/ui/ctrl/package-summary.html">csheets.ui.ctrl.SearchAction</a><br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author 1130346
 */
package csheets.userstories.core07_02.search_multi;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1130346
 *
 */
class _Dummy_ {
}
