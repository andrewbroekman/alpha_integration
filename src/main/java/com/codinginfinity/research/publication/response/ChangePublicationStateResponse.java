package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class ChangePublicationStateResponse implements Response {

    private static final long serialVersionUID = 4107652860571255335L;

    private long modifiedPublication;

    public ChangePublicationStateResponse() {
    }

    public long getModifiedPublication() {
        return modifiedPublication;
    }

    public void setModifiedPublication(long modifiedPublication) {
        this.modifiedPublication = modifiedPublication;
    }
}
