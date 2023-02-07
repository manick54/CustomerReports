package com.application.dto;

import java.util.Date;

public class CountryDTO {
    int countryGroupId;
    int countryId;
    String countryGroupName;
    String countryName;
    String createdBy;
    Date createdDate;
    String lastUpdatedBy;
    Date lastUpdatedDate;

    public int getCountryGroupId() {
        return countryGroupId;
    }

    public void setCountryGroupId(int countryGroupId) {
        this.countryGroupId = countryGroupId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryGroupName() {
        return countryGroupName;
    }

    public void setCountryGroupName(String countryGroupName) {
        this.countryGroupName = countryGroupName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
