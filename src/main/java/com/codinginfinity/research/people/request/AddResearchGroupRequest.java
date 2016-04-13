package com.codinginfinity.research.people.request;

import com.codinginfinity.research.people.Group;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddResearchGroupRequest implements Request {

    private static final long serialVersionUID = 4636439588751143106L;

    Group group;
    public AddResearchGroupRequest(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }





}
