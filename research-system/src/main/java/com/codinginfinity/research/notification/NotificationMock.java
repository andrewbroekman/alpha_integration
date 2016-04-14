package com.codinginfinity.research.notification;

import com.codinginfinity.research.notification.exceptions.EmailInvalidException;
import com.codinginfinity.research.notification.exceptions.SendEmailFailedException;
import com.codinginfinity.research.notification.request.SendActivityNotificationRequest;
import com.codinginfinity.research.notification.request.SendBroadcastNotificationRequest;
import com.codinginfinity.research.notification.request.SendReportNotificationRequest;
import com.codinginfinity.research.notification.response.SendActivityNotificationResponse;
import com.codinginfinity.research.notification.response.SendBroadcastNotificationResponse;
import com.codinginfinity.research.notification.response.SendReportNotificationResponse;
import com.codinginfinity.research.services.RequestNotValidException;
import com.codinginfinity.research.services.mocking.BaseMock;
import com.codinginfinity.research.services.mocking.Mock;
import com.codinginfinity.research.validation.beanvalidation.services.ServiceValidationUtilities;
import org.springframework.stereotype.Service;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Claudio on 2016/04/14.
 */
@Stateless
@Service
public class NotificationMock extends BaseMock implements INotification {

    public NotificationMock() {

        setState(State.externalRequirementsMet);

    }

    @Override
    public SendActivityNotificationResponse sendActivityNotification(SendActivityNotificationRequest sendActivityNotificationRequest) throws RequestNotValidException, EmailInvalidException, SendEmailFailedException {
        serviceValidationUtilities.validateRequest(SendActivityNotificationRequest.class, sendActivityNotificationRequest);

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

    public enum State implements Mock.State{externalRequirementsMet, EmailInvalidException, SendEmailFailedException}

    @Inject
    private ServiceValidationUtilities serviceValidationUtilities;
}
