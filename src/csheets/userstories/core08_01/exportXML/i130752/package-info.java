/**
 * Technical documentation regarding the user story core08.01: Export XML
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * It is asked to add the funcionality of exporting various elements of a workbook
 * to XML using a option in the File menu. There must be a window to define the tags
 * that will be used for each element being added.
 * 
 *
 * <br/>
 * <br/>
 * <b>Use Case "Export XML":</b> 
 * The user selects the option from the menu and it lets him choose which
 * elements are meant to be exported and with which tags they will be exported
 * all in a window created for this objective.
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * To implement this method of exporting we will need to create the class
 * responsible for doing this functionality specifically for XML and also
 * implement the necessary classes so it's possible to improve on it and add
 * other types of exportation without interfering with the already types 
 * implemented.
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" sequence
 * diagram because it functions like a draft that we can do during analysis or
 * early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created). It serves as the guidelines for the design.<br/>
 * <br/>
 * <img src="doc-files/core08_01_analysis.png"/>
 * <br/>
 * <br/>
 * With this diagram we see that it will be used a Strategy for this Use Case.<br/>
 * Therefore, at this point, we need to implement all the required classes for
 * a valid and functional strategy.<br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * There isn't any way of exporting in the application so this will be the first
 * implementation of this process so all the classes will be created from scratch.<br/>

 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to enable the use of a Export function.
 * For testing we will test if the content selected by the user corresponds to
 * the content exported.
 * <br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.
 * <br/>
 * <br/>
 *
 * <h2>4. Design</h2>
 *
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * insert href to code later here<br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * The Strategy pattern as described in Design Patterns: Elements of 
 * Reusable Object-Oriented Software is one of the most important points of this
 * Use Case.
 * <br/>
 * <br/>
 * <br/>
 *
 * @author i130752
 */
package csheets.userstories.core08_01.exportXML.i130752;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author i130752
 */
class _ExportXML_ {
}
