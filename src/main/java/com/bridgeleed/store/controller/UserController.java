package com.bridgeleed.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bridgeleed.store.bean.ResponseResult;
import com.bridgeleed.store.bean.User;
import com.bridgeleed.store.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private IUserService userService;
	
	//��ʾע����ͼ
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		return "register";
	}
	
	/**
	 * ʵ���û����Ƿ���ڵ��첽��֤ 
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr = null;
		if(userService.checkUsername(username)==true){
			rr = new ResponseResult<Void>(0,"�û���������ʹ��");
		}else {
			rr = new ResponseResult<Void>(1,"�û�������ʹ��");
		}
		return rr;
	} 
	
	/**
	 * ��֤������첽���󷽷�
	 * @param email
	 * @return
	 */
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr = null;
		if (userService.checkEmail(email)==true) {
			rr = new ResponseResult<Void>(0,"���䲻����ʹ��");
		}else {
			rr = new ResponseResult<Void>(1,"�������ʹ��" );
		}
		
 		return rr;
	} 
	
	/**
	 * ��֤�ֻ�������첽���󷽷�
	 * @param phone
	 * @return
	 */
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr = null;
		if (userService.checkPhone(phone)==true) {
			rr = new ResponseResult<Void>(0,"�ֻ����벻����ʹ��");
		}else {
			rr = new ResponseResult<Void>(1,"�ֻ��������ʹ��");
		}
		
 		return rr;
	} 
	
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname")String username,@RequestParam("upwd")String password,String email,String phone){
		ResponseResult<Void> rr = null;
		try{
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		user.setPhone(phone);
		userService.addUser(user);
		
		rr = new ResponseResult<Void>(1,"������ݳɹ�");
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/showLogin.do")
	public String showLogin(){
		return "login";
	}
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session){
		ResponseResult<Void> rr = null;
		
		try{
			User user = userService.login(username, password);
			rr = new ResponseResult<Void>(1,"��½�ɹ�");
			 session.setAttribute("user", user);
			
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}

	/**
	 * ����ǿ����˺��˳��Ĺ���
	 */
	@RequestMapping("/exit.do")
	public String exit(HttpSession session){
		session.invalidate(); 
		return "redirect:/main/showIndex.do";
	}
	
	/**
	 * 
	 */
	@RequestMapping("/showPassword.do")
	public String showPassword(){
		return "personal_password";
	}
	
	/**
	 * �޸�����
	 * @param session
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(HttpSession session,String oldPwd,String newPwd){
		ResponseResult<Void> rr = null;
		 
		try{
			userService.changePassword(this.getId(session), oldPwd, newPwd);
			rr = new ResponseResult<Void>(1,"�޸ĳɹ�");
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}

	//��ʾ������Ϣҳ��
	@RequestMapping("/showPersonpage.do")
	public String showPersonpage(){
	  return "personpage";
		
	}
	
	//�ϴ�ͼƬ
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(MultipartFile file,HttpSession session) throws Exception{
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"�ɹ�");
		//�ϴ�ͼƬ
		//��ȡ��ǰӦ�õ���ʵ·��
		String path = session.getServletContext().getRealPath("/");
		System.out.println(path);
		file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		//�޸����ݿ��е�image�ֶ�
		userService.updImage(this.getId(session), "/upload/"+file.getOriginalFilename());
		
		return rr;
	}
	
}
