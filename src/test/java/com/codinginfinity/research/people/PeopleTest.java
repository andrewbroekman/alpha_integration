package com.codinginfinity.research.people;

import com.codinginfinity.research.people.exeptions.UserDoesNotExist;
import com.codinginfinity.research.people.request.EditPersonDetailsRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by andrew on 2016/04/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PeopleTest.class})
@ComponentScan("com.codinginfinity.research")
public class PeopleTest {

    @Inject
    private PeopleMock peopleMock;

    @Test(expected = UserDoesNotExist.class)
    public void userDoesNotExistTest() throws Exception{
        peopleMock.setState(PeopleMock.State.invalidUser);
        Person p = createJohnDoe();
        EditPersonDetailsRequest req = new EditPersonDetailsRequest();
        req.setPerson(p);
        req.setPrimaryEmail(createJohnDoeEmail());
        peopleMock.editPersonDetails(req);
    }

    private static Person createJohnDoe(){
        EmailAddress email = new EmailAddress();
        email.setAddress("johndoe@example.com");
        return new Person("john", "doe", email);
    }

    private static Group createCirg(){
        Group group = new Group();
        group.setName("CIRG");
        return group;
    }

    private static EmailAddress createJohnDoeEmail(){
        EmailAddress email = new EmailAddress();
        email.setAddress("johndoe@example.com");
        return email;
    }

}