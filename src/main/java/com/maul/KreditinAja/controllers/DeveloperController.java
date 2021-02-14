package com.maul.KreditinAja.controllers;

import com.maul.KreditinAja.entities.Account;
import com.maul.KreditinAja.entities.Developer;
import com.maul.KreditinAja.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developer")
public class DeveloperController {
    @Autowired
    DeveloperService developerService;

    @GetMapping()
    public List<Developer> getAllDataDeveloper(){
        return developerService.getAllData();
    }

    @GetMapping("/{id}")
    public Developer getDataDeveloperById(@PathVariable String id){
        return developerService.getDataById(id);
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
