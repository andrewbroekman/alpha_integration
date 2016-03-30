package com.codinginfinity.research.rest;

import javax.inject.Inject;
import javax.management.Notification;
import javax.ws.rs.*;


/**
 * Created by Brenton on 3/28/2016.
 */
@Path("notification")
public class NotificationsResource
{

    @GET
    @Path("/report")
    public void send(Notification notification)
    {
        notifications.sendReport(new ReportNotificationRequest (notification));
    }

    @GET
    @Path("/activity")
    public void send(Notification notification)
    {
        notifications.sendActivityNotification(new ActivityNotificationRequest (notification));
    }

    @GET
    @Path("/reminder")
    public void send(Notification notification)
    {
        notifications.sendReminder(new ReminderRequest (notification));
    }

    @GET
    @Path("/broad")
    public void send(Notification notification)
    {
        notifications.sendBroadNotification(new BroadNotificationRequest (notification));
    }

    @Inject
    Notifications notifications;
}

