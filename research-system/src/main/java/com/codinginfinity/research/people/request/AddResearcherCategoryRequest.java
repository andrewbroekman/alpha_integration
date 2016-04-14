package com.codinginfinity.research.people.request;

import com.codinginfinity.research.people.ReseacherCategory;
import com.codinginfinity.research.services.Request;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddResearcherCategoryRequest implements Request {

    private static final long serialVersionUID = -882396609782179821L;
    ReseacherCategory reseacherCategory;

    public ReseacherCategory getReseacherCategory()
    {
        return reseacherCategory;
    }

    public void setReseacherCategory(ReseacherCategory reseacherCategory)
    {
        this.reseacherCategory = reseacherCategory;
    }
    public AddResearcherCategoryRequest(ReseacherCategory reseacherCategory)
    {
        this.reseacherCategory = reseacherCategory;
    }
}
