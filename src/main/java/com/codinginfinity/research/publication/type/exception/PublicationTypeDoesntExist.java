package com.codinginfinity.research.publication.type.exception;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by andrew on 2016/04/13.
 */
public class PublicationTypeDoesntExist extends PreconditionViolation {

    private static final long serialVersionUID = -7752733863675230318L;

    public PublicationTypeDoesntExist() {
    }

    public PublicationTypeDoesntExist(String message) {
        super(message);
    }

    public PublicationTypeDoesntExist(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationTypeDoesntExist(Throwable cause) {
        super(cause);
    }
}
