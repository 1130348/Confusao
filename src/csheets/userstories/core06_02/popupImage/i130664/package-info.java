/**
 * Technical documentation regarding the user story core06_1: Insert Image.
 * <br/>
 * <br/>
 * <h2>1. Requirements</h2>
 * From the previous use case core06_01, insert image, it is now supposed
 * to show a signal/icon on the a cell that has an image associated, is also needed
 * to appear a floating image when the mouse is on top of a cell that contains an image.
 * On the side bar, a button that allows you to export the image
 * to a file, is now required .
 * <br/>
 * <br/>
 * <b>Use Case Popup Image:</b> The user inserts a image on a cell, the system
 * now shows a icon/signal on the same cell. The user places his mouse on a cell
 * with an image, the system shows the image floting. The user wants to export 
 * the image to a file, the system exports the image.<br/>
 * <br/>
 *
 * This use case I think it is better to split it in two parts.
 * The first part, since the window to call functions is already done, I just 
 * need to add some specific changes to that. On the second part, I need to 
 * understand how the values of the edit box are assigned to the cell, so I 
 * can introduce the new button that will do the same as the edit box, but in 
 * this case, the result will be stored in the selected cell.
 * 
 * <h2>2. Analysis</h2>
 * In order to implement the core06.2 use case I need to study the previous use case
 * core06.1 to understand how the image is being associated to a cell. It will 
 * also be necessary to understand how the image will be shown floating when the cursor
 * is on top of a cell that contains an image. In addition to the previous I must study 
 * the exportation of images.
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
 * 
 * @author 1130664
 */
package csheets.userstories.core06_02.popupImage.i130664;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1130664
 *
 */
class _Dummy_ {
}
