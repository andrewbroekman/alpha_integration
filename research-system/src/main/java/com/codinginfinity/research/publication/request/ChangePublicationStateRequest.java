package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.publication.PublicationState;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class ChangePublicationStateRequest implements Request {

    private static final long serialVersionUID = 1587988030982600628L;

    private PublicationState publicationToModify;
    private long modifiedPublication;

    public PublicationState getPublicationToModify() {
        return publicationToModify;
    }

    public void setPublicationToModify(PublicationState publicationToModify) {
        this.publicationToModify = publicationToModify;
    }

    public long getModifiedPublication() {
        return modifiedPublication;
    }

    public void setModifiedPublication(long modifiedPublication) {
        this.modifiedPublication = modifiedPublication;
    }

    public ChangePublicationStateRequest(PublicationState publicationToModify, long modifiedPublication) {

        this.publicationToModify = publicationToModify;
        this.modifiedPublication = modifiedPublication;
    }

    public ChangePublicationStateRequest() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
