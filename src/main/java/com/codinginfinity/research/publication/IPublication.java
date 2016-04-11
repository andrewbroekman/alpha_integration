package com.codinginfinity.research.publication;

import com.codinginfinity.research.publication.request.*;
import com.codinginfinity.research.publication.response.*;

/**
 * Created by andrew on 2016/04/11.
 */
public interface IPublication {

    AddPublicationResponse addPublication(AddPublicationRequest addPublicationRequest);
    GetPublicationResponse getPublication(GetPublicationRequest getPublicationRequest);
    CreatePublicationResponse createPublication(CreatePublicationRequest createPublicationRequest);
    ChangePublicationStateResponse changePublicationState(ChangePublicationStateRequest changePublicationStateRequest);
    AddPublicationTypeResponse addPublicationType(AddPublicationTypeRequest addPublicationTypeRequest);
    GetPublicationTypeResponse getPublicationType(GetPublicationTypeRequest getPublicationRequest);
    ModifyPublicationTypeResponse modifyPublicationType(ModifyPublicationTypeRequest modifyPublicationTypeRequest);
    GetPublicationsForPersonResponse getPublicationsForPerson(GetPublicationsForPersonRequest getPublicationsForPersonRequest);
    GetPublicationsForGroupResponse getPublicationsForGroup(GetPublicationsForGroupRequest getPublicationsForGroupRequest);
    CalcAccreditationPointsForPersonResponse calcAccreditationPointsForPerson(CalcAccreditationPointsForPersonRequest calcAccreditationPointsForPersonRequest);
    CalcAccreditationPointsForGroupResponse calcAccreditationPointsForGroup(CalcAccreditationPointsForGroupRequest calcAccreditationPointsForGroupRequest);
}
