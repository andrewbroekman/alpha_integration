package com.codinginfinity.research.notification;

import com.codinginfinity.research.people.User;

import java.util.ArrayList;

/**
 * Created by andrew on 2016/04/11.
 */
public class BroadcastNotificationRequest extends NotificationRequest {

    private static final long serialVersionUID = -2268049475697357446L;

    private Schedule schedule;
    private String message;
    private ArrayList<Long> broadcastList;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Long> getBroadcastList() {
        return broadcastList;
    }

    public void setBroadcastList(ArrayList<Long> broadcastList) {
        this.broadcastList = broadcastList;
    }
}
