package com.codinginfinity.research.notification;

import com.codinginfinity.research.notification.defaultImpl.Notification;
import com.codinginfinity.research.notification.exceptions.EmailInvalidException;
import com.codinginfinity.research.notification.exceptions.SendEmailFailedException;
import com.codinginfinity.research.notification.request.SendActivityNotificationRequest;
import com.codinginfinity.research.notification.request.SendReportNotificationRequest;
import com.codinginfinity.research.people.EmailAddress;
import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.people.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NotificationTest.class})
@ComponentScan("com.codinginfinity.research")
public class NotificationTest {

    @Inject
    private NotificationMock notificationMock;


    //////////////////////////
    // Activity tests
    //////////////////////////


    @Test
    public void sendActivityTest() throws Exception{

        notificationMock.setState(NotificationMock.State.externalRequirementsMet);

        long u = 12345;
        long p = 12345;

        ActivitiesNotificationRequest actNot = new ActivitiesNotificationRequest();
        actNot.setUser(u);
        actNot.setPublication(p);

        SendActivityNotificationRequest actReq =  new SendActivityNotificationRequest();
        actReq.setActivitiesNotificationRequest(actNot);

        notificationMock.sendActivityNotification(actReq);

    }

    @Test(expected = EmailInvalidException.class)
    public void sendInvalidEmailActivityTest() throws Exception{

        notificationMock.setState(NotificationMock.State.EmailInvalidException);

        long u = 11111;
        long p = 12345;

        ActivitiesNotificationRequest actNot = new ActivitiesNotificationRequest();
        actNot.setUser(u);
        actNot.setPublication(p);

        SendActivityNotificationRequest actReq =  new SendActivityNotificationRequest();
        actReq.setActivitiesNotificationRequest(actNot);

        notificationMock.sendActivityNotification(actReq);

    }

    @Test(expected = SendEmailFailedException.class)
    public void sendFailedActivityTest() throws Exception{

        notificationMock.setState(NotificationMock.State.SendEmailFailedException);

        long u = 12345;
        long p = 12345;

        ActivitiesNotificationRequest actNot = new ActivitiesNotificationRequest();
        actNot.setUser(u);
        actNot.setPublication(p);

        SendActivityNotificationRequest actReq =  new SendActivityNotificationRequest();
        actReq.setActivitiesNotificationRequest(actNot);

        notificationMock.sendActivityNotification(actReq);

    }



    //////////////////////////
    // Report tests
    //////////////////////////



    @Test
    public void sendReportTest() throws Exception{

        notificationMock.setState(NotificationMock.State.externalRequirementsMet);

        long u = 12345;
        long p = 12345;

        DurationUnit unit = DurationUnit.WEEKS;

        Interval i = new Interval();
        i.setDuration(1);
        i.setDurationUnit(unit);

        RepeatRequest r = new RepeatRequest();
        r.setEndDate(null);
        r.setInterval(i);

        Schedule s = new Schedule();
        LocalDateTime dt = LocalDateTime.parse("2016-04-15 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        s.setStartDate(dt);
        s.setName("Scheduled Progress Report");
        s.setRepeatRequest(r);

        ReportNotificationRequest repNot = new ReportNotificationRequest();
        repNot.setUser(u);
        repNot.setSchedule(s);

        SendReportNotificationRequest repReq = new SendReportNotificationRequest();
        repReq.setReportNotificationRequest(repNot);

        notificationMock.sendReportNotification(repReq);

    }

//    @Test
//    public void sendBroadcastTest() throws Exception{
//
//        notificationMock.setState(NotificationMock.State.externalRequirementsMet);
//
//        User u = new User();
//        Person p = createValidEmailPerson();
//
//        BroadcastNotificationRequest broadNot = new BroadcastNotificationRequest();
//
//    }
//
//    @Test
//    public void sendReminderTest() throws Exception{
//
//        notificationMock.setState(NotificationMock.State.externalRequirementsMet);
//
//        User u = new User();
//        Person p = createValidEmailPerson();
//
//        ReminderRequest reminder = new ReminderRequest();
//        reminder.setUser(u);
//
//    }

}
