package com.codinginfinity.research.publication.response;

import com.codinginfinity.research.services.Response;

/**
 * Created by andrew on 2016/04/11.
 */
public class CalcAccreditationPointsForPersonResponse implements Response {

    private static final long serialVersionUID = -3268050641790988929L;

    int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public CalcAccreditationPointsForPersonResponse(int points) {

        this.points = points;
    }

    public CalcAccreditationPointsForPersonResponse() {
    }
}
