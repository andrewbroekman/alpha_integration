package com.codinginfinity.research.services.mocking;

import com.codinginfinity.research.services.Request;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * Created by andrew on 2016/04/11.
 */
@Aspect
public class CallLoggingAspect {

    @Around(value = "@within(com.codinginfinity.research.services.mocking.Mocking)" + "|| @annotation(com.codinginfinity.research.services.mocking" +
            ".Mocking)")
    public Object logCall(ProceedingJoinPoint joinPoint) throws Throwable
    {
        LocalDateTime requestTime = LocalDateTime.now();

        Method method = ((MethodSignature)joinPoint.getStaticPart().getSignature()).getMethod();
        Request request = null;
        try
        {
            request = (Request)joinPoint.getArgs()[0];
        }
        catch (Exception e){ /* Ignore all non-service requests, i.e. methods which do not receive a single service request */ }

        Object response;
        LocalDateTime responseTime;

        try
        {
            response = joinPoint.proceed();
            responseTime = LocalDateTime.now();

            if (request != null)
                ((Mock)joinPoint.getTarget()).getCallLogger().logCall(
                        new CallDescriptor(method, requestTime, request, response, responseTime));
            return response;
        }
        catch (Exception e)
        {
            responseTime = LocalDateTime.now();
            response = e;
            ((Mock)joinPoint.getTarget()).getCallLogger().logCall(
                    new CallDescriptor(method, requestTime, request, response, responseTime));
            throw e;
        }
    }

}
