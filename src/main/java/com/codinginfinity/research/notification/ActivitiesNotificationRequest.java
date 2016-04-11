package com.codinginfinity.research.notification;

import javax.validation.constraints.NotNull;

/**
 * Created by andrew on 2016/04/11.
 */
public class ActivitiesNotificationRequest extends UserNotificationRequest {

    private static final long serialVersionUID = 7720159516379201547L;

    @NotNull
    private long publication;
}
