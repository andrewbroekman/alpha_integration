package com.codinginfinity.research.people.response;

import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class EditPersonDetailsResponse implements Response {

    private static final long serialVersionUID = 8548646086025704704L;

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public EditPersonDetailsResponse(Person person) {
        this.person = person;

    }
}
