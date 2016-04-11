package com.codinginfinity.research.people;

import com.codinginfinity.research.core.BaseEntity;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by andrew on 2016/04/11.
 */
public class ResearcherCategoryAssociation extends BaseEntity {

    private static final long serialVersionUID = -6138535822721285577L;

    private LocalDateTime effectiveDate;

    @NotNull
    private long researcherCategory;

    public ResearcherCategoryAssociation() {
    }
}
