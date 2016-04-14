package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.publication.Period;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class CalcAccreditationPointsForPersonRequest implements Request {

    private static final long serialVersionUID = -1336448696158164436L;

    private long person;
    private Period publicationPeriod;

    public long getPerson() {
        return person;
    }

    public void setPerson(long person) {
        this.person = person;
    }

    public Period getPublicationPeriod() {
        return publicationPeriod;
    }

    public void setPublicationPeriod(Period publicationPeriod) {
        this.publicationPeriod = publicationPeriod;
    }

    public CalcAccreditationPointsForPersonRequest(long person, Period publicationPeriod) {

        this.person = person;
        this.publicationPeriod = publicationPeriod;
    }

    public CalcAccreditationPointsForPersonRequest() {
    }
}
