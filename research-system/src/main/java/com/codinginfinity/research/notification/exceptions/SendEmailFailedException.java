package com.codinginfinity.research.notification.exceptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by Claudio on 2016/04/13.
 */
public class SendEmailFailedException extends PreconditionViolation {

    public SendEmailFailedException() {
    }

    public SendEmailFailedException(String message) {
        super(message);
    }

    public SendEmailFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SendEmailFailedException(Throwable cause) {
        super(cause);
    }

}
