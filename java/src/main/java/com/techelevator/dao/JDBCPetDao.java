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
        String sql = "SELECT * FROM pets;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while (result.next()) {
            pets.add(mapRowToPet(result));
        }
        return pets;
    }

    @Override
    public Pet findById(int petId) {
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
        if (results.next()) {
            return mapRowToPet(results);
        } else {
            return null;
        }
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

//    @Override
//    public Pet createPet (Pet newPet) {
//        String sql = "INSERT INTO pets (pet_name, pet_photo, is_adopted, species, gender, breed, age_years, description) " +
//               "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING pet_id; ";
//        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
//                newPet.getPetName(), newPet.getPetPhoto(), newPet.getIsAdopted(), newPet.getSpecies(), newPet.getGender(), newPet.getBreed(), newPet.getAgeYears(), newPet.getDescription());)
//
//         return getPet(newId);
//
//
//    }

//    @Override
//    public void updatePet(Pet pet) {
//        String sql = "UPDATE pet " +
//                      "SET pet_name = ?, pet_photo = ?, is_adopted = ?, species = ?, gender = ?, breed = ?, age_years = ?, description = ? " +
//                      "WHERE pet_id = ?;";
//        jdbcTemplate.update(sql, pet.getPetName(), pet.getPetPhoto(), newPet.getIsAdopted(), pet.getSpecies(), pet.getGender(), pet.getBreed(), pet.getAgeYears(), pet.getDescription());
//
//    }


    private Pet mapRowToPet(SqlRowSet sql) {
        Pet pet = new Pet();
        pet.setPetId(sql.getInt("pet_id"));
        pet.setPetName(sql.getString("pet_name"));
        pet.setPetPhoto(sql.getString("pet_photo"));
        pet.setAdopted(sql.getBoolean("is_adopted"));
        pet.setSpecies(sql.getString("species"));
        pet.setGender(sql.getString("gender"));
        pet.setBreed(sql.getString("breed"));
        pet.setAge(sql.getInt("age_years"));
        pet.setDescription(sql.getString("description"));
        return pet;
    }
}
