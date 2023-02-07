package com.application.transaction;

import com.application.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Component
public class UserDAO {

    Logger logger = LoggerFactory.getLogger(UserDAO.class);

    @Autowired
    QueryDAO queryDAO;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ReportCategoryDTO> getReportCategories(String queryName){
        logger.info("Getting Report Categories");
        List<ReportCategoryDTO> reportCategoryList = jdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), new RowMapper<ReportCategoryDTO>(){
            @Override
            public ReportCategoryDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                ReportCategoryDTO reportCategoryDTO = new ReportCategoryDTO();
                reportCategoryDTO.setReportCategoryId(rs.getInt("REPORT_CATEGORY_ID"));
                reportCategoryDTO.setCategoryName(rs.getString("CATEGORY_NAME"));
                reportCategoryDTO.setCreatedBy(rs.getString("CREATED_BY"));
                reportCategoryDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                reportCategoryDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                reportCategoryDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return reportCategoryDTO;
            }
        });
        return reportCategoryList;
    }

    @Transactional
    public boolean saveReportCategories(ReportCategoryDTO reportDetails, String queryName){
        Object[] params = new Object[] {reportDetails.getCategoryName(), reportDetails.getCreatedBy(), reportDetails.getCreatedBy()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while saving category details", e);
            return false;
        }
    }

    @Transactional
    public boolean updateReportCategories(ReportCategoryDTO reportDetails, String queryName){
        Object[] params = new Object[] {reportDetails.getCategoryName(), reportDetails.getLastUpdatedBy(), reportDetails.getReportCategoryId()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while updating category details for category_id: " + reportDetails.getReportCategoryId(), e);
            return false;
        }
    }

    @Transactional
    public boolean deleteReportCategory(int reportCategoryId, String queryName){
        MapSqlParameterSource msps = new MapSqlParameterSource("reportCategoryId", reportCategoryId);
        try{
            namedParameterJdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), msps);
            return true;
        }catch(Exception e){
            logger.error("Exception while deleting category details", e);
            throw new RuntimeException(e);
        }
    }

    public List<ReportCategoryDTO> getReportSubCategories(int reportCategoryId, String queryName){
        logger.info("Getting Report Subcategories");
        MapSqlParameterSource msps = new MapSqlParameterSource("reportCategoryId", reportCategoryId);
        List<ReportCategoryDTO> reportSubCategoryList = namedParameterJdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), msps, new RowMapper<ReportCategoryDTO>(){
            @Override
            public ReportCategoryDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                ReportCategoryDTO reportCategoryDTO = new ReportCategoryDTO();
                reportCategoryDTO.setReportSubCategoryId(rs.getInt("REPORT_SUBCATEGORY_ID"));
                reportCategoryDTO.setReportCategoryId(rs.getInt("REPORT_CATEGORY_ID"));
                reportCategoryDTO.setSubCategoryName(rs.getString("SUBCATEGORY_NAME"));
                reportCategoryDTO.setCreatedBy(rs.getString("CREATED_BY"));
                reportCategoryDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                reportCategoryDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                reportCategoryDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return reportCategoryDTO;
            }
        });
        return reportSubCategoryList;
    }

    @Transactional
    public boolean saveReportSubCategories(ReportCategoryDTO reportDetails, String queryName){
        Object[] params = new Object[] {reportDetails.getReportCategoryId(),
                reportDetails.getSubCategoryName(), reportDetails.getCreatedBy(), reportDetails.getCreatedBy()};
        int[] types = new int[] {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while saving subcategory details", e);
            return false;
        }
    }

    @Transactional
    public boolean updateReportSubCategories(ReportCategoryDTO reportDetails, String queryName){
        Object[] params = new Object[] {reportDetails.getSubCategoryName(), reportDetails.getLastUpdatedBy(), reportDetails.getReportSubCategoryId()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while updating Subcategory details for subcategory_id: " + reportDetails.getReportSubCategoryId(), e);
            return false;
        }
    }

    @Transactional
    public boolean deleteReportSubCategory(int reportSubCategoryId, String queryName){
        MapSqlParameterSource msps = new MapSqlParameterSource("reportSubCategoryId", reportSubCategoryId);
        try{
            namedParameterJdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), msps);
            return true;
        }catch(Exception e){
            logger.error("Exception while deleting subcategory details", e);
            return false;
        }
    }

    public List<ReportFrequencyDTO> getReportFrequency(String queryName){
        logger.info("Getting Report Categories");
        List<ReportFrequencyDTO> reportFrequencyList = jdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), new RowMapper<ReportFrequencyDTO>(){
            @Override
            public ReportFrequencyDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                ReportFrequencyDTO reportFrequencyDTO = new ReportFrequencyDTO();
                reportFrequencyDTO.setFrequencyId(rs.getInt("FREQUENCY_ID"));
                reportFrequencyDTO.setFrequencyName(rs.getString("FREQUENCY_NAME"));
                reportFrequencyDTO.setCreatedBy(rs.getString("CREATED_BY"));
                reportFrequencyDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                reportFrequencyDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                reportFrequencyDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return reportFrequencyDTO;
            }
        });
        return reportFrequencyList;
    }

    @Transactional
    public boolean saveReportFrequency(ReportFrequencyDTO frequencyDTO, String queryName){
        Object[] params = new Object[] {frequencyDTO.getFrequencyName(), frequencyDTO.getCreatedBy(), frequencyDTO.getCreatedBy()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while saving category details", e);
            return false;
        }
    }
    @Transactional
    public boolean updateReportFrequency(ReportFrequencyDTO frequencyDTO, String queryName){
        Object[] params = new Object[] {frequencyDTO.getFrequencyName(), frequencyDTO.getLastUpdatedBy(), frequencyDTO.getFrequencyId()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while updating frequency details for frequency_id: " + frequencyDTO.getFrequencyId(), e);
            return false;
        }
    }
    @Transactional
    public boolean deleteReportFrequency(int frequencyId, String queryName){
        MapSqlParameterSource msps = new MapSqlParameterSource("frequencyId", frequencyId);
        try{
            namedParameterJdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), msps);
            return true;
        }catch(Exception e){
            logger.error("Exception while deleting frequency details", e);
            throw new RuntimeException(e);
        }
    }

    public List<CountryDTO> getCountryGroups(String queryName){
        logger.info("Getting Report Categories");
        List<CountryDTO> countryGroupList = jdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), new RowMapper<CountryDTO>(){
            @Override
            public CountryDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                CountryDTO countryDTO = new CountryDTO();
                countryDTO.setCountryGroupId(rs.getInt("COUNTRY_GROUP_ID"));
                countryDTO.setCountryGroupName(rs.getString("COUNTRY_GROUP_NAME"));
                countryDTO.setCreatedBy(rs.getString("CREATED_BY"));
                countryDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                countryDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                countryDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return countryDTO;
            }
        });
        return countryGroupList;
    }

    @Transactional
    public boolean saveCountryGroup(CountryDTO countryDTO, String queryName){
        Object[] params = new Object[] {countryDTO.getCountryGroupName(), countryDTO.getCreatedBy(), countryDTO.getCreatedBy()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while saving category details", e);
            return false;
        }
    }

    @Transactional
    public boolean updateCountryGroup(CountryDTO countryDTO, String queryName){
        Object[] params = new Object[] {countryDTO.getCountryGroupName(), countryDTO.getLastUpdatedBy(), countryDTO.getCountryGroupId()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while updating country group details for country_group_id: " + countryDTO.getCountryGroupId(), e);
            return false;
        }
    }

    @Transactional
    public boolean deleteCountryGroup(int countryGroupId, String queryName){
        MapSqlParameterSource msps = new MapSqlParameterSource("countryGroupId", countryGroupId);
        try{
            namedParameterJdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), msps);
            return true;
        }catch(Exception e){
            logger.error("Exception while deleting frequency details", e);
            throw new RuntimeException(e);
        }
    }

    public FundTypeDTO getFundTypes(int fundTypeId, String queryName) {
        logger.info("Getting Fund Types");
        MapSqlParameterSource msps = new MapSqlParameterSource("fundTypeId", fundTypeId);
        List<FundTypeDTO> fundTypes = namedParameterJdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), msps, new RowMapper<FundTypeDTO>() {
            @Override
            public FundTypeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                FundTypeDTO fundTypeDTO = new FundTypeDTO();
                fundTypeDTO.setFundTypeId(rs.getInt("FUND_TYPE_ID"));
                fundTypeDTO.setFundTypeName(rs.getString("FUND_TYPE_NAME"));
                fundTypeDTO.setCreatedBy(rs.getString("CREATED_BY"));
                fundTypeDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                fundTypeDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                fundTypeDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return fundTypeDTO;
            }
        });
        return fundTypes != null ? fundTypes.get(0) : null;
    }

    public List<CountryDTO> getCountryDetails(int countryGroupId, String queryName){
        logger.info("Getting Country Details");
        MapSqlParameterSource msps = new MapSqlParameterSource("countryGroupId", countryGroupId);
        List<CountryDTO> countryDTOList = namedParameterJdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), msps, new RowMapper<CountryDTO>(){
            @Override
            public CountryDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                CountryDTO countryDTO = new CountryDTO();
                countryDTO.setCountryGroupId(rs.getInt("COUNTRY_GROUP_ID"));
                countryDTO.setCountryId(rs.getInt("COUNTRY_ID"));
                countryDTO.setCountryName(rs.getString("COUNTRY_NAME"));
                countryDTO.setCreatedBy(rs.getString("CREATED_BY"));
                countryDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                countryDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                countryDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return countryDTO;
            }
        });
        return countryDTOList;
    }

    @Transactional
    public boolean saveCountryDetails(CountryDTO countryDTO, String queryName){
        Object[] params = new Object[] {countryDTO.getCountryGroupId(),
                countryDTO.getCountryName(), countryDTO.getCreatedBy(), countryDTO.getCreatedBy()};
        int[] types = new int[] {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while saving subcategory details", e);
            return false;
        }
    }

    @Transactional
    public boolean updateCountryDetails(CountryDTO countryDTO, String queryName){
        Object[] params = new Object[] {countryDTO.getCountryName(), countryDTO.getLastUpdatedBy(), countryDTO.getCountryId()};
        int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try{
            jdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), params, types);
            return true;
        }catch(Exception e){
            logger.error("Exception while updating country details for country_id: " + countryDTO.getCountryId(), e);
            return false;
        }
    }

    @Transactional
    public boolean deleteCountryDetails(int countryId, String queryName){
        MapSqlParameterSource msps = new MapSqlParameterSource("countryId", countryId);
        try{
            namedParameterJdbcTemplate.update(queryDAO.getQuery(queryName).getQuery(), msps);
            return true;
        }catch(Exception e){
            logger.error("Exception while deleting subcategory details", e);
            return false;
        }
    }

    public List<FormatDTO> getReportFormats(String queryName){
        logger.info("Getting Report Formats");
        List<FormatDTO> formatList = jdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), new RowMapper<FormatDTO>(){
            @Override
            public FormatDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                FormatDTO formatDTO = new FormatDTO();
                formatDTO.setFormatId(rs.getInt("FORMAT_ID"));
                formatDTO.setFormatName(rs.getString("FORMAT_NAME"));
                formatDTO.setCreatedBy(rs.getString("CREATED_BY"));
                formatDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                formatDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                formatDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return formatDTO;
            }
        });
        return formatList;
    }

    public List<ElementDTO> getReportElements(String queryName){
        logger.info("Getting Report Elements");
        List<ElementDTO> elementList = jdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), new RowMapper<ElementDTO>(){
            @Override
            public ElementDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                ElementDTO elementDTO = new ElementDTO();
                elementDTO.setElementId(rs.getInt("ELEMENT_ID"));
                elementDTO.setElementName(rs.getString("ELEMENT_NAME"));
                elementDTO.setCreatedBy(rs.getString("CREATED_BY"));
                elementDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                elementDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                elementDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return elementDTO;
            }
        });
        return elementList;
    }

    public ReportDetailsDTO getReportDetails(int reportCategoryId, int reportSubCategoryId, String queryName){
        logger.info("Getting Report Details");
        MapSqlParameterSource msps = new MapSqlParameterSource("reportCategoryId", reportCategoryId).
                addValue("reportSubCategoryId", reportSubCategoryId);
        List<ReportDetailsDTO> reportDetailsList = namedParameterJdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), msps, new RowMapper<ReportDetailsDTO>(){
            @Override
            public ReportDetailsDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                ReportDetailsDTO reportDetailsDTO = new ReportDetailsDTO();
                reportDetailsDTO.setReportId(rs.getInt("REPORT_ID"));
                reportDetailsDTO.setReportCategoryId(rs.getInt("REPORT_CATEGORY_ID"));
                reportDetailsDTO.setReportSubCategoryId(rs.getInt("REPORT_SUBCATEGORY_ID"));
                reportDetailsDTO.setReportName(rs.getString("REPORT_NAME"));
                reportDetailsDTO.setReportDescription(rs.getString("REPORT_DESCRIPTION"));
                reportDetailsDTO.setReportSourceId(rs.getInt("REPORT_SOURCE_ID"));
                reportDetailsDTO.setLevelId(rs.getInt("LEVEL_ID"));
                reportDetailsDTO.setMarketRequirement(rs.getString("MARKET_REQUIREMENT"));
                reportDetailsDTO.setFundTypeId(rs.getInt("FUND_TYPE_ID"));
                reportDetailsDTO.setFormatId(rs.getInt("FORMAT_ID"));
                reportDetailsDTO.setCountryId(rs.getInt("COUNTRY_ID"));
                reportDetailsDTO.setFrequencyId(rs.getInt("FREQUENCY_ID"));
                reportDetailsDTO.setChannelId(rs.getInt("CHANNEL_ID"));
                reportDetailsDTO.setElementId(rs.getInt("ELEMENT_ID"));
                reportDetailsDTO.setCreatedBy(rs.getString("CREATED_BY"));
                reportDetailsDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                reportDetailsDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                reportDetailsDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return reportDetailsDTO;
            }
        });
        return reportDetailsList!=null? reportDetailsList.get(0):null;
    }

    public ReportDetailsDTO getReportDetailsByFilters(ReportDetailsDTO reportDetailsDTO, String queryName){
        logger.info("Getting Report Details By Filters");
        MapSqlParameterSource msps = new MapSqlParameterSource("reportCategoryId", reportDetailsDTO.getReportCategoryId())
                .addValue("reportSubCategoryId", reportDetailsDTO.getReportSubCategoryId())
                .addValue("fundTypeId", reportDetailsDTO.getFundTypeId())
                .addValue("formatId", reportDetailsDTO.getFormatId())
                .addValue("frequencyId", reportDetailsDTO.getFrequencyId())
                .addValue("channelId", reportDetailsDTO.getChannelId());
        List<ReportDetailsDTO> reportDetailsList = namedParameterJdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), msps, new RowMapper<ReportDetailsDTO>(){
            @Override
            public ReportDetailsDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                ReportDetailsDTO reportDetailsDTO = new ReportDetailsDTO();
                reportDetailsDTO.setReportId(rs.getInt("REPORT_ID"));
                reportDetailsDTO.setReportCategoryId(rs.getInt("REPORT_CATEGORY_ID"));
                reportDetailsDTO.setReportSubCategoryId(rs.getInt("REPORT_SUBCATEGORY_ID"));
                reportDetailsDTO.setReportName(rs.getString("REPORT_NAME"));
                reportDetailsDTO.setReportDescription(rs.getString("REPORT_DESCRIPTION"));
                reportDetailsDTO.setReportSourceId(rs.getInt("REPORT_SOURCE_ID"));
                reportDetailsDTO.setLevelId(rs.getInt("LEVEL_ID"));
                reportDetailsDTO.setMarketRequirement(rs.getString("MARKET_REQUIREMENT"));
                reportDetailsDTO.setFundTypeId(rs.getInt("FUND_TYPE_ID"));
                reportDetailsDTO.setFormatId(rs.getInt("FORMAT_ID"));
                reportDetailsDTO.setCountryId(rs.getInt("COUNTRY_ID"));
                reportDetailsDTO.setFrequencyId(rs.getInt("FREQUENCY_ID"));
                reportDetailsDTO.setChannelId(rs.getInt("CHANNEL_ID"));
                reportDetailsDTO.setElementId(rs.getInt("ELEMENT_ID"));
                reportDetailsDTO.setCreatedBy(rs.getString("CREATED_BY"));
                reportDetailsDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                reportDetailsDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                reportDetailsDTO.setLastUpdatedDate(rs.getDate("LAST_UPDATED_DATE"));
                return reportDetailsDTO;
            }
        });
        return reportDetailsList!=null? reportDetailsList.get(0):null;
    }
}
