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
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;


/**
 * Created by Claudio on 2016/04/14.
 */
@Stateless
@Service
@SuppressWarnings("Duplicates")
public class NotificationMock extends BaseMock implements INotification {

    @Inject
    private ReportingMock reportingMock;

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
//            Person p = new Person("Claudio", "Da Silva", new EmailAddress("alphaintegrationteam@gmail.com"));
//            PublicationDetails pub = new PublicationDetails("Neural networks paper", LocalDate.parse("2016-08-15",
//                    DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            String subjectLine = "Activity on " + pub.getTitle() + " during (" + LocalDateTime.now().format(formatter) +")";
//
//            return new SendActivityNotificationResponse( sendEmail(
//                    p.getFirstName() + " " + p.getSurname(), p.getPrimaryEmail().getAddress(),
//                    subjectLine,createBody("Activity update",
//                            sendActivityNotificationRequest.getActivitiesNotificationRequest().getChanges() +
//                    pub.getTitle())));

            return new SendActivityNotificationResponse(true);
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
//            Person p = new Person("Claudio", "Da Silva", new EmailAddress("alphaintegrationteam@gmail.com"));
//            ReportingMock report = new ReportingMock();
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            String subjectLine = "Report as of " + "(" + LocalDateTime.now().format(formatter) +")";
//            String svgXML = report.getProgressReportResponse(new GetProgressReportRequest()).getResponseString();
//
//            return new SendReportNotificationResponse(sendEmail(
//                    p.getFirstName() + " " + p.getSurname(), p.getPrimaryEmail().getAddress(),
//                    subjectLine,
//                    createBody( "Report",
//                            reportingMock.getProgressReportResponse(new GetProgressReportRequest()).getResponseString() )));

            return new SendReportNotificationResponse(true);
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
//            Person p = new Person("Claudio", "Da Silva", new EmailAddress("alphaintegrationteam@gmail.com"));
//
//            ArrayList<Person> pList = new ArrayList<Person>();
//            pList.add(new Person( "Andrew", "Broekman", new EmailAddress("alphaintegrationteam@gmail.com") ) );
//            pList.add(new Person( "Reinhardt", "Cromhout", new EmailAddress("alphaintegrationteam@gmail.com") ) );
//            pList.add(new Person( "Rohan", "Chhipa", new EmailAddress("alphaintegrationteam@gmail.com") ) );
//            pList.add(new Person( "Fabio", "Loreggian", new EmailAddress("alphaintegrationteam@gmail.com") ) );
//            pList.add(new Person( "Brenton", "Watt", new EmailAddress("alphaintegrationteam@gmail.com") ) );
//
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            String subjectLine = "Broadcast from " + p.getFirstName() + " " + p.getSurname() + " <" +
//                    p.getPrimaryEmail().getAddress() + "> on (" + LocalDateTime.now().format(formatter) +")";
//
//            return new SendBroadcastNotificationResponse(sendEmail(
//                    p.getFirstName() + " " + p.getSurname(), p.getPrimaryEmail().getAddress(), subjectLine,
//                    sendBroadcastNotificationRequest.getBroadcastNotificationRequest().getMessage(), pList));

            return new SendBroadcastNotificationResponse(true);
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
//            Person p = new Person("Claudio", "Da Silva", new EmailAddress("alphaintegrationteam@gmail.com"));
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            String subjectLine = "Reminder request for (" + LocalDateTime.now().format(formatter) +")";
//
//            return new SendReminderResponse(sendEmail(
//                    p.getFirstName() + " " + p.getSurname(), p.getPrimaryEmail().getAddress(),
//                    subjectLine,
//                    createBody("Reminder request",sendReminderRequest.getReminderRequest().getMessage() )));

            return new SendReminderResponse(true);
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
            message.setContent(body, "text/html; charset=utf-8");

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

    public boolean sendEmail(String name, String sender, String subject, String body, ArrayList<Person> pList)
    {
        boolean success = false;

        while ( !pList.isEmpty() )
        {
            Person p = pList.remove(0);
            sendEmail(name, p.getPrimaryEmail().getAddress(), subject,
                    createBody("Broadcast notification from " + name + " (" + sender + ")", body) );
        }

        return success;
    }

    public String createBody(String type, String body)
    {
        return "<h1 style=\"background-color: #CCCCCC; border: 2px solid #003366; padding: 10px; margin-bottom: 50px;\">CS Research Management System</h1>" +
                "<h2 style=\"margin-bottom: 50px;\">" + type + "</h2>" + body + "<div style=\"margin-top: 50px;\">" +
                "<strong><p>Kind regards</p><p>The CS Team</p><a href=\"www.cs.up.ac.za\">www.cs.up.ac.za</a></strong></div>";
    }

    public enum State implements Mock.State{externalRequirementsMet, EmailInvalidException, InvalidDateException, SendEmailFailedException}

    @Inject
    private ServiceValidationUtilities serviceValidationUtilities;
}
