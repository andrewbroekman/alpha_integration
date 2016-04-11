package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.services.Request;
import com.codinginfinity.research.publication.PublicationState;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddPublicationRequest implements Request {

    private static final long serialVersionUID = -6601253793808234608L;

    private PublicationState initialState;

    public AddPublicationRequest() {
    }

    public PublicationState getInitialState() {
        return initialState;
    }

    public void setInitialState(PublicationState initialState) {
        this.initialState = initialState;
    }
}
