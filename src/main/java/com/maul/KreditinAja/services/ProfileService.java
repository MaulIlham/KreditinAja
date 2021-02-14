package com.maul.KreditinAja.services;

import com.maul.KreditinAja.entities.Profile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProfileService {
    public List<Profile> getAllData();
    public Profile getDataById(String id);
    public Profile getProfileByAccountId(String id);
    public void insertData(Profile data);
    public void updateData(String data, MultipartFile photoProfile, MultipartFile photoIdentity) throws IOException;
    public void deleteData(String id);
}
