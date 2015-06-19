/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.compiler;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.Variable;
import csheets.core.formula.BinaryOperation;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionCall;
import csheets.core.formula.Literal;
import csheets.core.formula.Reference;
import csheets.core.formula.UnaryOperation;
import csheets.core.formula.lang.CellReference;
import csheets.core.formula.lang.Dollar;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.RangeReference;
import csheets.core.formula.lang.ReferenceOperation;
import csheets.core.formula.lang.UnknownElementException;
import csheets.core.formula.lang.VariableReference;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

/**
 *
 * @author joaomonteiro
 */
public class MoneyExpressionCompiler implements ExpressionCompiler {

    /**
     * The character that signals that a cell's content is a formula ('=')
     */
    public static final char FORMULA_STARTER = '#';
    private static Literal leftOperand;

    public MoneyExpressionCompiler() {
    }

    @Override
    public char getStarter() {
        return FORMULA_STARTER;
    }

    @Override
    public Expression compile(Cell cell, String source) throws FormulaCompilationException {
        ANTLRStringStream input = new ANTLRStringStream(source);

        // create the buffer of tokens between the lexer and parser
        FormulaLexer lexer = new FormulaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        FormulaParser parser = new FormulaParser(tokens);

        CommonTree tree = null;

        try {
            tree = (CommonTree) parser.expression().getTree();
        } catch (RecognitionException e) {
            String message = parser.getErrorMessage(e, parser.tokenNames);
            throw new FormulaCompilationException("At (" + e.line + ";" + e.charPositionInLine + "): " + message);
        } catch (Exception e) {
            String message = "Other exception : " + e.getMessage();
            throw new FormulaCompilationException(message);
        }
      
        return convert(cell, tree);
    }

     /**
     * Converts the given ANTLR AST to an expression.
     *
     * @param node the abstract syntax tree node to convert
     * @return the result of the conversion
     */
    public Expression convert(Cell cell, Tree node) throws FormulaCompilationException {
        System.out.println("Converting node '" + node.getText() + "' of tree " + node.toStringTree());
        if (node.getChildCount() == 0) {
            try {
                switch (node.getType()) {
                    case FormulaLexer.NUMBER:
                        return new Literal(Value.parseNumericValue(node.
                                getText()));                      
                    case FormulaLexer.DOLLAR:
                        
                        Literal l = new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));
                        
                        return l;
                    case FormulaLexer.EURO:
                        return new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));
                    case FormulaLexer.POUND:
                        return new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));
                    case FormulaLexer.YEN:
                        return new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));
                    case FormulaLexer.WON:
                        return new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));
                    case FormulaLexer.RUPEE:
                        return new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));
                    case FormulaLexer.PLUS:
                        return new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));
                    case FormulaLexer.MINUS:
                        return new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));
                    case FormulaLexer.DIV:
                        return new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));                        
                    case FormulaLexer.MULTI:
                        return new Literal(Value.
                                parseValue(node.getText(), Value.Type.TEXT));
                        
                }
            } catch (ParseException e) {
                throw new FormulaCompilationException(e);
            }
        }

        // Convert function call
        Function function = null;
        try {
            function = Language.getInstance().getFunction(node.getText());
        } catch (UnknownElementException e) {
        }

        if (function != null) {
            List<Expression> args = new ArrayList<Expression>();
            Tree child = node.getChild(0);
            if (child != null) {
                for (int nChild = 0; nChild < node.getChildCount(); ++nChild) {
                    child = node.getChild(nChild);
                    args.add(convert(cell, child));
                }
            }
            Expression[] argArray = args.toArray(new Expression[args.size()]);
            return new FunctionCall(function, argArray);
        }

        if (node.getChildCount() == 1) // Convert unary operation
        {
            return new UnaryOperation(
                    Language.getInstance().getUnaryOperator(node.getText()),
                    convert(cell, node.getChild(0))
            );
        } else if (node.getChildCount() == 2) {
            // Convert binary operation
            BinaryOperator operator = Language.getInstance().
                    getBinaryOperator(node.getText());
            if (operator instanceof RangeReference) {
                return new ReferenceOperation(
                        (Reference) convert(cell, node.getChild(0)),
                        (RangeReference) operator,
                        (Reference) convert(cell, node.getChild(1))
                );
            } else {
                return new BinaryOperation(
                        convert(cell, node.getChild(0)),
                        operator,
                        convert(cell, node.getChild(1))
                );
            }
        } else // Shouldn't happen
        {
            throw new FormulaCompilationException();
        }
    }
}
