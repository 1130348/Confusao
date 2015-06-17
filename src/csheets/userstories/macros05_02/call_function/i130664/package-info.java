/**
 * Technical documentation regarding the user story macros05.02: Call Function.
 * <br/>
 * <br/>
 *
 *
 * <h2>1. Requirement</h2>
 * Based on the previous use case, "macros05_01" it is now needed to display
 * entry fields for each parameter of the function. As we fill in the fields
 * it is necessary to see the "possible" result in the window. While not filled
 * out all parameters, or some parameters are filled with wrong data, must be 
 * visible a text message informing what is wrong or incomplete. The list of 
 * functions should now also include the operators as well as the functions that
 * are dynamically loaded of java.lang.Math. The option to launch the wizard 
 * should now be an option of cleansheets base menus as well as a button 
 * that appears in the formula bar between the identification of the cell and 
 * the edit box where you enter a formula or value to assign to the cell.
 * <br/>
 * <br/>
 * <b>Use Case "Call Function":</b> Based on the <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * This use case I think it is better to split it in two parts.
 * The first part, since the window to call functions is already done, I just 
 * need to add some specific changes to that. On the first part, I need also 
 * to understand how the values of the edit box are assigned to the cell, so I 
 * can introduce the new button that will do the same as the edit box, but in 
 * this case, the result will be stored in the selected cell.
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * This diagram is exactly the same as the previous use case, since the changes
 * are not really significative.<br/>
 * <br/>
 * <img src="doc-files/draft_macros_05_02.png"/>
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
 * function call definition (ex: sum(Number)). Then it should appear the text boxes
 * as the number of parameters of the function. The user enters all the parameters
 * needed and then, the system, executes the selected function with the parameter values 
 * and adds it to the formulas bar in the wizard. 
 * If the user selects the button between the edit box and the cell identifier,
 * is supposed to show the same window, with the only difference being that, the 
 * result of the function, is supposed to be placed on the identified cell, instead
 * of the formulas bar.
 *
 * <h2>3. Tests</h2>
 * I just need to test the second part of the use case since the previous use case
 * already has significant tests. 
 * The test that I need to do is if the button that I'll add to the application, 
 * is storing the right result on the right cell.
 * <br/>
 * <br/>
 *
 * <h2>4. Design</h2>
 *
 * In the first part of this case use, as the changes relating to the prior use case 
 * are just graphic level and system changes, so the sequence diagram won't suffer 
 * any changes.
 * <br/>
 * <img src="doc-files/design_macros_05_02.png"/>
 * </br>
 * On the second part of this use case, I need to create a button that will set a content 
 * in a cell selected previously, since the change is very small to use case, i just need 
 * get the cell selected an then set the content. Since the changes are really small, 
 * I don't think it is necessary to do a new diagram.
 * 
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a
 * href="../../../../csheets/core/formula/lang/package-summary.html">csheets.core.formula.lang</a><br/>
 * <br/>
 *
 * @author i130664
 */
package csheets.userstories.macros05_02.call_function.i130664;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Carlos Silva (1130664)
 */
class _Dummy_ {
}
