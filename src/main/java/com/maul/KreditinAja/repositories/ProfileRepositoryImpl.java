package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProfileRepositoryImpl implements ProfileRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Profile> findAll() {
        String query = "SELECT * from profile";
        RowMapper<Profile> profileRowMapper = new ProfileRowMapper();
        List<Profile> profiles = jdbcTemplate.query(query, profileRowMapper);
        return profiles;
    }

    @Override
    public Profile findById(String id) {
        String query = "SELECT * from profile where id = ?";
        RowMapper<Profile> profileRowMapper = new BeanPropertyRowMapper<Profile>(Profile.class);
        Profile profile = jdbcTemplate.queryForObject(query, profileRowMapper, id);
        return profile;
    }

    @Override
    public Profile findByAccountId(String id) {
        String query = "SELECT * from profile where account_id = ?";
        RowMapper<Profile> profileRowMapper = new BeanPropertyRowMapper<Profile>(Profile.class);
        Profile profile = jdbcTemplate.queryForObject(query, profileRowMapper, id);
        return profile;
    }

    @Override
    public void save(Profile data) {
        String query = "INSERT INTO profile(id,account_id,isdeveloper) VALUES(?,?,?)";
        jdbcTemplate.update(query,data.getId(),data.getAccountId(),data.getIsDeveloper());
    }

    @Override
    public void update(Profile data) {
        String query = "UPDATE profile set first_name = ?, last_name = ?, " +
                "gender = ?, birth_date = ?, address = ?, photo_profile = ?, photo_identity = ?, " +
                "isdeveloper = ? where id = ?";
        jdbcTemplate.update(query,data.getFirstName(),data.getLastName(),data.getGender(),data.getBirthDate(),data.getAddress()
                ,data.getPhotoProfile(),data.getPhotoIdentity(),data.getIsDeveloper(),data.getId());
    }

    @Override
    public void deleteById(String id) {
        String query = "DELETE FROM profile where id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public void deleteAll() {
        String query = "TRUNCATE TABLE profile";
        jdbcTemplate.update(query);
    }
}
