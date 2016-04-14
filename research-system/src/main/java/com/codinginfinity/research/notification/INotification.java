package com.codinginfinity.research.notification;

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
import com.codinginfinity.research.services.RequestNotValidException;

/**
 * Created by andrew on 2016/04/11.
 */
public interface INotification {

    SendActivityNotificationResponse sendActivityNotification(SendActivityNotificationRequest sendActivityNotificationRequest)
            throws RequestNotValidException,EmailInvalidException, SendEmailFailedException, InvalidDateException;
    SendReportNotificationResponse sendReportNotification(SendReportNotificationRequest sendReportNotificationRequest)
            throws RequestNotValidException,EmailInvalidException, SendEmailFailedException, InvalidDateException;
    SendBroadcastNotificationResponse sendBroadcastNotification(SendBroadcastNotificationRequest sendBroadcastNotificationRequest)
            throws RequestNotValidException,EmailInvalidException, SendEmailFailedException, InvalidDateException;
    SendReminderResponse sendReminderRequest(SendReminderRequest sendReminderRequest)
            throws RequestNotValidException,EmailInvalidException, SendEmailFailedException, InvalidDateException;
}
