package com.codinginfinity.research.notification.request;

import com.codinginfinity.research.notification.BroadcastNotificationRequest;
import com.codinginfinity.research.services.Request;

import javax.validation.constraints.NotNull;

/**
 * Created by Claudio on 2016/04/13.
 */
public class SendBroadcastNotificationRequest implements Request {

    private static final long serialVersionUID = -8917518377330673736L;

    @NotNull
    private BroadcastNotificationRequest broadcastNotificationRequest;

    public BroadcastNotificationRequest getBroadcastNotificationRequest() {

        return broadcastNotificationRequest;

    }

    public void setBroadcastNotificationRequest(BroadcastNotificationRequest broadcastNotificationRequest) {

        this.broadcastNotificationRequest = broadcastNotificationRequest;

    }
}
