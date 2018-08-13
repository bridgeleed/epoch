package com.bridgeleed.store.service;

import com.bridgeleed.store.bean.User;

public interface IUserService {
	/**
	 * ʵ���û������
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 
	 * @param ��֤email phone username�Ƿ����
	 * @return ������ڷ���true ��������ڷ���false
	 */
	Boolean checkEmail(String email);
	Boolean checkPhone(String phone);
	Boolean checkUsername(String username);
	//��½��֤
	User login(String username,String password);
	
	//�޸�����
	
	void changePassword(Integer id,String oldPwd,String newPwd);
	
	//�޸�ͷ��
	void updImage(Integer id,String image);

}
