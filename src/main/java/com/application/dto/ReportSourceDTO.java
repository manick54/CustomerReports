package com.application.dto;

import java.util.Date;

public class ReportSourceDTO {
    int reportSourceId;
    String reportSourceName;
    String createdBy;
    Date createdDate;
    String lastUpdatedBy;
    Date lastUpdatedDate;

    public int getReportSourceId() {
        return reportSourceId;
    }

    public void setReportSourceId(int reportSourceId) {
        this.reportSourceId = reportSourceId;
    }

    public String getReportSourceName() {
        return reportSourceName;
    }

    public void setReportSourceName(String reportSourceName) {
        this.reportSourceName = reportSourceName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
