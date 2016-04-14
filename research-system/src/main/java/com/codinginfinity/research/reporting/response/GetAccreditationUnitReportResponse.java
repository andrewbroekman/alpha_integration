package com.codinginfinity.research.reporting.response;

import com.codinginfinity.research.services.Response;

/**
 * Created by Rohan on 2016-04-13.
 */
public class GetAccreditationUnitReportResponse  implements Response {

    private static final long serialVersionUID = 2256781121917119116L;

    private String reportString;

    public GetAccreditationUnitReportResponse(String reportString) {
        this.reportString = reportString;
    }

    public String getResponseString() {
        return reportString;
    }

    public void setReponseString(String reponseString) {
        this.reportString = reponseString;
    }
}
