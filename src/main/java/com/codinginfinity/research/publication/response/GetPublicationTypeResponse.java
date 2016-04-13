package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.publication.type.PublicationType;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationTypeResponse implements Response {

    private static final long serialVersionUID = 8773883314266706073L;

    private PublicationType publicationType;

    public GetPublicationTypeResponse() {
    }

    public GetPublicationTypeResponse(PublicationType publicationType) {
        this.publicationType = publicationType;
    }

    public PublicationType getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(PublicationType publicationType) {
        this.publicationType = publicationType;
    }
}
