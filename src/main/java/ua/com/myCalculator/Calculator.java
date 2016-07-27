package ua.com.myCalculator;

/**
 * Created by andrii.kazhurin on 14.07.2016.
 */
public interface Calculator {
    void setSupportOperations();
    String getStringSupportOperations();
    String calculate(String expression, ExpressionParser parser) throws FailedExpression;
}
