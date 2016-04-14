package com.codinginfinity.research.reporting;

import com.codinginfinity.research.people.EmailAddress;
import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.publication.Period;
import com.codinginfinity.research.publication.lifecycle.Published;
import com.codinginfinity.research.publication.type.PublicationType;
import com.codinginfinity.research.reporting.exceptions.InvalidPeriodException;
import com.codinginfinity.research.reporting.request.GetAccreditationUnitReportRequest;
import com.codinginfinity.research.reporting.request.GetProgressReportRequest;
import com.codinginfinity.research.reporting.response.GetAccreditationUnitReportResponse;
import com.codinginfinity.research.reporting.response.GetProgressReportResponse;
import com.codinginfinity.research.services.RequestNotValidException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by andrew on 2016/04/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ReportingTest.class})
@ComponentScan("com.codinginfinity.research")
public class ReportingTest {

    @Inject
    private ReportingMock reportMock;

    @Test
    public void getAccreditationUnitReportValidRequest() throws RequestNotValidException, InvalidPeriodException {
        GetAccreditationUnitReportRequest req = createAccreditationUnitReportValidRequest();
        GetAccreditationUnitReportResponse resp = reportMock.getAccreditationUnitReport(req);

        assert resp.getResponseString() != null;
        assert !resp.getResponseString().equals("");
    }

    @Test
    public void getProgressReportValidRequest() throws RequestNotValidException, InvalidPeriodException {
        GetProgressReportRequest req = new GetProgressReportRequest();
        GetProgressReportResponse resp = reportMock.getProgressReportResponse(req);

        assert resp.getResponseString() != null;
        assert !resp.getResponseString().equals("");
    }


    private GetAccreditationUnitReportRequest createAccreditationUnitReportValidRequest()
    {
        GetAccreditationUnitReportRequest req = new GetAccreditationUnitReportRequest();
        req.setEntity(new Person("Jane", "Doe", new EmailAddress("jane.doe@sharkmail.com")));
        req.setPeriod(new Period());
        req.setState(new Published());
        req.setType(new PublicationType());

        return req;
    }
}
