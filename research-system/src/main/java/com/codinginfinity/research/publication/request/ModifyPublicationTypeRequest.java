package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.publication.type.PublicationTypeState;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class ModifyPublicationTypeRequest implements Request {

    private static final long serialVersionUID = 5216542632787249636L;

    private PublicationTypeState publicationTypeState;
    private long modifiedPublicationType;

    public ModifyPublicationTypeRequest() {
    }

    public ModifyPublicationTypeRequest(PublicationTypeState publicationTypeState, long modifiedPublicationType) {
        this.publicationTypeState = publicationTypeState;
        this.modifiedPublicationType = modifiedPublicationType;
    }

    public PublicationTypeState getPublicationTypeState() {
        return publicationTypeState;
    }

    public void setPublicationTypeState(PublicationTypeState publicationTypeState) {
        this.publicationTypeState = publicationTypeState;
    }

    public long getModifiedPublicationType() {
        return modifiedPublicationType;
    }

    public void setModifiedPublicationType(long modifiedPublicationType) {
        this.modifiedPublicationType = modifiedPublicationType;
    }
}
