package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.publication.Period;
import com.codinginfinity.research.publication.PublicationConfidenceLevel;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationsForPersonRequest implements Request {

    private static final long serialVersionUID = 263441248359317490L;

    private long person;
    private PublicationConfidenceLevel confidenceLevel;
    private Period publicationPeriod;

    public long getPerson() {
        return person;
    }

    public void setPerson(long person) {
        this.person = person;
    }

    public PublicationConfidenceLevel getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(PublicationConfidenceLevel confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    public Period getPublicationPeriod() {
        return publicationPeriod;
    }

    public void setPublicationPeriod(Period publicationPeriod) {
        this.publicationPeriod = publicationPeriod;
    }

    public GetPublicationsForPersonRequest() {
    }
}
