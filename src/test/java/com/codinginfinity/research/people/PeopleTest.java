package com.codinginfinity.research.people;


import com.codinginfinity.research.people.defaultImpl.People;
import com.codinginfinity.research.people.exeptions.*;
import com.codinginfinity.research.people.request.*;
import com.codinginfinity.research.people.response.*;
import com.codinginfinity.research.services.RequestNotValidException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.time.LocalDateTime;

/**
 * Created by andrew on 2016/04/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PeopleTest.class})
@ComponentScan("com.codinginfinity.research")
public class PeopleTest {

    @Inject
    private PeopleMock peopleMock;

    //editPersonDetails
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
    //addPerson
    @Test (expected = EmailAddressInUse.class)
    public void addDuplicateUser() throws Exception{
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
    //endResearchGroupAssociation
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
        peopleMock.setState(PeopleMock.State.externalRequirementsMet);
        Person p = createJohnDoe();
        Group g = createCirg();
        EndResearchGroupAssociationRequest req = new EndResearchGroupAssociationRequest(g,p);
        peopleMock.endResearchGroupAssociation(req);
        assert true; //if no exceptions were thrown all went well
    }

    @Test(expected = RequestNotValidException.class)
    public void endResearchGroupAssosiationInvalidRequest() throws Exception{
        peopleMock.setState(PeopleMock.State.externalRequirementsMet);
        Person p = createJohnDoe();
        Group g = createCirg();
        g.setName("NOT cirg");
        EndResearchGroupAssociationRequest req = new EndResearchGroupAssociationRequest(g,p);
        peopleMock.endResearchGroupAssociation(req);
    }

    //addResearchGroupAssociation
    @Test(expected = GroupAssociationAlreadyExists.class)
    public void addExistingReserchGroupAssociation() throws Exception{
        peopleMock.setState(PeopleMock.State.invalidGroupAssociation);
        Person p = createJohnDoe();
        Group g = createCirg();
        AddResearchGroupAssociationRequest req = new AddResearchGroupAssociationRequest(g,p);
        peopleMock.addResearchGroupAssociation(req);
    }

    @Test
    public void addResearchGroupAssosiation() throws Exception{
        peopleMock.setState(PeopleMock.State.externalRequirementsMet);
        Person p = createJohnDoe();
        Group g = createCirg();
        AddResearchGroupAssociationRequest req = new AddResearchGroupAssociationRequest(g,p);
        peopleMock.addResearchGroupAssociation(req);
        assert true; //if no exceptions were thrown all went well
    }

    @Test(expected = RequestNotValidException.class)
    public void addResearchGroupAssosiationInvalidRequest() throws Exception {
        peopleMock.setState(PeopleMock.State.externalRequirementsMet);
        Person p = createJohnDoe();
        Group g = createCirg();
        g.setName("NOT cirg");
        AddResearchGroupAssociationRequest req = new AddResearchGroupAssociationRequest(g, p);
        peopleMock.addResearchGroupAssociation(req);
    }


    @Test
    public void addResearchGroup() throws Exception{
        peopleMock.setState(PeopleMock.State.invalidResearchGroup);
        Group g = createCirg();
        AddResearchGroupRequest req = new AddResearchGroupRequest(g);
        AddResearchGroupResponse resp = peopleMock.addResearchGroup(req);
        assert true;
    }

    @Test(expected = RequestNotValidException.class)
    public void addResearchGroupInvalidRequest() throws Exception{
        peopleMock.setState(PeopleMock.State.invalidResearchGroup);
        Group g = createCirg();
        g.setName("Not CIRG");
        AddResearchGroupRequest req = new AddResearchGroupRequest(g);
        peopleMock.addResearchGroup(req);
    }

    @Test
    public void suspendResearchGroup() throws Exception{
        peopleMock.setState(PeopleMock.State.researchGroupAlreadySuspended);
        Group g = createCirg();
        SuspendResearchGroupRequest req = new SuspendResearchGroupRequest(g);
        peopleMock.suspendResearchGroup(req);
        assert true;
    }

    @Test(expected = RequestNotValidException.class)
    public void suspendResearchGroupInvalidRequest() throws Exception{
        peopleMock.setState(PeopleMock.State.researchGroupAlreadySuspended);
        Group g = createCirg();
        g.setActive(false);
        SuspendResearchGroupRequest req = new SuspendResearchGroupRequest(g);
        peopleMock.suspendResearchGroup(req);
    }


    @Test
    public void addResearcherCategory() throws Exception
    {
        peopleMock.setState(PeopleMock.State.externalRequirementsMet);
        ReseacherCategory r = createAI();
        AddResearcherCategoryRequest req = new AddResearcherCategoryRequest(r);
        AddResearcherCategoryResponse response = peopleMock.addResearcherCategory(req);
        ReseacherCategory resp = response.getReseacherCategory();
        assert (resp.getResearcherCategory().toString().equals("ai"));
    }

    @Test(expected = RequestNotValidException.class)
    public void addInvalidResearcherCategory() throws Exception
    {
        peopleMock.setState(PeopleMock.State.invalidResearchGroup);
        ReseacherCategory reseacherCategory = createAI();
        reseacherCategory.setResearcherCategoryState("Not AI");
        AddResearcherCategoryRequest req = new AddResearcherCategoryRequest(reseacherCategory);
        peopleMock.addResearcherCategory(req);
    }

    @Test
    public void modifyResearcherCategory() throws Exception
    {
        peopleMock.setState(PeopleMock.State.externalRequirementsMet);
        ReseacherCategory r = createAI();
        ModifyResearcherCategoryRequest req = new ModifyResearcherCategoryRequest(r);
        ModifyResearcherCategoryResponse response = peopleMock.ModifyResearcherCategory(req);
        ReseacherCategory resp = response.getReseacherCategory();
        assert (resp.getResearcherCategory().toString().equals("ai"));
    }

    @Test (expected = ResearcherCategoryDoesntExist.class)
    public void invalidModifyResearcherCategory() throws Exception
    {
        peopleMock.setState(PeopleMock.State.invalidResearcherCategory);
        ReseacherCategory r = createAI();
        ModifyResearcherCategoryRequest req = new ModifyResearcherCategoryRequest(r);
        peopleMock.ModifyResearcherCategory(req);
    }

    private static Person createJohnDoe(){
        EmailAddress email = new EmailAddress();
        email.setAddress("johndoe@example.com");
        return new Person("john", "doe", email);
    }

    private static Group createCirg(){
        Group group = new Group("CIRG");
        return group;
    }

    private static EmailAddress createJohnDoeEmail(){
        EmailAddress email = new EmailAddress();
        email.setAddress("johndoe@example.com");
        return email;
    }

    private static ReseacherCategory createAI()
    {
        ReseacherCategory reseacherCategory = new ReseacherCategory();
        reseacherCategory.setResearcherCategoryState("ai");
        return  reseacherCategory;
    }

}