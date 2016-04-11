package com.codinginfinity.research.people;

import com.codinginfinity.research.core.BaseEntity;

import java.time.LocalDateTime;

/**
 * Created by andrew on 2016/04/11.
 */
public class ResearchCategoryState extends BaseEntity {

    private static final long serialVersionUID = 5446989936391171769L;

    private LocalDateTime effectiveDate;
    private double researchOutputTarget;

    public ResearchCategoryState() {
    }
}
