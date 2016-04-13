package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.publication.Publication;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationResponse implements Response {

    private static final long serialVersionUID = 1064309047716181776L;

    private Publication publication;

    public GetPublicationResponse() {
    }

    public GetPublicationResponse(Publication publication) {
        this.publication = publication;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
