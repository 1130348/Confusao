/**
 * Technical documentation regarding the user story macros05.01: Call Function.
 * <br/>
 * <br/>
 *
 *
 * <h2>1. Requirement</h2>
 * Basic Wizard capable of call functions. The main window should allow
 * selecting a function from a list of functions. This list will be filled based
 * on the properties file where the functions are defined. After selecting the
 * function, is presented in an editable text box, the function's call, allowing
 * you to add the values that will be passed as parameter. It should also
 * provide two buttons, the run button, which execute the function defined in
 * the text box, and the help button, which describes its function.
 *
 * <br/>
 * <br/>
 * <b>Use Case "Call Function":</b> The user selects a function from a list of
 * functions. The System show, on the editable text box, the function's call.
 * The user enter the values required and click the button run. The System
 * execute the function and adds it to the formulas bar<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * To fully understand the concept of function call we need to learn how the
 * system read functions from the properties file and how it execute them. Then
 * we need to design the main window where the data will be presented (buttons,
 * text boxes, selection boxes, frames). After done the user interface, its time
 * to fill the list box with the functions names.
 * <br/>
 * <br/>
 * <img src="WizardBasico.png"/>
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).<br/>
 * <br/>
 * <img src="doc-files/draft_macros_05_01.png"/>
 * <br/>
 * <br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * In a deeper analysis, we found that the functions list is saved in the Class Language,
 * and we must call method "getFunctions" to get all the different functions in the system.<br/>
 * <br/>
 * <code>public Function[] getFunctions()</code>.
 * <br/>
 * <br/>
 * After that, it's possible to fill the selection list on the User Interface.<br/>
 * <br/>
 * <br/>
 * Then, after selected a function from the list, the system must get the 
 * function call definition (ex: sum(Number)) and fill the editable text box with it, so the user
 * can enter the parameter values.
 * The System, after user confirmation, executes the selected function with the parameter values 
 * and adds it to the formulas bar in the wizard.
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we identify some tests. We need to test if the list
 * that will be used to fill the selection list on User Interface is not empty, need to test too if the
 * the function call definition, that appears in the editable text box, represents the selected
 * function. Finally we must test if the system executes the chosen function with the parameter values
 * entered by the user.
 * As usual, in a test driven development approach tests
 * normally fail in the beginning. The idea is that the tests will pass in the
 * end.
 * <br/>
 * <br/>
 *
 * <h2>4. Design</h2>
 *
 * This User Story uses more classes than the classes identified in the Analysis. The new 
 * identified classes are FunctionCall, FunctionCaller and Function. The FunctionCaller receives the
 * input made in the editable text box and divides it into function identifier and arguments, then it 
 * creates an new instance of FunctionCall and sends to it the function and the arguments,
 * and finally it can call the given function with the parameter values.<br/>
 * After executing the function the generated value is returned to the FunctionCaller.<br/>
 * <img src="doc-files/design_macros_05_01.png"/>
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a
 * href="../../../../csheets/core/formula/lang/package-summary.html">csheets.core.formula.lang</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * As an extra this use case to apply the new functions and operators needs them
 * to be written in the language.props file (n the src-resources package)<br/>
 * <br/>
 * <br/>
 *
 * @author i130346
 */
package csheets.userstories.macros05_01.call_function.i130346;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _CallFunction_ {
}
