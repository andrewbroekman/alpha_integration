package com.codinginfinity.research.reporting.request;

import com.codinginfinity.research.people.Entity;
import com.codinginfinity.research.publication.type.PublicationType;
import com.codinginfinity.research.services.Request;

/**
 * Created by Rohan on 2016/04/13.
 */
public class GetProgressReportRequest implements Request {

    private static final long serialVersionUID = 1356789921817499666L;

    private Entity entity;
    private PublicationType type;

    public GetProgressReportRequest() {
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
    }
}