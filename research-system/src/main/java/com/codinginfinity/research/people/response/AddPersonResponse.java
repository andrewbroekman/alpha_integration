package com.codinginfinity.research.people.response;

import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddPersonResponse implements Response {

    private static final long serialVersionUID = -9044882471452033833L;
    private Person person;
    public AddPersonResponse(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
