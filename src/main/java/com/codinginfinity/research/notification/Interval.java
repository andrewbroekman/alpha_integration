package com.codinginfinity.research.notification;

import com.codinginfinity.research.core.BaseEntity;

/**
 * Created by andrew on 2016/04/11.
 */
public class Interval extends BaseEntity {

    private static final long serialVersionUID = -1542977120794143741L;

    private Integer duration;
    private DurationUnit durationUnit;

    public Interval() {
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public DurationUnit getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(DurationUnit durationUnit) {
        this.durationUnit = durationUnit;
    }
}
