package com.imooc.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pdfTest")
public class PdfTestController {

	Logger LOGGER = LoggerFactory.getLogger(PdfTestController.class);
	private static final String FILE_PATH = "D:/czg/pdf/pdfTest.pdf";
	
	@GetMapping("/download1")
	public ResponseEntity<InputStreamResource> downloadFile1() throws IOException {
		LOGGER.info("---------------->进入到PDF downloadFile1方法");
	      File file = new File(FILE_PATH);
	      InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	
	      return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION,
	                  "attachment;filename=" + file.getName())
	            .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
	            .body(resource);
	}
	
	// Using ResponseEntity<ByteArrayResource>
	   @GetMapping("/download2")
	   public ResponseEntity<ByteArrayResource> downloadFile2() throws IOException {

	      Path path = Paths.get(FILE_PATH);
	      byte[] data = Files.readAllBytes(path);
	      ByteArrayResource resource = new ByteArrayResource(data);

	      return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION,
	                  "attachment;filename=" + path.getFileName().toString())
	            .contentType(MediaType.APPLICATION_PDF).contentLength(data.length)
	            .body(resource);
	   }

	   // Using HttpServletResponse
	   @GetMapping("/download3")
	   public void downloadFile3(HttpServletResponse resonse) throws IOException {
	      File file = new File(FILE_PATH);
	       
	      // 示例中使用的是pdf，实际的content-type需要根据上传文件时的content-type进行确定(最长可达255字节)
	      resonse.setContentType("application/pdf");
	      resonse.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
	      BufferedInputStream inStrem = new BufferedInputStream(new FileInputStream(file));
	      BufferedOutputStream outStream = new BufferedOutputStream(resonse.getOutputStream());
	      
	      byte[] buffer = new byte[1024];
	      int bytesRead = 0;
	      while ((bytesRead = inStrem.read(buffer)) != -1) {
	        outStream.write(buffer, 0, bytesRead);
	      }
	      outStream.flush();
	      inStrem.close(); 
	   }
	   
	   @RequestMapping("/download4")
	   public ResponseEntity<byte[]> export() throws IOException {  
	    	
	        HttpHeaders headers = new HttpHeaders();    
	        File file = new File(FILE_PATH);
	        
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);    
	        headers.setContentDispositionFormData("attachment", "pdfTest4.pdf");    
	       
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
	                                              headers, HttpStatus.CREATED);    
	    }

	   
}
