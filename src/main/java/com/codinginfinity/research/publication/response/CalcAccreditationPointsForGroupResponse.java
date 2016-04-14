package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class CalcAccreditationPointsForGroupResponse implements Response{

    private static final long serialVersionUID = 3324896138651625082L;

    int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public CalcAccreditationPointsForGroupResponse(int points) {

        this.points = points;
    }

    public CalcAccreditationPointsForGroupResponse() {
    }
}
