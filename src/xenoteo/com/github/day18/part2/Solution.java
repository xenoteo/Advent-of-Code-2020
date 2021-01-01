package xenoteo.com.github.day18.part2;

import java.util.List;

/**
 * The homework consists of a series of expressions that consist of addition (+), multiplication (*), and
 * parentheses ((...)). Just like normal math, parentheses indicate that the expression inside must be evaluated before
 * it can be used by the surrounding expression. Addition still finds the sum of the numbers on both sides
 * of the operator, and multiplication still finds the product. However, the rules of operator precedence have changed.
 * Rather than evaluating multiplication before addition, addition is evaluated before multiplication.
 *
 * Finding a sum of evaluated expressions.
 */
public class Solution {

    /**
     * Evaluates all the expressions and find their sum.
     * @param expressions a list of expressions to evaluate
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
     * @param expression an expression to evaluate
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
     * @param expression an expression
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
     * @param expression an expression
     * @param leftParen an index of given opening paren
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
     * @param expression an expression
     * @param leftParen an index of opening paren
     * @param rightParen an index of closing paren
     * @return updated expression
     */
    private StringBuilder updateExpressionEvaluatingOneParentheses(StringBuilder expression,
                                                                   int leftParen, int rightParen){
        StringBuilder newExpression = new StringBuilder();

        CharSequence leftPart = expression.subSequence(0, leftParen);
        newExpression.append(leftPart);

        StringBuilder expressionInParentheses = new StringBuilder(expression.subSequence(leftParen + 1, rightParen));
        long evaluatedParentheses = evaluateExpressionWithoutParentheses(expressionInParentheses);
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
     * @param expression an expression without parentheses
     * @return the value of evaluated expression
     */
    private long evaluateExpressionWithoutParentheses(StringBuilder expression){
        while (expression.indexOf("+") != -1){
            expression = updateExpressionEvaluatingOneSum(expression);
        }
        return evaluateExpressionWithoutParenthesesAndSums(expression);
    }

    /**
     * Evaluates the first sum and creates a new expression with newly evaluated part.
     * @param expression an expression
     * @return updated expression
     */
    private StringBuilder updateExpressionEvaluatingOneSum(StringBuilder expression){
        int sumIndex = expression.indexOf("+");
        int startIndex = startOfSum(expression, sumIndex);
        int endIndex = endOfSUm(expression, sumIndex);

        StringBuilder newExpression = new StringBuilder();
        newExpression.append(expression.subSequence(0, startIndex));
        newExpression.append(countSum(expression, startIndex, sumIndex, endIndex));
        newExpression.append(expression.subSequence(endIndex, expression.length()));
        return newExpression;
    }

    /**
     * Finds the start index of a sum subexpression.
     * @param expression an expression
     * @param sumIndex an index of plus sign
     * @return the start index of a sum expression
     */
    private int startOfSum(StringBuilder expression, int sumIndex){
        int start = 0;
        for (int i = 0; i < sumIndex; i++){
            if (expression.charAt(i) == ' ' && i != sumIndex - 1)
                start = i + 1;
        }
       return start;
    }

    /**
     * Finds the end index of a sum subexpression.
     * @param expression an expression
     * @param sumIndex an index of plus sign
     * @return the end index of a sum expression
     */
    private int endOfSUm(StringBuilder expression, int sumIndex){
        for (int i = sumIndex + 2; i < expression.length(); i++){
            if (expression.charAt(i) == ' ')
                return i;
        }
        return expression.length();
    }

    /**
     * Counts a sum subexpression that starts and ends at given indexes.
     * @param expression an expression
     * @param startIndex the start index of a sum expression
     * @param sumIndex an index of plus sign
     * @param endIndex the end index of a sum expression
     * @return evaluated sum
     */
    private int countSum(StringBuilder expression, int startIndex, int sumIndex, int endIndex){
        int leftNumber = Integer.parseInt((String) expression.subSequence(startIndex, sumIndex - 1));
        int rightNumber = Integer.parseInt((String) expression.subSequence(sumIndex + 2, endIndex));
        return leftNumber + rightNumber;
    }

    /**
     * Evaluates an expression containing only multiplications (without parentheses an sums).
     * @param expression an expression without parentheses an sums
     * @return evaluated expression
     */
    private long evaluateExpressionWithoutParenthesesAndSums(StringBuilder expression){
        long value = 1;
        int leftIndex = 0;
        for (int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == ' ' && expression.charAt(i - 1) != '*'){
                int number = Integer.parseInt((String) expression.subSequence(leftIndex, i));
                value *= number;
                leftIndex = i + 3;
            }
        }
        int number = Integer.parseInt((String) expression.subSequence(leftIndex, expression.length()));
        value *= number;
        return value;
    }
}
