package com.codinginfinity.research.notification.response;

import com.codinginfinity.research.notification.ReportNotificationRequest;
import com.codinginfinity.research.services.Response;

import javax.validation.constraints.NotNull;

/**
 * Created by Claudio on 2016/04/13.
 */
public class SendReportNotificationResponse implements Response {


    private static final long serialVersionUID = 2240666298738577961L;

    @NotNull
    private ReportNotificationRequest reportNotificationRequest;

    public ReportNotificationRequest getReportNotificationRequest() {

        return reportNotificationRequest;

    }

    public void setReportNotificationRequest(ReportNotificationRequest reportNotificationRequest) {

        this.reportNotificationRequest = reportNotificationRequest;

    }
}
