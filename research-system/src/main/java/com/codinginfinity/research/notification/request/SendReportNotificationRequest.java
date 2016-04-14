package com.codinginfinity.research.notification.request;

import com.codinginfinity.research.notification.ReportNotificationRequest;
import com.codinginfinity.research.services.Request;

import javax.validation.constraints.NotNull;

/**
 * Created by Claudio on 2016/04/13.
 */
public class SendReportNotificationRequest implements Request {

    private static final long serialVersionUID = -5498788792501745938L;

    @NotNull
    private ReportNotificationRequest reportNotificationRequest;

    public ReportNotificationRequest getReportNotificationRequest() {

        return reportNotificationRequest;

    }

    public void setReportNotificationRequest(ReportNotificationRequest reportNotificationRequest) {

        this.reportNotificationRequest = reportNotificationRequest;

    }
}
