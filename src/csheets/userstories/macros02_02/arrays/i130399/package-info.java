/**
 * Technical documentation regarding the user story macros02.01: Variable
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * It should be added a support for the array variables. Any variable can be an
 * array. When accessing the variable only by name are accessing content from
 * position 1 of the array. To access a position of the array must explicitly
 * use your index in square brackets. For example, the formula "= @ abc [2]: =
 * 123" will place the value 123 in the second position of abc array. Each
 * position of the array may have a different data type. For example, we have in
 * the same array numeric and alphanumeric values.
 * <br/>
 * <br/>
 * <b>Use Case "Workbok's Arrays":</b> The user begins by introducing a variable
 * in a cell that begins with the @ symbol. Then defines a set of characters
 * that will be the array name and in brackets the size of this. The arrays are
 * shared by all spreadsheets open in the same workbook. Everything the user
 * defines in the right of the array is stored within it. The array may have
 * different types of data in different positions. Finally if the user inserted
 * array that already exists in the system an error message is returned.
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * In order to support the arrays a study of ANTLR will be necessary, once there
 * is the defined grammar that describes how the variables works, and these can
 * later be arrays. Arrays must be persistent in the system and the values for
 * each position of the array have to be saved.
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
 * <img src="doc-files/draft_macros_02_02.png"/>
 * <br/>
 * <br/>
 * From the previous diagram we can see that we need to add a list of arrays
 * that will contain arrays to the workbook. The arrays saves the value of each
 * position. If the array does not exist it will be created, else it will change
 * the values of the array.<br/>
 * At this point, will be needed to change the concept of variable in formula
 * file and in the parser/lexer so that these accept the definition of arrays.
 * This is the core technical problem regarding this issue.<br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * As we can see in domain model of the application
 * <a href="../../../../overview-summary.html#modelo_de_dominio">here</a><br/>
 * From the domain model we can see that there is a Variable class. We will need
 * an Array class that will extends the variable, so that can be a support of
 * variables. The workbook has a list of arrays which saves the values of each
 * and a name of the array. <br/>
 * In {@link csheets.Formula.Formula} code we see that if the variable doesn't
 * exist, the workbook will create a new one.
 * <br/>
 * <code> public void setContent(String content) throws FormulaCompilationException;</code>
 * <br/>
 * <br/>
 * <code>public Object accept(ExpressionVisitor visitor);</code>
 * <br/>
 * <br/>
 *
 * The formula file has the data used to parse the expressions and validate
 * them. To add the support for the variables array we need to edit the formula
 * file and add the array behavior.
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to enable the use arrays. If the array is
 * called inside a cell fill the the cell with the value of position called or
 * generate an error if the array doens't exist. In a formula context, the array
 * positions can be changed. The arrays must be persisent and can be used inside
 * the same workbook for other spreadsheets. Different positions of the array
 * must be able to save numeric values and alphanumeric values. When the array
 * is called only by the name it should fill the cell with the value of the
 * first position.
 * <br/>
 * Following this approach we can start by coding a unit test that tests the
 * creation of arrays inside a cell and inside a formula. Another test to
 * validate the result of the variable. And another test to verify if when
 * access a array by the name it returns the value of the first positon of the
 * array.
 * <br/>
 * <br/>
 * see: <code>csheets.userstories.macros02_02.arrays</code><br/>
 *
 * <h2>4. Design</h2>
 *
 * There are two classes that generates the grammar automatically, FormulaLexer
 * and FormulaParser having regard to the grammar formula. The class
 * ExcelExpressionCompiler will indentify tokens typed and choose the correct
 * behaviour, has regarding the options in the grammar. After the compiler
 * recognizes an array it will add it to workbook and create an ArrayReference
 * that will have all the values of the array that will be needed when the user
 * does a attribution to an array position.<br/>
 * For the creation of the array it's necessary to change the grammar and add
 * array behaviour.
 * <br/>
 * The following diagram illustrate the approach used in the design of the
 * solution for this use case.<br/>
 * <img src="doc-files/design_macros_02_02.png"/>
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/core/formula/lang/package-summary.html">csheets.core.formula.lang</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 *
 *
 * <br/>
 * <br/>
 * <br/>
 *
 * @author Sergio Gomes <1130399@isep.ipp.pt>
 */
package csheets.userstories.macros02_02.arrays.i130399;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Sergio Gomes
 */
class _Arrays_ {
}
