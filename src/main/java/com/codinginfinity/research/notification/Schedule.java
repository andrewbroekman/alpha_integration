package com.codinginfinity.research.notification;

import com.codinginfinity.research.core.BaseEntity;

import java.time.LocalDateTime;

/**
 * Created by andrew on 2016/04/11.
 */
public class Schedule extends BaseEntity {

    private static final long serialVersionUID = -5405672375689819587L;

    private LocalDateTime startDate;
    private String name;
    private RepeatRequest repeatRequest;

    public Schedule() {
    }
}
