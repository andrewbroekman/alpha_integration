package com.codinginfinity.research.reporting.defaultImpl;

import com.codinginfinity.research.reporting.IReporting;
import com.codinginfinity.research.reporting.request.GetAccreditationUnitReportRequest;
import com.codinginfinity.research.reporting.request.GetProgressReportRequest;
import com.codinginfinity.research.reporting.response.GetAccreditationUnitReportResponse;
import com.codinginfinity.research.reporting.response.GetProgressReportResponse;

/**
 * Created by Rohan on 2016/04/13.
 */
public class Reporting implements IReporting {

    @Override
    public GetAccreditationUnitReportResponse getAccreditationUnitReport(GetAccreditationUnitReportRequest getAccreditationUnitReportRequest) {
        return null;
    }

    @Override
    public GetProgressReportResponse getProgressReportResponse(GetProgressReportRequest getProgressReportRequest) {
        return null;
    }
}
