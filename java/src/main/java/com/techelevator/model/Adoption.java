package com.techelevator.model;

import java.util.Date;

public class Adoption {
    //private member variables
    private int adoptionId;
    private int petId;
    private String petName;
    private String species;
    //TODO LocalDate ???
    private String adoptionDate;
    private String gender;
    private String breed;
    private int age;
    private String description;
    private boolean isAdopted;
    private String petPhoto;
    private String parentName;
    private String parentEmail;

    //constructors
    public Adoption() {
    }

    public Adoption(int adoptionId, int petId, String petName, String species, String adoptionDate, String gender, String breed, int age, String description, boolean isAdopted, String petPhoto, String parentName, String parentEmail) {
        this.adoptionId = adoptionId;
        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.adoptionDate = adoptionDate;
        this.gender = gender;
        this.breed = breed;
        this.age = age;
        this.description = description;
        this.isAdopted = isAdopted;
        this.petPhoto = petPhoto;
        this.parentName = parentName;
        this.parentEmail = parentEmail;
    }

    //getters and setters
    public int getAdoptionId() {
        return adoptionId;
    }

    public void setAdoptionId(int adoptionId) {
        this.adoptionId = adoptionId;
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

    public String getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(String adoptionDate) {
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

    public String getPetPhoto() {
        return petPhoto;
    }

    public void setPetPhoto(String petPhoto) {
        this.petPhoto = petPhoto;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    //toString
    @Override
    public String toString() {
        return "Adoption{" +
                "adoptionId=" + adoptionId +
                ", petId=" + petId +
                ", petName='" + petName + '\'' +
                ", species='" + species + '\'' +
                ", adoptionDate=" + adoptionDate +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", isAdopted=" + isAdopted +
                ", petPhoto='" + petPhoto + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentEmail='" + parentEmail + '\'' +
                '}';
    }
}
