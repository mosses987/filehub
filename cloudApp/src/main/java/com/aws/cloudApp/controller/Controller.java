package com.aws.cloudApp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.aws.cloudApp.service.AWSS3Service;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class Controller {

	@Autowired
    private AWSS3Service service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
    }
    
//    @GetMapping("/retrieveFile")
//    public List<String> deleteFile() {
//        return service.getFileName();
//    }
    
    @GetMapping("/getFiles")
    public ResponseEntity<List<String>> deleteFile() {
    	HttpHeaders headers = new HttpHeaders();
            
        return new ResponseEntity<>(
          service.getFileName(), headers, HttpStatus.OK);
    }

	    
}
