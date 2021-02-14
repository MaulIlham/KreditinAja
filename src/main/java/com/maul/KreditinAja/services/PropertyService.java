package com.maul.KreditinAja.services;

import com.maul.KreditinAja.entities.Property;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PropertyService {
    public List<Property> getAllData();
    public Property getDataById(String id);
    public void insertData(String data, MultipartFile[] files) throws IOException;
    public void updateData(String data, MultipartFile[] files) throws IOException;
    public void deleteData(String id);
}
