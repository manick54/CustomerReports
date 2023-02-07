package com.application.transaction;

import com.application.dto.QueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class QueryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Cacheable(cacheNames="query", key="#root.args[0]")
    public QueryDTO getQuery(String queryName) {

        MapSqlParameterSource msps = new MapSqlParameterSource("queryName", queryName);
        String query = "SELECT * FROM CUSTOMER.QUERY_DETAILS WHERE QUERY_NAME = :queryName ";
        List<QueryDTO> queryDTOList = namedParameterJdbcTemplate.query(query, msps, new RowMapper<QueryDTO>(){
        @Override
        public QueryDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
            QueryDTO queryDTO = new QueryDTO();
            queryDTO.setQuery(rs.getString("QUERY"));
            queryDTO.setQueryID(rs.getString("QUERY_ID"));
            queryDTO.setQueryName(rs.getString("QUERY_NAME"));
            queryDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
            return queryDTO;
        }
    });
        return queryDTOList !=null ?queryDTOList.get(0):null;
    }

}
