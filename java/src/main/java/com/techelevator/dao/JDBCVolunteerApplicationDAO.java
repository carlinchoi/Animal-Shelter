package com.techelevator.dao;


import com.techelevator.model.VolunteerApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCVolunteerApplicationDAO implements VolunteerApplicationDAO {
    private final JdbcTemplate jdbcTemplate;
    public JDBCVolunteerApplicationDAO (DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource);}

    public JDBCVolunteerApplicationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<VolunteerApplication> findAll() {
        List<VolunteerApplication> volunteer_application = new ArrayList<>();
        String sql = "SELECT * FROM volunteer_application;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            volunteer_application.add(mapRowToVolunteerApplication(result));
        }
        return volunteer_application;
    }

    @Override
    public VolunteerApplication findById(int applicationId) {
        VolunteerApplication volunteerapplication = new VolunteerApplication();
        String sql = "SELECT * FROM volunteer_application WHERE application_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, applicationId);
        if (results.next()) {
            return mapRowToVolunteerApplication(results);
        } else {
            return null;
        }
    }







    private VolunteerApplication mapRowToVolunteerApplication(SqlRowSet sql) {
        VolunteerApplication volunteerapplication = new VolunteerApplication();
        volunteerapplication.setApplicationId(sql.getInt("application_id"));
        volunteerapplication.setUserId(sql.getInt("user_id"));
        volunteerapplication.setApplicationStatus(sql.getString("status"));
        return volunteerapplication;
    }



}
