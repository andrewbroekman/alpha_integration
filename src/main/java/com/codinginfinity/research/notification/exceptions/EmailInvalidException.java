package com.codinginfinity.research.notification.exceptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by Claudio on 2016/04/13.
 */
public class EmailInvalidException extends PreconditionViolation {

    public EmailInvalidException() {
    }

    public EmailInvalidException(String message) {
        super(message);
    }

    public EmailInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailInvalidException(Throwable cause) {
        super(cause);
    }

}
