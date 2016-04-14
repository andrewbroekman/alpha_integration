package com.codinginfinity.research.reporting.response;

import com.codinginfinity.research.services.Response;

/**
 * Created by Rohan on 2016-04-13.
 */
public class GetProgressReportResponse implements Response {

    private String reportString;

    public GetProgressReportResponse(String reportString) {
        this.reportString = reportString;
    }

    public String getReportString() {
        return reportString;
    }

    public void setReportString(String reportString) {
        this.reportString = reportString;
    }
}
