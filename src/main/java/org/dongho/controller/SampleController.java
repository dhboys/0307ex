package org.dongho.controller;

import java.io.File;
import java.util.ArrayList;

import org.dongho.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto)throws Exception {
		log.info(""+dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		log.info("name: " + name);
		log.info("age: " +  age);
		
		return "ex02";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto , @ModelAttribute("page") int page) {
		
		log.info(dto);
		log.info(page);

		return "/sample/ex04";
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("À±µ¿È£");
		
		return dto;
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("upload............");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("----------------");
			log.info("name: "+ file.getOriginalFilename());
			log.info("size: " + file.getSize());
			
			String uploadFolder = "C:\\upload";
			
			for (MultipartFile multipartFile : files) {
				
				String uploadFileName = multipartFile.getOriginalFilename();
				
				File saveFile = new File(uploadFolder , uploadFileName);
				
				try {
					multipartFile.transferTo(saveFile);
				}catch(Exception e) {
					e.printStackTrace();
				}
			} // end for
			
		});
		
	}
	
	
}
