package com.codinginfinity.research.rest;

import com.codinginfinity.research.reporting.IReporting;
import com.codinginfinity.research.reporting.exceptions.InvalidPeriodException;
import com.codinginfinity.research.reporting.request.GetAccreditationUnitReportRequest;
import com.codinginfinity.research.reporting.response.GetAccreditationUnitReportResponse;
import com.codinginfinity.research.services.RequestNotValidException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Rohan on 2016/04/05.
 */


@Path("reporting")
public class ReportingResource {
    @Inject
    private IReporting reporting;


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response getAccreditationUnitReport(GetAccreditationUnitReportRequest req){
        try {
            GetAccreditationUnitReportResponse resp = reporting.getAccreditationUnitReport(req);
            return javax.ws.rs.core.Response.status(200).entity(resp).build();
        }catch(InvalidPeriodException e){
            return javax.ws.rs.core.Response.status(412).build();
//            return javax.ws.rs.core.Response.status(418).build();

        }catch (RequestNotValidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch(Exception e) {
            return javax.ws.rs.core.Response.status(500).build();
        }
    }
}