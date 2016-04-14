package com.codinginfinity.research.reporting.response;

import com.codinginfinity.research.services.Response;

/**
 * Created by Rohan on 2016-04-13.
 */
public class GetAccreditationUnitReportResponse  implements Response {

    private String reportString;

    public GetAccreditationUnitReportResponse(String reportString) {
        this.reportString = reportString;
    }

    public String getReponseString() {
        return reportString;
    }

    public void setReponseString(String reponseString) {
        this.reportString = reponseString;
    }
}
