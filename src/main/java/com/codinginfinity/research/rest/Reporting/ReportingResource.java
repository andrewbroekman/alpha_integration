package com.codingInfinity.research.rest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Rohan on 3/29/2016.
 */

@Path("reporting")
public class ReportingResource
{
    @Inject
    Reporting reporting;

    @GET
    @Path("/accreditationReport")
    @Consumes(MediaType.APPLICATION_JSON)
    public void get(ReportBean reportBean)
    {
        reporting.getAccreditationUnitReport(new GetAccreditationUnitReportRequest(reportBean));
    }

    @GET
    @Path("/progressReport")
    @Consumes(MediaType.APPLICATION_JSON)
    public void get(ReportBean reportBean)
    {
        reporting.getProgressReport(new GetProgressReportRequest(reportBean));
    }
}