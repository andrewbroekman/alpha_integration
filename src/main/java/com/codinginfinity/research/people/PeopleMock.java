package com.codinginfinity.research.people;

import com.codinginfinity.research.people.exeptions.EmailAddressInUse;
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
 */
@Stateless
@Service
public class PeopleMock extends BaseMock implements IPeople {

    public PeopleMock() {
        setState(State.externalRequirementsMet);
    }

    @Override
    public EditPersonDetailsResponse editPersonDetails(EditPersonDetailsRequest editPersonDetailsRequest) {
        return null;
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
    public EndResearchGroupAssociationResponse editResearchGroupAssociation(EndResearchGroupAssociationRequest endResearchGroupAssociationRequest) {
        return null;
    }

    @Override
    public AddResearchGroupAssociationResponse addResearchGroupAssociation(AddResearchGroupAssociationRequest addResearchGroupAssociationRequest) {
        return null;
    }

    @Override
    public AddResearcherCategoryResponse addResearcherCategory(AddResearcherCategoryRequest addResearcherCategoryRequest) {
        return null;
    }

    @Override
    public ModifyResearcherCategoryResponse ModifyResearcherCategory(ModifyResearcherCategoryRequest modifyResearcherCategoryRequest) {
        return null;
    }

    @Override
    public AddResearchGroupResponse addResearchGroup(AddResearchGroupRequest addResearchGroupRequest) {
        return null;
    }

    @Override
    public SuspendResearchGroupResponse suspendResearchGroup(SuspendResearchGroupRequest suspendResearchGroupRequest) {
        return null;
    }

    public enum State implements Mock.State{externalRequirementsMet, emailAddressInUse}

    @Inject
    private ServiceValidationUtilities serviceValidationUtilities;
}
