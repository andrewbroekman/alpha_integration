package com.codinginfinity.research.people.exeptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by reinhardt on 2016/04/13.
 */
public class EmailAddressInUse extends PreconditionViolation{
    public EmailAddressInUse() {
    }

    public EmailAddressInUse(String message) {
        super(message);
    }

    public EmailAddressInUse(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailAddressInUse(Throwable cause) {
        super(cause);
    }
}
