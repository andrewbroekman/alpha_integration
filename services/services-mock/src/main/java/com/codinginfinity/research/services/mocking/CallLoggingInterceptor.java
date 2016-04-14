package com.codinginfinity.research.services.mocking;

import com.codinginfinity.research.services.Request;
import com.codinginfinity.research.services.Response;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.LocalDateTime;

/**
 * Created by andrew on 2016/04/11.
 */
@Interceptor
@Mocking
public class CallLoggingInterceptor {

    @AroundInvoke
    public Object logCall(InvocationContext invocationContext) throws Exception
    {
        System.out.println("Logging call");
        LocalDateTime requestTime = LocalDateTime.now();
        Request request = (Request)invocationContext.getParameters()[0];

        Object response;
        LocalDateTime responseTime;

        try
        {
            response = (Response) invocationContext.proceed();

            responseTime = LocalDateTime.now();

            ((Mock)invocationContext.getTarget()).getCallLogger().logCall(new CallDescriptor(invocationContext
                    .getMethod(), requestTime, request, response, responseTime));

            return response;
        }
        catch (Exception e)
        {
            responseTime = LocalDateTime.now();

            response = e;

            ((Mock)invocationContext.getTarget()).getCallLogger().logCall(new CallDescriptor(invocationContext
                    .getMethod(), requestTime, request, response, responseTime));

            throw e;
        }
    }
}
