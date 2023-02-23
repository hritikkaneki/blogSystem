package com.example.blogsystem.controller;

import com.example.blogsystem.entity.FileData;
import com.example.blogsystem.exception.CustomException;
import com.example.blogsystem.service.implementation.FileDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileDataController {
    private final FileDataService fileDataService;

    public FileDataController(FileDataService fileDataService) {
        this.fileDataService = fileDataService;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file) throws IOException, CustomException {
        String uploadFile = fileDataService.uploadFile(file);
        return new ResponseEntity<>(uploadFile,HttpStatus.OK);
    }

    @GetMapping("{fileName}")
    public ResponseEntity<?>downloadFile(@PathVariable("fileName") String fileData) throws CustomException {
//        String fileName = fileData.getName();
//        String type= fileData.getType();
//        System.out.println(type);
        FileData fileData1 = fileDataService.downloadFile(fileData);
//        System.out.println(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(fileData1.getType()))
                .body(fileData1.getFileData());



    }
}
