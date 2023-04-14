package com.techelevator.dao;

import com.techelevator.model.Adoption;

import java.util.List;

public interface AdoptionDao {

        List<Adoption> findAllAdoptions ();

        Adoption getAdoptionById(int adoptionId);

        Adoption createAdoption(Adoption adoption);

        Adoption findAdoptionById(int id);

}
