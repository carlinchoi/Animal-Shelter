package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/pet")
@CrossOrigin
//TODO preAuthorize??
public class PetController {
    //private Pet pet;
    private final PetDao petDao;

    public PetController( PetDao petDao) {
        //this.pet = pet;
        this.petDao = petDao;
    }
    @RequestMapping(path="/all",method = RequestMethod.GET)
    public List<Pet> listAllPet(){
        //TODO list all pet from petDao.findAll()
        List<Pet> allPet = petDao.findAll();
        //TODO return List
        return allPet;

    }
    //@RequestMapping(path="/all/adopted", method = RequestMethod.GET)
    //public List<Pet> listAllAdoptedPets(){
        //TODO list all adoptedPet from petDao.findAllAdopted()
        //List<Pet> allAdoptedPet = petDao.findAllAdopted();
        //TODO return List
        //return allPet;


    @PreAuthorize("permitAll")
    @RequestMapping(path="/{id}",method = RequestMethod.GET)
    public Pet listPet(@PathVariable("id") int petId){
        //TODO  get pet from petDao.findById()
        Pet pet = petDao.findById(petId);
        //TODO return List
        return pet;
    }

    @RequestMapping(path ="/all", method = RequestMethod.POST)
    public Pet createPet(@RequestBody Pet newPet) {
        return petDao.createPet(newPet);
    }

    @RequestMapping(path = "/{petId}", method = RequestMethod.PUT)
    public Pet updatePet(@RequestBody Pet pet, @PathVariable int petId) {
        Pet updatedPet = petDao.updatePet(pet, petId);
        if (updatedPet == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This Pet does not exist");
        } else {
            return updatedPet;
        }
    }

}
