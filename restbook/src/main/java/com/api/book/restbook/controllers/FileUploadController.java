package com.api.book.restbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.restbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;
    
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // System.out.println(file.getOriginalFilename());
            // System.out.println(file.getSize());
            // System.out.println(file.getContentType());
            // System.out.println(file.getName());
            if(file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            if(!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg content type are allowed");
            }
            
            //file upload code..
            //requirement -: 
            //where to uplaod the file on server
            boolean flag = fileUploadHelper.uploadFile(file);
            if(flag) {
                return ResponseEntity.ok("Uploaded Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. Try again!!");
    }
}
