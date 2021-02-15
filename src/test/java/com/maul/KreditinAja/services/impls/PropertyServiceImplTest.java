package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.entities.Property;
import com.maul.KreditinAja.repositories.ProfileRepository;
import com.maul.KreditinAja.repositories.PropertyRepository;
import com.maul.KreditinAja.services.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyServiceImplTest {

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    PropertyService propertyService;

    @BeforeEach
    public void cleanUp() {
        propertyRepository.deleteAll();
    }

    @Test
    void getAllData() {
        Property property = new Property("uuid","griya","75m2","jl. sudirman","234234234","234324234243","23423423432",2200,"rumah 2 lantai",300000.0,"Konvensional","testaccount","testdeveloper");
        propertyRepository.save(property);
        assertEquals(1,propertyService.getAllData().size());
    }

    @Test
    void getDataById() {
        Property property = new Property("uuid","griya","75m2","jl. sudirman","234234234","234324234243","23423423432",2200,"rumah 2 lantai",300000.0,"Konvensional","testaccount","testdeveloper");
        propertyRepository.save(property);
        assertEquals(property,propertyService.getDataById(property.getId()));
    }

    @Test
    void insertData() {
    }

    @Test
    void updateData() {
    }

    @Test
    void deleteData() {
        Property propertyA = new Property("uuid1","griya","75m2","jl. sudirman","234234234","234324234243","23423423432",2200,"rumah 2 lantai",300000.0,"Konvensional","testaccount","testdeveloper");
        Property propertyB = new Property("uuid2","griya","75m2","jl. sudirman","234234234","234324234243","23423423432",2200,"rumah 2 lantai",300000.0,"Konvensional","testaccount","testdeveloper");
        propertyRepository.save(propertyA);
        propertyRepository.save(propertyB);
        propertyService.deleteData(propertyA.getId());
        assertEquals(1,propertyService.getAllData().size());
    }
}