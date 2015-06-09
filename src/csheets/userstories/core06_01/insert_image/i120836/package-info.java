/**
 * Technical documentation regarding the user story core06_1: Insert Image.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * An option to insert a picture in the spreadsheet. The inserted picture is
 * associated with a cell (the cell that is currently active). There must be a
 * sidebar that displays the image that is associated with the cell (in order to
 * simulate reviews).
 * <br/>
 * <br/>
 * <b>Use Case Insert Image:</b> The user selects the cell where he/she wants to
 * insert an image. The user selects the extension "Insert Image" of the
 * Extension Menu and there open's a File Chooser for the user to choose a image
 * to insert.<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * The UC Core06.1 objective is to gave the user the possibility to insert an
 * image in the the sheet on the select cell. The extension will have a File
 * Chooser, making the user able to choose an image inserting it and a SideBar
 * that will show the image that is associated with the selected cell. For the
 * development of the this functionality we will use a few classes as their
 * properties that already has been created like: "Extension" and
 * "CellExtension".
 * <br/>
 *
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
 * <img src="doc-files/insert_image_extension_analysis.png">
 * <br/>
 * <br/>
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to add an attribute to the cell,
 * to be used to store an image. We need to be able to set and get its
 * "object"(image).<br/>
 * Following this approach we can start by coding a unit test that uses a
 * subclass of <code>CellExtension</code> with a new attribute for user insert
 * image with the corresponding method accessors (set and get). A simple test
 * can be to set this attribute with a simple "object"(image) and to verify if
 * the get method returns the same "object"(image).<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * <br/>
 * see: <code>csheets.ext.insert_image.ImageCellTest</code><br/>
 *
 * <h2>4. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension
 * <code>csheets.ext.Insert_Image</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Insert Image" extension when cleansheets is run.<br/><br/>
 * <img src="doc-files/insert_image_extension_design1.png">
 * <br/>
 *
 * <h3>User Selects a Cell</h3>
 * The following diagram illustrates what happens when the user selects a cell. The idea is that when this happens the extension must display in the sidebar the Image of that cell (if it exists).<br/> 
 * <br/>
 * <img src="doc-files/insert_image_extension_design2.png">
 * <br/>
 * <h3>User Updates the Image of a Cell</h3>
 * The following diagram illustrates what happens when the user updates the image of the current cell. To be noticed that this diagram does not depict the actual selection of a cell (that is illustrated in the previous diagram).<br/>
 * <br/>
 * <img src="doc-files/insert_image_extension_design3.png">
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/insert_image/package-summary.html">csheets.ext.insert_image</a><br/>
 * <a href="../../../../csheets/ext/insert_image/ui/package-summary.html">csheets.ext.insert_image.ui</a><br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author 1120836
 */
package csheets.userstories.core06_01.insert_image.i120836;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1120836
 *
 */
class _InsertImage_ {
}
