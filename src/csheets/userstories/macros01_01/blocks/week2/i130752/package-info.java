/**
 * Technical documentation regarding the user story macros01.01: Instruction
 * Blocks - Week 2, Refactoring.
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
 * and it is saved to the left of the operator. Finally it applies the for cicle
 * operator to an instruction block where the first instruction sets the first
 * value of the cycle, the second defines the end value while the others are
 * executed repeatedly until the cycle mets its end value.
 *
 * <br/>
 * <br/>
 * <b>Use Case "Instruction Blocks":</b> The user writes the instructions inside
 * { and }. The multiple instructions inside the same block must be separated by
 * ;. When enter is pressed the result of the instructions block is saved in the
 * cell which executed the block. Inside of the instruction block we can insert
 * any type of instruction from functions, operations or cicles and
 * coditions.<br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * To implement the instructions blocks we need will need how to program given
 * to us works and how it is structured so we can navigate through the classes
 * at ease and we need also to study how the ANTLR works as well as the lexer
 * and parser. The nature of the instructions must be well defined not only
 * between the ones in the same block but in full use of operators like the
 * attribution and the for cycle.
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
 * <img src="doc-files/draft_macros_01_01.png"/>
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
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to enable the use of instructions blocks,
 * the operator attribution and for cycle. We need to be able in case of having
 * more than 2 instructions, applying them sequentially and store the proper
 * result. If it uses the attribution operator we must save the correct result
 * on the right, in the variable to the left of the operator. In the case of a
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
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 * <a href="../../../../csheets/core/formula/lang/package-summary.html">csheets.core.formula.lang</a><br/>
 * <br/>
 * <h2>6. Final Remarks</h2>
 * As an extra this use case to apply the new functions and operators needs them
 * to be written in the language.props file (n the src-resources package)<br/>
 * <br/>
 * <br/>
 *
 * @author i130752
 */
package csheets.userstories.macros01_01.blocks.week2.i130752;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author i130752
 */
class _InstructionBlock_ {
}
