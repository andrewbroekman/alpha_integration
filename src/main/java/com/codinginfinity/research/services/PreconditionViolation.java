package com.codinginfinity.research.services;

public abstract class PreconditionViolation extends Exception
{
	public PreconditionViolation(){}

    public PreconditionViolation(String message)
    {
        super(message);
    }

    public PreconditionViolation(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PreconditionViolation(Throwable cause)
    {
        super(cause);
    }

}