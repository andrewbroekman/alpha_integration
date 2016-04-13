package com.codinginfinity.research.people.exeptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by reinhardt on 2016/04/13.
 */
public class GroupAssociationAlreadyExists extends PreconditionViolation {
    public GroupAssociationAlreadyExists() {
    }

    public GroupAssociationAlreadyExists(String message) {
        super(message);
    }

    public GroupAssociationAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupAssociationAlreadyExists(Throwable cause) {
        super(cause);
    }
}
