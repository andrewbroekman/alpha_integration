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
import com.codinginfinity.research.people.EmailAddress;
import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.people.response.EditPersonDetailsResponse;
import com.codinginfinity.research.publication.Publication;
import com.codinginfinity.research.publication.PublicationDetails;
import com.codinginfinity.research.reporting.ReportingMock;
import com.codinginfinity.research.reporting.request.GetProgressReportRequest;
import com.codinginfinity.research.services.RequestNotValidException;
import com.codinginfinity.research.services.mocking.BaseMock;
import com.codinginfinity.research.services.mocking.Mock;
import com.codinginfinity.research.validation.beanvalidation.services.ServiceValidationUtilities;
import org.springframework.stereotype.Service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;


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
    public SendActivityNotificationResponse sendActivityNotification(SendActivityNotificationRequest sendActivityNotificationRequest)
            throws RequestNotValidException, EmailInvalidException, SendEmailFailedException, InvalidDateException {

        serviceValidationUtilities.validateRequest(SendActivityNotificationRequest.class, sendActivityNotificationRequest);

        if(getState() == State.EmailInvalidException)
            throw new EmailInvalidException();
        else if (getState() == State.SendEmailFailedException)
            throw new SendEmailFailedException();
        else
        {
            Person p = new Person("Claudio", "Da Silva", new EmailAddress("c.m.dasilva@live.co.za"));
            PublicationDetails pub = new PublicationDetails("Neural networks paper", LocalDate.parse("2016-08-15",
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String subjectLine = "Activity on " + pub.getTitle() + " (" + LocalDateTime.now().format(formatter) +")";

            return new SendActivityNotificationResponse( sendEmail(
                    p.getFirstName() + " " + p.getSurname(), p.getPrimaryEmail().getAddress(),
                    subjectLine,"Testing formatting"));
        }

    }

    @Override
    public SendReportNotificationResponse sendReportNotification(SendReportNotificationRequest sendReportNotificationRequest)
            throws RequestNotValidException, EmailInvalidException, SendEmailFailedException, InvalidDateException {

        if(getState() == State.EmailInvalidException)
            throw new EmailInvalidException();
        else if (getState() == State.InvalidDateException)
            throw new InvalidDateException();
        else if (getState() == State.SendEmailFailedException)
            throw new SendEmailFailedException();
        else
        {
//            Person p = new Person("Claudio", "Da Silva", new EmailAddress("c.m.dasilva@live.co.za"));
//            ReportingMock report = new ReportingMock();
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            String subjectLine = "Report as of " + "(" + LocalDateTime.now().format(formatter) +")";
//
//            return new SendReportNotificationResponse(sendEmail(
//                    p.getFirstName() + " " + p.getSurname(), p.getPrimaryEmail().getAddress(),
//                    subjectLine,report.getProgressReportResponse(new GetProgressReportRequest()).getReportString()));
        }

    }

    @Override
    public SendBroadcastNotificationResponse sendBroadcastNotification(SendBroadcastNotificationRequest sendBroadcastNotificationRequest)
            throws RequestNotValidException, EmailInvalidException, SendEmailFailedException, InvalidDateException {

        if(getState() == State.EmailInvalidException)
            throw new EmailInvalidException();
        else if (getState() == State.InvalidDateException)
            throw new InvalidDateException();
        else if (getState() == State.SendEmailFailedException)
            throw new SendEmailFailedException();
        else
        {
            // SendEmail
            return new SendBroadcastNotificationResponse(false);
        }

    }

    @Override
    public SendReminderResponse sendReminderRequest(SendReminderRequest sendReminderRequest)
            throws RequestNotValidException, EmailInvalidException, SendEmailFailedException, InvalidDateException {

        if(getState() == State.EmailInvalidException)
            throw new EmailInvalidException();
        else if (getState() == State.InvalidDateException)
            throw new InvalidDateException();
        else if (getState() == State.SendEmailFailedException)
            throw new SendEmailFailedException();
        else
        {
            // SendEmail
            return new SendReminderResponse(false);
        }

    }

    public boolean sendEmail(String name, String recipient, String subject, String body)
    {

        String mailFrom = "alphaintegrationteam@gmail.com";

        try
        {

            Properties properties = System.getProperties();
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.starttls.required", "true");
            properties.put("mail.smtp.auth", "true");
            properties.setProperty("mail.smtp.host", "smtp.gmail.com");

            MimeMessage message = new MimeMessage( Session.getDefaultInstance(properties,
                    new javax.mail.Authenticator(){
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(
                                    mailFrom, "alphaintegrate");
                        }
                    }));

            message.setFrom(new InternetAddress(mailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(body);
//            message.setContent(message, "text/html; charset=utf-8");
//            message.setSentDate(new Date());

            Transport.send(message);

        }
        catch (AddressException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        catch (MessagingException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public enum State implements Mock.State{externalRequirementsMet, EmailInvalidException, InvalidDateException, SendEmailFailedException}

    @Inject
    private ServiceValidationUtilities serviceValidationUtilities;
}
