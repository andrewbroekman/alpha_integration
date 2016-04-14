package com.codinginfinity.research.publication;

import com.codinginfinity.research.core.BaseEntity;

import java.util.Date;

/**
 * Created by andrew on 2016/04/11.
 */
public class Period extends BaseEntity {

    private static final long serialVersionUID = 8759315115752048504L;

    private Date start;
    private Date end;

    public Period() {
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Period(Date start, Date end) {

        this.start = start;
        this.end = end;
    }
}
