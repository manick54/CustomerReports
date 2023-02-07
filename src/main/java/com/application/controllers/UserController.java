package com.application.controllers;

import com.application.dto.*;
import com.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/getReportCategories", method = RequestMethod.GET, produces = "application/json")
        public List<ReportCategoryDTO> getReportCategories(){
            return userService.getReportCategories();
        }

    @RequestMapping(value = "/saveReportCategories", method = RequestMethod.POST, consumes = "application/json")
    public String saveReportCategories(@RequestBody ReportCategoryDTO reportDetails){
        boolean isSaved = userService.saveReportCategories(reportDetails);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/updateReportCategories", method = RequestMethod.POST, consumes = "application/json")
    public String updateReportCategories(@RequestBody ReportCategoryDTO reportDetails){
        boolean isSaved = userService.updateReportCategories(reportDetails);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/deleteReportCategory/{reportCategoryId}", method = RequestMethod.GET)
    public String deleteReportCategory(@PathVariable int reportCategoryId){
        boolean isDeleted = userService.deleteReportCategory(reportCategoryId);
        if(isDeleted){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/getReportSubCategories/{subCategoryId}", method = RequestMethod.GET, produces = "application/json")
    public List<ReportCategoryDTO> getReportSubCategories(@PathVariable int subCategoryId){
        System.out.println("Inside controller");
        return userService.getReportSubCategories(subCategoryId);
    }

    @RequestMapping(value = "/saveReportSubCategories", method = RequestMethod.POST, consumes = "application/json")
    public String saveReportSubCategories(@RequestBody ReportCategoryDTO reportDetails){
        boolean isSaved = userService.saveReportSubCategories(reportDetails);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/updateReportSubCategories", method = RequestMethod.POST, consumes = "application/json")
    public String updateReportSubCategories(@RequestBody ReportCategoryDTO reportDetails){
        boolean isSaved = userService.updateReportSubCategories(reportDetails);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/deleteReportSubCategory/{subCategoryId}", method = RequestMethod.GET)
    public String deleteReportSubCategory(@PathVariable int subCategoryId){
        boolean isDeleted = userService.deleteReportSubCategory(subCategoryId);
        if(isDeleted){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/getFundTypes/{fundTypeId}", method = RequestMethod.GET, produces = "application/json")
    public FundTypeDTO getFundTypes(@PathVariable int fundTypeId){
        return userService.getFundTypes(fundTypeId);
    }

    @RequestMapping(value = "/getReportDetails/{reportCategoryId}/{reportSubCategoryId}", method = RequestMethod.GET, produces = "application/json")
    public ReportDetailsDTO getReportDetails(@PathVariable int reportCategoryId, @PathVariable int reportSubCategoryId){
        return userService.getReportDetails(reportCategoryId, reportSubCategoryId);
    }

    @RequestMapping(value = "/getReportDetailsByFilters", method = RequestMethod.POST, produces = "application/json")
    public ReportDetailsDTO getReportDetailsByFilters(@RequestBody ReportDetailsDTO reportDetailsDTO){
        return userService.getReportDetailsByFilters(reportDetailsDTO);
    }
    @RequestMapping(value = "/getReportFrequency", method = RequestMethod.GET, produces = "application/json")
    public List<ReportFrequencyDTO> getReportFrequency(){
        return userService.getReportFrequency();
    }

    @RequestMapping(value = "/saveReportFrequency", method = RequestMethod.POST, consumes = "application/json")
    public String saveReportFrequency(@RequestBody ReportFrequencyDTO frequencyDTO){
        boolean isSaved = userService.saveReportFrequency(frequencyDTO);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/updateReportFrequency", method = RequestMethod.POST, consumes = "application/json")
    public String updateReportFrequency(@RequestBody ReportFrequencyDTO frequencyDTO){
        boolean isSaved = userService.updateReportFrequency(frequencyDTO);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/deleteReportCategory/{frequencyId}", method = RequestMethod.GET)
    public String deleteReportFrequency(@PathVariable int frequencyId){
        boolean isDeleted = userService.deleteReportFrequency(frequencyId);
        if(isDeleted){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/getCountryGroups", method = RequestMethod.GET, produces = "application/json")
    public List<CountryDTO> getCountryGroups(){
        return userService.getCountryGroups();
    }

    @RequestMapping(value = "/saveCountryGroup", method = RequestMethod.POST, consumes = "application/json")
    public String saveCountryGroup(@RequestBody CountryDTO countryDTO){
        boolean isSaved = userService.saveCountryGroup(countryDTO);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/updateCountryGroup", method = RequestMethod.POST, consumes = "application/json")
    public String updateCountryGroup(@RequestBody CountryDTO countryDTO){
        boolean isSaved = userService.updateCountryGroup(countryDTO);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/deleteCountryGroup/{countryGroupId}", method = RequestMethod.GET)
    public String deleteCountryGroup(@PathVariable int countryGroupId){
        boolean isDeleted = userService.deleteCountryGroup(countryGroupId);
        if(isDeleted){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/getCountryDetails/{countryGroupId}", method = RequestMethod.GET, produces = "application/json")
    public List<CountryDTO> getCountryDetails(@PathVariable int countryGroupId){
        return userService.getCountryDetails(countryGroupId);
    }

    @RequestMapping(value = "/saveCountryDetails", method = RequestMethod.POST, consumes = "application/json")
    public String saveCountryDetails(@RequestBody CountryDTO countryDTO){
        boolean isSaved = userService.saveCountryDetails(countryDTO);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/updateCountryDetails", method = RequestMethod.POST, consumes = "application/json")
    public String updateCountryDetails(@RequestBody CountryDTO countryDTO){
        boolean isSaved = userService.updateCountryDetails(countryDTO);
        if(isSaved){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/deleteCountryDetails/{countryId}", method = RequestMethod.GET)
    public String deleteCountryDetails(@PathVariable int countryId){
        boolean isDeleted = userService.deleteCountryDetails(countryId);
        if(isDeleted){
            return "Success";
        }else{
            return "Failure";
        }
    }

    @RequestMapping(value = "/getReportFormats", method = RequestMethod.GET, produces = "application/json")
    public List<FormatDTO> getReportFormats(){
        return userService.getReportFormats();
    }

    @RequestMapping(value = "/getReportElements", method = RequestMethod.GET, produces = "application/json")
    public List<ElementDTO> getReportElements(){
        return userService.getReportElements();
    }

}