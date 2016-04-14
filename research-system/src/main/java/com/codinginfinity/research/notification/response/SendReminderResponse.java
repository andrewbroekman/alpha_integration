package com.codinginfinity.research.notification.response;

import com.codinginfinity.research.notification.ReminderRequest;
import com.codinginfinity.research.services.Response;

import javax.validation.constraints.NotNull;

/**
 * Created by Claudio on 2016/04/14.
 */
public class SendReminderResponse implements Response {

    private static final long serialVersionUID = -3822763195673461747L;

    @NotNull
    private boolean success;

    public SendReminderResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
