package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCPetDao implements PetDao {
    private final JdbcTemplate jdbcTemplate;
    public JDBCPetDao(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT pets.*, pet_photos.photo_url \n" +
                "FROM pets \n" +
                "LEFT JOIN pet_photos \n" +
                "ON pets.pet_id = pet_photos.pet_id \n" +
                "WHERE pets.is_adopted = false;\n";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            pets.add(mapRowToPet(result));
        }
        return pets;
    }

    @Override
    public Pet findById(int petId) {
        String sql = "SELECT pets.*, pet_photos.photo_url\n" +
                "FROM pets\n" +
                "LEFT JOIN pet_photos ON pets.pet_id = pet_photos.pet_id\n" +
                "WHERE pets.pet_id = ?;\n";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
        if (results.next()) {
            return mapRowToPet(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Pet> findAdoptedPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT pets.*, pet_photos.photo_url \n" +
                "FROM pets \n" +
                "LEFT JOIN pet_photos ON pets.pet_id = pet_photos.pet_id \n" +
                "WHERE pets.is_adopted = true;\n";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            pets.add(mapRowToPet(result));
        }
        return pets;
    }

    @Override
    public List<String> findAllPhotos(int petId) {
        List<String> photoUrls = new ArrayList<>();
        String sql = "SELECT photo_url FROM pet_photos WHERE pet_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, petId);

        while(result.next()) {
            String photoUrl = result.getString("photo_url");
            photoUrls.add(photoUrl);
        }
        return photoUrls;
    }



//    @Override
//    public List searchPetsByName(String petName) {
//          List<Pet> petByName = new ArrayList<>();
//          String sql = "SELECT pet_id, pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description " +
//                  "FROM pets " +
//                  "WHERE pet_name ILIKE ?; ";
//              SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + petName + "%");
//              while (results.next()) {
//                  petByName.add(mapRowToPet(results));
//    }
//        return petByName;
//    }

    @Override
    public Pet createPet (Pet newPet) {
        String sql = "INSERT INTO pets (pet_name, is_adopted, species, gender, breed, age_years, description) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING pet_id; ";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                newPet.getPetName(), newPet.isAdopted(), newPet.getSpecies(), newPet.getGender(), newPet.getBreed(), newPet.getAge(), newPet.getDescription());

        String sql2 = "INSERT INTO pet_photos (pet_id, photo_url) VALUES (?, ?);";
        jdbcTemplate.update(sql2, newId, newPet.getPetPhoto());

        return findById(newId);
    }


    //    @Override
//    public Pet updatePet(Pet pet, int petId) {
//        String sql = "UPDATE pets " +
//                "SET pet_name = ?, is_adopted = ?, species = ?, gender = ?, breed = ?, age_years = ?, description = ? " +
//                "WHERE pet_id = ?;";
//        jdbcTemplate.update(sql, pet.getPetName(), pet.isAdopted(), pet.getSpecies(), pet.getGender(), pet.getBreed(), pet.getAge(), pet.getDescription(), petId);
//
//        sql = "UPDATE pet_photo " +
//                "SET photo_url = ? " +
//                "WHERE pet_id = ?;";
//        jdbcTemplate.update(sql, pet.getPetPhoto(), petId);
//
//        return pet;
//    }
@Override
public Pet updatePet(Pet pet, int petId) {
    String sql = "UPDATE pets " +
            "SET pet_name = ?, is_adopted = ?, species = ?, gender = ?, breed = ?, age_years = ?, description = ?, adoption_date = ? " +
            "FROM pet_photos " +
            "WHERE pets.pet_id = pet_photos.pet_id AND pets.pet_id = ?;";

    jdbcTemplate.update(sql, pet.getPetName(), pet.isAdopted(), pet.getSpecies(), pet.getGender(), pet.getBreed(), pet.getAge(), pet.getDescription(), pet.getAdoptionDate(), petId);

    String sql2 = "UPDATE pet_photos " +
            "SET photo_url = ? " +
            "WHERE pet_id = ?;";

    jdbcTemplate.update(sql2, pet.getPetPhoto(), petId);

    return pet;
}






    private Pet mapRowToPet(SqlRowSet sql) {
        Pet pet = new Pet();
        pet.setPetId(sql.getInt("pet_id"));
        pet.setPetName(sql.getString("pet_name"));
        pet.setPetPhoto(sql.getString("photo_url"));
        pet.setAdopted(sql.getBoolean("is_adopted"));
        pet.setSpecies(sql.getString("species"));
        pet.setGender(sql.getString("gender"));
        pet.setBreed(sql.getString("breed"));
        pet.setAge(sql.getInt("age_years"));
        pet.setDescription(sql.getString("description"));
        pet.setAdoptionDate(sql.getString("adoption_date"));
        return pet;
    }

    private Pet mapRowToPetPhoto(SqlRowSet sql) {
        Pet pet = new Pet();
        pet.setPetPhoto(sql.getString("photo_url"));
        return pet;
    }

}
