package com.codinginfinity.research.publication.lifecycle;

/**
 * Created by andrew on 2016/04/11.
 */
public class InProgress extends LifeCycleState  {

    private static final long serialVersionUID = 8510520853818822312L;

    private Integer percentageCompleted;

    public InProgress() {
    }

    public InProgress(Integer percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }

    public Integer getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(Integer percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }
}
