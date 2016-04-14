package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.publication.Publication;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddPublicationResponse implements Response {

    private static final long serialVersionUID = 6859593711135810887L;

    private Publication addedPublication;

    public AddPublicationResponse() {
    }

    public AddPublicationResponse(Publication publication) {
    }

    public Publication getAddedPublication() {
        return addedPublication;
    }

    public void setAddedPublication(Publication addedPublication) {
        this.addedPublication = addedPublication;
    }
}
