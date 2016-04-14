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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RepeatRequest getRepeatRequest() {
        return repeatRequest;
    }

    public void setRepeatRequest(RepeatRequest repeatRequest) {
        this.repeatRequest = repeatRequest;
    }
}
