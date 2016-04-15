package com.codinginfinity.research.reporting;

import com.codinginfinity.research.reporting.exceptions.InvalidPeriodException;
import com.codinginfinity.research.reporting.request.GetAccreditationUnitReportRequest;
import com.codinginfinity.research.reporting.request.GetProgressReportRequest;
import com.codinginfinity.research.reporting.response.GetAccreditationUnitReportResponse;
import com.codinginfinity.research.reporting.response.GetProgressReportResponse;
import com.codinginfinity.research.services.RequestNotValidException;
import com.codinginfinity.research.services.mocking.BaseMock;
import com.codinginfinity.research.services.mocking.Mock;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Service;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import javax.ejb.Stateless;
import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Rohan on 2016/04/13.
 */

@Stateless
@Service
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
            JasperReport jasperReport = JasperCompileManager.compileReport(new File(".").getCanonicalPath() + "/src/main/java/com/codinginfinity/research/reporting/templates/acc_report.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), new  JREmptyDataSource());

            DOMImplementation dom = GenericDOMImplementation.getDOMImplementation();
            Document document = dom.createDocument(null, "svg", null);
            SVGGraphics2D svgGraphic = new SVGGraphics2D(document);

            JRGraphics2DExporter svgWriter = new JRGraphics2DExporter();
            svgWriter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            svgWriter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, svgGraphic);
            svgWriter.setParameter(JRExporterParameter.PAGE_INDEX, 0);
            svgWriter.exportReport();

            StringWriter sw = new StringWriter();
            svgGraphic.stream(sw, true);

            return new GetAccreditationUnitReportResponse(sw.toString());
        }

        catch(Exception j) {
        }


        return null;
    }


    @Override
    public GetProgressReportResponse getProgressReportResponse(GetProgressReportRequest getProgressReportRequest) throws RequestNotValidException {

        if (getState() == State.InvalidInput)
            throw new RequestNotValidException();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(new File(".").getCanonicalPath() + "/src/main/java/com/codinginfinity/research/reporting/templates/progress_report.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), new JREmptyDataSource());
//            return new GetProgressReportResponse(JasperExportManager.exportReportToXml(jasperPrint));

            DOMImplementation dom = GenericDOMImplementation.getDOMImplementation();
            Document document = dom.createDocument(null, "svg", null);
            SVGGraphics2D svgGraphic = new SVGGraphics2D(document);

            JRGraphics2DExporter svgWriter = new JRGraphics2DExporter();
            svgWriter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            svgWriter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, svgGraphic);
            svgWriter.setParameter(JRExporterParameter.PAGE_INDEX, 0);
            svgWriter.exportReport();

            StringWriter sw = new StringWriter();
            svgGraphic.stream(sw, true);

            return new GetProgressReportResponse(sw.toString());
        }

        catch(Exception j) {
        }

        return null;
    }

    public enum State implements Mock.State{validInput, InvalidInput, InvalidPeriod}
}
