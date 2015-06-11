/**
 * Technical documentation regarding the user story core03_1: Sort the contents
 * of cells.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * Provide a extension to allow the user to sort the contents of cells, it also
 * most give the option to sort ascending or descending. The interaction with
 * the use can be based only on application menu options, for this use case it
 * is enough to order only one column.
 * <br/>
 * <b>Sort the contents of cells:</b> The user selects one cell of the column he
 * desires to order, then he goes to "Extensions" -> "Sort" and chooses between
 * ascending and descending.<br/>
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * It should be possible to order ascending and descending one column of cells.
 * Analyzing this in a graphical way, its required to give an option to sort the
 * selected column so it must be created a "Sort" menu in "Extensions" menu, the
 * created menu will give two options "Sort Ascending" to sort the content of
 * column increasingly and "Sort Descending" to sort it downward. Analyzing this
 * in a coding way it necessary an ArrayList to store the content of the
 * selected column, to facilitate the treatment of the information in this
 * particular case sorting the column with the "sort()" and "reverse()" methods
 * provided by ArrayList.
 *
 * <br/>
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
 * <img src="doc-files/core03_01_sort_analysis.png">
 * <br/>
  * <br/>
* <h2>3. Tests</h2>
* 
* Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to sort an column based on the content of the cells. We need to be able to get the contents of the cells of the desired column we want to sort.<br/>
* Following this aproach we can start by coding a unit test that uses the classes <code>Cell</code>, <code>Spreadsheet</code> to allow us to retrive the contents of the active spreadsheet and the contents of the column selected. A test that will be performed will be setting some values in the cells and sort them and see if the cells at "first position" has the "lowest" value and the "last position" has the highest value.
* 
 * As usual, in a test driven development approach tests normally fail in the beginning. The idea is that the tests will pass in the end.<br> 
 * 
 * <h3 style="font-size:14px;">Functional Tests</h3>
 * To test this use case, the user must follow these steps:
 * <ul>
 * <li>Select any cell of the column that must be ordered</li>
 * <li>Go to "Extensions" menu</li>
 * <li>Select Sort</li>
 * <li>Choose between ascending or descending</li>
 * </ul>
 * Doing all these steps will order the column
 *
 * <br/>
  * <br/>
  * 
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We will also need to create a subclass of UIExtension. 
 * In the code of the extension <code>csheets.ext.style</code> we can find examples that illustrate how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution for this use case.<br/>
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Sort" extension when cleansheets is run.<br/><br/>
 * <img src="doc-files/core03_01_design.png">
 * <br/>
 *
 * <h3>User Selects Cell and Selects Sort Ascending/Descending</h3>
 * The following diagram illustrates what happens when the user updates the text of the comment of the current cell. To be noticed that this diagram does not depict the actual selection of a cell (that is illustrated in the previous diagram).<br/>
 * The following diagram illustrates what happens when the user selects the sort he wants.<br/>
 * <br/>
 * <img src="doc-files/core03_01_design2.png">
 * 
 * <br/>
 * <br/>
 
 * <h2>5. Coding</h2>
 * see:<br/>
 * <h3>Created</h3>
 *
 * <h3>Modified</h3>
 * <br/>
 * <br/>
 *
 * @author 1120810
 */
package csheets.userstories.core03_1.sort_contents_cells.i120810;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1120810
 *
 */
class _Dummy_ {
}
