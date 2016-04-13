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


}
