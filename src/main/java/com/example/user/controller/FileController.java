 package com.example.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.user.entity.UploadFileResponse;
import com.example.user.entity.User;
import com.example.user.service.impl.FileService;

@RestController
@RequestMapping("/api/file")
@CrossOrigin(origins = {"http://localhost:8000","http://localhost:8001","http://localhost:8002","http://localhost:8003","http://localhost:8004"},maxAge = 3600)
public class FileController {
     
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    

    @Value("${file.upload-dir}")
    private String uploadPath;
    
    @Autowired
    private FileService fileService;
   
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("data") String data){
      String fileName = fileService.storeFile(file);
   
      String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
          .path(this.uploadPath)
          .path(fileName)
          .toUriString();
   
      return new UploadFileResponse(fileName, fileDownloadUri,
          file.getContentType(), file.getSize());
    }
    
    @PostMapping("/uploadFile1")
    public UploadFileResponse uploadFile1(@RequestParam("file") MultipartFile file, @ModelAttribute User data){
      String fileName = fileService.storeFile(file);
   
      String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
          .path(this.uploadPath)
          .path(fileName)
          .toUriString();
   
      return new UploadFileResponse(fileName, fileDownloadUri,
          file.getContentType(), file.getSize());
    }
   
   
    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("file") MultipartFile[] files) {
        List<UploadFileResponse> listResponse = new ArrayList<UploadFileResponse>();
        for(MultipartFile file: files) {
            if(!file.isEmpty()) {
                String fileName = fileService.storeFile(file); 
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path(this.uploadPath)
                    .path(fileName)
                    .toUriString();
                UploadFileResponse resp = new UploadFileResponse(fileName, fileDownloadUri,
                    file.getContentType(), file.getSize());
                listResponse.add(resp);
            }
        }
        return listResponse;
    }
   
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
      // Load file as Resource
      Resource resource = fileService.loadFileAsResource(fileName);
   
      // Try to determine file's content type
      String contentType = null;
      try {
        contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
      } catch (IOException ex) {
        logger.info("Could not determine file type.");
      }
   
      // Fallback to the default content type if type could not be determined
      if(contentType == null) {
        contentType = "application/octet-stream";
      }
   
      return ResponseEntity.ok()
          .contentType(MediaType.parseMediaType(contentType))
          .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
          .body(resource);
    }
}
