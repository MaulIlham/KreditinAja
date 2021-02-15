package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.entities.Developer;
import com.maul.KreditinAja.repositories.DeveloperRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeveloperServiceImplTest {

    @Autowired
    DeveloperRepository developerRepository;

    @BeforeEach
    public void cleanUp() {
        developerRepository.deleteAll();
    }

    @Test
    void getAllData_shouldGet1_whenDataInDBIs1() {
        Developer developer = new Developer("uuid","maul","maul@gmail.com","08344234234","+2342432","www.maul.com","JL. sudirman","Jawa Tengah","Semarang","Ngaliyan","Mangunharjo","512300","uuidaccount");
        developerRepository.save(developer);
        assertEquals(1,developerRepository.findAll().size());
    }

    @Test
    void getDataById_shouldGet1_whenDataInDBIs1() {
        Developer developer = new Developer("uuid","maul","maul@gmail.com","08344234234","+2342432","www.maul.com","JL. sudirman","Jawa Tengah","Semarang","Ngaliyan","Mangunharjo","512300","uuidaccount");
        developerRepository.save(developer);
        assertEquals(developer,developerRepository.findById(developer.getId()));
    }

    @Test
    void getDeveloperByAccountId_shouldGetData_whenGivenCorrectId() {
        Developer developer = new Developer("uuid","maul","maul@gmail.com","08344234234","+2342432","www.maul.com","JL. sudirman","Jawa Tengah","Semarang","Ngaliyan","Mangunharjo","512300","uuidaccount");
        developerRepository.save(developer);
        assertEquals(developer,developerRepository.findByAccountId(developer.getAccountId()));
    }

    @Test
    void insertData_shouldAdd1DataInDB_whenSaved() {
        Developer developer = new Developer("uuid","maul","maul@gmail.com","08344234234","+2342432","www.maul.com","JL. sudirman","Jawa Tengah","Semarang","Ngaliyan","Mangunharjo","512300","uuidaccount");
        developerRepository.save(developer);
        assertEquals(1,developerRepository.findAll().size());
    }

    @Test
    void updateData_shouldUpdateDataInDB_whenUpdate() {
        Developer developer = new Developer("uuid","maul","maul@gmail.com","08344234234","+2342432","www.maul.com","JL. sudirman","Jawa Tengah","Semarang","Ngaliyan","Mangunharjo","512300","uuidaccount");
        developerRepository.save(developer);
        Developer developerUpdate = developerRepository.findById(developer.getId());
        developer.setName("TestUpdate");
        developerRepository.update(developerUpdate);
        assertEquals(developer,developerRepository.findById(developer.getId()));
    }

    @Test
    void deleteData_shouldDelete1DataInDB_whenDeleted() {
        Developer developerA = new Developer("uuid1","maul","maul@gmail.com","08344234234","+2342432","www.maul.com","JL. sudirman","Jawa Tengah","Semarang","Ngaliyan","Mangunharjo","512300","uuidaccount");
        Developer developerB = new Developer("uuid2","maul2","maul@gmail.com","08344234234","+2342432","www.maul.com","JL. sudirman","Jawa Tengah","Semarang","Ngaliyan","Mangunharjo","512300","uuidaccount");
        developerRepository.save(developerA);
        developerRepository.save(developerB);
        developerRepository.deleteById(developerA.getId());
        assertEquals(1,developerRepository.findAll().size());
    }
}