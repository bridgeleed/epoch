package test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgeleed.store.bean.User;
import com.bridgeleed.store.mapper.UserMapper;
import com.bridgeleed.store.service.IUserService;
import com.bridgeleed.store.service.UserService;

public class InsertUserTest {
	
	@Test
	public void testInsertUser(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		User user1 = userMapper.selectByUsername(" ¶±¶ª‘");
		if (user1!=null) {
			System.out.println(user1);
			return;
		}else{
		User user = new User();
		user.setUsername(" ¶±¶ª‘");
		user.setPassword("123456");
		user.setEmail("123465");
		user.setPhone("123456789");
		user.setImage("µÿ÷∑");
		user.setModifiedUser("aaa");
		user.setModifiedTime(new Date());
		userMapper.insertUser(user);
		}
		ac.close();
	}
	@Test
	public void testAddUser(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		
		IUserService userService = ac.getBean("userService",UserService.class);
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setEmail("123465");
		user.setPhone("123456789");
		user.setImage("µÿ÷∑");
		user.setModifiedUser("aaa");
		user.setModifiedTime(new Date());
		
		userService.addUser(user);
		
		ac.close();
		
	}
	
	@Test
	public void selectEmailCount(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService userService = ac.getBean("userService",UserService.class);
		boolean flag = userService.checkEmail("123465");
		if (flag) {
			return;
		}else {
			User user = new User();
			user.setUsername("” œ‰");
			user.setPassword("123456");
			user.setEmail("123465");
			user.setPhone("123456789");
			user.setImage("µÿ÷∑");
			user.setModifiedUser("aaa");
			user.setModifiedTime(new Date());
			userService.addUser(user);
		}
		ac.close();
	}
	
	@Test
	public void selectByPhone(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		
		UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);
		Integer count = userMapper.selectByEmail("123456789");
		System.out.println(count);
		ac.close();
	}
	
	@Test
	public void checkUsernameTest(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService userService = ac.getBean("userService",UserService.class);
		boolean flag = userService.checkUsername("À’À’");
		System.out.println(flag);
		ac.close();
		
	}
	
	
	
	
	
	
	
	

}
