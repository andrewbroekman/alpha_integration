package com.codinginfinity.research.notification.request;

import com.codinginfinity.research.notification.ActivitiesNotificationRequest;
import com.codinginfinity.research.services.Request;

import javax.validation.constraints.NotNull;

/**
 * Created by Claudio on 2016/04/13.
 */
public class SendActivityNotificationRequest implements Request {

    private static final long serialVersionUID = 8170713551216458217L;

    @NotNull
    private ActivitiesNotificationRequest activitiesNotificationRequest;

    public ActivitiesNotificationRequest getActivitiesNotificationRequest() {

        return activitiesNotificationRequest;

    }

    public void setActivitiesNotificationRequest(ActivitiesNotificationRequest activitiesNotificationRequest) {

        this.activitiesNotificationRequest = activitiesNotificationRequest;

    }
}
