package com.saurabh.aop.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingAdvice.class);

    @Pointcut(value = "execution(* com.saurabh.aop.*.*.*(..) )")
    public void myPointcut() {
    }

    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
        // so that our logging retains real class name prefixes
        // final Logger log = LoggerFactory.getLogger(pjp.getTarget().getClass());

        final ObjectMapper mapper = new ObjectMapper();
        final String methodName = pjp.getSignature().getName();
        final String className = pjp.getTarget().getClass().toString();
        final Object[] array = pjp.getArgs();
        LOG.info("method invoked {}} : {}() arguments : {}",
                className,
                methodName,
                mapper.writeValueAsString(array));

        // since we are using a pointcut - this will run the method
        final Object response = pjp.proceed();

        LOG.info("{} : {}() Response : {}",
                className,
                methodName,
                mapper.writeValueAsString(response));

        return response;
    }
}
