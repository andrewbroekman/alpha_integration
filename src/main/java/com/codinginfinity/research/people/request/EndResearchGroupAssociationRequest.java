package com.codinginfinity.research.people.request;

import com.codinginfinity.research.people.Group;
import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class EndResearchGroupAssociationRequest implements Request {

    private static final long serialVersionUID = -7413869438101170054L;
    Person person;
    Group group;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public EndResearchGroupAssociationRequest(Group group, Person person) {
        this.group = group;
        this.person = person;

    }
}
