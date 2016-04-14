package com.codinginfinity.research.notification.response;

import com.codinginfinity.research.notification.ActivitiesNotificationRequest;
import com.codinginfinity.research.services.Response;

import javax.validation.constraints.NotNull;

/**
 * Created by Claudio on 2016/04/13.
 */
public class SendActivityNotificationResponse implements Response {


    private static final long serialVersionUID = 8212503469686352558L;

    @NotNull
    private boolean success;

    public SendActivityNotificationResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
