package com.maul.KreditinAja.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maul.KreditinAja.constants.Constant;
import com.maul.KreditinAja.entities.Profile;
import com.maul.KreditinAja.repositories.ProfileRepository;
import com.maul.KreditinAja.services.FileUtil;
import com.maul.KreditinAja.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    FileUtil fileUtil;

    @Override
    public List<Profile> getAllData() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getDataById(String id) {
        return profileRepository.findById(id);
    }

    @Override
    public Profile getProfileByAccountId(String id) {
        return profileRepository.findByAccountId(id);
    }

    @Override
    public void insertData(Profile data) {
        data.setId(UUID.randomUUID().toString());
        data.setIsDeveloper(false);
        profileRepository.save(data);
    }

    @Override
    public void updateData(String data, MultipartFile photoProfile, MultipartFile photoIdentity) throws IOException {
        Profile profile = objectMapper.readValue(data, Profile.class);
        profile.setPhotoProfile(String.format(Constant.PATHPROFILE, fileUtil.uploads(profile.getId(),photoProfile)));
        profile.setPhotoIdentity(String.format(Constant.PATHIDENTITY, fileUtil.uploads("identity"+profile.getId(),photoIdentity)));
        profileRepository.update(profile);
    }

    @Override
    public void deleteData(String id) {
        profileRepository.deleteById(id);
    }
}
