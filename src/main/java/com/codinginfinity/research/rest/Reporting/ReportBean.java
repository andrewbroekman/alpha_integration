package com.codingInfinity.research.rest;

/**
 * Created by Rohan on 3/29/2016.
 */

public class ReportBean
{
    private String entityName;
    private String publicationType;
    private String lifeCycleState;
    private Date startDate;
    private Date endDate;

    public String getEntityName() {
        return entityName;
    }

    public String getPublicationType() {
        return publicationType;
    }

    public String getLifeCycleState() {
        return lifeCycleState;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEntityName(String _entityName) {
        entityName = _entityName;
    }

    public void setPublicationType(String _publicationType)
    {
        publicationType = _publicationType;
    }

    public void setLifeCycleState(String _lifeCycleState)
    {
        lifeCycleState = _lifeCycleState;
    }

    public void setStartDate(Date _startDate)
    {
        startDate = _startDate;
    }

    public void setEndDate(Date _endDate)
    {
        endDate = _endDate;
    }
}