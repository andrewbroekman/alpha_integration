package com.codinginfinity.research.publication;

import com.codinginfinity.research.notification.exceptions.EmailInvalidException;
import com.codinginfinity.research.notification.exceptions.InvalidDateException;
import com.codinginfinity.research.notification.exceptions.SendEmailFailedException;
import com.codinginfinity.research.publication.exception.*;
import com.codinginfinity.research.publication.request.*;
import com.codinginfinity.research.publication.response.*;
import com.codinginfinity.research.publication.type.exception.PublicationTypeDoesntExist;
import com.codinginfinity.research.services.RequestNotValidException;

/**
 * Created by andrew on 2016/04/11.
 */
public interface IPublication {

    AddPublicationResponse addPublication(AddPublicationRequest addPublicationRequest) throws RequestNotValidException, PublicationWithTitleExistsForAuthorsException;
    GetPublicationResponse getPublication(GetPublicationRequest getPublicationRequest) throws RequestNotValidException, PublicationDoesntExist;
    CreatePublicationResponse createPublication(CreatePublicationRequest createPublicationRequest) throws RequestNotValidException;
    ChangePublicationStateResponse changePublicationState(ChangePublicationStateRequest changePublicationStateRequest)
            throws RequestNotValidException, PublicationDoesntExist, AlreadyPublishedException, InvalidDateException, EmailInvalidException, SendEmailFailedException;
    AddPublicationTypeResponse addPublicationType(AddPublicationTypeRequest addPublicationTypeRequest) throws RequestNotValidException, PublicationTypeExistsException;
    GetPublicationTypeResponse getPublicationType(GetPublicationTypeRequest getPublicationTypeRequest) throws RequestNotValidException, PublicationTypeDoesntExist;
    ModifyPublicationTypeResponse modifyPublicationType(ModifyPublicationTypeRequest modifyPublicationTypeRequest) throws RequestNotValidException;
    GetPublicationsForPersonResponse getPublicationsForPerson(GetPublicationsForPersonRequest getPublicationsForPersonRequest) throws RequestNotValidException;
    GetPublicationsForGroupResponse getPublicationsForGroup(GetPublicationsForGroupRequest getPublicationsForGroupRequest) throws RequestNotValidException;
    CalcAccreditationPointsForPersonResponse calcAccreditationPointsForPerson(CalcAccreditationPointsForPersonRequest calcAccreditationPointsForPersonRequest) throws RequestNotValidException, PersonDoesNotExist;
    CalcAccreditationPointsForGroupResponse calcAccreditationPointsForGroup(CalcAccreditationPointsForGroupRequest calcAccreditationPointsForGroupRequest) throws RequestNotValidException, GroupDoesNotExist;
}
