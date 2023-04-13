package com.techelevator.controller;

import com.techelevator.dao.VolunteerDao;

import com.techelevator.model.Volunteer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/volunteer")
@CrossOrigin
public class VolunteerController {
    private final VolunteerDao volunteerDao;

    public VolunteerController( VolunteerDao volunteerDao) {

        this.volunteerDao = volunteerDao;
    }


    @PreAuthorize("permitAll")
    @RequestMapping(path="/all",method = RequestMethod.GET)
    public List<Volunteer> listAllVolunteer(){
        List<Volunteer> allVolunteer = volunteerDao.findAll();
        return allVolunteer;

    }
}
