package xenoteo.com.github.day18.part1;

import java.util.List;

/**
 * The homework consists of a series of expressions that consist of addition (+), multiplication (*), and
 * parentheses ((...)). Just like normal math, parentheses indicate that the expression inside must be evaluated before
 * it can be used by the surrounding expression. Addition still finds the sum of the numbers on both sides
 * of the operator, and multiplication still finds the product. However, the rules of operator precedence have changed.
 * Rather than evaluating multiplication before addition, the operators have the same precedence, and are evaluated
 * left-to-right regardless of the order in which they appear.
 *
 * Class finding a sum of evaluated expressions.
 */
public class Solution {

    /**
     * Evaluates all the expressions and find their sum.
     *
     * @param expressions  a list of expressions to evaluate
     * @return a sum of evaluated expressions
     */
    public long sumOfEvaluatedExpressions(List<String> expressions){
        long generalSum = 0;
        for (String expressionString : expressions){
            generalSum += evaluateExpression(new StringBuilder(expressionString));
        }
        return generalSum;
    }

    /**
     * Evaluates one expression.
     *
     * @param expression  an expression to evaluate
     * @return the value of evaluated expression
     */
    private long evaluateExpression(StringBuilder expression){
        while (expression.indexOf("(") != -1){
            int leftParen = leftIndexOfMostInnerParentheses(expression);
            int rightParen = rightIndexOfMostInnerParentheses(expression, leftParen);
            expression = updateExpressionEvaluatingOneParentheses(expression, leftParen, rightParen);
        }
        return evaluateExpressionWithoutParentheses(expression);
    }

    /**
     * Finds an index of the most inner or the most right opening paren of the expression.
     *
     * @param expression  an expression
     * @return an index of the most inner or the most right opening paren of the expression
     */
    private int leftIndexOfMostInnerParentheses(StringBuilder expression){
        int leftParen = -1;
        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) == '(')
                leftParen = i;
        }
        return leftParen;
    }

    /**
     * Finds an index of closing paren for given opening paren.
     *
     * @param expression  an expression
     * @param leftParen  an index of given opening paren
     * @return an index of closing paren for given opening paren
     */
    private int rightIndexOfMostInnerParentheses(StringBuilder expression, int leftParen){
        for (int i = leftParen; i < expression.length(); i++){
            if (expression.charAt(i) == ')')
                return i;
        }
        return -1;
    }

    /**
     * Evaluates expression in given parentheses and creates a new expression with newly evaluated part.
     *
     * @param expression  an expression
     * @param leftParen  an index of opening paren
     * @param rightParen  an index of closing paren
     * @return the updated expression
     */
    private StringBuilder updateExpressionEvaluatingOneParentheses(StringBuilder expression,
                                                                   int leftParen, int rightParen){
        StringBuilder newExpression = new StringBuilder();

        CharSequence leftPart = expression.subSequence(0, leftParen);
        newExpression.append(leftPart);

        StringBuilder expressionInParentheses = new StringBuilder(expression.subSequence(leftParen + 1, rightParen));
        long evaluatedParentheses = evaluateExpression(expressionInParentheses);
        newExpression.append(evaluatedParentheses);

        int expressionLength = expression.length();
        if (rightParen + 1 < expressionLength) {
            CharSequence rightPart = expression.subSequence(rightParen + 1, expressionLength);
            newExpression.append(rightPart);
        }

        return newExpression;
    }

    /**
     * Evaluates an expression without parentheses.
     *
     * @param expression  an expression to evaluate
     * @return the value of evaluated expression
     */
    private long evaluateExpressionWithoutParentheses(StringBuilder expression){
        int leftIndex = 0;
        long value = 0;
        char lastOperation = 0;

        for (int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == ' '){
                char previousChar = expression.charAt(i - 1);
                if (previousChar == '+' || previousChar == '*')
                    leftIndex = i + 1;
                else{
                    value = updateValue(value, expression, leftIndex, i, lastOperation);
                    leftIndex = i + 3;
                }
            }
            else if (c == '+' || c == '*'){
                lastOperation = c;
            }
        }
        value = updateValue(value, expression, leftIndex, expression.length(), lastOperation);

        return value;
    }

    /**
     * Updates current value based on the last number and the operation to perform on this number.
     *
     * @param value  the current value
     * @param expression  an expression
     * @param leftIndex  the first index of the number
     * @param rightIndex  the last index of the number (excluded)
     * @param lastOperation  the operation to perform on a number
     * @return updated value
     */
    private long updateValue(long value, StringBuilder expression, int leftIndex, int rightIndex, char lastOperation){
        int number = Integer.parseInt((String) expression.subSequence(leftIndex, rightIndex));
        if (lastOperation == 0)
            value = number;
        else {
            if (lastOperation == '+')
                value += number;
            else if (lastOperation == '*')
                value *= number;
        }
        return value;
    }
}
