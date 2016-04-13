package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.services.Request;
import com.codinginfinity.research.publication.PublicationState;

import javax.validation.constraints.NotNull;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddPublicationRequest implements Request {

    private static final long serialVersionUID = -6601253793808234608L;

    @NotNull
    private PublicationState initialState;
    @NotNull
    private long owner;

    public AddPublicationRequest() {
    }

    public PublicationState getInitialState() {
        return initialState;
    }

    public void setInitialState(PublicationState initialState) {
        this.initialState = initialState;
    }
}
