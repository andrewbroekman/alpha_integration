package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.publication.Publication;
import com.codinginfinity.research.services.Response;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class GetPublicationsForGroupResponse implements Response {

    private static final long serialVersionUID = 3663049256007610387L;

    private List<Publication> matchingPublications;

    public GetPublicationsForGroupResponse() {
        matchingPublications = new LinkedList<Publication>();
    }

    public void addPublication(Publication publication){
        matchingPublications.add(publication);
    }
}
