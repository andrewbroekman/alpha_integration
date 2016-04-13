package com.codinginfinity.research.people;

import com.codinginfinity.research.core.BaseEntity;

import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class ReseacherCategory extends BaseEntity {

    private static final long serialVersionUID = 3297201826811126033L;

    private List<String> researcherCategory;

    public ReseacherCategory() {
    }

    public List<String> getResearcherCategory() {
        return researcherCategory.subList(0,1);
    }

    public void setResearcherCategoryState(String researcherCategoryState) {
        researcherCategory.add(researcherCategoryState);
    }
}
