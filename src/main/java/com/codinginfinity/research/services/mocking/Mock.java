package com.codinginfinity.research.services.mocking;

/**
 * Created by andrew on 2016/04/11.
 */
@Mocking
public interface Mock {

    CallLogger getCallLogger();

    void setState(State state) throws InvalidStateException;

    State getState();

    interface State{}

    class InvalidStateException extends Exception{}
}
