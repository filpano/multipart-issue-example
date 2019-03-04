package com.example.controller;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@RestController
public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);
    }

    @Autowired // For ease of debugging potential configuration issues
    ApplicationContext applicationContext;

    /**
     * Upload using the standard multipart API.
     */
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok("OK");
    }

    /**
     * Attempt to upload and then save the stream to disk using the commons-fileupload streaming API.
     */
    @PostMapping("/uploadtodisk")
    public ResponseEntity<String> uploadToDisk(HttpServletRequest request) throws FileUploadException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);


        ServletFileUpload upload = new ServletFileUpload();
        FileItemIterator iterStream = upload.getItemIterator(request);
        File file = new File("."); // change as desired
        Path path = file.toPath();

        while (iterStream.hasNext()) {
            FileItemStream item = iterStream.next();
            String name = item.getFieldName();
            InputStream inputStream = item.openStream();
            Files.copy(inputStream, path);
        }
        return ResponseEntity.ok("OK");
    }

    /**
     * Test mapping to verify service is accessible at all through Gateway.
     */
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("OK");
    }
}
