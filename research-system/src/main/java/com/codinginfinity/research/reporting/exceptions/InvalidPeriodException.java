package com.codinginfinity.research.reporting.exceptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by Rohan on 2016/04/13.
 */
public class InvalidPeriodException extends PreconditionViolation {
    public InvalidPeriodException() {
    }

    public InvalidPeriodException(String message) {
        super(message);
    }

    public InvalidPeriodException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPeriodException(Throwable cause) {
        super(cause);
    }
}