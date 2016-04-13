package com.codinginfinity.research.people.exeptions;

import com.codinginfinity.research.services.PreconditionViolation;
import com.google.common.base.Throwables;

/**
 * Created by Brenton on 4/13/2016.
 */
public class ResearcherCategoryAlreadyExists extends PreconditionViolation
{
    public ResearcherCategoryAlreadyExists(){}

    public ResearcherCategoryAlreadyExists(String message){super(message);}

    public ResearcherCategoryAlreadyExists(String message, Throwable cause){super(message, cause);}

    public ResearcherCategoryAlreadyExists(Throwable cause){super(cause);}
}
