package com.application.dto;

import java.util.Date;

public class ReportDetailsDTO {
    int reportId;
    int reportCategoryId;
    int reportSubCategoryId;
    String reportName;
    String reportDescription;
    int reportSourceId;
    int levelId;
    String marketRequirement;
    int fundTypeId;
    int formatId;
    int countryId;
    int frequencyId;
    int channelId;
    int elementId;
    String createdBy;
    Date createdDate;
    String lastUpdatedBy;
    Date lastUpdatedDate;

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getReportCategoryId() {
        return reportCategoryId;
    }

    public void setReportCategoryId(int reportCategoryId) {
        this.reportCategoryId = reportCategoryId;
    }

    public int getReportSubCategoryId() {
        return reportSubCategoryId;
    }

    public void setReportSubCategoryId(int reportSubCategoryId) {
        this.reportSubCategoryId = reportSubCategoryId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public int getReportSourceId() {
        return reportSourceId;
    }

    public void setReportSourceId(int reportSourceId) {
        this.reportSourceId = reportSourceId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getMarketRequirement() {
        return marketRequirement;
    }

    public void setMarketRequirement(String marketRequirement) {
        this.marketRequirement = marketRequirement;
    }

    public int getFundTypeId() {
        return fundTypeId;
    }

    public void setFundTypeId(int fundTypeId) {
        this.fundTypeId = fundTypeId;
    }

    public int getFormatId() {
        return formatId;
    }

    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(int frequencyId) {
        this.frequencyId = frequencyId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
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
