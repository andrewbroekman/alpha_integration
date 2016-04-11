package com.codinginfinity.research.people;

import com.codinginfinity.research.people.request.*;
import com.codinginfinity.research.people.response.*;

/**
 * Created by andrew on 2016/04/11.
 */
public interface IPeople {

    EditPersonDetailsResponse editPersonDetails(EditPersonDetailsRequest editPersonDetailsRequest);
    AddPersonResponse addPerson(AddPersonRequest addPersonRequest);
    EndResearchGroupAssociationResponse editResearchGroupAssociation(EndResearchGroupAssociationRequest endResearchGroupAssociationRequest);
    AddResearchGroupAssociationResponse addResearchGroupAssociation(AddResearchGroupAssociationRequest addResearchGroupAssociationRequest);
    AddResearcherCategoryResponse addResearcherCategory(AddResearcherCategoryRequest addResearcherCategoryRequest);
    ModifyResearcherCategoryResponse ModifyResearcherCategory(ModifyResearcherCategoryRequest modifyResearcherCategoryRequest);
    AddResearchGroupResponse addResearchGroup(AddResearchGroupRequest addResearchGroupRequest);
    SuspendResearchGroupResponse suspendResearchGroup(SuspendResearchGroupRequest suspendResearchGroupRequest);

}
