package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.publication.Period;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationsForGroupRequest implements Request{

    private static final long serialVersionUID = 5821774448794732884L;

    private long group;
    private Period publicationPeriod;

    public Period getPublicationPeriod() {
        return publicationPeriod;
    }

    public void setPublicationPeriod(Period publicationPeriod) {
        this.publicationPeriod = publicationPeriod;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
    }

    public GetPublicationsForGroupRequest() {
    }
}
