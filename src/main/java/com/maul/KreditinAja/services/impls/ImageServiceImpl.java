package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.constants.Constant;
import com.maul.KreditinAja.entities.Image;
import com.maul.KreditinAja.repositories.ImageRepository;
import com.maul.KreditinAja.services.FileUtil;
import com.maul.KreditinAja.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    FileUtil fileUtil;

    @Override
    public List<Image> getAllData() {
        return imageRepository.findAll();
    }

    @Override
    public Image getDataById(String id) {
        return imageRepository.findById(id);
    }

    @Override
    public void insertData(Image data, MultipartFile file) throws IOException {
        data.setId(UUID.randomUUID().toString());
        data.setName(String.format(Constant.PATHIMAGE,fileUtil.uploads(data.getId(),file)));
        imageRepository.save(data);
    }

    @Override
    public void updateData(Image data, MultipartFile file) throws IOException {
        deleteData(data.getId());
        insertData(data,file);
    }

    @Override
    public void deleteData(String id) {
        imageRepository.deleteById(id);
    }
}
