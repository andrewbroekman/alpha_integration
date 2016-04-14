package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.publication.Period;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class CalcAccreditationPointsForGroupRequest implements Request {

    private static final long serialVersionUID = 7244353272833550335L;

    private long group;
    private Period publicationPeriod;

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
    }

    public Period getPublicationPeriod() {
        return publicationPeriod;
    }

    public void setPublicationPeriod(Period publicationPeriod) {
        this.publicationPeriod = publicationPeriod;
    }

    public CalcAccreditationPointsForGroupRequest(long group, Period publicationPeriod) {

        this.group = group;
        this.publicationPeriod = publicationPeriod;
    }

    public CalcAccreditationPointsForGroupRequest() {
    }
}
