package com.codinginfinity.research.people.request;

import com.codinginfinity.research.people.Group;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class SuspendResearchGroupRequest implements Request {

    private static final long serialVersionUID = -1595524863598161378L;

    Group group;
    public SuspendResearchGroupRequest(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


}
