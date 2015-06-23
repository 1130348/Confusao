/**
 * Technical documentation regarding the user story macros_09_01: buttons on
 * toolbar.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Add a window that allows the user to add buttons (icons) on the toolbar of
 * cleansheets. Each button has associated a text that should appear when let
 * fluit the mouse above that icon (one tooltip). Should still has an action
 * when clinking. That action can be a macro, a beanshell script or a form. The
 * buttons on the toolbar can be active or not. If disable the click don't
 * originate any action. Should be added functions on macros and beanshell that
 * allows activate and disable the buttons on the toolbar.
 * <br/>
 * <br/>
 * <b>Use Case "Buttons on the toolbar":</b>
 * The user will need to click on the button "Add" or "Edit". After that it
 * should be possible to add a button and to choose the tooltip text and the
 * action that is associated. Then to activate the button that will be a
 * different window.
 *
 * <br/>
 * <br/>
 * <h2>2. Analysis</h2>
 * The user will need to add, edit or remove the buttons that will appear on the
 * toolbar. From this moment, the ideia is to make an option on the menu with
 * the name "add button" or "edit button". When the user clicks on that option
 * will open a new window that allows the user to add, edit or remove a button.
 * On the top of the window has the list of action buttons already created. If
 * the user opted for creating a new one just need to select the button "Add
 * Button". On the otherside, if opted to edit a button (to change the tooltip,
 * the action and the active or disable just need to click two times on the name
 * of the button on the list. To remove just need to select one name of button
 * and select the button "Remove Button". After that the name of the button will
 * be deleted from the list.<br/><br/>
 * For now, let's see the ssd for the adding option. Like I said, the user
 * select the option on menu and the clicks on "Add Button". Then, will open a
 * new window in order to the user select the tooltip, the icon and the action
 * that is associated to that button. Also have the possibility to select if it
 * is active or not.
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_ssd_add.png"/>
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_analysis_sequence_add.png"/>
 * <br/><br/>
 * Now for the edition of the buttons. The user just need to select one button
 * and then a new window will open with all the information that was already
 * choosen. The user has no the possibility to change the information. This
 * edition was most create to the user can change if the button is active or
 * disable. If it is disable any action will be done when clicking on the button
 * on the toolbar.
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_ssd_edit.png"/>
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_analysis_sequence_edit.png"/>
 * <br/><br/>
 * To remove a button from the toolbar is very easy. The user just need to
 * select one button on the list and then click on the option "Remove Button".
 * After that the name of the button will disappear from the list and from the
 * toolbar.
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_ssd_remove.png"/>
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_analysis_sequence_remove.png"/>
 * <br/><br/>
 * From this point, I just understand how it will be done because of the package
 * csheets.ext.style.ui that creats a toolbar and buttons. The main problem I
 * believe that is to know how the buttons will be save and the action ill be
 * atributed since I don«t know what option the user will choose and on that
 * package has a class for each action. Because of that I think that is
 * necessary to create a controller that will create the actions to the button.
 * To make a class a toolbar will be necessary to implement JToolBar that has a
 * ButtonGroup with a vector of Abstract Vectors.
 * <br/>
 * Let's now see the class diagram from this use case with some of the methods
 * that the classes will have at this time of the analysis.
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_analysis_classes.png"/>
 * <br/><br/>
 *
 * <h2>3. Tests</h2>
 *  * Basically, from requirements and also analysis, we see that the MACRO
 * functionality of this use case is to be able to add buttons with some action
 * (macros, beansheel scripts or forms) to the toolbar. This use case is more
 * about GUI interface and because of that there aren't the necessity of doing
 * more than the actual tests that are already implemented. Since almost all the
 * methods in this use case were made previosly I assumed that them unitary
 * tests were working. On this use case, I created a lot of new classes but all
 * of them implemented or extends a class that was already implemented in this
 * cleansheets projet. All the classes that will be created: to add the new
 * buttons (the add and to edit - active or disable), the windows that will open
 * (Add: insert tooltip, the name of the icon and the chosen action; Edit: edit
 * a button or remove it). The controller class that will be created
 * (ButtonsController) will exist because of the differents action that will be
 * created. From this moment, I just can add an action of a macro to the button
 * because beanshell scripts and forms are not implemented yet. All the methods
 * of all the classes created I will test by functional tests and usind
 * debugging. As usual, in a test driven development approach tests normally
 * fail in the beginning. The idea is that the tests will pass in the end.
 * <br/>
 *
 * <h2>4. Design</h2>
 *
 * <h2>5. Coding</h2>
 *
 * <h2>6. Final Remarks</h2>
 * <br/>
 *
 */
package csheets.userstories.macros09_01.buttons_on_toolbar_i130371;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package!
 *
 * @author Cristina Lopes
 */
class _Dummy_ {
}
