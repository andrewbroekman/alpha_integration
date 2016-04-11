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
}
