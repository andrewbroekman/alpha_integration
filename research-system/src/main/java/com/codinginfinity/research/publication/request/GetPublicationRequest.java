package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationRequest implements Request {

    private static final long serialVersionUID = -3830795730279001019L;

    private long publication;

    public GetPublicationRequest() {
    }

    public long getPublication() {
        return publication;
    }

    public void setPublication(long publication) {
        this.publication = publication;
    }
}
