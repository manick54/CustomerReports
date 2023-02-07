package com.application.service;

import com.application.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.application.transaction.UserDAO;

import java.util.List;

@Component
public class UserService {

    @Autowired
    UserDAO userDAO;

    public List<ReportCategoryDTO> getReportCategories(){
        return userDAO.getReportCategories("GET_REPORT_CATEGORIES");
    }

    public boolean saveReportCategories(ReportCategoryDTO reportDetails){
        return userDAO.saveReportCategories(reportDetails, "SAVE_REPORT_CATEGORIES");
    }

    public boolean updateReportCategories(ReportCategoryDTO reportDetails){
        return userDAO.updateReportCategories(reportDetails, "UPDATE_REPORT_CATEGORY");
    }

    public boolean deleteReportCategory(int reportCategoryId){
        return userDAO.deleteReportCategory(reportCategoryId,"DELETE_REPORT_CATEGORY");
    }

    public List<ReportCategoryDTO> getReportSubCategories(int subCategoryId){
        return userDAO.getReportSubCategories(subCategoryId, "GET_REPORT_SUBCATEGORIES");
    }

    public boolean saveReportSubCategories(ReportCategoryDTO reportDetails){
        return userDAO.saveReportSubCategories(reportDetails, "Save_Report_SubCategories");
    }

    public boolean updateReportSubCategories(ReportCategoryDTO reportDetails){
        return userDAO.updateReportSubCategories(reportDetails, "UPDATE_REPORT_SUBCATEGORY");
    }

    public boolean deleteReportSubCategory(int subCategoryId){
        return userDAO.deleteReportSubCategory(subCategoryId,"Delete_Report_SubCategory");
    }

    public FundTypeDTO getFundTypes(int fundTypeId){
        return userDAO.getFundTypes(fundTypeId, "Get_Fund_Types");
    }

    public ReportDetailsDTO getReportDetails(int reportCategoryId, int reportSubCategoryId){
        return userDAO.getReportDetails(reportCategoryId, reportSubCategoryId, "Get_Report_Details");
    }

    public ReportDetailsDTO getReportDetailsByFilters(ReportDetailsDTO reportDetailsDTO){
        return userDAO.getReportDetailsByFilters(reportDetailsDTO, "Get_Report_Details_By_Filters");
    }
    public List<ReportFrequencyDTO> getReportFrequency(){
        return userDAO.getReportFrequency("GET_REPORT_FREQUENCY");
    }

    public boolean saveReportFrequency(ReportFrequencyDTO frequencyDTO){
        return userDAO.saveReportFrequency(frequencyDTO, "SAVE_REPORT_FREQUENCY");
    }

    public boolean updateReportFrequency(ReportFrequencyDTO frequencyDTO){
        return userDAO.updateReportFrequency(frequencyDTO, "UPDATE_REPORT_FREQUENCY");
    }

    public boolean deleteReportFrequency(int frequencyId){
        return userDAO.deleteReportFrequency(frequencyId,"DELETE_REPORT_FREQUENCY");
    }

    public List<CountryDTO> getCountryGroups(){
        return userDAO.getCountryGroups("GET_COUNTRY_GROUP");
    }

    public boolean saveCountryGroup(CountryDTO countryDTO){
        return userDAO.saveCountryGroup(countryDTO, "SAVE_COUNTRY_GROUP");
    }

    public boolean updateCountryGroup(CountryDTO countryDTO){
        return userDAO.updateCountryGroup(countryDTO, "UPDATE_COUNTRY_GROUP");
    }

    public boolean deleteCountryGroup(int countryGroupId){
        return userDAO.deleteCountryGroup(countryGroupId,"DELETE_COUNTRY_GROUP");
    }
    public List<CountryDTO> getCountryDetails(int countryGroupId){
        return userDAO.getCountryDetails(countryGroupId,"GET_COUNTRY_DETAILS");
    }

    public boolean saveCountryDetails(CountryDTO countryDTO){
        return userDAO.saveCountryDetails(countryDTO, "SAVE_COUNTRY_DETAILS");
    }

    public boolean updateCountryDetails(CountryDTO countryDTO){
        return userDAO.updateCountryDetails(countryDTO, "UPDATE_COUNTRY_DETAILS");
    }

    public boolean deleteCountryDetails(int countryGroupId){
        return userDAO.deleteCountryDetails(countryGroupId,"DELETE_COUNTRY");
    }

    public List<FormatDTO> getReportFormats(){
        return userDAO.getReportFormats("GET_REPORT_FORMATS");
    }

    public List<ElementDTO> getReportElements(){
        return userDAO.getReportElements("GET_REPORT_ELEMENTS");
    }

}
