/**
 * Technical documentation regarding the user story macros02.01: Variable
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Support workbook's variables. The user should be able to use variable. The
 * system identifies the variables by its name which are initialized or called
 * with the start of the @ symbol. The variables can only be created in the
 * formula context. The variables must be persistent (must be saved within the
 * file). The variables must save any type of value.
 *
 * <br/>
 * <br/>
 * <b>Use Case "Workbok's variables":</b> The user writes the varible starting
 * with the @ symbol. Everything to the right of the symbol must be saved in the
 * variable until the end is found or a symbol indicating the end of the
 * variable. The system return an error if the variable doesn't exist (it must
 * created if called inside a formula). The variables are shared between
 * spreedsheets inside the same workbook.
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * To have full support to the variables we will need to study how the ANTLR
 * works as well as the lexer and parser. The variables must be persistent and
 * save any type of value.
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
 * <img src="doc-files/draft_macros_02_01.png"/>
 * <br/>
 * <br/>
 * From the previous diagram we see that we need to add a list of variables to
 * the workbook. The variables saves the value. If there ins't a variable the
 * workbook will create a new one.<br/>
 * Therefore, at this point, we need to study how to add the new concept to the
 * formula file and to the parser/lexer. This is the core technical problem
 * regarding this issue.<br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * We can see a class diagram of the domain model of the application
 * <a href="../../../../overview-summary.html#modelo_de_dominio">here</a><br/>
 * From the domain model we see that there is a Variable class. The workbook
 * saves a list of variables which saves a value and a name (that must be
 * distinct). <br/>
 * If we open the {@link csheets.Formula.Formula} code we see that if the
 * variable doesn't exist, the workbook will create a new one (the cell only
 * tries to read.
 * <br/>
 * <code> public void setContent(String content) throws FormulaCompilationException;</code>
 * <br/>
 * <br/>
 * <code>public Object accept(ExpressionVisitor visitor);</code>
 * <br/>
 * <br/>
 *
 * The File Formula has the data used to parse the expressions and validate
 * them. To add the support for the variables we need to edit the Antlr file and
 * add the variable behavior.
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to enable the use variables. If the
 * variable is called inside a cell this must return a value or call an error
 * because the variable that was called doesn't exist. In a formula context, the
 * variable can be changed or created. The variables must be persisent and exist
 * inside the same workbook. The variable must be able to save any type of
 * value.
 * <br/>
 * Following this approach we can start by coding a unit test that tests the
 * creation of variables inside a cell and inside a formula. Another test must
 * be made to validate the result of the variable. The variables must be acessed
 * from different spreedsheets in the same workbook.
 * <br/>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.
 * <br/>
 * <br/>
 * see: <code>csheets.userstories.macros02_01.blocks</code><br/>
 *
 * <h2>4. Design</h2>
 *
 * This User Story uses mostly intefaces and has the particularity of having 2
 * classes that are automatically generated by the respective intefaces, those
 * classes are FormulaLexer and FormulaParser and there are specific Java
 * classes (Lexer and Parser) that generated depending on the grammar
 * created.<br/>
 * For the creation of the variable we have to define it in the grammar.
 * <br/>
 * The class ExpressionCompiler during runtime will identify and decide what
 * type of command is written and choose the correct behavior.<br/>
 * The following diagram illustrate the approach used in the design of the
 * solution for this use case.<br/>
 * <img src="doc-files/design_macros_02_01.png"/>
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/core/formula/lang/package-summary.html">csheets.core.formula.lang</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * Once a variable is created it won't be deleted from the list.
 *
 * <br/>
 * <br/>
 * <br/>
 *
 * @author i130395
 */
package csheets.userstories.macros02_01.variables.i130395;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author 1130395
 */
class _Variable_ {
}
