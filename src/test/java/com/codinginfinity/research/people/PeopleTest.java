package com.codinginfinity.research.people;

import com.codinginfinity.research.people.exeptions.EmailAddressInUse;
import com.codinginfinity.research.people.exeptions.GroupAssosiationDoesNotExist;
import com.codinginfinity.research.people.exeptions.UserDoesNotExist;
import com.codinginfinity.research.people.request.AddPersonRequest;
import com.codinginfinity.research.people.request.EditPersonDetailsRequest;
import com.codinginfinity.research.people.request.EndResearchGroupAssociationRequest;
import com.codinginfinity.research.people.response.AddPersonResponse;
import com.codinginfinity.research.people.response.EditPersonDetailsResponse;
import com.codinginfinity.research.services.RequestNotValidException;
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

    @Test
    public void regularPersonEdit() throws Exception {
        peopleMock.setState(PeopleMock.State.externalRequirementsMet);
        Person p = createJohnDoe();
        EditPersonDetailsRequest req = new EditPersonDetailsRequest();
        req.setPerson(p);
        req.setPrimaryEmail(createJohnDoeEmail());
        EditPersonDetailsResponse response = peopleMock.editPersonDetails(req);
        Person resp = response.getPerson();
        assert (resp.getPrimaryEmail().getAddress().equals("johndoe@example.com") &&
                resp.getFirstName().equals("john") && resp.getSurname().equals("doe"));
    }

    @Test (expected = EmailAddressInUse.class)
    public void addDupliocateUser() throws Exception{
        peopleMock.setState(PeopleMock.State.emailAddressInUse);
        Person p = createJohnDoe();
        AddPersonRequest req = new AddPersonRequest();
        req.setPerson(p);
        req.setPrimaryEmail(createJohnDoeEmail());
        peopleMock.addPerson(req);
    }

    @Test
    public void addRegularPerson() throws Exception{
        peopleMock.setState(PeopleMock.State.externalRequirementsMet);
        Person p = createJohnDoe();
        AddPersonRequest req = new AddPersonRequest();
        req.setPerson(p);
        req.setPrimaryEmail(createJohnDoeEmail());
        AddPersonResponse response = peopleMock.addPerson(req);
        Person resp = response.getPerson();
        assert (resp.getPrimaryEmail().getAddress().equals("johndoe@example.com") &&
                resp.getFirstName().equals("john") && resp.getSurname().equals("doe"));
    }

    @Test(expected = RequestNotValidException.class)
    public void addInvalidPersonRequest() throws Exception{
        peopleMock.setState(PeopleMock.State.externalRequirementsMet);
        Person p = new Person("Wrong", "Verkeerd", new EmailAddress("notexistent@email.com#wrong"));
        AddPersonRequest req = new AddPersonRequest();
        req.setPerson(p);
        req.setPrimaryEmail(new EmailAddress("notexistent@email.com#wrong"));
        peopleMock.addPerson(req);
    }

    @Test(expected = GroupAssosiationDoesNotExist.class)
    public void endingNotExistentUserGroupAssociation() throws Exception{
        peopleMock.setState(PeopleMock.State.invalidGroupAssociation);
        Person p = createJohnDoe();
        Group g = createCirg();
        EndResearchGroupAssociationRequest req = new EndResearchGroupAssociationRequest(g,p);
        peopleMock.endResearchGroupAssociation(req);
    }

    @Test
    public void endResearchGroupAssosiation() throws Exception{
        peopleMock.setState(PeopleMock.State.invalidGroupAssociation);
        Person p = createJohnDoe();
        Group g = createCirg();
        EndResearchGroupAssociationRequest req = new EndResearchGroupAssociationRequest(g,p);
        peopleMock.endResearchGroupAssociation(req);
        assert true; //if no exceptions were thrown all went well
    }

    @Test(expected = RequestNotValidException.class)
    public void endResearchGroupAssosiationInvalidRequest() throws Exception{
        peopleMock.setState(PeopleMock.State.invalidGroupAssociation);
        Person p = createJohnDoe();
        Group g = createCirg();
        g.setName("NOT cirg");
        EndResearchGroupAssociationRequest req = new EndResearchGroupAssociationRequest(g,p);
        peopleMock.endResearchGroupAssociation(req);
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