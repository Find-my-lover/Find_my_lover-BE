package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.dto.FileDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
    private final AmazonS3ResourceStorage amazonS3ResourceStorage;

    @Autowired
    public FileUploadService(AmazonS3ResourceStorage amazonS3ResourceStorage) {
        this.amazonS3ResourceStorage = amazonS3ResourceStorage;
    }

    public FileDetail save(MultipartFile multipartFile) {
        FileDetail fileDetail = FileDetail.multipartOf(multipartFile);
        amazonS3ResourceStorage.store(fileDetail.getPath(), multipartFile);
        return fileDetail;
    }
}