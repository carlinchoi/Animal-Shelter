package com.techelevator.dao;

import com.techelevator.model.VolunteerApplication;

import java.util.List;

public interface VolunteerApplicationDAO {

    public List<VolunteerApplication> findAll();

    public VolunteerApplication findById (int applicationId);

    VolunteerApplication createVolunteerApplication(VolunteerApplication volunteerApplication);

//    public Application submitApplication();
//
//    public Application checkApplicationStatus(String status);

    //public DeleteApplication(int application_id);
}
