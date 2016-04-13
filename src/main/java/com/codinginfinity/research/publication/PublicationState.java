package com.codinginfinity.research.publication;

import com.codinginfinity.research.core.BaseEntity;
import com.codinginfinity.research.publication.lifecycle.LifeCycleState;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by andrew on 2016/04/11.
 */
public class PublicationState extends BaseEntity {

    private static final long serialVersionUID = -4356781121817499116L;

    @NotNull
    private LocalDate date;
    private String reason;
    private PublicationDetails publicationDetails;
    @NotNull
    private LifeCycleState lifeCycleState;
    private long publicationTarget;
    @NotNull
    private long publicationType;
    private long owner;

    public PublicationState(LocalDate date, String reason, PublicationDetails publicationDetails, LifeCycleState lifeCycleState, long publicationTarget, long publicationType, long owner) {
        this.date = date;
        this.reason = reason;
        this.publicationDetails = publicationDetails;
        this.lifeCycleState = lifeCycleState;
        this.publicationTarget = publicationTarget;
        this.publicationType = publicationType;
        this.owner = owner;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public PublicationDetails getPublicationDetails() {
        return publicationDetails;
    }

    public void setPublicationDetails(PublicationDetails publicationDetails) {
        this.publicationDetails = publicationDetails;
    }

    public LifeCycleState getLifeCycleState() {
        return lifeCycleState;
    }

    public void setLifeCycleState(LifeCycleState lifeCycleState) {
        this.lifeCycleState = lifeCycleState;
    }

    public long getPublicationTarget() {
        return publicationTarget;
    }

    public void setPublicationTarget(long publicationTarget) {
        this.publicationTarget = publicationTarget;
    }

    public long getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(long publicationType) {
        this.publicationType = publicationType;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }
}
