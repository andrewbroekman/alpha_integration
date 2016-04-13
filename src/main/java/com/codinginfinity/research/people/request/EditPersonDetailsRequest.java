package com.codinginfinity.research.people.request;

import com.codinginfinity.research.people.EmailAddress;
import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.services.Request;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class EditPersonDetailsRequest implements Request {

    private static final long serialVersionUID = 6854802492006534544L;

    @NotNull
    private Person person;
    @NotNull
    private EmailAddress primaryEmail;
    private List<EmailAddress> auxillaryEmails;

    public EditPersonDetailsRequest() {

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
