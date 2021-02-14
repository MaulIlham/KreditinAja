package com.maul.KreditinAja.controllers;

import com.maul.KreditinAja.constants.Constant;
import com.maul.KreditinAja.entities.Account;
import com.maul.KreditinAja.entities.Image;
import com.maul.KreditinAja.entities.Profile;
import com.maul.KreditinAja.services.FileUtil;
import com.maul.KreditinAja.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    ImageService imageService;

    @Autowired
    FileUtil fileUtil;

    @GetMapping("/image")
    public List<Image> getAllDataImage(){
        return imageService.getAllData();
    }

    @GetMapping("image/{id}")
    public Image getDataImageById(@PathVariable String id){
        return imageService.getDataById(id);
    }

    @GetMapping("/image/{path}")
    public ResponseEntity<Resource> getPhotoIdentity(@PathVariable String path, HttpServletRequest request){
        Image image = imageService.getDataById(path);
        if(path==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        Resource resource = fileUtil.read(image.getId());
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

    @DeleteMapping("/image/{id}")
    public ResponseEntity<String> deleteDataImage(@PathVariable String id){
        imageService.deleteData(id);
        return ResponseEntity.ok("Delete Data Image Success");
    }
}
