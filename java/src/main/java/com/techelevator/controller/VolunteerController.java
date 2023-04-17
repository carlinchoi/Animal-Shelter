package com.techelevator.controller;

import com.techelevator.dao.VolunteerDao;

import com.techelevator.model.User;
import com.techelevator.model.Volunteer;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping(path="/volunteer")
@CrossOrigin
public class VolunteerController {
    private final VolunteerDao volunteerDao;

    public VolunteerController( VolunteerDao volunteerDao) {

        this.volunteerDao = volunteerDao;
    }



    @RequestMapping(path="/all",method = RequestMethod.GET)
    public List<Volunteer> listAllVolunteer(){
        List<Volunteer> allVolunteer = volunteerDao.findAll();
        return allVolunteer;

    }

    @RequestMapping(value="/volunteer-pending-list",method=RequestMethod.PUT)
    public void updateVolunteer(@RequestBody Volunteer volunteer){
        volunteerDao.updatePendingVolunteerUser(volunteer);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/pending-volunteer", method = RequestMethod.GET)
    public List<Volunteer> findAllPendingVolunteers() {
        List<Volunteer> newVolunteerList = volunteerDao.findAllPendingVolunteers();
        return newVolunteerList;
    }

}
