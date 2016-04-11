package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.services.Response;
import com.codinginfinity.research.publication.Publication;

import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationsForPersonResponse implements Response {

    private static final long serialVersionUID = -7529309701039798192L;

    private List<Publication> matchingPublications;

    public GetPublicationsForPersonResponse() {
    }
}
