package com.codinginfinity.research.notification;

import javax.validation.constraints.NotNull;

/**
 * Created by andrew on 2016/04/11.
 */
public class ReportNotificationRequest extends UserNotificationRequest {

    private static final long serialVersionUID = 7942377441679963077L;

    @NotNull
    private Schedule schedule;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
