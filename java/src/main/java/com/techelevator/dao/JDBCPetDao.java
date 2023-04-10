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
