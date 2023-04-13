package com.techelevator.dao;


import com.techelevator.model.Volunteer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcVolunteerDao implements VolunteerDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcVolunteerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Volunteer> findAll() {
        List<Volunteer> volunteers = new ArrayList<>();
        String sql="select * from users where(role = 'ROLE_VOLUNTEER' OR role = 'ROLE_ADMIN') AND first_name <> '' ";
        SqlRowSet result=jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Volunteer volunteer=mapRowToVolunteer(result);
            volunteers.add(volunteer);
        }
        System.out.println((volunteers));
        return volunteers;
    }


    private Volunteer mapRowToVolunteer(SqlRowSet rs) {
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName(rs.getString("first_name"));
        volunteer.setLastName(rs.getString("last_name"));
        volunteer.setEmail(rs.getString("email"));
        volunteer.setPhone(rs.getString("phone"));
        volunteer.setRole(rs.getString("role"));

        return volunteer;
    }
}
