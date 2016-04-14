package com.codinginfinity.research.reporting;

import com.codinginfinity.research.reporting.request.*;
import com.codinginfinity.research.reporting.response.*;
import com.codinginfinity.research.services.RequestNotValidException;
import com.codinginfinity.research.services.mocking.BaseMock;
import com.codinginfinity.research.services.mocking.Mock;
import com.codinginfinity.research.reporting.exceptions.*;
import com.codinginfinity.research.validation.beanvalidation.services.ServiceValidationUtilities;
import org.springframework.stereotype.Service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashMap;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 * Created by Rohan on 2016/04/13.
 */
public class ReportingMock extends BaseMock implements IReporting {

    public ReportingMock() {
        setState(State.validInput);
    }

    @Override
    public GetAccreditationUnitReportResponse getAccreditationUnitReport(GetAccreditationUnitReportRequest getAccreditationUnitReportRequest) throws RequestNotValidException, InvalidPeriodException {
//        return null;

        if (getState() == State.InvalidInput)
            throw new RequestNotValidException();

        if (getState() == State.InvalidPeriod)
            throw new InvalidPeriodException();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("templates/acc_report.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap() ,new  JREmptyDataSource());
            return new GetAccreditationUnitReportResponse(JasperExportManager.exportReportToXml(jasperPrint));
        }

        catch(JRException j) {
        }

        return null;
    }


    @Override
    public GetProgressReportResponse getProgressReportResponse(GetProgressReportRequest getProgressReportRequest) throws RequestNotValidException {

        if (getState() == State.InvalidInput)
            throw new RequestNotValidException();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport("templates/progress_report.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap() ,new  JREmptyDataSource());
            return new GetProgressReportResponse(JasperExportManager.exportReportToXml(jasperPrint));
        }

        catch(JRException j) {
        }

        return null;
    }

    public enum State implements Mock.State{validInput, InvalidInput, InvalidPeriod}
}
