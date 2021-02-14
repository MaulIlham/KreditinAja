package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Property;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PropertyRowMapper implements RowMapper<Property> {
    @Override
    public Property mapRow(ResultSet resultSet, int i) throws SQLException {
        Property property = new Property();
        property.setId(resultSet.getString("id"));
        property.setName(resultSet.getString("name"));
        property.setSize(resultSet.getString("size"));
        property.setAddress(resultSet.getString("address"));
        property.setLatitude(resultSet.getString("latitude"));
        property.setLongitude(resultSet.getString("longitude"));
        property.setCertificate(resultSet.getString("certificate"));
        property.setPowerSupply(resultSet.getInt("power_supply"));
        property.setDescription(resultSet.getString("description"));
        property.setPrice(resultSet.getDouble("price"));
        property.setStatus(resultSet.getString("status"));
        property.setAccountId(resultSet.getString("account_id"));
        property.setDeveloperId(resultSet.getString("developer_id"));
        return property;
    }
}
