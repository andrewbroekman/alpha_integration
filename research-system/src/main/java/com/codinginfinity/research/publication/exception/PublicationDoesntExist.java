package com.codinginfinity.research.publication.exception;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by andrew on 2016/04/13.
 */
public class PublicationDoesntExist extends PreconditionViolation {

    private static final long serialVersionUID = 1027906214155470536L;

    public PublicationDoesntExist() {
    }

    public PublicationDoesntExist(String message) {
        super(message);
    }

    public PublicationDoesntExist(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationDoesntExist(Throwable cause) {
        super(cause);
    }
}
