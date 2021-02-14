package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Image;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageRowMapper implements RowMapper<Image> {
    @Override
    public Image mapRow(ResultSet resultSet, int i) throws SQLException {
        Image image = new Image();
        image.setId(resultSet.getString("id"));
        image.setName(resultSet.getString("name"));
        image.setPropertyId(resultSet.getString("property_id"));
        return image;
    }
}
