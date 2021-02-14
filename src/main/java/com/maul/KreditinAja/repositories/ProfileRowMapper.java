package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Profile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileRowMapper implements RowMapper<Profile> {
    @Override
    public Profile mapRow(ResultSet resultSet, int i) throws SQLException {
        Profile profile = new Profile();
        profile.setId(resultSet.getString("id"));
        profile.setFirstName(resultSet.getString("first_name"));
        profile.setLastName(resultSet.getString("last_name"));
        profile.setGender(resultSet.getString("gender"));
        profile.setBirthDate(resultSet.getString("birth_date"));
        profile.setAddress(resultSet.getString("address"));
        profile.setPhotoProfile(resultSet.getString("photo_profile"));
        profile.setPhotoIdentity(resultSet.getString("photo_identity"));
        profile.setAccountId(resultSet.getString("account_id"));
        profile.setIsDeveloper(resultSet.getBoolean("isdeveloper"));
        return profile;
    }
}
