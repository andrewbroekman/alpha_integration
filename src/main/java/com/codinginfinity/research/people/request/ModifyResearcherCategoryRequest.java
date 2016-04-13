package com.codinginfinity.research.people.request;

import com.codinginfinity.research.people.ReseacherCategory;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class ModifyResearcherCategoryRequest implements Request {

    private static final long serialVersionUID = 8191024091613042109L;
    ReseacherCategory reseacherCategory;
    public ReseacherCategory getReseacherCategory()
    {
        return reseacherCategory;
    }

    public void setReseacherCategory(ReseacherCategory reseacherCategory)
    {
        this.reseacherCategory = reseacherCategory;
    }

    public ModifyResearcherCategoryRequest(ReseacherCategory reseacherCategory)
    {
        this.reseacherCategory = reseacherCategory;
    }
}
