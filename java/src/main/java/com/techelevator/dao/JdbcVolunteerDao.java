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
        String sql="select * from users where role = 'ROLE_VOLANTEER' or role = 'ROLE_ADMIN' ";
        SqlRowSet result=jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Volunteer volunteer=mapRowToVolunteer(result);
            volunteers.add(volunteer);
        }
        return volunteers;
    }


    private Volunteer mapRowToVolunteer(SqlRowSet rs) {
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName(rs.getString("first_name"));
        System.out.println((volunteer.getFirstName()));
        volunteer.setLastName(rs.getString("last_name"));
        System.out.println((volunteer.getLastName()));
        volunteer.setEmail(rs.getString("email"));
        System.out.println((volunteer.getEmail()));
        volunteer.setPhone(rs.getString("phone"));
        System.out.println((volunteer.getPhone()));
        System.out.println((volunteer));
        return volunteer;
    }
}
