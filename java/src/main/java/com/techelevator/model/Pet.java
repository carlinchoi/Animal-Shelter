package com.techelevator.model;

import java.util.Date;

public class Pet {
    private int petId;
    private String petName;
    private String species;
    //TODO LocalDate ???
    private Date adoptionDate;
    private String gender;
    private String breed;
    private int age;
    private String description;
    private boolean isAdopted;

    public Pet(){

    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", species='" + species + '\'' +
                ", adoptionDate=" + adoptionDate +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", isAdopted=" + isAdopted +
                '}';
    }

    public Pet(int petId, String petName, String species, Date adoptionDate, String gender, String breed, int age, String description, boolean isAdopted) {
        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.adoptionDate = adoptionDate;
        this.gender = gender;
        this.breed = breed;
        this.age = age;
        this.description = description;
        this.isAdopted = isAdopted;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }
}
