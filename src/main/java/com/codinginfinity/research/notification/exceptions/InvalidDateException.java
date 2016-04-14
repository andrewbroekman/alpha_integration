package com.codinginfinity.research.notification.exceptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by Claudio on 2016/04/14.
 */
public class InvalidDateException extends PreconditionViolation{

    public InvalidDateException() {
    }

    public InvalidDateException(String message) {
        super(message);
    }

    public InvalidDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDateException(Throwable cause) {
        super(cause);
    }
}
