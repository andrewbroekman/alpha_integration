package com.codinginfinity.research.services;

public class RequestNotValidException extends PreconditionViolation
{

    public RequestNotValidException(){}

    public RequestNotValidException(String message)
    {
        super(message);
    }

    public RequestNotValidException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public RequestNotValidException(Throwable cause)
    {
        super(cause);
    }

}