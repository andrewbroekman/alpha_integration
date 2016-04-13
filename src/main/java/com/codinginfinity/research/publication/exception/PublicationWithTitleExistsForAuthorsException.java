package com.codinginfinity.research.publication.exception;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by andrew on 2016/04/11.
 */
public class PublicationWithTitleExistsForAuthorsException extends PreconditionViolation {

    private static final long serialVersionUID = 7518339920053385153L;

    public PublicationWithTitleExistsForAuthorsException() {
    }
}
