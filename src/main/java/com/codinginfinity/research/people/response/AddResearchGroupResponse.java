package com.codinginfinity.research.people.response;

import com.codinginfinity.research.people.Group;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddResearchGroupResponse implements Response {

    private static final long serialVersionUID = 7803330950970862845L;
    Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    public AddResearchGroupResponse(Group group) {
        this.group = group;
    }
}
