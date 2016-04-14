package com.codinginfinity.research.people;

import com.codinginfinity.research.core.BaseEntity;

import java.time.LocalDate;

/**
 * Created by andrew on 2016/04/11.
 */
public class ResearchCategoryState extends BaseEntity {

    private static final long serialVersionUID = 5446989936391171769L;

    private LocalDate effectiveDate;
    private double researchOutputTarget;

    public ResearchCategoryState() {
    }

    public ResearchCategoryState(double researchOutputTarget, LocalDate effectiveDate) {
        this.researchOutputTarget = researchOutputTarget;
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getResearchOutputTarget() {
        return researchOutputTarget;
    }

    public void setResearchOutputTarget(double researchOutputTarget) {
        this.researchOutputTarget = researchOutputTarget;
    }
}
