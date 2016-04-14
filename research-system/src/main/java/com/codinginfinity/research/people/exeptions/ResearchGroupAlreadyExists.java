package com.codinginfinity.research.people.exeptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by fabio on 2016/04/13.
 */
public class ResearchGroupAlreadyExists extends PreconditionViolation {
    public ResearchGroupAlreadyExists(){}

    public ResearchGroupAlreadyExists(String message){super(message);}
    public ResearchGroupAlreadyExists(String message, Throwable cause){super(message, cause);}
    public ResearchGroupAlreadyExists(Throwable cause){super (cause);}
}