/**
 * Technical documentation regarding the user story macros03.03: Formulas Array.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * The user should be able to use functions, like MINVERSE(Matrix
 * Inverse) and MMULT(Matrix Product) that have as a result a array.
 *
 * <br/>
 * <br/>
 * <b>Use Case "Formulas Array":</b>
 * A formula deve ser escrita na celula do canto superior esquerdo.
 * O resultado da formula aplica-se a um range que inicia 
 * canto superior esquerdo. O caractere inicial da 
 * formula e o '{'.
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * To solve this use case will be necessary to understand how is done the
 * recognition of functions and how they are treated by ANTLR and also realize
 * the cells distribution.
 * <br/>
 * <br/>
 * After analyzing the documentation made in use case Macros:03_02: Advance Functions,
 * we think there is no need to add more information to the
 * analysis diagram, so the next reflections on possible solutions to problems
 * will be based on the diagram mentioned above.<br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * The previous iteration already created the MINVERSE and MMULT classes that extend the
 * class Function, according to our iteration layout, and so the program will recognize these functions. 
 * After that, we need to edit the grammar file that has all the different
 * possibilities of what can be used in the application, in a way that we can 
 * identify the array formula, starting with a '{' and not a '='.
 *
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to ensure that mathematical calculations
 * are correct. Many of the testsnare already done by previous developers in Macros02.1 
 * and Macros02.2. As usual, in a test driven development approach tests normally fail 
 * in the beginning. The idea is that the tests will pass in the end.
 * <br/>
 * <br/>
 * see:
 * <code>csheets.userstories.csheets.advanced_functions.AdvancedFunctionsTest</code><br/>
 * <code>csheets.userstories.macros03_01.baseOperators.i130386.BaseOperators</code><br/>
 *
 * <h2>4. Design</h2>
 * It's pretty the same as Macros03.2 in the cell's action,
 * when the user enter the cell content it activates the method actionPerformed
 * of Class CellEditor.<br/>
 * For the development of the expression we have to define it in the
 * grammar because it's now beggining with '{' instead of '='.<br/>
 * The class ExpressionCompiler during runtime will identify and decide what
 * type of command is written and choose the correct behavior.<br/>
 * The interface Function will decide wich function will apply, in this use case
 * will use the class Minverse and Mmult. The following diagram illustrate the
 * approach used in the design of the solution for this use case.<br/>
 * <img src="doc-files/sequence_diagram.png"/>
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/core/formula/lang/package-summary.html">csheets.core.formula.lang</a><br/>
 * <br/>
 * <br/>
 *
 * @author 1130348
 */
package csheets.userstories.macros03_03.formulas_array.i130348;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 *
 * @author Egidio Santos
 */
class _Dummy_ {
}
