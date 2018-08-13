package com.bridgeleed.store.service;

import com.bridgeleed.store.bean.User;

public interface IUserService {
	/**
	 * 实现用户的添加
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 
	 * @param 验证email phone username是否存在
	 * @return 如果存在返回true 如果不存在返回false
	 */
	Boolean checkEmail(String email);
	Boolean checkPhone(String phone);
	Boolean checkUsername(String username);
	//登陆验证
	User login(String username,String password);
	
	//修改密码
	
	void changePassword(Integer id,String oldPwd,String newPwd);
	
	//修改头像
	void updImage(Integer id,String image);

}
