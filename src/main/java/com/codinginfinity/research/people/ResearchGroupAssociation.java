package com.codinginfinity.research.people;

import com.codinginfinity.research.core.BaseEntity;

import java.time.LocalDateTime;

/**
 * Created by andrew on 2016/04/11.
 */
public class ResearchGroupAssociation extends BaseEntity {

    private static final long serialVersionUID = -922776865578404399L;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ResearchGroupAssociationType researchGroupAssociationType;

    public ResearchGroupAssociation(LocalDateTime startDate, LocalDateTime endDate, ResearchGroupAssociationType researchGroupAssociationType){
        this.startDate = startDate;
        this.endDate = endDate;
        this.researchGroupAssociationType = researchGroupAssociationType;
    }

    public ResearchGroupAssociationType getResearchGroupAssociationType() {
        return researchGroupAssociationType;
    }

    public void setResearchGroupAssociationType(ResearchGroupAssociationType researchGroupAssociationType) {
        this.researchGroupAssociationType = researchGroupAssociationType;
    }

    public LocalDateTime getEndDate() {

        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {

        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
