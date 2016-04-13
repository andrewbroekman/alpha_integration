package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.publication.Publication;
import com.codinginfinity.research.publication.PublicationState;
import com.codinginfinity.research.services.Request;

import javax.validation.constraints.NotNull;

/**
 * Created by andrew on 2016/04/11.
 */
public class CreatePublicationRequest implements Request {

    private static final long serialVersionUID = -5913755483362475338L;

    @NotNull
    private PublicationState initialState;

    public CreatePublicationRequest() {
    }

    public CreatePublicationRequest(PublicationState initialState) {
        this.initialState = initialState;
    }

    public PublicationState getInitialState() {
        return initialState;
    }

    public void setInitialState(PublicationState initialState) {
        this.initialState = initialState;
    }
}
