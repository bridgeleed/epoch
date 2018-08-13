package test;

import javax.jws.soap.SOAPBinding.Use;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgeleed.store.bean.User;
import com.bridgeleed.store.mapper.UserMapper;
import com.bridgeleed.store.service.IUserService;
import com.bridgeleed.store.service.UserService;

public class LoginTest {
	
	@Test
	public void testLogin(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
	    IUserService userService = ac.getBean("userService",UserService.class);
	    
	   User user =  userService.login("李状军", "123456");
	   System.out.println(user);
	}
	
	@Test
	public void testUpdate(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		
		User user = new User();
		user.setId(9);
		//user.setPassword("11111111");
		user.setUsername("我的小乳猪");
		user.setGender(0);
		user.setEmail("1297323908@qq.com");
		user.setPhone("11111111999");
		userMapper.updateUser(user);
		ac.close();
	}
	@Test
	public void testSelectUserById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		User user = userMapper.selectUserById(116);
		System.out.println(user);
		
		ac.close();
		
	}
	
	@Test
	public void testChangePassword(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
	
		UserService userService = ac.getBean("userService",UserService.class);
		userService.changePassword(19, "11111111", "22222222");
		ac.close();
		
	
	}
	
	
	
	
	

}
