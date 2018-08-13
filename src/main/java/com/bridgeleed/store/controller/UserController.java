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
	
	//显示注册视图
	@RequestMapping("/showRegister.do")
	public String showRegister(){
		return "register";
	}
	
	/**
	 * 实现用户名是否存在的异步验证 
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr = null;
		if(userService.checkUsername(username)==true){
			rr = new ResponseResult<Void>(0,"用户名不可以使用");
		}else {
			rr = new ResponseResult<Void>(1,"用户名可以使用");
		}
		return rr;
	} 
	
	/**
	 * 验证邮箱的异步请求方法
	 * @param email
	 * @return
	 */
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr = null;
		if (userService.checkEmail(email)==true) {
			rr = new ResponseResult<Void>(0,"邮箱不可以使用");
		}else {
			rr = new ResponseResult<Void>(1,"邮箱可以使用" );
		}
		
 		return rr;
	} 
	
	/**
	 * 验证手机号码的异步请求方法
	 * @param phone
	 * @return
	 */
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr = null;
		if (userService.checkPhone(phone)==true) {
			rr = new ResponseResult<Void>(0,"手机号码不可以使用");
		}else {
			rr = new ResponseResult<Void>(1,"手机号码可以使用");
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
		
		rr = new ResponseResult<Void>(1,"添加数据成功");
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
			rr = new ResponseResult<Void>(1,"登陆成功");
			 session.setAttribute("user", user);
			
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}

	/**
	 * 这个是控制账号退出的功能
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
	 * 修改密码
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
			rr = new ResponseResult<Void>(1,"修改成功");
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}

	//显示个人信息页面
	@RequestMapping("/showPersonpage.do")
	public String showPersonpage(){
	  return "personpage";
		
	}
	
	//上传图片
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(MultipartFile file,HttpSession session) throws Exception{
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"成功");
		//上传图片
		//获取当前应用的真实路径
		String path = session.getServletContext().getRealPath("/");
		System.out.println(path);
		file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		//修改数据库中得image字段
		userService.updImage(this.getId(session), "/upload/"+file.getOriginalFilename());
		
		return rr;
	}
	
}
