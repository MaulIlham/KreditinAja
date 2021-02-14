package com.maul.KreditinAja.services;

import com.maul.KreditinAja.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    public List<Image> getAllData();
    public Image getDataById(String id);
    public void insertData(Image data, MultipartFile file) throws IOException;
    public void updateData(Image data, MultipartFile file) throws IOException;
    public void deleteData(String id);
}
