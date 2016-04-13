package com.codinginfinity.research.people;

import com.codinginfinity.research.people.exeptions.EmailAddressInUse;
import com.codinginfinity.research.people.exeptions.GroupAssociationAlreadyExists;
import com.codinginfinity.research.people.exeptions.GroupAssosiationDoesNotExist;
import com.codinginfinity.research.people.exeptions.UserDoesNotExist;
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
    AddResearcherCategoryResponse addResearcherCategory(AddResearcherCategoryRequest addResearcherCategoryRequest);
    ModifyResearcherCategoryResponse ModifyResearcherCategory(ModifyResearcherCategoryRequest modifyResearcherCategoryRequest);
    AddResearchGroupResponse addResearchGroup(AddResearchGroupRequest addResearchGroupRequest);
    SuspendResearchGroupResponse suspendResearchGroup(SuspendResearchGroupRequest suspendResearchGroupRequest);
}
