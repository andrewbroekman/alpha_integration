package com.codinginfinity.research.notification.defaultImpl;

import com.codinginfinity.research.notification.INotification;
import com.codinginfinity.research.notification.exceptions.EmailInvalidException;
import com.codinginfinity.research.notification.exceptions.SendEmailFailedException;
import com.codinginfinity.research.notification.request.SendActivityNotificationRequest;
import com.codinginfinity.research.notification.request.SendBroadcastNotificationRequest;
import com.codinginfinity.research.notification.request.SendReportNotificationRequest;
import com.codinginfinity.research.notification.response.SendActivityNotificationResponse;
import com.codinginfinity.research.notification.response.SendBroadcastNotificationResponse;
import com.codinginfinity.research.notification.response.SendReportNotificationResponse;
import com.codinginfinity.research.services.RequestNotValidException;

/**
 * Created by Claudio on 2016/04/13.
 */
public class Notification implements INotification {

    @Override
    public SendActivityNotificationResponse sendActivityNotification(SendActivityNotificationRequest sendActivityNotificationRequest) throws RequestNotValidException, EmailInvalidException, SendEmailFailedException {
        return null;
    }

    @Override
    public SendReportNotificationResponse sendReportNotification(SendReportNotificationRequest sendReportNotificationRequest) throws RequestNotValidException, EmailInvalidException, SendEmailFailedException {
        return null;
    }

    @Override
    public SendBroadcastNotificationResponse sendBroadcastNotification(SendBroadcastNotificationRequest sendBroadcastNotificationRequest) throws RequestNotValidException, EmailInvalidException, SendEmailFailedException {
        return null;
    }
}
