/**
 * Technical documentation regarding the user story macros01.01: Instruction
 * Blocks - Week 2, Refactoring.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Support CleanSheet formulas. The user should be able to use specifific formulas
 * to add, subtract, multiply and divide two currencies. The user should be able to
 * specifie the currency of the result. The formula should have this format: #euro{10,25€ + 11,70$}
 *
 * <br/>
 * <br/>
 * <b>Use Case "Linguagem monetária":</b> The user writes a formula in a celected cell.
 * The formula should have the following format: #result_currency{amount1+currency1 ,amount2+curency2}.
 * The system should be able to parse the formula, convert to the currency that was provided has the 
 * result currency and show the result in the cell
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * To implement this functionality its important to understand the previous use case (Intruction Block).
 * Many of the knoledge required to implement this functionlaity correctly is represented in that use case.
 * Since we need to implement a new kind of formula structure, the current grammar will be edited to support
 * the new structure and a new compiller will be created to support the new prefix of the formula (#).
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" sequence
 * diagram because it functions like a draft that we can do during analysis or
 * early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created). It serves as the guidelines for the design.<br/>
 * <br/>
 * <img src="doc-files/draft_macros_01_02.png"/>
 * <br/>
 * <br/>
 * From the previous diagram we see that we need to add new operators.<br/>
 * Therefore, at this point, we need to study how to add this new attribute to
 * the formula file and to the parser/lexer. This is the core technical problem
 * regarding this issue.<br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * We see that are many classes that are predefined for Java itself and others
 * like CellImpl that implement a already given interface and following that
 * model we can't edit this classes so we have to adapt to this implementation
 * given.<br/>
 * On a closer analysis we see that the class Cell is the one that calls and
 * makes user of the functions of Parser and Lexer through various methods.<br/>
 * If we open the {@link csheets.core.Cell} code we see that the interface is
 * defined as:
 * <br/>
 * <code>public interface Cell extends Comparable &lt;Cell&gt;, Extensible&lt;Cell&gt;, Serializable</code>.
 * <br/>
 * Because of the <code>Extensible</code> it seams that a cell can be
 * extended.<br/>
 * If we further investigate we can see the Cell has support for Formulas.
 * *<br/>
 * <code> public void setContent(String content) throws FormulaCompilationException;</code>
 * <br/>
 * The class FormulaCompiler will attempt to create a formula from a string. The
 * setContent method will validate the formula throwing an exception if it
 * detects an error. The formula class implements the expression interface which
 * is responsible for parsing the expression and as such validating it. The
 * Expressions in the present moment are represented as abstract syntax trees
 * and can hold literals, references, operations (unary and binary and function
 * calls.
 * <br/>
 * <br/>
 * <code>public Object accept(ExpressionVisitor visitor);</code>
 * <br/>
 * <br/>
 * Like the do cycle, the for cycle must be an implementation of the function
 * interface. As such, the class will define its behavior in the applyTo Method.
 *
 * The attribution operator will work similarly like the already implemented
 * operators. In this case it must give prioriy to possible operations that
 * occur in its right side and only then assimilate the final value to the
 * variable in the left side of the ':=' operator.
 *
 * The File Formula.g has the data used to parse the expressions and validate
 * them. To add the support for the instruction blocks and operators we need to
 * edit with AntlWorks this file and add their behavior.
 *
 * <h2>3. Tests</h2>
 * From our analysis, we can see that many tests from the previous use case are also needed
 * in this use case. In addiction to that already implemented tests we need to modify some
 * of them to match the new requirements, like the new grammar and the new compiler.
 * <br/>
 *
 * <h2>4. Design</h2>
 *
 * This Functionality is very similar to the already implement use case "Blocks".
 * The main diference is that we need to work with money and currencies instead of simple 
 * numbers.<br/>
 * For that we need to change the grammar to be able to parse the currency simbols and
 * the new formula structure. <br/>
 * To accomplish this use case goal we need to create a new expression compiler that will be able
 * to process the new formulas and deal with the currency exchanges that are needed to present the
 * result in the choosen currency.<br/>
 * We also need to create a mechanism to read a csv file that contains the currency exchanges to use
 * in the conversions of the compiler.
 * The following diagram illustrate the file read mechanism to this use case<br/>
 * <img src="doc-files/sequence_diagram_macros_01_02_chooseFile.png"/>
 * </br>
 * The following diagram illustrate the formula parsing process
 * <img src="doc-files/design_macros_01_01.png"/>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/core/formula/lang/package-summary.html">csheets.core.formula.lang</a><br/>
 * <br/>
 * <br/>
 *
 * @author João Monteiro <1130372@isep.ipp.pt>
 */
package csheets.userstories.macros01_02.monetary_language.i130372;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * João Monteiro <1130372@isep.ipp.pt>
 */
class _InstructionBlock_ {
}
