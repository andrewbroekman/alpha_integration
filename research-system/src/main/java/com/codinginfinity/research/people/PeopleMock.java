package com.codinginfinity.research.people;

import com.codinginfinity.research.people.exeptions.*;
import com.codinginfinity.research.people.request.*;
import com.codinginfinity.research.people.response.*;
import com.codinginfinity.research.services.RequestNotValidException;
import com.codinginfinity.research.services.mocking.BaseMock;
import com.codinginfinity.research.services.mocking.Mock;
import com.codinginfinity.research.validation.beanvalidation.services.ServiceValidationUtilities;
import org.springframework.stereotype.Service;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by reinhardt on 2016/04/13.
 * Added to by Brenton
 */
@Stateless
@Service
public class PeopleMock extends BaseMock implements IPeople {

    public PeopleMock() {
        setState(State.externalRequirementsMet);
    }

    @Override
    public EditPersonDetailsResponse editPersonDetails(EditPersonDetailsRequest editPersonDetailsRequest) throws RequestNotValidException, UserDoesNotExist {
        serviceValidationUtilities.validateRequest(EditPersonDetailsRequest.class, editPersonDetailsRequest);
        if(getState() == State.invalidUser)
            throw new UserDoesNotExist();
        if(editPersonDetailsRequest.getPerson().getFirstName().toLowerCase().equals("john") &&
                editPersonDetailsRequest.getPerson().getSurname().toLowerCase().equals("doe") &&
                editPersonDetailsRequest.getPerson().getPrimaryEmail().getAddress().toLowerCase().equals("johndoe@example.com")){
            return new EditPersonDetailsResponse(editPersonDetailsRequest.getPerson());
        }else{
            throw new RequestNotValidException();
        }
    }

    @Override
    public AddPersonResponse addPerson(AddPersonRequest addPersonRequest) throws RequestNotValidException, EmailAddressInUse {
        serviceValidationUtilities.validateRequest(AddPersonRequest.class, addPersonRequest);
        if(getState() == State.emailAddressInUse)
            throw new EmailAddressInUse();
        if(addPersonRequest.getPerson().getFirstName().toLowerCase().equals("john") &&
                addPersonRequest.getPerson().getSurname().toLowerCase().equals("doe") &&
                addPersonRequest.getPerson().getPrimaryEmail().getAddress().toLowerCase().equals("johndoe@example.com")){
            return new AddPersonResponse(new Person(addPersonRequest.getPerson().getFirstName(), addPersonRequest.getPerson().getSurname(), addPersonRequest.getPerson().getPrimaryEmail()));
        }else{
            throw new RequestNotValidException();
        }
    }

    @Override
    public EndResearchGroupAssociationResponse endResearchGroupAssociation(EndResearchGroupAssociationRequest endResearchGroupAssociationRequest) throws RequestNotValidException, GroupAssosiationDoesNotExist {
        serviceValidationUtilities.validateRequest(EndResearchGroupAssociationRequest.class, endResearchGroupAssociationRequest);
        if(getState() == State.invalidGroupAssociation){
            throw new GroupAssosiationDoesNotExist();
        }
        if(endResearchGroupAssociationRequest.getPerson().getFirstName().toLowerCase().equals("john") &&
                endResearchGroupAssociationRequest.getPerson().getSurname().toLowerCase().equals("doe") &&
                endResearchGroupAssociationRequest.getPerson().getPrimaryEmail().getAddress().toLowerCase().equals("johndoe@example.com") &&
                endResearchGroupAssociationRequest.getGroup().getName().equals("CIRG")) {
            return new EndResearchGroupAssociationResponse(endResearchGroupAssociationRequest.getGroup(), endResearchGroupAssociationRequest.getPerson());
        }else{
            throw new RequestNotValidException();
        }
    }

    @Override
    public AddResearchGroupAssociationResponse addResearchGroupAssociation(AddResearchGroupAssociationRequest addResearchGroupAssociationRequest) throws RequestNotValidException, GroupAssociationAlreadyExists {
        serviceValidationUtilities.validateRequest(AddResearchGroupAssociationRequest.class, addResearchGroupAssociationRequest);
        if(getState() == State.invalidGroupAssociation){
            throw new GroupAssociationAlreadyExists();
        }
        if(addResearchGroupAssociationRequest.getPerson().getFirstName().toLowerCase().equals("john") &&
                addResearchGroupAssociationRequest.getPerson().getSurname().toLowerCase().equals("doe") &&
                addResearchGroupAssociationRequest.getPerson().getPrimaryEmail().getAddress().toLowerCase().equals("johndoe@example.com") &&
                addResearchGroupAssociationRequest.getGroup().getName().equals("CIRG")) {
            return new AddResearchGroupAssociationResponse(addResearchGroupAssociationRequest.getGroup(), addResearchGroupAssociationRequest.getPerson());
        }else{
            throw new RequestNotValidException();
        }
    }

    @Override
    public AddResearcherCategoryResponse addResearcherCategory(AddResearcherCategoryRequest addResearcherCategoryRequest)throws RequestNotValidException, ResearcherCategoryAlreadyExists
    {
        serviceValidationUtilities.validateRequest(AddResearcherCategoryRequest.class, addResearcherCategoryRequest);
        if(getState() == State.invalidResearcherCategory)
        {
            throw new ResearcherCategoryAlreadyExists();
        }
        if(addResearcherCategoryRequest.getReseacherCategory().getResearcherCategory().toString().toLowerCase().equals("ai")) {
            return new AddResearcherCategoryResponse(addResearcherCategoryRequest.getReseacherCategory());
        }
        else
        {
            throw new RequestNotValidException();
        }
    }

    @Override
    public ModifyResearcherCategoryResponse ModifyResearcherCategory(ModifyResearcherCategoryRequest modifyResearcherCategoryRequest)throws RequestNotValidException, ResearcherCategoryDoesntExist{
        serviceValidationUtilities.validateRequest(ModifyResearcherCategoryRequest.class, modifyResearcherCategoryRequest);
        if(getState() == State.invalidResearcherCategory)
        {
            throw new ResearcherCategoryDoesntExist();
        }
        if(modifyResearcherCategoryRequest.getReseacherCategory().getResearcherCategory().toString().toLowerCase().equals("ai")){
            return new ModifyResearcherCategoryResponse(modifyResearcherCategoryRequest.getReseacherCategory());
        }
        else
        {
            throw new RequestNotValidException();
        }
    }

    @Override
    public AddResearchGroupResponse addResearchGroup(AddResearchGroupRequest addResearchGroupRequest) throws RequestNotValidException, ResearchGroupAlreadyExists {
        serviceValidationUtilities.validateRequest(AddResearchGroupRequest.class, addResearchGroupRequest);
        if(getState() == State.invalidResearchGroup){
            throw new ResearchGroupAlreadyExists();
        }
        if(addResearchGroupRequest.getGroup().getName().equals("CIRG") &&
                addResearchGroupRequest.getGroup().isActive()){
            return new AddResearchGroupResponse(addResearchGroupRequest.getGroup());
        }else{
            throw new RequestNotValidException();
        }
    }

    @Override
    public SuspendResearchGroupResponse suspendResearchGroup(SuspendResearchGroupRequest suspendResearchGroupRequest) throws RequestNotValidException, ResearchGroupAlreadySuspended {
        serviceValidationUtilities.validateRequest(SuspendResearchGroupRequest.class, suspendResearchGroupRequest);

        if(getState() == State.researchGroupAlreadySuspended){
            throw new ResearchGroupAlreadySuspended();
        }

        if(suspendResearchGroupRequest.getGroup().getName().equals("CIRG") &&
                suspendResearchGroupRequest.getGroup().isActive()){
            return new SuspendResearchGroupResponse(suspendResearchGroupRequest.getGroup());
        }else{
            throw new RequestNotValidException();
        }
    }

    public enum State implements Mock.State{externalRequirementsMet, emailAddressInUse, invalidUser,
        invalidGroupAssociation, invalidResearcherCategory, invalidResearchGroup, researchGroupAlreadySuspended
    }
    @Inject
    private ServiceValidationUtilities serviceValidationUtilities;
}
