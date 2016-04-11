package com.codinginfinity.research.publication.defaultImpl;

import com.codinginfinity.research.notification.INotifications;
import com.codinginfinity.research.publication.IPublications;
import com.codinginfinity.research.publication.request.*;
import com.codinginfinity.research.publication.response.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by andrew on 2016/04/11.
 */
public class Publications implements IPublications {

    @Inject
    private INotifications notifications;

    @Inject
    private EntityManager manager;

    @Override
    public AddPublicationResponse addPublication(AddPublicationRequest addPublicationRequest) {
        return null;
    }

    @Override
    public GetPublicationResponse getPublication(GetPublicationRequest getPublicationRequest) {
        return null;
    }

    @Override
    public CreatePublicationResponse createPublication(CreatePublicationRequest createPublicationRequest) {
        return null;
    }

    @Override
    public ChangePublicationStateResponse changePublicationState(ChangePublicationStateRequest changePublicationStateRequest) {
        return null;
    }

    @Override
    public AddPublicationTypeResponse addPublicationType(AddPublicationTypeRequest addPublicationTypeRequest) {
        return null;
    }

    @Override
    public GetPublicationTypeResponse getPublicationType(GetPublicationTypeRequest getPublicationRequest) {
        return null;
    }

    @Override
    public ModifyPublicationTypeResponse modifyPublicationType(ModifyPublicationTypeRequest modifyPublicationTypeRequest) {
        return null;
    }

    @Override
    public GetPublicationsForPersonResponse getPublicationsForPerson(GetPublicationsForPersonRequest getPublicationsForPersonRequest) {
        return null;
    }

    @Override
    public GetPublicationsForGroupResponse getPublicationsForGroup(GetPublicationsForGroupRequest getPublicationsForGroupRequest) {
        return null;
    }

    @Override
    public CalcAccreditationPointsForPersonResponse calcAccreditationPointsForPerson(CalcAccreditationPointsForPersonRequest calcAccreditationPointsForPersonRequest) {
        return null;
    }

    @Override
    public CalcAccreditationPointsForGroupResponse calcAccreditationPointsForGroup(CalcAccreditationPointsForGroupRequest calcAccreditationPointsForGroupRequest) {
        return null;
    }
}
