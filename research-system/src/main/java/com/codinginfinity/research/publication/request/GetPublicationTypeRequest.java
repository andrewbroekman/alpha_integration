package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationTypeRequest implements Request {

    private static final long serialVersionUID = -1648911496591525382L;

    private long publicationType;

    public GetPublicationTypeRequest() {
    }

    public GetPublicationTypeRequest(long publicationType) {
        this.publicationType = publicationType;
    }

    public long getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(long publicationType) {
        this.publicationType = publicationType;
    }
}
