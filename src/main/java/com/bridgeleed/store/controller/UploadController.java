package com.bridgeleed.store.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/upload")
public class UploadController {
	
	//��ʾ�ϴ��ı�
	@RequestMapping("/showUpload.do")
	public String showUpload(){
		return "upload";
	}
	
	//ʵ���ϴ��ļ��Ĺ���
	@RequestMapping("/uploadFile.do")
	public String uploadFile(MultipartFile file) throws Exception{
		//ʵ���ϴ�����
		file.transferTo(new File("f:/",file.getOriginalFilename()));
		
		return "redirect:../main/showIndex.do";
		
	}
	

}
