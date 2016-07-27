package ua.com.myCalculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.*;
import org.springframework.stereotype.Component;

/**
 * Created by andrii.kazhurin on 26.07.2016.
 */

@Aspect
@Component
public class LogAspect {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(ua.com.myCalculator.*)")
    public void allMethodsPointcut(){}

    @Around("allMethodsPointcut()")
    public Object onExecute(ProceedingJoinPoint joinPoint) throws Throwable{


        Object retVal = joinPoint.proceed();

        StringBuffer logMessage = new StringBuffer();
        logMessage.append(joinPoint.getTarget().getClass().getName());
        logMessage.append(".");
        logMessage.append(joinPoint.getSignature().getName());
        logMessage.append("(");
        // append args
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            logMessage.append(args[i]).append(",");
        }
        if (args.length > 0) {
            logMessage.deleteCharAt(logMessage.length() - 1);
        }
        logMessage.append(")");

        log.info(logMessage.toString());

        return retVal;
    }



}
