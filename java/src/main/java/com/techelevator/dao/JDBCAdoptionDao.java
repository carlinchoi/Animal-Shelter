package com.techelevator.dao;

import com.techelevator.model.Adoption;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCAdoptionDao implements AdoptionDao {
        private final JdbcTemplate jdbcTemplate;
        public JDBCAdoptionDao(DataSource dataSource) { jdbcTemplate = new JdbcTemplate(dataSource);}

        @Override
        public List <Adoption> findAllAdoptions() {
            List<Adoption> adoptions = new ArrayList<>();
            String sql = "SELECT * FROM adoptions";
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while (result.next()) {
                adoptions.add(mapRowToAdoption(result));
            }
            return adoptions;
        }

        @Override
        public Adoption getAdoptionById(int petId) {
            Adoption adoption = new Adoption();
            String sql = "SELECT * FROM adoptions WHERE adoption_id = ?";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
            if (results.next()) {
                return mapRowToAdoption(results);
            } else {
                return null;
            }
        }


    private Adoption mapRowToAdoption(SqlRowSet sql) {
                Adoption adoption = new Adoption();
                adoption.setAdoptionId(sql.getInt("adoption_id"));
                adoption.setPetId(sql.getInt("pet_id"));
                adoption.setAdoptionDate(sql.getDate("adoption_date"));
                adoption.setParentName(sql.getString("parent_name"));
                adoption.setParentEmail(sql.getString("parent_email"));

                return adoption;
    }
}
