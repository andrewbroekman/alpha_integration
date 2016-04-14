package com.codinginfinity.research.people.exeptions;

import com.codinginfinity.research.services.PreconditionViolation;

/**
 * Created by fabio on 2016/04/13.
 */
public class ResearchGroupAlreadySuspended extends PreconditionViolation {
    public ResearchGroupAlreadySuspended(){}

    public ResearchGroupAlreadySuspended(String message){super(message);}
    public ResearchGroupAlreadySuspended(String message, Throwable cause){super(message, cause);}
    public ResearchGroupAlreadySuspended(Throwable cause){super (cause);}
}
