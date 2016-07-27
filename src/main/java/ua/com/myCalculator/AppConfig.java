package ua.com.myCalculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * Created by andrii.kazhurin on 27.07.2016.
 */
@Configuration
@EnableAspectJAutoProxy
@Import(LogAspect.class)
public class AppConfig {

    @Bean
    public AppCalc appCalc() {
        AppCalc appCalc = new AppCalc();
        return appCalc;
    }

    @Bean
    public Calculator simpleCalc(){
        return new SimpleCalc();
    }

    @Bean
    public ExpressionParser expressionParser(){
        return new ExpressionParser(simpleCalc());
    }


}
