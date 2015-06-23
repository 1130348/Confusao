/**
 * Technical documentation regarding the user story core03_2: Sort a column of
 * cells from a selected range of cells.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * The user selects a range of cells and choose if he wants to sort ascending or
 * descending. After that the user should be able to choose the column from the
 * current selection that he wants to sort.
 * <br/>
 * <b>Sort the contents of cells:</b> The user selects a range of cells, then he
 * goes to "Extensions" -> "Sort" and chooses between * ascending and
 * descending. A new window pops up asking for the column of the current
 * selection that he wants to sort<br/>
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * From the previous use case the sort mechanism was implemented but it only
 * works for one column of the sheet, not for a range of cells that can include
 * more than one column. For this use case we need to change the already
 * implemented metods to accept the range selection without forcing the user to
 * make that selection. It should remain possible to simply select a cell and
 * sort the column of that cell. A new window should pop up if more than one
 * column are selected. This new window should let the user choose the column
 * from the selection that he wants to sort.
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
 * <img src="doc-files/core03_02_draft_core_03_02.png">
 * <br/>
 * <br/>
 * <h2>3. Tests</h2>
 * From the analysis we can see that we need to test if the sort methods work properly.
 * For that we need to check if the method <code> cellContents() </code> its able to get 
 * the cells content correctly. We also need to test if the method <code> sort() </code>
 * is able to sort the cells content correcly in booth ascending and descendig order.
 * Finally we need to test if the method <code> fillSorted() </code> is able to update the 
 * cells content in the right order.
 * 
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
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
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. In the code of the
 * extension <code>csheets.ext.style</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 *
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Sort" extension when
 * cleansheets is run.<br/><br/>
 * <img src="doc-files/core03_01_design.png">
 * <br/>
 *
 * <h3>User Selects Cell and Selects Sort Ascending/Descending</h3>
 * The following diagram illustrates what happens when the user updates the text
 * of the comment of the current cell. To be noticed that this diagram does not
 * depict the actual selection of a cell (that is illustrated in the previous
 * diagram).<br/>
 * The following diagram illustrates what happens when the user selects the sort
 * he wants.<br/>
 * <br/>
 * <img src="doc-files/core03_01_design2.png">
 *
 * <br/>
 * <br/>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <h3>Created</h3>
 *
 * <h3>Modified</h3>
 * <br/>
 * <br/>
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 */
package csheets.userstories.core03_02.sort_range_of_cells.i130372;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 *
 */
class _Dummy_ {
}
