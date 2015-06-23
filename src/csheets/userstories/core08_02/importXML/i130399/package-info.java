/**
 * Technical documentation regarding the user story core08.02: Import XML
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * It must be possible to import data from XML file. Depending on the contents
 * of the file to import, the import data can substitute a workbook, a sheet or
 * an area of a sheet. The option to import should appear in the "File" menu.
 * <br/>
 * <br/>
 * <b>Use Case "Import XML":</b>
 * The user selects the option to import as from the menu. That option lets him
 * choose what is the file type, in this case XML, after this user can choose
 * what sheet he wants to import the data or he can import the data to a new
 * sheet. Finally the user selects the xml file that he wants to import and the
 * data is imported with success.
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * To support the importation of xml files we need to implement an method that
 * imports a file, it will be needed to create a class that will be responsible
 * for doing this functionality specifically for XML and implement the necessary
 * classes to be possible in future use cases support other types of importation
 * without interfering with the already types implemented.
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
 * <img src="doc-files/draft_core08_02.png"/>
 * <br/>
 * <br/>
 * To implement this use case we will use a Strategy.<br/>
 * Therefore, at this point, we need to implement all the required classes in
 * order to implement a valid and functional strategy.<br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * In order to import an XML file we will need to study how a xml file can be
 * imported with dom parser and after this how to fill the cells with the
 * data.<br/>
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to import or export data from a
 * text file.<br/>
 * I have to perform functional tests to see if the file is being created when
 * doing an exportation. I also need to test if the data from the text file is
 * being imported correctly. Furthermore I also have to test if the file created
 * by the exportation has the correct data.<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.
 * <br/>
 * <br/>
 *
 * <h2>4. Design</h2>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.
 * <br/>
 * <img src="doc-files/core08_01_design.png"/>
 * <br/>
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * insert href to code later here<br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * The Strategy pattern as described in Design Patterns: Elements of Reusable
 * Object-Oriented Software is one of the most important points of this Use
 * Case.
 * <br/>
 * <br/>
 * <br/>
 *
 * @author Sergio Gomes <1130399@isep.ipp.pt>
 */
package csheets.userstories.core08_02.importXML.i130399;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Sergio Gomes
 */
class _ImportXML_ {
}
