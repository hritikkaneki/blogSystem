package com.example.blogsystem.service;

import com.example.blogsystem.entity.FileData;
import com.example.blogsystem.exception.CustomException;
import com.example.blogsystem.repository.FileDataRepository;
import com.example.blogsystem.service.implementation.FileDataService;
import com.example.blogsystem.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileDataServiceImpl implements FileDataService {
    private final FileDataRepository fileDataRepository;

    public FileDataServiceImpl(FileDataRepository fileDataRepository) {
        this.fileDataRepository = fileDataRepository;
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException, CustomException {
        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(FileUtil.compressFile(file.getBytes())).build());
        if(fileData!=null){
            return "File uploaded to database successfully"+file.getOriginalFilename();
        }
        else{
            return "Couldn't upload the file to database";
        }
    }

    @Override
    public FileData downloadFile(String fileName) throws CustomException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        FileData fileData1 = fileData.get();
        fileData1.setFileData(FileUtil.decompressFile(fileData.get().getFileData()));
        return fileData1;
    }
}
