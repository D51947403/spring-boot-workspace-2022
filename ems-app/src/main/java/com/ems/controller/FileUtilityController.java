package com.ems.controller;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ems.config.FileUploadProperties;

import jakarta.annotation.PostConstruct;
//https://devwithus.com/download-upload-files-with-spring-boot/
@RestController
@RequestMapping("file-api")
public class FileUtilityController {

	private final Path dirLocation;

	public FileUtilityController(FileUploadProperties fileUploadProperties) {
		this.dirLocation = Paths.get(fileUploadProperties.getLocation()).toAbsolutePath().normalize();
	}

	// create folder before api call
	@PostConstruct
	public void initDir() {
		try {
			Files.createDirectories(this.dirLocation);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("fileName") String fileName,
			@RequestParam("multiPartFile") MultipartFile multiPartFile) {

		if (!Files.exists(this.dirLocation)) {
			initDir();
		}
		try {
			Path directoryPath = this.dirLocation.resolve(fileName);
			// size comparison on KB
			if (multiPartFile.getSize() / 1000 > 100)
				return ResponseEntity.internalServerError().body("Internal server error");
			else
				Files.copy(multiPartFile.getInputStream(), directoryPath, StandardCopyOption.REPLACE_EXISTING);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");

	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> downloadFile(@RequestParam("fileName") String fileName) throws FileNotFoundException{
		try {
            Path file = this.dirLocation.resolve(fileName).normalize();
            
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                		.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                                .body(resource);
              }
            else {
            	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UrlResource("File not available"));
            }
          } 
          catch (MalformedURLException e) {
              throw new FileNotFoundException("Could not download file");
          }     
		
	}
	
	
}
