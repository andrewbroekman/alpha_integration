package com.codinginfinity.research.notification.request;

import com.codinginfinity.research.notification.ReminderRequest;
import com.codinginfinity.research.services.Request;

import javax.validation.constraints.NotNull;

/**
 * Created by Claudio on 2016/04/14.
 */
public class SendReminderRequest implements Request {

    private static final long serialVersionUID = 6873186831884149044L;

    @NotNull
    private ReminderRequest reminderRequest;

    public ReminderRequest getReminderRequest() {

        return reminderRequest;

    }

    public void setReminderRequest(ReminderRequest reminderRequest) {

        this.reminderRequest = reminderRequest;

    }
}
