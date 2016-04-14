package com.codinginfinity.research.people.response;

import com.codinginfinity.research.people.Group;
import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddResearchGroupAssociationResponse implements Response {

    private static final long serialVersionUID = -7482575186014890818L;

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

    public AddResearchGroupAssociationResponse(Group group, Person person) {
        this.group = group;
        this.person = person;
    }
}
