/**
 * Technical documentation regarding the user story core07_01 : Search Text
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * Provide a window to allow search text. It can be regular expression or a
 * string.
 * <br/>
 * <br/>
 * <b>Use Case "Search Text":</b> The user select "Search and Replace"on the
 * "Edit" bar, or press Ctrl+F ate the same tyme. The system show a window to
 * imput the word or the regular expression to search. The System search and if
 * the text is found the cell become active. <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * User Story Core07.1 aims to automate the process of search text <br />
 * The search class makes the search of the text that the user entered and
 * select the cell. <br/>
 * The research is carried out in the open Workbook and selected Spreadsheet.
 * The first cell found is selected. In this case, the search will be done line
 * by line from left to right.<br/>
 * If the search text is not found, the application displays a box with the
 * message that were not found cells with that value.
 *
 * <br/>
 *
 * <h2>a) First Sequence Diagram</h2>
 * <img src="doc-files/core07_01_search_text.png">
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
 * <a href="../../../../csheets/ext/Search/package-summary.html">csheets.ext.Search</a><br/>
 *
 * <h3>Modified</h3>
 * <a href="../../../../csheets/ext/ui/ctrl/package-summary.html">csheets.ui.ctrl.SearchAction</a><br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author 1091334
 */
package csheets.userstories.core07_01.search_text;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1091334
 *
 */
class _Dummy_ {
}
