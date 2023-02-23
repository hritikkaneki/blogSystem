package com.example.blogsystem.service.implementation;

import com.example.blogsystem.entity.FileData;
import com.example.blogsystem.exception.CustomException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileDataService {
    String uploadFile(MultipartFile file) throws IOException, CustomException;

    FileData downloadFile(String fileName) throws CustomException;

}
