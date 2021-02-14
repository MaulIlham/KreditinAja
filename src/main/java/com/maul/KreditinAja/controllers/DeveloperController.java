package com.maul.KreditinAja.controllers;

import com.maul.KreditinAja.entities.Account;
import com.maul.KreditinAja.entities.Developer;
import com.maul.KreditinAja.entities.Image;
import com.maul.KreditinAja.entities.Property;
import com.maul.KreditinAja.services.DeveloperService;
import com.maul.KreditinAja.services.ImageService;
import com.maul.KreditinAja.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/developer")
public class DeveloperController {
    @Autowired
    DeveloperService developerService;

    @Autowired
    PropertyService propertyService;

    @Autowired
    ImageService imageService;

    @GetMapping()
    public List<Developer> getAllDataDeveloper(){
        List<Developer> developers = developerService.getAllData().stream()
                .map(item -> {
                    List<Property> properties = propertyService.getAllData().stream()
                            .filter(property -> property.getDeveloperId().equals(item.getId()))
                            .map(property -> {
                                List<Image> images = imageService.getAllData().stream().filter(image -> image.getPropertyId().equals(property.getId())).collect(Collectors.toList());
                                property.setImages(images);
                                return property;
                            }).collect(Collectors.toList());
                    item.setProperties(properties);
                    return item;
                }).collect(Collectors.toList());
        return developers;
    }

    @GetMapping("/{id}")
    public Developer getDataDeveloperById(@PathVariable String id){
        List<Property> properties = propertyService.getAllData().stream()
                .filter(property -> property.getDeveloperId().equals(id))
                .map(item -> {
                    List<Image> images = imageService.getAllData().stream().filter(image -> image.getPropertyId().equals(item.getId())).collect(Collectors.toList());
                    item.setImages(images);
                    return item;
                }).collect(Collectors.toList());
        Developer developer = developerService.getDataById(id);
        developer.setProperties(properties);
        return developer;
    }

    @PostMapping()
    public ResponseEntity<String> saveDataDeveloper(@RequestBody Developer developer){
        developerService.insertData(developer);
        return ResponseEntity.ok("Save Data Developer Success");
    }

    @PutMapping()
    public ResponseEntity<String> updateDataDeveloper(@RequestBody Developer developer){
        developerService.updateData(developer);
        return ResponseEntity.ok("Update Data Developer Success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDataDeveloper(@PathVariable String id){
        developerService.deleteData(id);
        return ResponseEntity.ok("Delete Data Developer Success");
    }
}
