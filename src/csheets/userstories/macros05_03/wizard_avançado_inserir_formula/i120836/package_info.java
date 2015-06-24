/**
 * Technical documentation regarding the user story macros05_3: Insert Wizard
 * Advanced Formula.
 * <br/>
 * <br/>
 * <h2>1. Requirements</h2>
 * Based on the previous use case, "macros05_01" and "macros05_02" it is now
 * needed that the wizard window should now contain an area Optional you must
 * submit a "tree" with the "structure " of the formula expression (type
 * Abstract Syntax Tree). Since this field is optional, should be a button (or
 * check box) to enable or disable this functionality (in itself Wizard window).
 * The syntax tree must be built on result of the compilation of the formula.
 * When you click a tree element of the respective text in the edit box should
 * appear highlighted.
 * <br/>
 * <br/>
 * <b>Use Case "Insert Wizard Advanced Formula":</b> When the user compile the
 * formula that he as insert, an (type of Abstract Syntax Tree) should be
 * generated and show.<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * The UC Macros05_3 objective is to gave the user the possibility to see an
 * (type of Abstract Syntax Tree). To reach this objective the wizard will have
 * an label to show the "tree", one button to make the tree appear in the label
 * and a checkbox, that will allow the user to disable or enable the label
 * containing the "tree".
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
 * <img src="doc-files/macros05_03_analysis.png">
 * <br/>
 * <br/>
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able show an (type of Abstract Syntax
 * Tree), from a result compilation of a formula.<br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.<br>
 * It will not be necessary to make unitary tests since I worked with Graphical
 * components JSwing. In the end this use case requires only Functional Tests:
 * #A tree should be generated if only have an result compilation of a formula;
 * #A tree should not appear if the formula have an error;
 *
 * <h2>4. Design</h2>
 * Base on the previous use cases, to realize this user story we will need to
 * create a subclass of Extension. We will also need to create a subclass of
 * UIExtension. In the code of the extension
 * <code>csheets.ext.call_function</code> we can find examples that illustrate
 * how to implement these technical requirements.<br/>
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.<br/>
 *
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Call Function" extension when
 * cleansheets is run.<br/><br/>
 * <img src="doc-files/marcos05_03_design1.png">
 * <br/>
 *
 * <h3>User "click" to show the Tree </h3>
 * The following diagram illustrates what happens when the user "click" to show
 * the generated tree from the inserted function. The idea is that when this
 * happens the extension must display a tree in the Jlabel, and have a button
 * that disable and enable this "extension".
 * <br/>
 * <br/>
 * <img src="doc-files/marcos05_03_design2.png">
 * <br/>
 * <br/>
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/call_function/package-summary.html">csheets.ext.call_function</a><br/>
 * <a href="../../../../csheets/ext/call_function/ui/package-summary.html">csheets.ext.call_function.ui</a><br/>
 * <br/>
 * <br/>
 * <br/>
 *
 * @author 1120836
 */
package csheets.userstories.macros05_03.wizard_avançado_inserir_formula.i120836;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1120836
 *
 */
class WizardAvançadoInserirFormula {
}
