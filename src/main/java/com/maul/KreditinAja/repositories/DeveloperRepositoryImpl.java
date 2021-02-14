package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class DeveloperRepositoryImpl implements DeveloperRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Developer> findAll() {
        String query = "SELECT * from developer";
        RowMapper<Developer> developerRowMapper = new DeveloperRowMapper();
        List<Developer> developers = jdbcTemplate.query(query, developerRowMapper);
        return developers;
    }

    @Override
    public Developer findById(String id) {
        String query = "SELECT * from developer where id = ?";
        RowMapper<Developer> developerRowMapper = new BeanPropertyRowMapper<Developer>(Developer.class);
        Developer developer = jdbcTemplate.queryForObject(query, developerRowMapper, id);
        return developer;
    }

    @Override
    public Developer findByAccountId(String id) {
        String query = "SELECT * from developer where account_id = ?";
        RowMapper<Developer> developerRowMapper = new BeanPropertyRowMapper<Developer>(Developer.class);
        Developer developer = jdbcTemplate.queryForObject(query, developerRowMapper, id);
        return developer;
    }

    @Override
    public void save(Developer data) {
        String query = "INSERT INTO developer(id,name,email,phone_number,fax,website,address,province,city,sub_district,village,post_code,account_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,data.getId(),data.getName(),data.getEmail(),data.getPhoneNumber(),data.getFax(),data.getWebsite(), data.getAddress(),data.getProvince(),data.getCity(),data.getSubDistrict(),data.getVillage(),data.getPostCode(),data.getAccountId());
    }

    @Override
    public void update(Developer data) {
        String query = "UPDATE developer set name = ?, email = ?, phone_number = ?, fax = ?, website = ?," +
                "address = ?, province = ?, city = ?, sub_district = ?, village = ?, post_code = ?, account_id = ? where id = ?";
        jdbcTemplate.update(query,data.getName(),data.getEmail(),data.getPhoneNumber(),data.getFax(),data.getWebsite(), data.getAddress(),data.getProvince(),data.getCity(),data.getSubDistrict(),data.getVillage(),data.getPostCode(),data.getAccountId(),data.getId());
    }

    @Override
    public void deleteById(String id) {
        String query = "DELETE FROM developer where id = ?";
        jdbcTemplate.update(query, id);
    }
}
