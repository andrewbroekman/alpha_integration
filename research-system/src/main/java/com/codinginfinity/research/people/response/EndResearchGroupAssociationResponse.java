package com.codinginfinity.research.people.response;

import com.codinginfinity.research.people.Group;
import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class EndResearchGroupAssociationResponse implements Response {

    private static final long serialVersionUID = -976535414065731553L;

    Person person;
    Group group;

    public EndResearchGroupAssociationResponse(Group group, Person person) {
        this.group = group;
        this.person = person;

    }

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
}
