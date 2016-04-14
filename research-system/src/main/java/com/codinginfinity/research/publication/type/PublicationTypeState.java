package com.codinginfinity.research.publication.type;

import com.codinginfinity.research.core.BaseEntity;

import java.time.LocalDate;

/**
 * Created by andrew on 2016/04/11.
 */
public class PublicationTypeState extends BaseEntity {

    private static final long serialVersionUID = -3498392658240356418L;

    private LocalDate effectiveDate;

    public PublicationTypeState() {
    }

    public PublicationTypeState(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
