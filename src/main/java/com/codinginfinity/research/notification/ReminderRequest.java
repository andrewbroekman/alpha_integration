package com.codinginfinity.research.notification;

import java.time.LocalDateTime;

/**
 * Created by andrew on 2016/04/11.
 */
public class ReminderRequest extends UserNotificationRequest {

    private static final long serialVersionUID = -4968631683773137128L;

    private String message;
    private LocalDateTime date;
}
