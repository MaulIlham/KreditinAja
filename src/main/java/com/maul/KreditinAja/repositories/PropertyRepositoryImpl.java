package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class PropertyRepositoryImpl implements PropertyRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Property> findAll() {
        String query = "SELECT * from property";
        RowMapper<Property> propertyRowMapper = new PropertyRowMapper();
        List<Property> properties = jdbcTemplate.query(query, propertyRowMapper);
        return properties;
    }

    @Override
    public Property findById(String id) {
        String query = "SELECT * from property where id = ?";
        RowMapper<Property> propertyRowMapper = new BeanPropertyRowMapper<Property>(Property.class);
        Property property = jdbcTemplate.queryForObject(query, propertyRowMapper, id);
        return property;
    }

    @Override
    public void save(Property data) {
        String query = "INSERT INTO property(id,name,size,address,latitude,longitude,certificate,power_supply,description,price,status,account_id,developer_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,data.getId(),data.getName(),data.getSize(),data.getAddress(),data.getLatitude(),data.getLongitude(),data.getCertificate(),data.getPowerSupply(),data.getDescription(),data.getPrice(),data.getStatus(),data.getAccountId(),data.getDeveloperId());
    }

    @Override
    public void update(Property data) {
        String query = "UPDATE property SET name = ?,size = ?,address = ?,latitude = ?,longitude = ?,certificate = ?,power_supply = ?,description = ?,price = ?,status = ?,account_id = ?,developer_id = ? where id =?";
        jdbcTemplate.update(query,data.getName(),data.getSize(),data.getAddress(),data.getLatitude(),data.getLongitude(),data.getCertificate(),data.getPowerSupply(),data.getDescription(),data.getPrice(),data.getStatus(),data.getAccountId(),data.getDeveloperId(),data.getId());
    }

    @Override
    public void deleteById(String id) {
        String query = "DELETE FROM property where id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public void deleteAll() {
        String query = "TRUNCATE TABLE property";
        jdbcTemplate.update(query);
    }
}
