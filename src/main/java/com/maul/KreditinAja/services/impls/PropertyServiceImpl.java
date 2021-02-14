package com.maul.KreditinAja.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maul.KreditinAja.entities.Image;
import com.maul.KreditinAja.entities.Property;
import com.maul.KreditinAja.repositories.PropertyRepository;
import com.maul.KreditinAja.services.ImageService;
import com.maul.KreditinAja.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ImageService imageService;

    @Override
    public List<Property> getAllData() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getDataById(String id) {
        return propertyRepository.findById(id);
    }

    @Override
    public void insertData(String data, MultipartFile[] files) throws IOException {
        Property property = objectMapper.readValue(data,Property.class);
        property.setId(UUID.randomUUID().toString());
        propertyRepository.save(property);
        for (MultipartFile file: files) {
            Image image = new Image(UUID.randomUUID().toString(),"",property.getId());
            imageService.insertData(image,file);
        }
    }

    @Override
    public void updateData(String data, MultipartFile[] files) throws IOException {
        Property property = objectMapper.readValue(data,Property.class);
        propertyRepository.update(property);
        for (MultipartFile file: files) {
            Image image = new Image(UUID.randomUUID().toString(),"",property.getId());
            imageService.updateData(image,file);
        }
    }

    @Override
    public void deleteData(String id) {
        propertyRepository.deleteById(id);
    }
}
