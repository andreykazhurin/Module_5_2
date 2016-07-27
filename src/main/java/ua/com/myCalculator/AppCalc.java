package ua.com.myCalculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by andrii.kazhurin on 25.07.2016.
 */
public class AppCalc {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AppCalc appCalc = (AppCalc) applicationContext.getBean("appCalc");
        Calculator calculator = (Calculator) applicationContext.getBean("simpleCalc");
        ExpressionParser parser = (ExpressionParser) applicationContext.getBean("expressionParser");
        appCalc.execute(calculator, parser);

    }

    private void execute(Calculator calculator, ExpressionParser parser) {

        String res = "";
        try {
            res = calculator.calculate("2+3-4", parser);
        } catch (FailedExpression failedExpression) {
            failedExpression.printStackTrace();
        }
        System.out.println(res);
    }
}
