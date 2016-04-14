package com.codinginfinity.research.people;

import com.codinginfinity.research.core.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 2016/04/11.
 */
public class ReseacherCategory extends BaseEntity {

    private static final long serialVersionUID = 3297201826811126033L;

    private String researcherCategory;
    private List<ResearchCategoryState> stateEntry;

    public ReseacherCategory() {
    }

    public ReseacherCategory(String researcherCategory) {
        this.researcherCategory = researcherCategory;
    }

    public String getResearcherCategory() {
        return researcherCategory;
    }

    public void setResearcherCategory(String researcherCategory) {
        this.researcherCategory = researcherCategory;
    }

    public void addStateEntry(ResearchCategoryState state)
    {
        if (stateEntry == null)
            stateEntry = new ArrayList<>();

        stateEntry.add(state);
    }

    public List<ResearchCategoryState> getStateEntry() {
        return stateEntry;
    }
}
