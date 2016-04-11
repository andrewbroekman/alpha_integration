package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.services.Request;
import com.codinginfinity.research.publication.Period;
import com.codinginfinity.research.publication.PublicationConfidenceLevel;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationsForPersonRequest implements Request {

    private static final long serialVersionUID = 263441248359317490L;

    private long person;
    private PublicationConfidenceLevel confidenceLevel;
    private Period publicationPeriod;

    public GetPublicationsForPersonRequest() {
    }
}
