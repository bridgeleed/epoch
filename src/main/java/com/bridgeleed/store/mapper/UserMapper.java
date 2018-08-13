package com.bridgeleed.store.mapper;
import org.apache.ibatis.annotations.Param;

import com.bridgeleed.store.bean.User;

/**
 * 持久层操作
 * @author Super_man
 *
 */
public interface UserMapper {
	/**
	 * 
	 * @param user
	 * 插入用户
	 * 
	 */
	void insertUser(User user);
	/**
	 * 根据用户名进行查询
	 * @return 如果查询到了，把结果封住成User对象返回，如果没查询到返回null
	 * 
	 */
	User selectByUsername(String username);
	/**
	 * 判断邮箱的唯一性
	 * @param email
	 * @return
	 */
	Integer selectByEmail(String email);
	
	Integer selectByPhone(String phone);
	
	//更改个人信息
	void updateUser(User user);
	//参数列表的参数超过两个时 用注解进行传参
	void updateImage(@Param("id")Integer id,@Param("image")String image);	
	//通过id查询
	User selectUserById(Integer id);
	
	
	
	
	

}
