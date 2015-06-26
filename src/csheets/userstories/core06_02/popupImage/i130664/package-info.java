/**
 * Technical documentation regarding the user story core06_1: Insert Image.
 * <br/>
 * <br/>
 * <h2>1. Requirements</h2>
 * From the previous use case core06_01, insert image, it is now supposed to
 * show a signal/icon on the a cell that has an image associated, is also needed
 * to appear a floating image when the mouse is on top of a cell that contains
 * an image. On the side bar, a button that allows you to export the image to a
 * file, is now required .
 * <br/>
 * <br/>
 * <b>Use Case Popup Image:</b> The user inserts a image on a cell, the system
 * now shows a icon/signal on the same cell. The user places his mouse on a cell
 * with an image, the system shows the image floting. The user wants to export
 * the image to a file, the system exports the image.<br/>
 * <br/>
 *
 * This use case I think it is better to split it in two parts. The first part,
 * since the window to call functions is already done, I just need to add some
 * specific changes to that. On the second part, I need to understand how the
 * values of the edit box are assigned to the cell, so I can introduce the new
 * button that will do the same as the edit box, but in this case, the result
 * will be stored in the selected cell.
 *
 * <h2>2. Analysis</h2>
 * In order to implement the core06.2 use case I need to study the previous use
 * case core06.1 to understand how the image is being associated to a cell. It
 * will also be necessary to understand how the image will be shown floating
 * when the cursor is on top of a cell that contains an image. In addition to
 * the previous I must study the exportation of images.
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
 * <img src="doc-files/popup_image_analysis.png"/>
 * <br/>
 * <br/>
 * <h3>3. Tests</h3>
 * Basically, from requirements and also analysis, I see that the core functionality 
 * of this use case is to place a signal/icon on a cell that contains an image. 
 * It needs to show an image floating, when the cursor is on top of the cell, and 
 * later I need to export the image to a file. 
 * I have to perform a unitary test to see if the exportation is being done. I have 
 * functional tests to see the extension of the file to be exported. 
 * <br/>
 * <br/>
 * <h2>4. Design</h2>
 * The following diagrams illustrate core aspects of the design of the solution 
 * for this use case.<br/>
 * 
 * <h3>Export the image</h3>
 * The following diagram illustrates what happens when the user wants to export
 * an image.
 * When the user selects the option to export, the UI has access to the image stored
 * on the cell and has the absolute path from the image. I just call the controlller
 * that calls the exportImage class. Then the exportation is done.<br/><br/>
 * <img src="doc-files/core06_02_design_export.png"/>
 * <br/>
 * 
 * <h3>Tooltip and signal</h3>
 * To realize this part of the use case, I need to implement a method on CellRenderer
 * that checks if a cell has an image, if it has an image the class just adds a 
 * tooltip to the cell. To place a signal on the cell, the class InsertImageCellDecorator
 * has a method decorate, that draws a string on a cell, if it has an it displays 
 * the choosen a signal.
 * 
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/insert_image/package-summary.html">csheets.ext.insert_image</a><br/>
 * <a href="../../../../csheets/ext/insert_image/ui/package-summary.html">csheets.ext.insert_image.ui</a><br/>
 * <a href="../../../../csheets/ext/insert_image/ui/package-summary.html">csheets.ui.sheet</a><br/>
 * <br/>
 * <br/>
 * 
 * 
 * @author Carlos Silva (1130664)
 */
package csheets.userstories.core06_02.popupImage.i130664;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Carlos Silva (1130664)
 *
 */
class _Dummy_ {
}
