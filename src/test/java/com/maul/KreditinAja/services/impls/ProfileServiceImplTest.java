package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.entities.Profile;
import com.maul.KreditinAja.repositories.ProfileRepository;
import com.maul.KreditinAja.services.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProfileServiceImplTest {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ProfileService profileService;

    @BeforeEach
    public void cleanUp() {
        profileRepository.deleteAll();
    }

    @Test
    void getAllData_shouldGet1_whenDataInDBIs1() {
        Profile profile = new Profile("uuid","maul","ana","Male","JL. Sudirman","pathphoto","pathidentity","testacountid","testdeveloperid",false);
        profileRepository.save(profile);
        assertEquals(1,profileService.getAllData().size());
    }

    @Test
    void getDataById_shouldGetData_whenGivenCorrectId() {
        Profile profile = new Profile();
        profile.setId("uuid");
        profile.setAccountId("test");
        profileRepository.save(profile);
        System.out.println(profileRepository.findById(profile.getId()).toString());
        assertEquals(profile,profileRepository.findById(profile.getId()));
    }

    @Test
    void getProfileByAccountId_shouldGetData_whenGivenCorrectAccountId() {
        Profile profile = new Profile();
        profile.setId("uuid");
        profile.setAccountId("test");
        profileRepository.save(profile);
        assertEquals(profile,profileRepository.findByAccountId(profile.getAccountId()));
    }

    @Test
    void insertData_shouldAdd1DataInDB_whenSaved() {
        Profile profile = new Profile("uuid","maul","ana","Male","JL. Sudirman","pathphoto","pathidentity","testacountid","testdeveloperid",false);
        profileRepository.save(profile);
        assertEquals(1,profileRepository.findAll().size());
    }

    @Test
    void updateData() {
    }

    @Test
    void deleteData_shouldDelete1DataInDB_whenDeleted() {
        Profile profileA = new Profile("uuid1","maul","ana","Male","JL. Sudirman","pathphoto","pathidentity","testacountid","testdeveloperid",false);
        Profile profileB = new Profile("uuid2","maul","ana","Male","JL. Sudirman","pathphoto","pathidentity","testacountid","testdeveloperid",false);
        profileRepository.save(profileA);
        profileRepository.save(profileB);
        profileRepository.deleteById(profileA.getId());
        assertEquals(1,profileRepository.findAll().size());
    }
}