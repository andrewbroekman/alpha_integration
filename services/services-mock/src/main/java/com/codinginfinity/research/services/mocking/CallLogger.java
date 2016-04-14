package com.codinginfinity.research.services.mocking;

import com.codinginfinity.research.services.utilities.ServiceUtilities;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public interface CallLogger {

    void logCall(CallDescriptor callDescriptor);

    List<CallDescriptor> getCallLog();

    int getInvocationCount(Method method);

    int getInvocationCount(String serviceName) throws ServiceUtilities.NotAServiceException;

    void clearLog();

    BaseMock getMockObject();
}
