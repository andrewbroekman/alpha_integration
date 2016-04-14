package com.codinginfinity.research.notification;

import javax.validation.constraints.NotNull;

/**
 * Created by andrew on 2016/04/11.
 */
public class UserNotificationRequest extends NotificationRequest{

    private static final long serialVersionUID = 2873636705310644918L;

    @NotNull
    private long user;

    public long getUser() {

        return user;

    }

    public void setUser(long user) {

        this.user = user;

    }
}
