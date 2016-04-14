package com.codinginfinity.research.people.response;

import com.codinginfinity.research.people.Group;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class SuspendResearchGroupResponse implements Response {

    private static final long serialVersionUID = -7441332400699681974L;

    Group group;
    public SuspendResearchGroupResponse(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
