package com.techelevator.controller;

import com.techelevator.dao.AdoptionDao;
import com.techelevator.model.Adoption;
import com.techelevator.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@RequestMapping(path="")
@CrossOrigin
public class AdoptionController {
    private final AdoptionDao adoptionDao;

    public AdoptionController(AdoptionDao adoptionDao) {
        this.adoptionDao = adoptionDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path ="/adoption-form", method = RequestMethod.POST)
    public boolean createAdoption(@Valid @RequestBody Adoption newAdoption) {
        adoptionDao.createAdoption(newAdoption);
        return true;
    }



}
