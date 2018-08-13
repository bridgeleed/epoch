package com.bridgeleed.store.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.bridgeleed.store.bean.User;
import com.bridgeleed.store.mapper.UserMapper;
import com.bridgeleed.store.service.ex.PasswordNotMatchException;
import com.bridgeleed.store.service.ex.UserNotFoundException;
import com.bridgeleed.store.service.ex.UsernameAlreadyExistException;

@Service
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;
	@Value("#{config.salt}")
	private String salt; 
	public void addUser(User user) {
		User user1 = userMapper.selectByUsername(user.getUsername());
		if (user1==null) {
			String pwd = user.getPassword();
			//生成的密文
			String md5Pwd = DigestUtils.md5Hex(pwd+salt);
			//把秘文设置位user的属性
			user.setPassword(md5Pwd);
			userMapper.insertUser(user);
		}else {
			//自定义异常 UsernameAlreadyExistException();
			throw new UsernameAlreadyExistException("用户名已存在");
			
		}
	}

	
	public Boolean checkEmail(String email) {
		
		return userMapper.selectByEmail(email)>0;
	
	}
	
    public Boolean checkPhone(String phone) {
		
		return userMapper.selectByPhone(phone)>0;
		
	}
	
    public Boolean checkUsername(String username) {
    	return userMapper.selectByUsername(username)!=null;
    }
	
   /*
    * 验证用户登陆
    * @see com.bridgeleed.store.service.IUserService#login(java.lang.String, java.lang.String)
    */
 
    public User login(String username, String password) {
    	System.out.println("UserService.login()");
    	User user = userMapper.selectByUsername(username);
    	if (user==null) {
			throw new UserNotFoundException("用户不存在");
		}else {
			String md5Pwd = DigestUtils.md5Hex(password+salt);
			if (user.getPassword().equals(md5Pwd)) {
				return user;
			}else{
				throw new PasswordNotMatchException("密码错误");
			}
		}
    	
    }
    
    
    //修改密码
    public void changePassword(Integer id, String oldPwd, String newPwd) {
    	User user = userMapper.selectUserById(id);
    	if (user!=null) {
    		
    		//将oldPwd解析成成密文进行判断
    		String md5OldPwd = DigestUtils.md5Hex(oldPwd+salt); 
			if (user.getPassword().equals(md5OldPwd)) {
				User user1= new User();
				user1.setId(id);
				
				//将新密码加密然后存在数据库中
				String md5NewPwd = DigestUtils.md5Hex(newPwd+salt); 
				user1.setPassword(md5NewPwd);
				userMapper.updateUser(user1);
			}else {
				throw new PasswordNotMatchException("密码不匹配");
			}
			
		}else{
			throw new UserNotFoundException("用户不存在");
		}	
    }


	public void updImage(Integer id, String image) {
		userMapper.updateImage(id, image);
		
	}
	

}
