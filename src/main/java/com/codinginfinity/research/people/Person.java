package com.codinginfinity.research.people;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class Person extends Entity {
    
    private static final long serialVersionUID = -2676730123842785587L;
    
    private String firstName;
    private String surname;

    @NotNull
    private EmailAddress primaryEmail;
    private List<EmailAddress> auxillaryEmails;

    public Person(String firstName, String surname, EmailAddress primaryEmail) {
        this.firstName = firstName;
        this.surname = surname;
        this.primaryEmail = primaryEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
