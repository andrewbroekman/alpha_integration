package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.publication.Publication;
import com.codinginfinity.research.services.Response;

import javax.validation.constraints.NotNull;

/**
 * Created by andrew on 2016/04/11.
 */
public class CreatePublicationResponse implements Response {

    private static final long serialVersionUID = 6881276055958458790L;

    @NotNull
    private Publication publication;

    public CreatePublicationResponse() {
    }

    public CreatePublicationResponse(Publication publication) {
        this.publication = publication;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
