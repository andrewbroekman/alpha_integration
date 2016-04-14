package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class ModifyPublicationTypeResponse implements Response {

    private static final long serialVersionUID = -7760066394413961053L;

    private long id;

    public ModifyPublicationTypeResponse() {
    }

    public ModifyPublicationTypeResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
