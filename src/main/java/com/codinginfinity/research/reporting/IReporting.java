package com.codinginfinity.research.reporting;

import com.codinginfinity.research.reporting.exceptions.InvalidPeriodException;
import com.codinginfinity.research.reporting.request.*;
import com.codinginfinity.research.reporting.response.*;
import com.codinginfinity.research.services.RequestNotValidException;

/**
 * Created by Rohan on 2016/04/13.
 */
public interface IReporting {

    GetAccreditationUnitReportResponse getAccreditationUnitReport(GetAccreditationUnitReportRequest getAccreditationUnitReportRequest) throws RequestNotValidException, InvalidPeriodException;
    GetProgressReportResponse getProgressReportResponse(GetProgressReportRequest getProgressReportRequest) throws RequestNotValidException;
}