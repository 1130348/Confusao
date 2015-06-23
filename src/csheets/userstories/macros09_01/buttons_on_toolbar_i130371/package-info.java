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
 * The user will need to add a button that will appear on the toolbar. From this
 * moment, the ideia is to make an option on the menu with the name "add
 * button". When the user clicks on that option will open a new window that
 * allows the user to add a button. On the top of the window has the list of
 * action buttons already created. The user just need to insert the name of the
 * button (represented by a number), the tooltip, the icon and the
 * action.<br/><br/>
 * Let's see the ssd for the adding option. Like I said, the user select the
 * option on menu and the clicks on "Add Button". Then, will open a new window
 * in order to the user select the number, tooltip, the icon and the action that
 * is associated to that button.
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_ssd_add.png"/>
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_analysis_sequence.png"/>
 * <br/><br/>
 * To edit if the button is active or not I will need to create two function one
 * ATIVE_BUTTON and DISACTIVE_BUTTON passing by parameter the name of the
 * button. This is just an idea but it is the possibility how this will be
 * implemented. The main problem is the class that implements Function don't
 * have a method or the class UIController to get the components of the toolbar.
 * And because of that, I can't disable the button or activate. But this is a
 * problem that I want to resolve.<br/>
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
 * Basically, from requirements and also analysis, we see that the MACRO
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
 * When the cleansheets project open will be a button that allows the user to
 * create action buttons. When the user clicks on the button a new window will
 * be open and asks the user to fill all the information: the number of the
 * button (represents the name), the tooltip that wants to see when pass by the
 * button with the mouse and the action that is assigned. The action that is on
 * the button just can be a Macro because at this point scripts beanshell and
 * forms are not available and not implemented.<br/>
 * A sequence diagram shows object interactions arranged in time sequence. It
 * depicts the objects and classes involved in the scenario and the sequence of
 * messages exchanged betwween the objets needed to carry out the functionality
 * of the scenario.<br/>
 * Let's now see the sequence diagram at this point of the documentation of this
 * use case.
 * <br/><br/>
 * <img src = "doc-files/macros_09_01_design_sequence.png"/>
 * <br/><br/>
 * The other part of this use case is to create functions on macros and
 * beansheel (at this point of the implementation just the macros exists so the
 * button just can have assigned a macro). The idea is to create two classes
 * that implements Function and when the user selects the function
 * ACTIVATE_BUTTON(name) the button with the chosen name stays active and if the
 * function is DISACTIVATE_BUTTON(name) the button will have the action
 * associated but nothing will be done when clicking.
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
