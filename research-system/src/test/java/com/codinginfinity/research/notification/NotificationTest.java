package com.codinginfinity.research.notification;

import com.codinginfinity.research.notification.defaultImpl.Notification;
import com.codinginfinity.research.notification.exceptions.EmailInvalidException;
import com.codinginfinity.research.notification.exceptions.InvalidDateException;
import com.codinginfinity.research.notification.exceptions.SendEmailFailedException;
import com.codinginfinity.research.notification.request.SendActivityNotificationRequest;
import com.codinginfinity.research.notification.request.SendBroadcastNotificationRequest;
import com.codinginfinity.research.notification.request.SendReminderRequest;
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
@Ignore
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

    @Test(expected = EmailInvalidException.class)
    public void sendInvalidEmailReportTest() throws Exception{

        notificationMock.setState(NotificationMock.State.EmailInvalidException);

        long u = 11111;
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
        s.setName("Invalid Email Scheduled Progress Report");
        s.setRepeatRequest(r);

        ReportNotificationRequest repNot = new ReportNotificationRequest();
        repNot.setUser(u);
        repNot.setSchedule(s);

        SendReportNotificationRequest repReq = new SendReportNotificationRequest();
        repReq.setReportNotificationRequest(repNot);

        notificationMock.sendReportNotification(repReq);

    }

    @Test(expected = InvalidDateException.class)
    public void sendInvalidDateReportTest() throws Exception{

        notificationMock.setState(NotificationMock.State.InvalidDateException);

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
        LocalDateTime dt = LocalDateTime.parse("1942-08-13 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        s.setStartDate(dt);
        s.setName("Invalid Date Scheduled Progress Report");
        s.setRepeatRequest(r);

        ReportNotificationRequest repNot = new ReportNotificationRequest();
        repNot.setUser(u);
        repNot.setSchedule(s);

        SendReportNotificationRequest repReq = new SendReportNotificationRequest();
        repReq.setReportNotificationRequest(repNot);

        notificationMock.sendReportNotification(repReq);

    }

    @Test(expected = SendEmailFailedException.class)
    public void sendFailedReportTest() throws Exception{

        notificationMock.setState(NotificationMock.State.SendEmailFailedException);

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
        s.setName("Failed Scheduled Progress Report");
        s.setRepeatRequest(r);

        ReportNotificationRequest repNot = new ReportNotificationRequest();
        repNot.setUser(u);
        repNot.setSchedule(s);

        SendReportNotificationRequest repReq = new SendReportNotificationRequest();
        repReq.setReportNotificationRequest(repNot);

        notificationMock.sendReportNotification(repReq);

    }



    //////////////////////////
    // Broadcast tests
    //////////////////////////



    @Test
    public void sendBroadcastTest() throws Exception{

        notificationMock.setState(NotificationMock.State.externalRequirementsMet);

        long u = 12345;
        long p = 12345;

        long user1 = 22222;
        long user2 = 33333;
        long user3 = 44444;

        ArrayList<Long> list = new ArrayList<Long>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        DurationUnit unit = DurationUnit.DAYS;

        Interval i = new Interval();
        i.setDuration(2);
        i.setDurationUnit(unit);

        RepeatRequest r = new RepeatRequest();
        LocalDateTime dt = LocalDateTime.parse("2016-06-18 14:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        r.setEndDate(dt);
        r.setInterval(i);

        Schedule s = new Schedule();
        LocalDateTime dt2 = LocalDateTime.parse("2016-04-15 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        s.setStartDate(dt2);
        s.setName("COS 301 attempt to get on the same page with each other for lecturers");
        s.setRepeatRequest(r);

        BroadcastNotificationRequest broadNot = new BroadcastNotificationRequest();
        broadNot.setSchedule(s);
        broadNot.setMessage("Remember to teach students how to use the frameworks properly");
        broadNot.setBroadcastList(list);

        SendBroadcastNotificationRequest broadReq = new SendBroadcastNotificationRequest();
        broadReq.setBroadcastNotificationRequest(broadNot);

        notificationMock.sendBroadcastNotification(broadReq);

    }

    @Test(expected = EmailInvalidException.class)
    public void sendInvalidEmailBroadcastTest() throws Exception{

        notificationMock.setState(NotificationMock.State.EmailInvalidException);

        long u = 11111;
        long p = 12345;

        long user1 = 11111;
        long user2 = 33333;
        long user3 = 44444;

        ArrayList<Long> list = new ArrayList<Long>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        DurationUnit unit = DurationUnit.DAYS;

        Interval i = new Interval();
        i.setDuration(2);
        i.setDurationUnit(unit);

        RepeatRequest r = new RepeatRequest();
        LocalDateTime dt = LocalDateTime.parse("2016-06-18 14:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        r.setEndDate(dt);
        r.setInterval(i);

        Schedule s = new Schedule();
        LocalDateTime dt2 = LocalDateTime.parse("2016-04-15 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        s.setStartDate(dt2);
        s.setName("COS 301 attempt to get on the same page with each other for lecturers");
        s.setRepeatRequest(r);

        BroadcastNotificationRequest broadNot = new BroadcastNotificationRequest();
        broadNot.setSchedule(s);
        broadNot.setMessage("Remember to teach students how to use the frameworks properly");
        broadNot.setBroadcastList(list);

        SendBroadcastNotificationRequest broadReq = new SendBroadcastNotificationRequest();
        broadReq.setBroadcastNotificationRequest(broadNot);

        notificationMock.sendBroadcastNotification(broadReq);

    }

    @Test(expected = InvalidDateException.class)
    public void sendInvalidDateBroadcastTest() throws Exception{

        notificationMock.setState(NotificationMock.State.InvalidDateException);

        long u = 12345;
        long p = 12345;

        long user1 = 22222;
        long user2 = 33333;
        long user3 = 44444;

        ArrayList<Long> list = new ArrayList<Long>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        DurationUnit unit = DurationUnit.DAYS;

        Interval i = new Interval();
        i.setDuration(2);
        i.setDurationUnit(unit);

        RepeatRequest r = new RepeatRequest();
        LocalDateTime dt = LocalDateTime.parse("1111-11-11 16:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        r.setEndDate(dt);
        r.setInterval(i);

        Schedule s = new Schedule();
        LocalDateTime dt2 = LocalDateTime.parse("2016-04-15 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        s.setStartDate(dt2);
        s.setName("COS 301 attempt to get on the same page with each other for lecturers");
        s.setRepeatRequest(r);

        BroadcastNotificationRequest broadNot = new BroadcastNotificationRequest();
        broadNot.setSchedule(s);
        broadNot.setMessage("Remember to teach students how to use the frameworks properly");
        broadNot.setBroadcastList(list);

        SendBroadcastNotificationRequest broadReq = new SendBroadcastNotificationRequest();
        broadReq.setBroadcastNotificationRequest(broadNot);

        notificationMock.sendBroadcastNotification(broadReq);

    }

    @Test(expected = SendEmailFailedException.class)
    public void sendFailedBroadcastTest() throws Exception{

        notificationMock.setState(NotificationMock.State.SendEmailFailedException);

        long u = 12345;
        long p = 12345;

        long user1 = 22222;
        long user2 = 33333;
        long user3 = 44444;

        ArrayList<Long> list = new ArrayList<Long>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        DurationUnit unit = DurationUnit.DAYS;

        Interval i = new Interval();
        i.setDuration(2);
        i.setDurationUnit(unit);

        RepeatRequest r = new RepeatRequest();
        r.setEndDate(null);
        r.setInterval(i);

        Schedule s = new Schedule();
        LocalDateTime dt2 = LocalDateTime.parse("2016-04-15 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        s.setStartDate(dt2);
        s.setName("COS 301 attempt to get on the same page with each other for lecturers");
        s.setRepeatRequest(r);

        BroadcastNotificationRequest broadNot = new BroadcastNotificationRequest();
        broadNot.setSchedule(s);
        broadNot.setMessage("Remember to teach students how to use the frameworks properly");
        broadNot.setBroadcastList(list);

        SendBroadcastNotificationRequest broadReq = new SendBroadcastNotificationRequest();
        broadReq.setBroadcastNotificationRequest(broadNot);

        notificationMock.sendBroadcastNotification(broadReq);

    }



    //////////////////////////
    // Reminder tests
    //////////////////////////



    @Test
    public void sendReminderTest() throws Exception{

        notificationMock.setState(NotificationMock.State.externalRequirementsMet);

        long u = 12345;
        long p = 12345;

        ReminderRequest reminderNot = new ReminderRequest();
        reminderNot.setUser(u);
        reminderNot.setMessage("Learn how to use Spring instead of outdated Glassfish");
        LocalDateTime dt = LocalDateTime.parse("2016-04-15 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        reminderNot.setDate(dt);

        SendReminderRequest reminderReq =  new SendReminderRequest();
        reminderReq.setReminderRequest(reminderNot);

        notificationMock.sendReminderRequest(reminderReq);

    }

    @Test(expected = InvalidDateException.class)
    public void sendInvalidDateReminderTest() throws Exception{

        notificationMock.setState(NotificationMock.State.InvalidDateException);

        long u = 12345;
        long p = 12345;

        ReminderRequest reminderNot = new ReminderRequest();
        reminderNot.setUser(u);
        reminderNot.setMessage("Learn how to use Spring instead of outdated Glassfish");
        LocalDateTime dt = LocalDateTime.parse("1995-05-02 08:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        reminderNot.setDate(dt);

        SendReminderRequest reminderReq =  new SendReminderRequest();
        reminderReq.setReminderRequest(reminderNot);

        notificationMock.sendReminderRequest(reminderReq);

    }

    @Test(expected = EmailInvalidException.class)
    public void sendInvalidEmailReminderTest() throws Exception{

        notificationMock.setState(NotificationMock.State.EmailInvalidException);

        long u = 11111;
        long p = 12345;

        ReminderRequest reminderNot = new ReminderRequest();
        reminderNot.setUser(u);
        reminderNot.setMessage("Learn how to use Spring instead of outdated Glassfish");
        LocalDateTime dt = LocalDateTime.parse("2016-04-15 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        reminderNot.setDate(dt);

        SendReminderRequest reminderReq =  new SendReminderRequest();
        reminderReq.setReminderRequest(reminderNot);

        notificationMock.sendReminderRequest(reminderReq);

    }

    @Test(expected = SendEmailFailedException.class)
    public void sendFailedReminderTest() throws Exception{

        notificationMock.setState(NotificationMock.State.SendEmailFailedException);

        long u = 12345;
        long p = 12345;

        ReminderRequest reminderNot = new ReminderRequest();
        reminderNot.setUser(u);
        reminderNot.setMessage("Learn how to use Spring instead of outdated Glassfish");
        LocalDateTime dt = LocalDateTime.parse("2016-04-15 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        reminderNot.setDate(dt);

        SendReminderRequest reminderReq =  new SendReminderRequest();
        reminderReq.setReminderRequest(reminderNot);

        notificationMock.sendReminderRequest(reminderReq);

    }

}
