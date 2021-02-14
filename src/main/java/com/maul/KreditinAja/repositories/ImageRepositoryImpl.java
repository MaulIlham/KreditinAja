package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Image;
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
public class ImageRepositoryImpl implements ImageRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Image> findAll() {
        String query = "SELECT * from image";
        RowMapper<Image> imageRowMapper = new ImageRowMapper();
        List<Image> images = jdbcTemplate.query(query, imageRowMapper);
        return images;
    }

    @Override
    public Image findById(String id) {
        String query = "SELECT * from image where id = ?";
        RowMapper<Image> imageRowMapper = new BeanPropertyRowMapper<Image>(Image.class);
        Image image = jdbcTemplate.queryForObject(query, imageRowMapper,id);
        return image;
    }

    @Override
    public void save(Image data) {
        String query = "INSERT INTO image(id,name,property_id) VALUES(?,?,?)";
        jdbcTemplate.update(query,data.getId(),data.getName(),data.getPropertyId());
    }

    @Override
    public void update(Image data) {
        String query = "UPDATE image set name = ?, property_id = ? where id = ?";
        jdbcTemplate.update(query,data.getName(),data.getPropertyId(),data.getId());
    }

    @Override
    public void deleteById(String id) {
        String query = "DELETE FROM image where id = ?";
        jdbcTemplate.update(query, id);
    }
}
