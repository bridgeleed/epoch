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
			//���ɵ�����
			String md5Pwd = DigestUtils.md5Hex(pwd+salt);
			//����������λuser������
			user.setPassword(md5Pwd);
			userMapper.insertUser(user);
		}else {
			//�Զ����쳣 UsernameAlreadyExistException();
			throw new UsernameAlreadyExistException("�û����Ѵ���");
			
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
    * ��֤�û���½
    * @see com.bridgeleed.store.service.IUserService#login(java.lang.String, java.lang.String)
    */
 
    public User login(String username, String password) {
    	System.out.println("UserService.login()");
    	User user = userMapper.selectByUsername(username);
    	if (user==null) {
			throw new UserNotFoundException("�û�������");
		}else {
			String md5Pwd = DigestUtils.md5Hex(password+salt);
			if (user.getPassword().equals(md5Pwd)) {
				return user;
			}else{
				throw new PasswordNotMatchException("�������");
			}
		}
    	
    }
    
    
    //�޸�����
    public void changePassword(Integer id, String oldPwd, String newPwd) {
    	User user = userMapper.selectUserById(id);
    	if (user!=null) {
    		
    		//��oldPwd�����ɳ����Ľ����ж�
    		String md5OldPwd = DigestUtils.md5Hex(oldPwd+salt); 
			if (user.getPassword().equals(md5OldPwd)) {
				User user1= new User();
				user1.setId(id);
				
				//�����������Ȼ��������ݿ���
				String md5NewPwd = DigestUtils.md5Hex(newPwd+salt); 
				user1.setPassword(md5NewPwd);
				userMapper.updateUser(user1);
			}else {
				throw new PasswordNotMatchException("���벻ƥ��");
			}
			
		}else{
			throw new UserNotFoundException("�û�������");
		}	
    }


	public void updImage(Integer id, String image) {
		userMapper.updateImage(id, image);
		
	}
	

}
