package com.maul.KreditinAja.controllers;

import com.maul.KreditinAja.constants.Constant;
import com.maul.KreditinAja.entities.Account;
import com.maul.KreditinAja.entities.Profile;
import com.maul.KreditinAja.services.FileUtil;
import com.maul.KreditinAja.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @Autowired
    FileUtil fileUtil;

    @GetMapping()
    public List<Profile> getAllDataProfile(){
        return profileService.getAllData();
    }

    @GetMapping("/{id}")
    public Profile getDataProfileById(@PathVariable String id){
        return profileService.getDataById(id);
    }

    @GetMapping("/photo/{path}")
    public ResponseEntity<Resource> getPhotoProfile(@PathVariable String path, HttpServletRequest request){
        Profile profile = profileService.getDataById(path);
        if(profile==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        Resource resource = fileUtil.read(profile.getId());
        String contentType = null;
        try {
            contentType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+resource.getFilename()+"\"")
                .body(resource);
    }

    @GetMapping("/identity/{path}")
    public ResponseEntity<Resource> getPhotoIdentity(@PathVariable String path, HttpServletRequest request){
        String[] paths = path.split("y");
        Profile profile = profileService.getDataById(paths[1]);
        if(profile==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        Resource resource = fileUtil.read("identity"+profile.getId());
        String contentType = null;
        try {
            contentType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+resource.getFilename()+"\"")
                .body(resource);
    }


    @PostMapping()
    public ResponseEntity<String> saveDataProfile(@RequestBody Profile profile){
        profileService.insertData(profile);
        return ResponseEntity.ok("Save Data Profile Success");
    }

    @PutMapping()
    public ResponseEntity<String> updateDataProfile(@RequestPart String profile, @RequestPart MultipartFile photoProfile, @RequestPart MultipartFile photoIdentity) throws IOException {
        profileService.updateData(profile,photoProfile,photoIdentity);
        return ResponseEntity.ok("Save Data Update Success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDataProfile(@PathVariable String id){
        profileService.deleteData(id);
        return ResponseEntity.ok("Delete Data Profile Success");
    }

}
