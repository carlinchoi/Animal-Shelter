package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.List;

public interface PetDao {
    //List<Pet> allPet = petDao.findAll();
    public List<Pet> findAll();

    //Pet pet = petDao.findById(petId);
    public  Pet findById(int petId);

//  public List<Pet> searchPetsByName(String petName);

    public Pet createPet(Pet newPet);

    Pet updatePet(Pet pet, int petId);

    public List<Pet> findAdoptedPets();

    public List<String> findAllPhotos(int petId);
}
