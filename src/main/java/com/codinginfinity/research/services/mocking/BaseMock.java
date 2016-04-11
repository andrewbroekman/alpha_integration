package com.codinginfinity.research.services.mocking;

/**
 * Created by andrew on 2016/04/11.
 */
@Mocking
public class BaseMock implements Mock
{

    public BaseMock()
    {
        callLogger = new SimpleCallLogger(this);
    }

    @Override
    public CallLogger getCallLogger()
    {
        return callLogger;
    }

    public State getState()
    {
        return state;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    private CallLogger callLogger;
    private State state;

}
