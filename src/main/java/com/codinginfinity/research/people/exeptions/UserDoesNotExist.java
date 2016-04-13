package com.codinginfinity.research.people.exeptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by reinhardt on 2016/04/13.
 */
public class UserDoesNotExist extends PreconditionViolation{
    public UserDoesNotExist() {
    }

    public UserDoesNotExist(String message) {
        super(message);
    }

    public UserDoesNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDoesNotExist(Throwable cause) {
        super(cause);
    }
}
