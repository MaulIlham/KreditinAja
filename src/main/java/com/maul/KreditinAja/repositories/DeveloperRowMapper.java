package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Developer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperRowMapper implements RowMapper<Developer> {
    @Override
    public Developer mapRow(ResultSet resultSet, int i) throws SQLException {
        Developer developer = new Developer();
        developer.setId(resultSet.getString("id"));
        developer.setName(resultSet.getString("name"));
        developer.setAddress(resultSet.getString("address"));
        developer.setAccountId(resultSet.getString("account_id"));
        developer.setCity(resultSet.getString("city"));
        developer.setEmail(resultSet.getString("email"));
        developer.setFax(resultSet.getString("fax"));
        developer.setPostCode(resultSet.getString("post_code"));
        developer.setPhoneNumber(resultSet.getString("phone_number"));
        developer.setWebsite(resultSet.getString("website"));
        developer.setProvince(resultSet.getString("province"));
        developer.setSubDistrict(resultSet.getString("sub_district"));
        developer.setVillage(resultSet.getString("village"));
        return developer;
    }
}
