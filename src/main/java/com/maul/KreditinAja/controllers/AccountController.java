package com.maul.KreditinAja.controllers;

import com.maul.KreditinAja.entities.*;
import com.maul.KreditinAja.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    ProfileService profileService;

    @Autowired
    DeveloperService developerService;

    @Autowired
    PropertyService propertyService;

    @Autowired
    ImageService imageService;

    @GetMapping()
    public List<Account> getAllDataAccount(){
        List<Account> accounts = accountService.getAllData().stream()
                .map(item -> {
                    Profile profile = profileService.getProfileByAccountId(item.getId());
                    Developer developer = developerService.getDeveloperByAccountId(item.getId());
                    List<Property> properties = propertyService.getAllData().stream()
                            .filter(property -> property.getDeveloperId().equals(item.getId()))
                            .map(property -> {
                                List<Image> images = imageService.getAllData().stream().filter(image -> image.getPropertyId().equals(property.getId())).collect(Collectors.toList());
                                property.setImages(images);
                                return property;
                            }).collect(Collectors.toList());
                    item.setProfile(profile);
                    item.setDeveloper(developer);
                    item.setProperties(properties);
                    return item;
                }).collect(Collectors.toList());
        return accounts;
    }

    @GetMapping("/{id}")
    public Account getDataAccountById(@PathVariable String id){
        Profile profile = profileService.getProfileByAccountId(id);
        Account account= accountService.getDataById(id);
        account.setProfile(profile);
        return account;
    }

    @GetMapping("/find/{username}")
    public Account getDataAccountByUsername(@PathVariable String username){
        Account account= accountService.getAccountByUsername(username);
        Profile profile = profileService.getProfileByAccountId(account.getId());
        account.setProfile(profile);
        return account;
    }

    @PostMapping()
    public ResponseEntity<String> saveDataAccount(@RequestBody Account account){
        accountService.insertData(account);
        return ResponseEntity.ok("Save Data Account Success");
    }

    @PutMapping()
    public ResponseEntity<String> updateDataAccount(@RequestBody Account account){
        accountService.updateData(account);
        return ResponseEntity.ok("Update Data Account Success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDataAccount(@PathVariable String id){
        accountService.deleteData(id);
        return ResponseEntity.ok("Delete Data Account Success");
    }
}
