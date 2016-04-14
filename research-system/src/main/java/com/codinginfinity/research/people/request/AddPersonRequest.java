package com.codinginfinity.research.people.request;

import com.codinginfinity.research.people.EmailAddress;
import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.services.Request;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddPersonRequest implements Request {

    private static final long serialVersionUID = -1792072087062998393L;
    @NotNull
    private Person person;
    @NotNull
    private EmailAddress primaryEmail;
    private List<EmailAddress> auxillaryEmails;

    public AddPersonRequest() {

    }

    public AddPersonRequest(Person person, EmailAddress primaryEmail) {
        this.person = person;
        this.primaryEmail = primaryEmail;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public EmailAddress getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(EmailAddress primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public List<EmailAddress> getAuxillaryEmails() {
        return auxillaryEmails;
    }

    public void setAuxillaryEmails(List<EmailAddress> auxillaryEmails) {
        this.auxillaryEmails = auxillaryEmails;
    }
}
