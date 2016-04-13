package com.codinginfinity.research.people;

import com.codinginfinity.research.people.exeptions.EmailAddressInUse;
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
    EndResearchGroupAssociationResponse editResearchGroupAssociation(EndResearchGroupAssociationRequest endResearchGroupAssociationRequest);
    AddResearchGroupAssociationResponse addResearchGroupAssociation(AddResearchGroupAssociationRequest addResearchGroupAssociationRequest);
    AddResearcherCategoryResponse addResearcherCategory(AddResearcherCategoryRequest addResearcherCategoryRequest);
    ModifyResearcherCategoryResponse ModifyResearcherCategory(ModifyResearcherCategoryRequest modifyResearcherCategoryRequest);
    AddResearchGroupResponse addResearchGroup(AddResearchGroupRequest addResearchGroupRequest);
    SuspendResearchGroupResponse suspendResearchGroup(SuspendResearchGroupRequest suspendResearchGroupRequest);
}
