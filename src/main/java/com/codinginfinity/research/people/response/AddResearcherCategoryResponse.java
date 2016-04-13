package com.codinginfinity.research.people.response;

import com.codinginfinity.research.people.ReseacherCategory;
import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class AddResearcherCategoryResponse implements Response {

    private static final long serialVersionUID = -3987194448060344402L;
    ReseacherCategory reseacherCategory;
    public ReseacherCategory getReseacherCategory()
    {
        return reseacherCategory;
    }

    public void setReseacherCategory(ReseacherCategory reseacherCategory)
    {
        this.reseacherCategory = reseacherCategory;
    }

    public AddResearcherCategoryResponse(ReseacherCategory reseacherCategory)
    {
        this.reseacherCategory = reseacherCategory;
    }
}
