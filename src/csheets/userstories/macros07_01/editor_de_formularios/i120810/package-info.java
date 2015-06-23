/**
 * Technical documentation regarding the user story Macros07_01: Form Editor.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirements</h2>
 * There must be a window that allows " describe " / "draw " one form. Forms are
 * windows that allow data entry . The forms shall be simple. They must be made
 * of lines. In each line should be able to set two visual components .
 * Supported visual components are: button , edit box and static text box . In
 * the editing window form must be a "play" button to test the form. For now
 * only need support 1 form . The form is associated with a leaf. For it is no
 * longer necessary to persist the form. It should be possible to invoke the
 * "display" of a form in the formulas and macros in through a function
 * "adequate" to which is passed the name of the form. The form should have an
 * option to "close ". When you close the form the function that invoked it
 * ends.
 * <br/>
 * <br/>
 * <b>Use Case "Macros07_01: Form Editor":</b>The user can create a Form with
 * one or more line and in each line it will have two Components (Button, Edit
 * Box and Static Text Box), the user can preview the form he is creating by
 * clicking on "Preview".<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 *
 * Analyzing this in a coding way it necessary an ArrayList to store the
 * content of the selected column, to facilitate the treatment of the
 * information in this particular case sorting the column with the "sort()" and
 * "reverse()" methods provided by ArrayList.
 *
 * Macros07_01: Form Editor objective is to allow the user to create Forms using
 * a Editor.<br />
 * Analyzing this in a graphical way, it will be required to set an "Forms" Menu
 * on "Extensions" Menu to give the user the following options: "Create Form",
 * "Edit Form", "Display Form". The Editor Frame will have all the components
 * allowed to be used.
 * Now in coding its necessary to create an List of forms to
 * store all the forms created, each form will belong to one spreadsheet.
 *
 *
 * <br/>
 *
 * * <h2>a) First "Analysis" Sequence Diagram</h2>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).<br/>
 * <br/>
 *
 * <img src="doc-files/macros07_01_analysis.png">
 *
 * * <h2>3. Tests</h2>
 *  Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to create Forms using the Editor<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * It will not be necessary to make unitary tests since I worked with Graphical
 * components JSwing. 
 * In the end this use case requires only Functional Tests:
 * #Cannot create a form without "Lines"; 
 * #Each line must have exactly 2 Components and each components must have an name;

 * <br/>
 * see: <code>csheets.ext.FormEditorTests</code><br/>
 *
 * <h2>4. Design</h2>
 * 
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the MenuBar we need
 * to implement a JMenu. In the code of the extension
 * <code>csheets.ext.Form_Editor</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Form Editor" extension when
 * cleansheets is run.<br/><br/>
 * 
 * <br/>

 * <h2>5. Coding</h2>
 * see:<br/>
 * <h3>Created</h3>
 *
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author 1120810
 *
 */
package csheets.userstories.macros07_01.editor_de_formularios.i120810;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1120810
 *
 */
class macros07_01_FormEditor {
}
