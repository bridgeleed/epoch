package com.bridgeleed.store.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/upload")
public class UploadController {
	
	//显示上传的表
	@RequestMapping("/showUpload.do")
	public String showUpload(){
		return "upload";
	}
	
	//实现上传文件的功能
	@RequestMapping("/uploadFile.do")
	public String uploadFile(MultipartFile file) throws Exception{
		//实现上传功能
		file.transferTo(new File("f:/",file.getOriginalFilename()));
		
		return "redirect:../main/showIndex.do";
		
	}
	

}
