package com.codinginfinity.research.notification.response;

import com.codinginfinity.research.notification.BroadcastNotificationRequest;
import com.codinginfinity.research.services.Response;

import javax.validation.constraints.NotNull;

/**
 * Created by Claudio on 2016/04/13.
 */
public class SendBroadcastNotificationResponse implements Response {

    private static final long serialVersionUID = 1372180569984221556L;

    @NotNull
    private BroadcastNotificationRequest broadcastNotificationRequest;

    public BroadcastNotificationRequest getBroadcastNotificationRequest() {

        return broadcastNotificationRequest;

    }

    public void setBroadcastNotificationRequest(BroadcastNotificationRequest broadcastNotificationRequest) {

        this.broadcastNotificationRequest = broadcastNotificationRequest;

    }
}
