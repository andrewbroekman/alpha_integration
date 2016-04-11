package com.codinginfinity.research.publication.request;

import com.codinginfinity.research.services.Request;
import com.codinginfinity.research.publication.PublicationState;

/**
 * Created by andrew on 2016/04/11.
 */
public class ChangePublicationStateRequest implements Request {

    private static final long serialVersionUID = 1587988030982600628L;

    private PublicationState publicationToModify;
    private long modifiedPublication;

    public ChangePublicationStateRequest() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
