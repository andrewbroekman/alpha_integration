package com.codinginfinity.research.services.mocking;

import com.codinginfinity.research.services.utilities.MethodOverrideChecker;
import com.codinginfinity.research.services.utilities.MethodOverrideCheckerBean;
import com.codinginfinity.research.services.utilities.ServiceUtilities;
import com.codinginfinity.research.services.utilities.ServiceUtilitiesBean;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class SimpleCallLogger implements CallLogger{

    private BaseMock mock;
    private ServiceUtilities serviceUtilities = new ServiceUtilitiesBean();
    private MethodOverrideChecker methodOverrideChecker = new MethodOverrideCheckerBean();
    private List<CallDescriptor> callLog = new LinkedList<>();

    public SimpleCallLogger(BaseMock mock)
    {
        this.mock = mock;
    }

    @Override
    public void logCall(CallDescriptor callDescriptor)
    {
        callLog.add(callDescriptor);
    }

    @Override
    public List<CallDescriptor> getCallLog() { return callLog; }

    @Override
    public int getInvocationCount(Method method)
    {
        int numCalls = 0;
        for (CallDescriptor callDescriptor : callLog)
        {
            if (methodOverrideChecker.overrides(method, callDescriptor.getMethod()))
                numCalls++;
        }
        return numCalls;
    }

    @Override
    public BaseMock getMockObject() { return mock; }

    @Override
    public int getInvocationCount(String serviceName) throws ServiceUtilities.NotAServiceException
    {
        Method method = serviceUtilities.getService(mock, serviceName);
        return getInvocationCount(method);
    }

    @Override
    public void clearLog() { callLog.clear(); }


}
