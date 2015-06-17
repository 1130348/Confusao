package csheets.userstories.macros01_3.Eval_DoWhile_WhileDo;

/**
 * Technical documentation regarding the user story macros01.03: Eval DoWhile
 * and WhileDo
 * <br/>
 * <br/>
 *
 * <h2>1. Requirement</h2>
 * This function only receive one parameter. This function is to compile the
 * given parameter("string") and execute the required expression. The result of
 * the eval function is the compiled expression. Example if we write the
 * following formula-> =2+3 the result shown in the cell will be 2+3. However if
 * we write =eval("2+3") in cell the result will be 5.
 * And Implement
 * the cycle formulas: "DoWhile" and "WhileDo". The "DoWhile" must perform an
 * expression/block and then test an expression that indicates whether to
 * continue or not. <br/>
 * The "WhileDo" should test an expression/block that indicates whether to
 * execute a second expression/block or not. Example: "={@Conta=1; WhileDo(EVAL("A"& @Conta)>0; { C1=C1+EVAL("B" & @Conta); @Conta :=
 * @Conta+1 }) }".<br/>
 * In this example, in cell C1 will be the sum of all values in column B while
 * the corresponding values in column A are greater than zero.
 *
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * In this enhancement we need to answer the following requirements: The user
 * needs to obtain the expression value; The cell must be verified for syntax
 * errors This enhancement is only activated when the cell text starts with
 * =eval( It's important to pay attention to the operator priority
 * The grammar should be edited, in order to recognize the functions 
 * to be created (WhileDo and DoWhile).
 * 
 * <br/>
 * <br/>
 * <h3>First "analysis" sequence diagram</h3>
 * <br/>
 * <br/>
 *
 * <br/>
 * <br/>
 *
 *
 * <h2>3. Tests</h2>
 *
 * <br/>
 * <br/>
 *
 * <h2>4. Design</h2>
 *
 *
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:<br/>
 *
 * <br/>
 * <br/>
 *
 *
 *
 * /**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 */
class _macros01_3_EvalDoWhile_WhileDo_ {
}
