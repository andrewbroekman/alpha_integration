package com.codinginfinity.research.people.exeptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by reinhardt on 2016/04/13.
 */
public class GroupAssosiationDoesNotExist extends PreconditionViolation{
    public GroupAssosiationDoesNotExist() {
        super();
    }

    public GroupAssosiationDoesNotExist(String message) {
        super(message);
    }

    public GroupAssosiationDoesNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupAssosiationDoesNotExist(Throwable cause) {
        super(cause);
    }
}
