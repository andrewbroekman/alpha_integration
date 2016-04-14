package com.codinginfinity.research.reporting.response;

import com.codinginfinity.research.services.Response;

/**
 * Created by Rohan on 2016-04-13.
 */
public class GetProgressReportResponse implements Response {

    private static final long serialVersionUID = -4226783121817599116L;

    private String reportString;

    public GetProgressReportResponse(String reportString) {
        this.reportString = reportString;
    }

    public String getResponseString() {
        return reportString;
    }

    public void setReportString(String reportString) {
        this.reportString = reportString;
    }
}
