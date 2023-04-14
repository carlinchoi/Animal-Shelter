package com.techelevator.controller;

import com.techelevator.dao.AdoptionDao;
import com.techelevator.model.Adoption;
import com.techelevator.model.Pet;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/")
@CrossOrigin
public class AdoptionController {
    private final AdoptionDao adoptionDao;

    public AdoptionController(AdoptionDao adoptionDao) {
        this.adoptionDao = adoptionDao;
    }

    @RequestMapping(path ="/adoption-form", method = RequestMethod.POST)
    public Adoption createAdoption(@RequestBody Adoption newAdoption) {
        return adoptionDao.createAdoption(newAdoption);
    }



}
