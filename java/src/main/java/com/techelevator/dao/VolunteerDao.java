package com.techelevator.dao;

import com.techelevator.model.Volunteer;

import java.util.List;

public interface VolunteerDao {
    List<Volunteer> findAll();
}
