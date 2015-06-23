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
 * we write =eval("2+3") in cell the result will be 5. And Implement the cycle
 * formulas: "DoWhile" and "WhileDo". The "DoWhile" must perform an
 * block/Expression and then test an expression that indicates whether to
 * continue or not. <br/>
 * The "WhileDo" should test an expression/block that indicates whether to
 * execute a second expression/block or not. Example: "={
 *
 * @Conta=1; WhileDo(EVAL("A"& @Conta)>0; { C1=C1+EVAL("B" & @Conta); @Conta :=
 * @Conta+1 }) }".<br/>
 * In this example, in cell C1 will be the sum of all values in column B while
 * the corresponding values in column A are greater than zero.
 *
 * <br/>
 * <br/>
 *
 * <h2>2. Analysis</h2>
 * In this use case we need to answer the following requirements: The user needs
 * to obtain the expression value; The cell must be verified for syntax errors
 * This use case is only activated when the cell text starts with =eval( It's
 * important to pay attention to the operator priority. In DoWhile and WhileDo
 * we need to alter a class ExcellExpressionCompiler to recognize whileDo and
 * Dowhile.
 *
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
 * To implement this improvement it will be needed to edit the proprieties file
 * that contains the functions to load. The function will only accept one text
 * parameter<br/>
 * The method applyTo will strip down the argument so it will parse the
 * mathematical expression and give the result. This function is already
 * implemented. DoWhile and WhileDo After the entered expression is evaluated it
 * will count the number of childs and send an Array with the arguments (the
 * condition and the actions to execute).
 *
 *
 * </br>
 *
 * <h2>5. Coding</h2>
 * see:
 * <a href="../../../csheets/core/formula/lang/package-summary.html">csheets.core.formula.lang</a><br/>
 * <a href="../../../csheets/core/formula/compiler/package-summary.html">csheets.core.formula.compiler</a><br/>
 *
 * <br/>
 *
 * <br/>
 * <br/>
 * <h2> 6. Functional Tests</h2>
 * </b><br/>
 * To test Function Eval in a cell write "=eval(A1+A1)" or "=eval("2+3") in the
 * cell selected the expected result should be 5 To test While in a cell write
 * for example "=WhileDo(A1=1; B1:=1+1)" in the cell B1 the expected result
 * should be 2 And to test de DoWhile in a cell write "=DoWhile(A1:=1+A1;A1=1)"
 * in the cell A1 the result expected should be 2.
 * <br/>
 * <br/>
 *
 *
 * /**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 */
class _macros01_3_Eval_DoWhile_WhileDo_ {
}
