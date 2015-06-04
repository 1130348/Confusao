/**
 * Technical documentation regarding the user story macros01.01: Instruction
 * Blocks.
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * Support cleansheets formulas. The user should be able to use instruction
 * blocks. The system identifies the blocks limits with the characters { and }.
 * Inside each block the instructions are separated by ;. The instructions are
 * executed sequentially from the left to the right being the result the value
 * of the last instruction. It also supports the attribution operation applying
 * the operator :=. The result is calculated at the right side of the operator
 * and it is saved to the left of the operator. Finally it applies the for
 * operator to an instruction block where the first instruction sets the first
 * value of the cycle, the second defines the end value while the others are
 * executed repeatedly until the cycle ends.
 *
 * <br/>
 * <br/>
 * <b>Use Case "Instruction Blocks":</b> The user writes the instructions inside
 * { and }. The multiple instructions inside the same block must be separated by
 * ;. When enter is pressed the result of the instructions block is saved in the
 * cell which executed the block.<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * To have full support to the instructions blocks we will need to study how the
 * ANTLR works as well as the lexer and parser. The nature of the instructions
 * must be well defined not only between the ones in the same block but in full
 * use of operators like the attribution and the for cycle.
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
 * <img src="doc-files/draft_macros_01_01.png"/>
 * <br/>
 * <br/>
 * From the previous diagram we see that we need to add new operators.<br/>
 * Therefore, at this point, we need to study how to add this new attribute to
 * the formula file and to the parser/lexer. This is the core technical problem
 * regarding this issue.<br/>
 * <h3>Analysis of Core Technical Problem</h3>
 * We can see a class diagram of the domain model of the application
 * <a href="../../../../overview-summary.html#modelo_de_dominio">here</a><br/>
 * From the domain model we see that there is a Cell interface. This defines the
 * interface of the cells. We also see that there is a class CellImpl that must
 * implement the Cell interface.<br/>
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
 * The File Formula has the data used to parse the expressions and validate
 * them. To add the support for the instruction blocks and operators we need to
 * edit with AntlWorks this file and add their behavior.
 *
 * <h2>3. Tests</h2>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to enable the use of instructions blocks
 * and of the operator attribution and for cycle. We need to be able in case of
 * having many instructions, applying them sequentially and store the proper
 * result. If it uses the attribution operator we must save the correct result
 * on the right, in the variable to the left of the operator. In case it is a
 * for cycle we must detect correctly the beginning of the cycle and its ending
 * condition. The instructions inside the cycle must be repeated not only
 * correctly but the correct number of times. Following this approach we can
 * start by coding a unit test that tests the creation of an instruction block
 * inside a cell. Another test must be made to validate the result of the
 * instruction block. As usual, in a test driven development approach tests
 * normally fail in the beginning. The idea is that the tests will pass in the
 * end.
 * <br/>
 * <br/>
 * see: <code>csheets.ext.comments.InstructionsBlockTest</code><br/>
 *
 * <h2>4. Design</h2>
 *
 * This User Story uses mostly intefaces and has the particularity of having 2
 * classes that are automatically generated by the respective intefaces, those
 * classes are FormulaLexer and FormulaParser and there are specific Java
 * classes (Lexer and Parser) that generated depending on the grammar
 * created.<br/>
 * For the creation of the Instruction Block we have to define it in the grammar
 * and then implement the behavior of said rule in the respective class.<br/>
 * The class ExpressionCompiler during runtime will identify and decide what
 * type of command is written and choose the correct behavior.<br/>
 * The following diagram illustrate the approach used in the design of the
 * solution for this use case.<br/>
 * <img src="doc-files/design_macros_01_01.png"/>
 * </br>
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "comments" extension when
 * cleansheets is run.<br/><br/>
 * <img src="doc-files/core02_01_design.png"/>
 * <br/>
 *
 * <h3>User Selects a Cell</h3>
 * The following diagram illustrates what happens when the user selects a cell.
 * The idea is that when this happens the extension must display in the sidebar
 * the comment of that cell (if it exists).<br/>
 * <br/>
 * <img src="doc-files/core02_01_design2.png"/>
 * <br/>
 * <h3>User Updates the Comment of a Cell</h3>
 * The following diagram illustrates what happens when the user updates the text
 * of the comment of the current cell. To be noticed that this diagram does not
 * depict the actual selection of a cell (that is illustrated in the previous
 * diagram).<br/>
 * <br/>
 * <img src="doc-files/core02_01_design3.png"/>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.comments</a><br/>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.comments.ui</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * As an extra this use case also implements a small cell visual decorator if
 * the cell has a comment. This "feature" is not documented in this page.<br/>
 * <br/>
 * <br/>
 *
 * @author i130395
 */
package csheets.userstories.macros01_01.blocks.i130395;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _InstructionBlock_ {
}
