package com.codinginfinity.research.people;

import com.codinginfinity.research.people.exeptions.*;
import com.codinginfinity.research.people.request.*;
import com.codinginfinity.research.people.response.*;
import com.codinginfinity.research.services.RequestNotValidException;

/**
 * Created by andrew on 2016/04/11.
 */
public interface IPeople {

    EditPersonDetailsResponse editPersonDetails(EditPersonDetailsRequest editPersonDetailsRequest) throws RequestNotValidException, UserDoesNotExist;
    AddPersonResponse addPerson(AddPersonRequest addPersonRequest) throws RequestNotValidException, EmailAddressInUse;
    EndResearchGroupAssociationResponse endResearchGroupAssociation(EndResearchGroupAssociationRequest endResearchGroupAssociationRequest) throws RequestNotValidException, GroupAssosiationDoesNotExist;
    AddResearchGroupAssociationResponse addResearchGroupAssociation(AddResearchGroupAssociationRequest addResearchGroupAssociationRequest) throws RequestNotValidException, GroupAssociationAlreadyExists;
    AddResearcherCategoryResponse addResearcherCategory(AddResearcherCategoryRequest addResearcherCategoryRequest) throws RequestNotValidException, ResearcherCategoryAlreadyExists;
    ModifyResearcherCategoryResponse ModifyResearcherCategory(ModifyResearcherCategoryRequest modifyResearcherCategoryRequest)throws RequestNotValidException, ResearcherCategoryDoesntExist;
    AddResearchGroupResponse addResearchGroup(AddResearchGroupRequest addResearchGroupRequest);
    SuspendResearchGroupResponse suspendResearchGroup(SuspendResearchGroupRequest suspendResearchGroupRequest);
}
