package com.codinginfinity.research.people.exeptions;

import com.codinginfinity.research.services.PreconditionViolation;
/**
 * Created by Brenton on 4/13/2016.
 */
public class ResearcherCategoryDoesntExist extends PreconditionViolation
{
    public ResearcherCategoryDoesntExist(){}

    public ResearcherCategoryDoesntExist(String message){super(message);}

    public ResearcherCategoryDoesntExist(String message, Throwable cause){super(message, cause);}

    public ResearcherCategoryDoesntExist(Throwable cause){super(cause);}
}
