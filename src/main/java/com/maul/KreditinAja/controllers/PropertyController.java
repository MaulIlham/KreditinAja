package com.maul.KreditinAja.controllers;

import com.maul.KreditinAja.entities.Image;
import com.maul.KreditinAja.entities.Property;
import com.maul.KreditinAja.services.ImageService;
import com.maul.KreditinAja.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/property")
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @Autowired
    ImageService imageService;

    @GetMapping()
    public List<Property> getAllDataProperty(){
        List<Property> properties = propertyService.getAllData().stream()
                .map(item -> {
                    List<Image> images = imageService.getAllData().stream().filter(image -> image.getPropertyId().equals(item.getId())).collect(Collectors.toList());
                    item.setImages(images);
                    return item;
                }).collect(Collectors.toList());
        return properties;
    }

    @GetMapping("/{id}")
    public Property getDataPropertyById(@PathVariable String id){
        return propertyService.getDataById(id);
    }

    @PostMapping()
    public ResponseEntity<String> saveDataProperty(@RequestPart String property, @RequestPart MultipartFile[] images) throws IOException {
        propertyService.insertData(property,images);
        return ResponseEntity.ok("Save Data Property Success");
    }

    @PutMapping()
    public ResponseEntity<String> updateDataProperty(@RequestPart String property, @RequestPart MultipartFile[] images) throws IOException {
        propertyService.updateData(property,images);
        return ResponseEntity.ok("Update Data Property Success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDataProperty(@PathVariable String id){
        propertyService.deleteData(id);
        return ResponseEntity.ok("Delete Data Property Success");
    }
}
