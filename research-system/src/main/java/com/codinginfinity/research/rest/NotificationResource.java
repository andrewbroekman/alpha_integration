package com.codinginfinity.research.rest;

import com.codinginfinity.research.notification.INotification;
import com.codinginfinity.research.notification.exceptions.EmailInvalidException;
import com.codinginfinity.research.notification.exceptions.InvalidDateException;
import com.codinginfinity.research.notification.exceptions.SendEmailFailedException;
import com.codinginfinity.research.notification.request.SendActivityNotificationRequest;
import com.codinginfinity.research.notification.request.SendBroadcastNotificationRequest;
import com.codinginfinity.research.notification.request.SendReminderRequest;
import com.codinginfinity.research.notification.request.SendReportNotificationRequest;
import com.codinginfinity.research.notification.response.SendActivityNotificationResponse;
import com.codinginfinity.research.notification.response.SendBroadcastNotificationResponse;
import com.codinginfinity.research.notification.response.SendReminderResponse;
import com.codinginfinity.research.notification.response.SendReportNotificationResponse;
import com.codinginfinity.research.people.IPeople;
import com.codinginfinity.research.services.RequestNotValidException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Claudio on 2016/04/15.
 */
@Path("notification")
public class NotificationResource {

    @Inject
    private INotification notification;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response sendActivityNotification(SendActivityNotificationRequest req){
        try {
            SendActivityNotificationResponse resp = notification.sendActivityNotification(req);
            return javax.ws.rs.core.Response.status(200).entity(resp).build();
        }catch(EmailInvalidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(InvalidDateException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(SendEmailFailedException e){
            return javax.ws.rs.core.Response.status(500).build();
        }catch (RequestNotValidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(Exception e){
            return javax.ws.rs.core.Response.status(500).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response sendBroadcastNotification(SendBroadcastNotificationRequest req){
        try {
            SendBroadcastNotificationResponse resp = notification.sendBroadcastNotification(req);
            return javax.ws.rs.core.Response.status(200).entity(resp).build();
        }catch(EmailInvalidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(SendEmailFailedException e){
            return javax.ws.rs.core.Response.status(500).build();
        }catch (RequestNotValidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(Exception e){
            return javax.ws.rs.core.Response.status(500).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response sendReportNotification(SendReportNotificationRequest req){
        try {
            SendReportNotificationResponse resp = notification.sendReportNotification(req);
            return javax.ws.rs.core.Response.status(200).entity(resp).build();
        }catch(EmailInvalidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(InvalidDateException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(SendEmailFailedException e){
            return javax.ws.rs.core.Response.status(500).build();
        }catch (RequestNotValidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(Exception e){
            return javax.ws.rs.core.Response.status(500).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response sendReminderRequest(SendReminderRequest req){
        try {
            SendReminderResponse resp = notification.sendReminderRequest(req);
            return javax.ws.rs.core.Response.status(200).entity(resp).build();
        }catch(EmailInvalidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(InvalidDateException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(SendEmailFailedException e){
            return javax.ws.rs.core.Response.status(500).build();
        }catch (RequestNotValidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(Exception e){
            return javax.ws.rs.core.Response.status(500).build();
        }

    }

}
