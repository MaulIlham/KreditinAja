package com.maul.KreditinAja.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUtil {
    public Resource read(String fileName);
    public String uploads(String id, MultipartFile file) throws IOException;
}
