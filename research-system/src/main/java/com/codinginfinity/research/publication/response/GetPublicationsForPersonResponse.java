package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.publication.Publication;
import com.codinginfinity.research.services.Response;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationsForPersonResponse implements Response {

    private static final long serialVersionUID = -7529309701039798192L;

    private List<Publication> matchingPublications;

    public GetPublicationsForPersonResponse() {
        matchingPublications = new LinkedList<Publication>();
    }

    public void addPublication(Publication publication){
        matchingPublications.add(publication);
    }
}
