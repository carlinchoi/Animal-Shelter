package com.techelevator.dao;


import com.techelevator.model.Volunteer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
    @Override
    public void updatePendingVolunteerUser(Volunteer volunteerPendingUser) {
        System.out.println(volunteerPendingUser);
        String insertUserSql = "UPDATE users SET  email=?, first_name=?, last_name=?, phone=?, role=? WHERE user_id=?";
        System.out.println(insertUserSql);
        System.out.println(volunteerPendingUser);
        jdbcTemplate.update(insertUserSql,volunteerPendingUser.getEmail(),volunteerPendingUser.getFirstName(),volunteerPendingUser.getLastName(),volunteerPendingUser.getPhone(),volunteerPendingUser.getRole(),volunteerPendingUser.getUserId());
    }

    @Override
    public List<Volunteer> findAllPendingVolunteers() {
        List<Volunteer> pendingVolunteerList = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = 'ROLE_PENDINGVOLUNTEER';";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            pendingVolunteerList.add(mapRowToVolunteer(result));
        }
        return pendingVolunteerList;
    }

    @Override
    public List<Volunteer> findVolunteersToPromote() {
        List<Volunteer> pendingVolunteerList = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = 'ROLE_VOLUNTEER';";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            pendingVolunteerList.add(mapRowToVolunteer(result));
        }
        return pendingVolunteerList;
    }





    private Volunteer mapRowToVolunteer(SqlRowSet rs) {
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName(rs.getString("first_name"));
        volunteer.setLastName(rs.getString("last_name"));
        volunteer.setEmail(rs.getString("email"));
        volunteer.setPhone(rs.getString("phone"));
        volunteer.setRole(rs.getString("role"));
        volunteer.setUserId(rs.getInt("user_id"));
        System.out.println(volunteer);
        return volunteer;
    }
}
